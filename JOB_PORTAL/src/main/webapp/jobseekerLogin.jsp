<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login here</title>

<!-- common style  -->
<%@include file="component/common_cs_js.jsp" %>

</head>
<body>

<!-- navbar component -->
<%@include file="component/navbar.jsp" %>

<!-- jobseeker login form -->
	<div class="row mt-5">
		<div class="col-md-4 offset-md-4">
		
		<!-- page heading -->
		<h3 class="text-center my-2"> Login here</h3>
		
		
		<!-- this is a message if username and password is invalid -->
		<%@include file="component/message.jsp"%>
		
		
		<!-- form filling starts here -->
			<form action="JobseekerLoginController" method="post">
			
			<!-- username -->
			<!-- 	<div class="form-group">
					<label for="exampleInputEmail1">User Name</label> 
					<input
						type="text" class="form-control" id="exampleInputEmail1" name="username"
						aria-describedby="emailHelp" placeholder="Enter username" required>
				</div> -->
				
				
				<!-- email -->
				<div class="form-group">
					<label for="exampleInputEmail1">Email id</label> 
					<input
						type="email" class="form-control" id="exampleInputEmail1" name="email"
						aria-describedby="emailHelp" placeholder="Enter email id" required>
				</div>
				
				
				<!-- password -->
				<!-- <div class="form-group">
					<label for="exampleInputEmail1">Password</label> 
					<input
						type="password" class="form-control" id="exampleInputEmail1" name="password"
						aria-describedby="emailHelp" placeholder="Enter password" required>
				</div> -->
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password" name="password">
				</div>


				<!-- Register and reset button -->
				<div class="container text-center">
					<button type="submit" class="btn btn-outline-success">Login</button>
				</div>
								
			</form>
		</div>
	</div>
	


</body>
</html>