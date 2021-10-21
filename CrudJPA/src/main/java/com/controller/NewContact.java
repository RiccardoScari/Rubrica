package com.controller;

import java.io.IOException;

import com.model.Contatto;
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
 * Servlet implementation class NewContact
 */
@WebServlet("/NewContact")
public class NewContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ContattoBeanRemote contattoDAO;
	
	@EJB
	UserBeanRemote utenteDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * String username = request.getParameter("username"); String password =
		 * request.getParameter("password");
		 */
		String numero = request.getParameter("numerocontatto");
		String nome = request.getParameter("nomecontatto");

		User user = (User) request.getSession().getAttribute("user");

		Contatto contatto = new Contatto(nome, numero, user);

		contattoDAO.saveContact(contatto);
		request.getSession().setAttribute("user", utenteDAO.getUser(user.getUsername(), user.getPassword()));
		response.sendRedirect("Home.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
