package com.humanbooster.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.humanbooster.model.User;
import com.humanbooster.service.UserService;

/**
 * Servlet implementation class AdminDashboardServlet
 */

public class AdminDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDashboardServlet() {
    	this.us = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser =new ArrayList<>();

        try {
        	listUser = this.us.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("dashboardAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
