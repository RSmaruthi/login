<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><center>Registration Form</center></h1>

<form action = "Servlet1" method="post">
<table  width='480px' align='center'>
        <tr>
    <td align='center'> First Name: </td><td><input type = "text" name = "firstName"> </td></tr>
  		<br />
        <tr> <td align='center'>  Last Name: </td><td> <input type = "text" name = "lastName" /></td></tr>
         <br/>
          <tr> <td align='center'> User Name: </td><td> <input type = "text" name = "Uname" /></td></tr>
         <br/>
         <tr> <td align='center'> Email-id:  </td><td>   <input type = "text" name = "email" /></td></tr>
         <br/>
         <tr> <td align='center'> Password:  </td><td>   <input type = "text" name = "pass" /></td></tr>
         <br/>
         <tr> <td align='center'> Mobile No: </td><td>   <input type = "text" name = "Mnum" /></td></tr>
         <br/> 
        <tr> <td align='center'> </td><td>  <input type = "submit" value = "Register" /></td></tr>
    </table>
      </form>

</body>

</html>