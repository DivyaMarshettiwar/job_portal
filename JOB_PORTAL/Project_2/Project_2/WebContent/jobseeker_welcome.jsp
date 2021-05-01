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

<jsp:include page="HomePage.jsp"></jsp:include>

<!-- this is used to ensure that the welcome page is not accessed without login, if user tries to access it then it will be redirected to the Login page --> 
<%
	if(session.getAttribute("username") == null)
	{
		response.sendRedirect("LoginPage.jsp");
	}
%>

<h3>Welcome ${username}</h3>

<!-- logout button -->
<form action="LogoutController">
<input type="submit" value="logout">
</form>

</body>
</html>