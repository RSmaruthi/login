package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.webapp.dao.DataBaseInteractionToRegister;
import com.bridgelabz.webapp.model.User;

public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String Uname = request.getParameter("Uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String Mnum = request.getParameter("Mnum");
		DataBaseInteractionToRegister dataReg = new DataBaseInteractionToRegister();
		User user = new User(firstName, lastName, Uname, email, pass, Mnum);

		dataReg.addUserInfo(user);
		RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
		rd.forward(request, response);

	}

}
