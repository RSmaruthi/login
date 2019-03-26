package com.bridgelabz.webapp.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.bridgelabz.webapp.dao.DataBaseInteractionToRegister;
import com.bridgelabz.webapp.model.User;
import com.bridgelabz.webapp.services.ValidateUser;

/******************************************************************************
 * Purpose:RegisterFilter Class to validate the user inputs before Registration
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/

public class RegisterFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;// downcasting the servlet request to HttpRequest

		// getting all the user inputs using request from the register.jsp
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String Uname = req.getParameter("Uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String Mnum = req.getParameter("Mnum");
		DataBaseInteractionToRegister dataReg = new DataBaseInteractionToRegister();
		User user = new User(firstName, lastName, Uname, email, pass, Mnum);// creating user user object to validate

		String result = "";// empty string

		// validating the user name already exist or not
		if (dataReg.checkUserName(user.getUserName())) {
			result = result + "Duplicate UserName";
		}
		result = result + ValidateUser.getvalidateUser(user);// validating all the inputs are correct or incorrect means
																// getting the error msg strings
		// validating result is empty or not empty means all the validations is done
		// without any error msg
		if (!result.equals("")) {

			request.setAttribute("msg", result);
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		} else
			chain.doFilter(request, response);// forwarding to the register servlet class
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
