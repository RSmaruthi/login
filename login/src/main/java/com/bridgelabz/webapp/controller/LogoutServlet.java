package com.bridgelabz.webapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		
    		cookie.setMaxAge(0);
    		response.addCookie(cookie);
    	}
    	}
    	
    	HttpSession session = request.getSession(false);
    	
    	
    	if(session != null){
    		session.removeAttribute("uname");
    		session.invalidate();
    	}
		
		
		request.setAttribute("msg", "You are Successfully Logged Out");
		
			RequestDispatcher rd = request.getRequestDispatcher("Logout.jsp");
			rd.forward(request, response);

		}
	}

