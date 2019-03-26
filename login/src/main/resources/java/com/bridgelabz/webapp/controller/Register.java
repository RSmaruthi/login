package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.webapp.dao.DataBaseInteractionToRegister;
import com.bridgelabz.webapp.model.User;

/******************************************************************************
 * Purpose:Register Class to register the user to database
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;

//getting the request from the filter after validating
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//getting all the details from the user from jsp page
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String Uname = request.getParameter("Uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String Mnum = request.getParameter("Mnum");
		DataBaseInteractionToRegister dataReg = new DataBaseInteractionToRegister();// dao class to register
		User user = new User(firstName, lastName, Uname, email, pass, Mnum);

		dataReg.addUserInfo(user);// calling the dao package class to Add the user info
		RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
		rd.forward(request, response);

	}

}
