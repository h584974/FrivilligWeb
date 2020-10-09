package sendStemmer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="FruktWelcome", urlPatterns="/FruktXML")
public class FruktWelcome extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static Stream<String> alternativer; 

    @Override
    public void init() {
        String stemmealternativer = getServletContext().getInitParameter("stemmealternativer");
        alternativer = Arrays.stream(stemmealternativer.split(";"));
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Fruktstemming</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"FruktstemmePost\" method=\"post\">");
		out.println("<legend>Fruktstemming</legend>");
			
		alternativer.forEach(alternativ -> out.println("<p>" + alternativ + "<input type=\"radio\" id=\"" + alternativ + 
				"\" value=\"" + alternativ + "\" name=\"fruktstemme\"></p>"));
			
		out.println("<input type=\"submit\" value=\"Stem\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}