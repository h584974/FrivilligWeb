package mottaStemmer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FruktstemmePost")
public class FruktstemmePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FruktstemmePost() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fruktstemme = request.getParameter("fruktstemme");
		request.getSession().setAttribute("fruktstemme", fruktstemme);
		response.sendRedirect("Resultat");
	}

}