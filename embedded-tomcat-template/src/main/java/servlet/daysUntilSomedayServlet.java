package servlet;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.time.temporal.ChronoUnit.DAYS;

@WebServlet("/daysUntilSomeday")
public class daysUntilSomedayServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/dayOfYear.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("a")); 
		int b = Integer.parseInt(req.getParameter("b"));
		int c = Integer.parseInt(req.getParameter("c"));
		
		LocalDate today = LocalDate.now();
		
		req.setAttribute("first", a);
		req.setAttribute("second", b);
		req.setAttribute("third", c);
		req.setAttribute("forth", today);
		
		int todayDay = today.getDayOfMonth();
		int todayMonth = today.getMonthValue();
		int todayYear = today.getYear();
		
		LocalDate setDate = LocalDate.of(c, b, a);
		
		long daysBetween = DAYS.between(today, setDate);
		
		req.setAttribute("fifth", daysBetween);
		
		req.getRequestDispatcher("/WEB-INF/daysUntil.jsp").forward(req, resp);
	}
}
