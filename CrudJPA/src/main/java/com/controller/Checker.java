package com.controller;

import java.io.IOException;

import com.model.User;

import ejb.UserBeanRemote;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Checker
 */
@WebServlet("/Checker")
public class Checker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	UserBeanRemote utenteDAO;


	public Checker() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;

		user = utenteDAO.getUser(username, password);

		if (user != null) {
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		} else {
			try {
				request.setAttribute("errore", "true");
				request.getRequestDispatcher("Credentials.jsp").forward(request, response);
			} catch (IllegalStateException w) {
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
