package innlogging;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HemmeligSide")
public class HemmeligSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HemmeligSide() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnlogget(request)) {
			String brukernavn = (String)request.getSession().getAttribute("brukernavn");
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Hemmelig Side</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Hemmelig side!</h1>");
			out.println("<h3>Innlogget som:&ensp;" + brukernavn + "</h3>");
			out.println("<form method=\"post\" action=\"LoggUt\">");
			out.println("<input type=\"submit\" value=\"Logg ut\">");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			response.sendRedirect("LoggInn");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
