<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<div align="center">
	<form action="RegisterPageController" method="post">
		<table style="background-color:lightblue; margin-left:20px; margin-top:20px">
		
			<tr>
				<td></td>
				<td><h3> Register Page </h3></td>
				<td></td>
			</tr>
		
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
				<td> <input type="text" name="contact"> </td>
			</tr>
			<tr>
				<td>Gender</td>
				<td> <input type="radio" name="gender" value="Male"> Male </td>
				<td> <input type="radio" name="gender" value="Female"> Female </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" name="submit" value="Register"> </td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>