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


public class RegisterFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String Uname = req.getParameter("Uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String Mnum = req.getParameter("Mnum");
		DataBaseInteractionToRegister dataReg = new DataBaseInteractionToRegister();
		User user = new User(firstName, lastName, Uname, email, pass, Mnum);

		String result = "";

		
		if (dataReg.checkUserName(user.getUserName())) {
			result = result + "Duplicate UserName";
		}
		result = result + ValidateUser.getvalidateUser(user);
		
		if (!result.equals("")) {

			request.setAttribute("msg", result);
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		} else
			chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
