package com.roasters.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roasters.web.models.Team;

/**
 * Servlet implementation class mainController
 */
@WebServlet(name = "Home", urlPatterns = { "/Home" })
public class mainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("teamslist") == null) {
			ArrayList<Team> teamsList = new ArrayList<>();
			session.setAttribute("teamslist", teamsList);
		}
		
		RequestDispatcher view =  request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
