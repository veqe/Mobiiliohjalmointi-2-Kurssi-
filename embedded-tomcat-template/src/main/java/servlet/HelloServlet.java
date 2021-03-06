package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String greeting = "Hello ";
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		if (firstName == null) {
			firstName = "Anonymous";
			resp.getWriter().println(greeting + firstName + " " + lastName);
		} else if(lastName == null) {
			lastName = "Anonymous";
			resp.getWriter().println(greeting + firstName + " " + lastName);
		}else {
			resp.getWriter().println(greeting + firstName + " " + lastName);
		}
		
		resp.getWriter().println("Kivaa ku toimii!");
	}
}
