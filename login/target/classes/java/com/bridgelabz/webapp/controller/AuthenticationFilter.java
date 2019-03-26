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

import com.bridgelabz.webapp.dao.DataBaseInterActionLogin;
import com.bridgelabz.webapp.model.Login;

/******************************************************************************
 * Purpose:AuthenticationFilter Class to validate the user inputs before login
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class AuthenticationFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;// downcasting the servlet request to HttpRequest
		String userName = req.getParameter("uname");
		String password = req.getParameter("pass");
		Login login = new Login(userName, password);
		DataBaseInterActionLogin toLogin = new DataBaseInterActionLogin();
		// validating the username and password exist or not
		if (toLogin.isUser(login)) {
			chain.doFilter(request, response);// for existing
		}
		// for not existing
		else { // setting error message to display in error.jsp
			request.setAttribute("msg", "Login UnSuccessfull<br/> userName or password wrong");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
