package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -6236450854618995608L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("uname");
		
		request.setAttribute("msg", "Welcome " + userName);
		

		HttpSession newSession = request.getSession(true);
		newSession.setAttribute("uname", userName);
		newSession.setMaxInactiveInterval(2 * 60);
		Cookie cookieName = new Cookie("user", userName);
		cookieName.setMaxAge(1*60);
		response.addCookie(cookieName);
		
		RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		rd.forward(request, response);

	}
}
