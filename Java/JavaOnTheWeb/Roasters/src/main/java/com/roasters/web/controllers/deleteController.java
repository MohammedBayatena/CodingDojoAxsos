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
 * Servlet implementation class deleteController
 */
@WebServlet("/delete")
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teamName = request.getParameter("team");
		String playerFirstName = request.getParameter("firstname");
		String playerLastName = request.getParameter("lastname");
		HttpSession session = request.getSession();
		if (teamName != null && !teamName.equals("")) {
			
			if ( playerFirstName != null && !playerFirstName.equals("") && playerLastName != null && !playerLastName.equals("")) {
				
				ArrayList<Team> teamslist =(ArrayList<Team>) session.getAttribute("teamslist");
				for (Team team :teamslist) {
					if (team.getName().equals(teamName)) {
						for ( Player player: team.getPlayers() ) {
							if (player.getFirstName().equals(playerFirstName) && player.getLastName().equals(playerLastName)) {
								team.getPlayers().remove(player);
								team.updateplayers();
								break;
							}
						}
					}
					response.sendRedirect("details?team="+teamName);
				}
			}else {
				ArrayList<Team> teamslist =(ArrayList<Team>) session.getAttribute("teamslist");
				for (Team team :teamslist) {
					if (team.getName().equals(teamName)) {
						teamslist.remove(team);
						break;
					}
				}
				response.sendRedirect("Home");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
