<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- common style  -->
<%@include file="component/common_cs_js.jsp" %>

</head>
<body>

<!-- navbar component -->
<%@include file="component/navbar.jsp" %>


<!-- jobseeker registration form -->
	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
		
		<!-- page heading -->
		<h3 class="text-center my-2">Sign up here</h3>
		
		
		<!-- this will print the message of successful registration -->
		<%@include file="component/message.jsp" %>
		
			<form action="RecruiterRegisterController" method="post">
			
			<!-- username -->
				<div class="form-group">
					<label for="exampleInputEmail1">User Name</label> 
					<input
						type="text" class="form-control" id="exampleInputEmail1" name="username"
						aria-describedby="emailHelp" placeholder="Enter username" required>
				</div>
				
				
				<!-- email -->
				<div class="form-group">
					<label for="exampleInputEmail1">Email id</label> 
					<input
						type="email" class="form-control" id="exampleInputEmail1" name="email"
						aria-describedby="emailHelp" placeholder="Enter email id" required>
				</div>
				
				
				<!-- password -->
				<div class="form-group">
					<label for="exampleInputEmail1">Password</label> 
					<input
						type="password" class="form-control" id="exampleInputEmail1" name="password"
						aria-describedby="emailHelp" placeholder="Enter password" required>
				</div>
				
				
				<!-- company name -->
				<div class="form-group">
					<label for="exampleInputEmail1">Company Name</label> 
					<input
						type="text" class="form-control" id="exampleInputEmail1" name="companyName"
						aria-describedby="emailHelp" placeholder="Enter company name" required>
				</div>
				
				
				<!-- contact -->
				<div class="form-group">
					<label for="exampleInputEmail1">Contact number</label> 
					<input
						type="tel" class="form-control" id="exampleInputEmail1" name="contact"
						aria-describedby="emailHelp" placeholder="Enter contact number">
				</div>
				

				<!-- Register and reset button -->
				<div class="container text-center">
					<button type="submit" class="btn btn-outline-success">Register</button>
				</div>
				
				
				
			</form>
		</div>
	</div>

</body>
</html>