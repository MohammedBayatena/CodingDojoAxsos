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
 * Servlet implementation class teamController
 */
@WebServlet(name = "teams", urlPatterns = { "/teams" })
public class teamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view =  request.getRequestDispatcher("/WEB-INF/views/newteam.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name= request.getParameter("teamname");
		Team team = new Team(name,0);
		HttpSession session = request.getSession();
		ArrayList<Team> teamslist =(ArrayList<Team>) session.getAttribute("teamslist");
		teamslist.add(team);
		session.setAttribute("teamslist", teamslist);
		
		doGet(request, response);
	}

}
