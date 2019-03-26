<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h1><center>Login</center></h1>
<table  width='520px' align='center'>
<form action = "Servlet2" method = "post">
       <tr> <td align='center'>  User Name:</td><td>  <input type = "text" name="uname"></td></tr>
         <br />
           <tr> <td align='center'>Password:</td><td> <input type = "text"  name="pass" ></td></tr>
         <br/>
         
         <tr> <td align='center'></td><td> <input type = "submit" value = "Login" /></td></tr>
        
         
      </form>
      <br/>
       <tr> <td align='center'></td><td><a href="ForgotPassword.jsp">Forgot Password</a></td></tr>
      </table>
</body>
</html>