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
 * Purpose:LogoutServlet Class to quit the user from the webapp
 * 
 * @author BridgeLabz/punithhr
 * @version 1.0
 * @since 28-02-2019
 * 
 ******************************************************************************/
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	HttpSession session = request.getSession(false);// getting the session which as been created
		if (session != null) {
			session.removeAttribute("userName");// removing the session attribute
			session.invalidate();// session invalidating before leaving
			
*/			
		Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		
    		cookie.setMaxAge(0);
    		response.addCookie(cookie);
    	}
    	}
    	//getting the session if exists
    	HttpSession session = request.getSession(false);
    	//System.out.println("User="+session.getAttribute("uname"));
    	//invalidate the session if exists
    	if(session != null){
    		session.removeAttribute("uname");
    		session.invalidate();
    	}
		
		
		request.setAttribute("msg", "You are Successfully Logged Out");
			// forwarding to the Logout.jsp
			RequestDispatcher rd = request.getRequestDispatcher("Logout.jsp");
			rd.forward(request, response);

		}
	}

