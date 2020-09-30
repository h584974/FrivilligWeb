package frivillig1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Omregning")
public class Omregning extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Omregning() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String omregn = request.getParameter("omregn");
		String temperaturStr = request.getParameter("temp");
		PrintWriter out = response.getWriter();
		double temperatur = -1_000;
		
		try {
			temperatur = Double.parseDouble(temperaturStr);
		}
		catch(Throwable e) {}
		
		
		if(omregn == null || temperaturStr == null || temperaturStr.isEmpty() || (omregn.equalsIgnoreCase("ctilf") && 
		temperatur < -273.15) || (omregn.equalsIgnoreCase("ftilc") && temperatur < -459.67)) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<link rel=\"stylesheet\" href=\"errorstyle.css\"/>");
			out.println("<title>feilresultat</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>Feil ved omrenging. Temperatur m&aring; v&aelig;re et tall lik eller st&oslash;rre absolutt null, og omregningsmetode m&aring; v&aelig;re valgt</p>");
			out.println("</body>");
			out.println("</html>");
		}
		else {
			double omregnetTemp = 0;
			String start = "";
			String end = "";
			if(omregn.equalsIgnoreCase("ctilf")) {
				omregnetTemp = (temperatur * 1.8) + 32;
				start = "C";
				end = "F";
			}
			else {
				omregnetTemp = (temperatur - 32) / 1.8;
				start = "F";
				end = "C";
			}
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<link rel=\"stylesheet\" href=\"mainstyle.css\"/>");
			out.println("<title>feilresultat</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>Temperaturomrenging resultat</p>");
			out.println("<p>" + String.format("%.1f", temperatur) + "&deg;" + start + " = " + String.format("%.1f", omregnetTemp) + "&deg;" + end +  "</p>");
			out.println("</body>");
			out.println("</html>");
		}
		
	}

}