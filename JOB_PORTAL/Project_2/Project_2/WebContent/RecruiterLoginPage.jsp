<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<form action="RecruiterLoginPageController" method="post">
	<jsp:include page="HomePage.jsp"></jsp:include>
		<table align="center">
			<tr>
				<td>UserName</td>
				<td> <input type="text" name="username">  </td>
			</tr>
			<tr>
				<td>Password</td>
				<td> <input type="Password" name="password">  </td>
			</tr>
			<tr> 
				<td colspan="2" align="center"> <input type="Submit" value="Login"> </td>
			</tr>
		</table>
	</form>
	<p align="center">If not registered, then <a href="RegisterPage.jsp">Register here</a></p>
</body>
</html>