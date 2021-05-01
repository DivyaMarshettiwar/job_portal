
<%@page import="com.niit.connection.FactoryProvider" %>
<%@page import="com.niit.dao.JobsDao" %>
<%@page import="com.niit.dao.CategoryDao" %>
<%@page import="java.util.List"%>
<%@page import="com.niit.entities.JobDescription" %>
<%@page import="com.niit.entities.Category" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find jobs here</title>

<!-- common style  -->
<%@include file="component/common_cs_js.jsp" %>

</head>
<body>

<!-- navbar component -->
<%@include file="component/navbar.jsp" %>

<!-- category row -->
<div class="row">

	<!-- to fetch all jobs -->
	<%
		JobsDao jobsdao = new JobsDao(FactoryProvider.getFactory());
		List<JobDescription> list = jobsdao.getAllJobs();
		
		CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
		List<Category> clist = cdao.getCategories();
	%>
	<div class="col-md-12">
	
	<!-- to fetch category type -->
	<% 
		for(Category category : clist){
			out.println(category.getCategoryTitle() + "<br>");
		}
	%>
	
		<div class="col-md-5">
			<%
				for(JobDescription jobs : list){
					out.println(jobs.getJobDesignation() + "<br>");
				}
			%>
		</div>
	</div>
</div>

</body>
</html>