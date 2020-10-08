package registrering;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistreringPost")
public class RegistreringPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistreringPost() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie fornavn = new Cookie("fornavn", URLEncoder.encode(request.getParameter("fornavn"),"UTF-8"));
		Cookie etternavn = new Cookie("etternavn", URLEncoder.encode(request.getParameter("etternavn"),"UTF-8"));
		response.addCookie(fornavn);
		response.addCookie(etternavn);
		response.sendRedirect("Registrering");
	}

}
