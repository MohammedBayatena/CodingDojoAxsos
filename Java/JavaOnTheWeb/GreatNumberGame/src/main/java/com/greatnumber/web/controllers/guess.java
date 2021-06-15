package com.greatnumber.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class guess
 */

@WebServlet("/guess")
public class guess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/GreatNumberGame/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		if (session == null) {
		    // Not created yet. Now do so yourself.
		    session = request.getSession();
		} else {
			if ( session.getAttribute("number") == null ) {
				Random re = new Random();
				int num = re.nextInt(101);
				session.setAttribute("number", num);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GreatNumberGame/");
			    dispatcher.forward(request, response);	
			}else {
				int real = (int) session.getAttribute("number");
				int guessed = Integer.parseInt(request.getParameter("guessednum"));
				if (guessed > real) {
					request.setAttribute("message", "Too High!");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GreatNumberGame/");
				    dispatcher.forward(request, response);
				}else if(guessed < real) {
					request.setAttribute("message", "Too Low!");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GreatNumberGame/");
				    dispatcher.forward(request, response);
				}else{
					request.setAttribute("message", "Correct!");
					session.removeAttribute("number");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GreatNumberGame/");
				    dispatcher.forward(request, response);
				}	
			}	
		}
		
	}

}
