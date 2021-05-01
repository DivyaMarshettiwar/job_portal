<%@page import="com.niit.entities.Jobseeker" %>
<%@page import="com.niit.connection.FactoryProvider" %>
<%@page import="com.niit.dao.JobsDao" %>
<%@page import="com.niit.dao.CategoryDao" %>
<%@page import="java.util.List"%>
<%@page import="com.niit.entities.JobDescription" %>
<%@page import="com.niit.entities.Category" %>

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
<%@include file="component/LoginNavbar.jsp" %>


<div class="container-fluid">
<!-- category row -->
<div class="row mt-3 mx-2">

	<!-- to fetch all jobs -->
	<%
		JobsDao jobsdao = new JobsDao(FactoryProvider.getFactory());
		List<JobDescription> list = jobsdao.getAllJobs();
		
		CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
		List<Category> clist = cdao.getCategories();
	%>
	
	<!-- for category -->
	<div class="col-md-2">
		<div class="list-group mt-4">
		 	<a href="#" class="list-group-item list-group-item-action active btn custom-bg text-white">
   		 	Category
 		 	</a>
		
	
	<!-- to fetch category type -->
	<% 
		for(Category category : clist){
	%>
	
	  <a href="#" class="list-group-item list-group-item-action">
	  <%=category.getCategoryTitle() %> 
	  </a>
	
	<%
		}
	%>
	
		</div>
	
</div>	
	
	<!-- for jobs -->
		<div class="col-md-8">
			<!-- job row -->
			<div class="row mt-4">
			
				<!-- job column -->
				<div class="col-md-12">
					
					
						<!-- traversing -->
						<%
							for(JobDescription jobs : list){
						%>
							<div class="card">
								<div class="card-body">
									<h5 class="card-title">Designation : <%= jobs.getJobDesignation() %></h5>
									<p class="card-text">
										<p>Company Name : <%=jobs.getJobCompanyName()%></p>
										<p>Work Experience : <%=jobs.getJobExperience()%></p>
										<p>Salary : <%=jobs.getJobSalary()%></p>
										<p>Location : <%=jobs.getJobLocation()%></p>	
											
										
									</p>
								</div>
								
								<!-- button to apply for job -->
								<form action="AppliedJob" method="post">
									<div class="card-footer">
									<button class="btn custom-bg text-white">APPLY</button>
									</div>
								</form>
								
							</div>
							<br>
						<% 
							}
						%>
					
				</div>
			</div>
		

		</div>
	</div>

</div>

</body>
</html>