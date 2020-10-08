package innlogging;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoggInnPost")
public class LoggInnPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoggInnPost() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brukernavn = request.getParameter("brukernavn");
		if(InnloggingUtil.isGyldigPassord(brukernavn, "admin")) {
			InnloggingUtil.loggInnMedTimeout(request, 30);
			request.getSession().setAttribute("brukernavn",brukernavn);
			response.sendRedirect("HemmeligSide");
		}
		else {
			request.getSession().setAttribute("feilmelding", "Feil brukernavn, pr&oslash;v igjen:");
			response.sendRedirect("LoggInn");
		}
	}

}
