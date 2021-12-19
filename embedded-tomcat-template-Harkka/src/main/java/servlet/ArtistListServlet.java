package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ArtistDao;
import database.ArtistListItemDao;
import model.Artist;

@WebServlet("/")
public class ArtistListServlet extends HttpServlet {
	
	private ArtistDao dao = new ArtistDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> allArtists = this.dao.getAllArtists();
		
		req.setAttribute("artists", allArtists);
		req.getRequestDispatcher("/WEB-INF/ArtistList/artistList.jsp").forward(req, resp);	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String artist = req.getParameter("name");
		
		Artist newitem = new Artist(artist);
		
		this.dao.addItem(newitem);
		
		resp.sendRedirect("/");
	}
	
	// Remove pois kommentoitu 
	/*
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		resp.getWriter().println("test");
		boolean success = false;
		List<Artist> allItems = dao.getAllArtists();
		resp.getWriter().println("test");
		int id = Integer.parseInt(req.getParameter("id"));
		for (Artist item : allItems) {
			if(item.getId() == id) {
				this.dao.removeArtist(item);
				success = true;
			}
		}
		
		if(success) {
			resp.getWriter().println("{ \"success\": true }");
		}
	}
	*/
}
