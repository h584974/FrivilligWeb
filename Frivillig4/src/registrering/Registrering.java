package registrering;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet("/Registrering")
public class Registrering extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Registrering() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fornavn = "";
		String etternavn = "Verdi";
		
		try {
			fornavn = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equalsIgnoreCase("fornavn")).map(cookie -> cookie.getValue()).findAny().orElseThrow();
			etternavn = Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equalsIgnoreCase("etternavn")).map(cookie -> cookie.getValue()).findAny().orElseThrow();
		}
		catch(Throwable e) {}
			
		fornavn = URLDecoder.decode(fornavn,"UTF-8");
		etternavn = URLDecoder.decode(etternavn,"UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Regsitrering</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method=\"post\" action=\"RegistreringPost\">");
		out.println("<fieldset>");
		out.println("<legend>Registrering</legend>");
		out.println("<p>Fornavn&ensp;&ensp;<input type=\"text\" id=\"fornavn\" name=\"fornavn\" value=\"" + fornavn +"\"></p>");
		out.println("<p>Etternavn&ensp;&ensp;<input type=\"text\" id=\"etternavn\" name=\"etternavn\" value=\"" + etternavn +"\"></p>");
		out.println("<input type=\"submit\" value=\"Registrer\">");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}