package motta;

import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.text.StringEscapeUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Mottaker")
public class Mottaker extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Mottaker() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String navn = request.getParameter("navn");
		if(navn == null) {
			navn = "";
		}
		
		String hello = "Hello ";
		String spraak = request.getHeader("Accept-Language");
		String[] alleSpraak = spraak.split(",");
		if(alleSpraak[0].toLowerCase().contains("no") || alleSpraak[0].toLowerCase().contains("nb")) {
			hello = "Hallo ";
		}
		else if(alleSpraak[0].toLowerCase().contains("de")) {
			hello = "Guten tag ";
		}
		
		String navnRenset = StringEscapeUtils.escapeJava(StringEscapeUtils.escapeHtml4(navn));
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>hallo</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + hello + navnRenset + "!</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
