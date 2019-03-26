package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.webapp.dao.DataBaseForgotPassword;
import com.bridgelabz.webapp.model.ForgotPassword;
import com.bridgelabz.webapp.services.ValidateUser;

/******************************************************************************
 * Purpose:ForgotPasswordServlet Class to change the user password that exist
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class ForgotPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting all the user inputs to change the password
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		ForgotPassword forgotObj = new ForgotPassword(uname, email, pass);
		String result = ValidateUser.validateForgotPassword(forgotObj);// validating the forgot password details given
																		// by user
		DataBaseForgotPassword dbForgot = new DataBaseForgotPassword();
		// result is empty means details are correct and not empty means incorrect
		if (result.equals("")) {
			// checking the for given username and email is matching or not
			if (dbForgot.toCheckEmailUser(forgotObj)) {
				request.setAttribute("msg", "Reset Password Successfull");
				dbForgot.updatePassword(forgotObj);
				// forwarding to successfull
				RequestDispatcher rd = request.getRequestDispatcher("ForgotSuccessfull.jsp");
				rd.forward(request, response);
			}
		}
		// forwarding to error.jsp with the error messages to user
		else {
			request.setAttribute("msg", result);
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}

	}

}
