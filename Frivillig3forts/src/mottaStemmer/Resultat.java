package mottaStemmer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Resultat")
public class Resultat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AtomicInteger bananstemmer;
	private static AtomicInteger mangostemmer;
	private static AtomicInteger eplestemmer;
	private static AtomicInteger appelsinstemmer;   
    
    public Resultat() {
    	this.bananstemmer = new AtomicInteger(0);
    	this.mangostemmer = new AtomicInteger(0);
    	this.eplestemmer = new AtomicInteger(0);
    	this.appelsinstemmer = new AtomicInteger(0);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fruktstemme = (String)request.getSession().getAttribute("fruktstemme");
		
		if(fruktstemme == null) {
			fruktstemme = "";
		}
		
		switch(fruktstemme) {
			case "banan": bananstemmer.incrementAndGet(); break;
			case "mango": mangostemmer.incrementAndGet(); break;
			case "eple": eplestemmer.incrementAndGet(); break;
			case "appelsin": appelsinstemmer.incrementAndGet(); break;
			default: fruktstemme = "Stemme ikke avgitt";
		}
			
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Resultat</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Resultat</h1>");
		out.println("<h3>Du stemte: " + fruktstemme + "</h3>");
		out.println("<p>Banan:&ensp;" + bananstemmer + "</p>");
		out.println("<p>Mango:&ensp;" + mangostemmer + "</p>");
		out.println("<p>Eple:&ensp;" + eplestemmer + "</p>");
		out.println("<p>Appelsin:&ensp;" + appelsinstemmer + "</p>");
		out.println("<a href=\"/fruktwelcome/stem.html\">Stem en gang til</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}