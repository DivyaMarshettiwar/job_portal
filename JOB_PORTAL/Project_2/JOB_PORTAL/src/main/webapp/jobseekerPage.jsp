<%@page import="com.niit.entities.Jobseeker" %>

<!-- this is to check whether the user is login or not -->
<%
    Jobseeker jobseeker = (Jobseeker)session.getAttribute("current-user");

	if(jobseeker == null){
		session.setAttribute("message", "You need to login first");
		response.sendRedirect("jobseekerLogin.jsp");
		return;
	}
	/* else{
		if(jobseeker.getClass().equals("admin")){
			session.setAttribute("message", "you are not allowed to access this page");
			response.sendRedirect("index.jsp");
			return;
		} */
		
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobseeker Page</title>

<!-- common style  -->
<%@include file="component/common_cs_js.jsp" %>

</head>
<body>

<!-- navbar component -->
<%@include file="component/navbar.jsp" %>

</body>
</html>