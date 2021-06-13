package userinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Info
 */
@WebServlet("/Info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		http://localhost:8080/UserInformation/Info?firstName=Mohammed&lastName=Bayatena&favouriteLanguage=C&homeTown=Birzeit // URL
		
		String firstName = request.getParameter("firstName") != null ? request.getParameter("firstName") : "Unknown";
		String lastName = request.getParameter("lastName") != null ? request.getParameter("lastName") : "Unknown";
		String favouriteLanguage = request.getParameter("favouriteLanguage") != null ? request.getParameter("favouriteLanguage") : "Unknown";
		String homeTown = request.getParameter("homeTown") != null ? request.getParameter("homeTown") : "Unknown";
		// Sets the content type of the response
        response.setContentType("text/html");
        // writes the response
        PrintWriter out = response.getWriter();
        out.write("<h1 style='text-align: center;'>Welcome,"+firstName+" "+lastName+"</h1>");
        out.write("<h2 style='text-align: center;'>Your favourite language is:"+favouriteLanguage+"</h2>");
        out.write("<h2 style='text-align: center;'>Your hometown is:"+homeTown+"</h2>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
