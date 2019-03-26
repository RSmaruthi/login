package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/******************************************************************************
 * Purpose:LoginServlet Class to login user to webapp
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -6236450854618995608L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("uname");
		// setting value to the request to display in jsp file
		request.setAttribute("msg", "Welcome " + userName);
		/*HttpSession oldSession = request.getSession(false);// getting the session that exist
		if (oldSession != null) {
			oldSession.invalidate();// if another session is exist invalidating that session
		}*/

		HttpSession newSession = request.getSession(true);// creating the session for the user
		newSession.setAttribute("uname", userName);
		newSession.setMaxInactiveInterval(2 * 60);// given time out to invalidate session
		Cookie cookieName = new Cookie("user", userName);
		cookieName.setMaxAge(1*60);
		response.addCookie(cookieName);
		//forwarding to welcome.jsp
		RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
		rd.forward(request, response);

	}
}
