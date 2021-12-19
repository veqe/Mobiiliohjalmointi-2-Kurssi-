package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCShoppingListItemDao;
import database.ShoppingListItemDao;
import model.ShoppingListItem;

@WebServlet("/list")
public class ShoppingListServlet extends HttpServlet {
	
	private ShoppingListItemDao dao = new JDBCShoppingListItemDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ShoppingListItem> allItems = this.dao.getAllItems();
		
		req.setAttribute("items", allItems);
		
		req.getRequestDispatcher("/WEB-INF/shoppingList/list.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		
		ShoppingListItem newitem = new ShoppingListItem(title);
		
		this.dao.addItem(newitem);
		
		resp.sendRedirect("/list");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean success = false;
		List<ShoppingListItem> allItems = dao.getAllItems();
		int id = Integer.parseInt(req.getParameter("id"));
		
		for (ShoppingListItem item : allItems) {
			if(item.getId() == id) {
				this.dao.removeItem(item);
				success = true;
			}
		}
		
		if(success) {
			resp.getWriter().println("{ \"success\": true }");
		}
	}
}