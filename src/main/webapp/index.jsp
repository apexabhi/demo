
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Search WebApp</title>
<%@ include file="components/commons.jsp"%>
</head>
<body>
	<div class="container-fluid col-md-6 my-5 p-3" style="border:2px solid black">
	<h4>Login if existing user</h4>
	<form action="LogIn" method="post">
		<div class="mb-3">
			<label for="username" class="form-label">UserName</label> 
			<input type="text" class="form-control" name="username"
				id="username">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password</label>
			<input type="password" class="form-control" name="pwd"
				id="pwd">
		</div>
		<input type="submit" class="btn btn-primary" value="LogIn" />
	</form>
	</div>

	<div class="container-fluid col-md-6 my-5 p-3" style="border:2px solid black">
	<h4>Register to create new user</h4>
	<form action="SignUp" method="post">
		<div class="mb-3">
			<label for="username" class="form-label">UserName</label> 
			<input type="text" class="form-control" name="username"
				id="username">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password</label>
			<input type="password" class="form-control" name="pwd"
				id="pwd">
		</div>
		<input type="submit" class="btn btn-primary" value="Register" />
	</form>
	</div>

</body>
</html>
