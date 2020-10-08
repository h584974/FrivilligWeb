package innlogging;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoggUt")
public class LoggUt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoggUt() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InnloggingUtil.loggUt(request);
		response.sendRedirect("LoggInn");
	}

}
