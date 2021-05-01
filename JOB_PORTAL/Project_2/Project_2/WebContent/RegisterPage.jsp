<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> JOB HUNT </title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<form action="RegisterPageController" method="post">
	<jsp:include page="HomePage.jsp"></jsp:include>
		<table align="center">
			<h1 align="center">Register here !!!</h1>
			<tr>
				<td> UserName </td>
				<td> <input type="text" name="username" > </td>
			</tr>
			
			<tr>
				<td> Password </td>
				<td> <input type="password" name="password" > </td>
			</tr>
			
			<tr>
				<td> Email id </td>
				<td> <input type="email" name="email_id"> </td>
			</tr>
			
			<tr>
				<td> Contact Number </td>
				<td> <input type="text" name="contact_no"> </td>				
			</tr>
			
			<tr>
				<td>Gender</td>
				<td> <input type="radio" name="gender" value="Male"> Male </td>
				<td> <input type="radio" name="gender" value="Female"> Female </td>				
			</tr>
			
			<tr>
				<td colspan="2" align="center"> <input type="submit" value="Register"> </td>
			</tr>
		</table>
	</form>
	<p align="center"><a href="LoginPage.jsp">Login here</a></p>
</body>
</html>