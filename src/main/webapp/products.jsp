<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Products</title>
<%@ include file="components/commons.jsp"%>
</head>
<body>
	<nav class="navbar">
			<div class="container-fluid justify-content-center">
                <h2 >Product Search Tool</h2>
            </div >
            <div class="container-fluid justify-content-end" style="margin-top:-35px;">
            	<span class="m-2"><b>Hi <c:out value = "${uname}"/></b></span> 
                <span><a href="Logout"><button style="border-radius:7px;">Logout</button></a></span>
           </div>
    </nav>
    <c:if test="${productlist.size() == 0}">
		<h2>
				Sorry! No matching flights found!
		</h2>
	</c:if>
	<div class="row">
		<div class="col-12 col-lg-5 mt-5">
			<div class="container mx-lg-5">
				<!-- product form to enter details -->
				<h6>Please enter product details for searching!</h6>
				<form id="form" action="SearchProduct" method="post">
					<div class=" form-group row my-3">
						<label for="color" class="col-12 col-md-2">Color</label> <input
							type="text" class="col-12 col-md-4" name="color"
							placeholder="Enter Color for the product" required />
					</div>
					<div class=" form-group row mb-3">
						<label for="size" class="col-12 col-md-2">Size</label>
						<input type="text" class="col-12 col-md-4" name="size"
							id="size" placeholder="Enter Size" required />
					</div>
					<div class=" form-group row mb-3">
						<label for="gender" class="col-12 col-md-2">Gender</label> <input
							type="text" class="col-12 col-md-4" name="gender"
							id="gender" placeholder="Enter Gender" required />
					</div>
					<div class=" form-group row mb-3">
						<label for="pref" class="col-12 col-md-2 ">Output Preference</label> <input
							type="text" class="col-12 col-md-6" name="pref"
							id="pref" placeholder="Enter your preference" required />
					</div>
					<!--Adding buttons-->
					<div class="row">
						<input type="submit" class=" col-10 col-md-2 m-3" value="Search" />
						<input type="reset" class=" col-10 col-md-2 m-3" value="Clear" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="container-fluid" id="displayproducts">
		<table class="table table-striped table-bordered mt-2 result">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Color</th>
					<th>Gender</th>
					<th>Size</th>
					<th>Price</th>
					<th>Rating</th>
					<th>Availability</th>
				</tr>
				<c:forEach items="${productlist}" var="product">
					<tr>
						<td>${product.getId()}</td>
						<td>${product.getName()}</td>
						<td>${product.getColor()}</td>
						<td>${product.getGender()}</td>
						<td>${product.getSize()}</td>
						<td>${product.getPrice()}</td>
						<td>${product.getRating()}</td>
						<td>${product.getAvailable()}</td>
					</tr>
				</c:forEach>
		</table>
	</div>
</body>
</html>