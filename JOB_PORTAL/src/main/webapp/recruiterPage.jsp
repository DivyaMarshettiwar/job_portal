
<%@page import="com.niit.entities.Category"%>
<%@page import="com.niit.entities.Applied"%>
<%@page import="com.niit.entities.JobDescription"%>
<%@page import="com.niit.entities.Jobseeker"%>
<%@page import="com.niit.entities.Recruiter" %>
<%@page import="com.niit.dao.CategoryDao" %>
<%@page import="com.niit.dao.JobseekerDao" %>
<%@page import="com.niit.dao.JobsDao" %>
<%@page import="com.niit.connection.FactoryProvider" %>
<%@page import="java.util.List"%>


<!-- this is to check whether the user is login or not -->
<%
	Recruiter recruiter = (Recruiter)session.getAttribute("current-admin");

	if(recruiter == null){
		session.setAttribute("message", "You need to login first");
		response.sendRedirect("recruiterLogin.jsp");
		return;
	}
	/* else{
		if(recruiter.getClass().equals("Jobseeker")){
			session.setAttribute("message", "you are not allowed to access this page");
			response.sendRedirect("index.jsp");
			return;
		}
		
	} */
%>

<!-- for category -->
<%
	CategoryDao categorydao = new CategoryDao(FactoryProvider.getFactory());
	List<Category> list = categorydao.getCategories();
%>

<!-- for jobs -->
<%
	JobsDao jobsdao = new JobsDao(FactoryProvider.getFactory());
	List<JobDescription> joblist = jobsdao.getAllJobs();
%>

<!-- for users -->
<%
	JobseekerDao jobseekerdao = new JobseekerDao(FactoryProvider.getFactory());
	List<Jobseeker> jobseekerlist = jobseekerdao.getAllJobseekerlist();
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>

<!-- common style  -->
<%@include file="component/common_cs_js.jsp" %>

</head>
<body>

<!-- navbar component -->
<%@include file="component/LoginNavbar.jsp" %>

	<div class="container admin">
	
	<!-- this will give a message -->
	<div class="container-fluid mt-2">
		<%@include file="component/message.jsp" %>
	</div>

		<!-- for 1st row -->
		<div class="row mt-4">

			<!-- for user -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
					    <!-- this is for inside user box container -->
						<div class="container">
							<img style="max-height: 100px" class="img-fluid " src="img/team.png" alt=""/>
						</div>
						<h3><%= jobseekerlist.size() %></h3>
						<h1 class="text-uppercase text-muted">User</h1>
					</div>
				</div>
			</div>

			<!-- for category -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						 <!-- this is for inside category box container -->
						<div class="container">
							<img style="max-height: 100px" class="img-fluid " src="img/category.png" alt=""/>
						</div>
						<h3><%= list.size() %></h3>
						<h1 class="text-uppercase text-muted">Category</h1>
					</div>
				</div>
			</div>

			<!-- for job -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body text-center">
						 <!-- this is for inside job box container -->
						<div class="container">
							<img style="max-height: 100px" class="img-fluid " src="img/job-search.png" alt=""/>
						</div>
						<h3><%= joblist.size() %></h3>
						<h1 class="text-uppercase text-muted">Job</h1>
					</div>
				</div>
			</div>
			
		<!-- 1st row end -->	
		</div>

		<!-- for 2nd row -->
		<div class="row mt-4">

			<!-- for add category -->
			<div class="col-md-4">
				<div class="card" data-toggle="modal" data-target="#add-category-modal">
					<div class="card-body text-center">
						 <!-- this is for inside add category box container -->
						<div class="container">
							<img style="max-height: 100px" class="img-fluid " src="img/add.png" alt=""/>
						</div>
						<h1 class="text-uppercase text-muted">Add Category</h1>
					</div>
				</div>
			</div>

			<!-- for add job -->
			<div class="col-md-4">
				<div class="card" data-toggle="modal" data-target="#add-job-modal">
					<div class="card-body text-center">
						 <!-- this is for inside add job box container -->
						<div class="container">
							<img style="max-height: 100px" class="img-fluid " src="img/cv.png" alt=""/>
						</div>
						<h1 class="text-uppercase text-muted">Add Job</h1>
					</div>
				</div>
			</div>
			
			<!-- for applied job -->
			<div class="col-md-4">
				<div class="card" data-toggle="modal" data-target="#applied-modal">
					<a href="Applied.jsp" class="card-link"></a>
					<div class="card-body text-center">
						 <!-- this is for inside add job box container -->
						<div class="container">
							<img style="max-height: 100px" class="img-fluid " src="img/accept.png" alt=""/>
						</div>
						<h2 class="text-uppercase text-muted">View Applied jobs</h2>
					</div>
				</div>
			</div>
			
		<!-- 2nd row end -->
		</div>


	</div>


	<!-- 	add category modal -->
	<!-- Modal -->
	<div class="modal fade" id="add-category-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">ADD CATEGORY</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				
				<!-- add category form -->
				<form action="JobOperationServlet" method="post">
				
					<input type="hidden" name="operation" value="addcategory"/>
					
					<div class="form-group">
						<input type="text" class="form-control" name="catTitle" placeholder="Enter category here" required />
					</div>
					
					<!-- save and close buttons -->
					<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<input type="submit" class="btn btn-info" value="Save">
					</div>
					
				</form>
				
				
				</div>
				
			</div>
		</div>
	</div>
	<!-- 	end category modal -->


	<!-- add job modal -->
	<!-- Modal -->
	<div class="modal fade" id="add-job-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">ADD JOBS</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<!-- add jobs form -->
					<form action="JobOperationServlet" method="post">

						<input type="hidden" name="operation" value="addjob" />

						<div class="form-group">


							
							<div class="form-group">
								<select name="jobCategory" class="form-control">
								<% 
									for(Category c : list){
								%>
								<option value="<%= c.getCategoryId()%>"> 
									<%= c.getCategoryTitle() %>
								</option>
								<% 
									}
								%>
								</select>
							</div>
							
							
							<!-- <input type="text" class="form-control" name="jobCategory"
								placeholder="Enter job category here" required /> 
							<br>  -->
							<input
								type="text" class="form-control" name="jobTitle"
								placeholder="Enter job title here" required />
							 <br>
							 <input
								type="text" class="form-control" name="jobCompanyName"
								placeholder="Enter company name here" />
							 <br> 
							 <input
								type="text" class="form-control" name="jobExp"
								placeholder="Enter job experience here" />
							 <br> 
							 <input
								type="text" class="form-control" name="jobSalary"
								placeholder="Enter salary here" /> 
							<br> 
							<input type="text"
								class="form-control" name="jobLocation"
								placeholder="Enter job location here" required /> 
							<br>
						</div>

						<!-- save and close buttons -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<input type="submit" class="btn btn-info" value="Save">
						</div>
					</form>
					<!-- add job form ends here -->

				</div>
			
			</div>
		</div>
	</div>
	<!-- end job modal -->
	
	
		<!-- 	applied modal -->
	<!-- Modal -->
	<!--  
	<div class="modal fade" id="applied-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">View who applied</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
				
				<%-- 	<%
						Jobseeker jobseeker = new Jobseeker();
						Applied applied = new Applied(FactoryProvider.getFactory());
						applied.getDetails(); 
					%> --%>
					<h6><%-- <%=jobseeker.getJobseekerName() %> --%></h6>
				
				</div>
				
			</div>
		</div>
	</div>
	-->
	<!-- 	end applied modal -->

</body>
</html>