package com.pets.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pets.web.models.Cat;
import com.pets.web.models.Dog;

/**
 * Servlet implementation class showInfo
 */
@WebServlet("/animals/*")
public class showInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		if (  request.getPathInfo().replace("/", "").equals("cat")) {
			
			String name = request.getParameter("catName") != null ? request.getParameter("catName") : "Unknown";
			String breed = request.getParameter("catBreed") != null ? request.getParameter("catBreed") : "Unknown";
			double weight = request.getParameter("catWeight") != null ? Double.parseDouble(request.getParameter("catWeight") ): 0;
			Cat cat = new Cat(name , breed , weight);
			request.setAttribute("animal", cat);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Info.jsp");
	        view.forward(request, response);
	        
		}else if (request.getPathInfo().replace("/", "").equals("dog")) {	
			
			String name = request.getParameter("dogName") != null ? request.getParameter("dogName") : "Unknown";
			String breed = request.getParameter("dogBreed") != null ? request.getParameter("dogBreed") : "Unknown";
			double weight = request.getParameter("dogWeight") != null ? Double.parseDouble(request.getParameter("dogWeight") ): 0;
			Dog dog = new Dog(name , breed , weight);
			request.setAttribute("animal", dog);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Info.jsp");
	        view.forward(request, response);
	        
		}else {
			response.getWriter().append("Animal Not Supported Yet");
		}
		
		
		
		
	}

}
