package com.humanbooster.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.model.User;
import com.humanbooster.service.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        this.us = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		user.setLogin(request.getParameter("login"));
		user.setProfilePicture(request.getParameter("profilePicture"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		
		request.getRequestDispatcher("modifyUser.jsp").forward(request, response);
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
			user.setPhoneNumber(request.getParameter("phoneNumber"));
			
			us.update(user);
			response.sendRedirect("AdminDashboard");
			
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}
	}

}
