package com.clicker.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Clicker
 */
@WebServlet(name = "Counter", urlPatterns = { "/Counter" })
public class Clicker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String count = (String) session.getAttribute("count");	
		if (count == null) {
			session.setAttribute("count", "1");
		}else {
			int countAsInt = Integer.parseInt(count);
			session.setAttribute("count", Integer.toString(++countAsInt));
		}
		
		 RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
	     view.forward(request, response);
		System.out.println(count);
		
		
	}

}
