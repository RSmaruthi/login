<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<h1><center>Forgot Password </center></h1>
<table  width='520px' align='center'>
<form action = "Servlet3" method = "post">
	<tr> <td align='center'>  User Name:</td><td> <input type="text" name="uname"></td></tr>
	<br/>
      <tr> <td align='center'>Email: </td><td> <input type = "text" name="email"></td></tr>
         <br />
       <tr> <td align='center'> New  Password:</td><td> <input type = "text"  name="pass" ></td></tr>
         <br/>
         
         <tr> <td align='center'> </td><td><input type = "submit" value = "Confirm" /></td></tr>
        
         
      </form>
      </table>
</body>
</html>