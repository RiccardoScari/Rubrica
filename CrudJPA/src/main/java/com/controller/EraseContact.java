package com.controller;

import java.io.IOException;

import com.model.User;

import ejb.ContattoBeanRemote;
import ejb.UserBeanRemote;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EraseContact
 */
@WebServlet("/EraseContact")
public class EraseContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	ContattoBeanRemote contattoDAO;
	
	@EJB
	UserBeanRemote utenteDAO;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EraseContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");*/
		User user = (User)request.getSession().getAttribute("user");

		String num = request.getParameter("numtelefono");
		contattoDAO.deleteContact(num, user);
		
		request.getSession().setAttribute("user", utenteDAO.getUser(user.getUsername(), user.getPassword()));
		response.sendRedirect("Home.jsp");

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
