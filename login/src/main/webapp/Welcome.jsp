<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welome to WebApp</h1>
	<%=request.getAttribute("msg")%><br />
	<%
		//allow access only if session exists
		String user = null;
		if (session.getAttribute("uname") == null) {
			response.sendRedirect("login.jsp");
		} else
			user = (String) session.getAttribute("uname");
		String userName = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
				if (cookie.getName().equals("JSESSIONID"))
					sessionID = cookie.getValue();
			}
		} else {
			sessionID = session.getId();
		}
	%>
	<h3>
		<!-- Your Session ID=<%=sessionID%></h3>-->
	<br>
	<a href="LogoutServlet">Logout</a>
</body>
</html>