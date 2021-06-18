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

import com.roasters.web.models.Player;
import com.roasters.web.models.Team;

/**
 * Servlet implementation class PlayerController
 */
@WebServlet(name = "players", urlPatterns = { "/players" })
public class PlayerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teamName = request.getParameter("team");
		request.setAttribute("teamName", teamName);
		RequestDispatcher view =  request.getRequestDispatcher("/WEB-INF/views/newplayer.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String teamName = request.getParameter("team");
		String firstName= (String)request.getParameter("firstname");
		String lastName = (String)request.getParameter("lastname");
		System.out.println((String)request.getParameter("age"));
		int age = Integer.parseInt((String)request.getParameter("age"));
		Player player = new Player(firstName,lastName,age);
		
		HttpSession session = request.getSession();
		ArrayList<Team> teamslist =(ArrayList<Team>) session.getAttribute("teamslist");
		for (Team team :teamslist) {
			if (team.getName().equals(teamName)) {
				team.getPlayers().add(player);
				team.updateplayers();
			}
		}
		
		session.setAttribute("teamslist", teamslist);
		doGet(request, response);
	}

}
