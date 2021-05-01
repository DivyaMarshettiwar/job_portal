<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Login </title>
</head>
<body>
<div align="center">
	<form action="LoginPageController" method="post" align="center">
		<table style="background-color:lightgreen; margin-left:20px; margin-top:20px">
		
			<tr>
				<td></td>
				<td><h3> Login Page </h3></td>
				<td></td>
			</tr>
		
			<tr>
				<td>UserName</td>
				<td> <input type="text" name="username">  </td>
			</tr>

			<tr><td></td></tr>
			
			<tr>
				<td>Password</td>
				<td> <input type="Password" name="password">  </td>
			</tr>
			
			<tr><td></td></tr>
			
			<tr> 
				<td> <input type="Submit" name="submit" value="Login"> </td>
				<td> <a href="RegisterPage.jsp">Register</a> </td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>