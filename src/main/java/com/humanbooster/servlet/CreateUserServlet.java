package com.humanbooster.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.humanbooster.model.User;
import com.humanbooster.service.UserService;

public class CreateUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	private UserService us;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
    	this.us = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("newUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			User user = new User();
			UserService us = new UserService();
			
			
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));
			if ("Oui".equals(request.getParameter("isAdmin"))) {
			   user.setAdmin(true);
			} else if ("Non".equals(request.getParameter("isAdmin"))) {
				user.setAdmin(false);
			}
			user.setProfilePicture(request.getParameter("profilePicture"));
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			//Date date=(Date) new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("hireDate")); 
			//user.setHireDate(request.getParameter("hireDate"));
			user.setPhoneNumber(request.getParameter("phoneNumber"));
			
			us.create(user);
			response.sendRedirect("AdminDashboard");
			
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

}
