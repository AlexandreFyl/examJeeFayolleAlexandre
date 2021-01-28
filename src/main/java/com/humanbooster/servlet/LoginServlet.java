package com.humanbooster.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.humanbooster.model.User;
import com.humanbooster.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final UserService userService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	this.userService = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			User user = new User();
			UserService us = new UserService();
			user.setLogin(request.getParameter("un"));
			user.setPassword(request.getParameter("pw"));

			if (us.isUserRegistered(user)) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", user);
				if(us.isAdmin(user)) {
					response.sendRedirect("AdminDashboard"); // loggé en tant qu'admin
				} else {
					response.sendRedirect("UserDashboard"); // loggé en tant qu'utilisateur lambda
				}
				
				
			}

			else
				response.sendRedirect("/login"); // retour au login
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

}
