<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Player</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" 
crossorigin="anonymous">
<style>
     <%@ include file="style.css"%>
</style>
</head>
<body>
<header class="p-3">
	<h1>Create a new player: </h1>
</header>
<form class="ml-50" action="" method="post"> 

	<div class="ml-50 m-3 row">
		<div class="col-sm-1">
			<label class="form-label" for="firstname">First Name: </label>
		</div>
		<div class="col-sm-3">
			<input class="form-control" type="text" name="firstname" id="playerfirstname" required> 
		</div>
	</div>
	<div class="ml-50 m-3 row">
		<div class="col-sm-1">
			<label class="form-label" for="lastname">Last Name: </label>
		</div>
		<div class="col-sm-3">
			<input class="form-control" type="text" name="lastname" id="playerlastname" required> 
		</div>
	</div>
	<div class="ml-50 m-3 row">
		<div class="col-sm-1">
			<label class="form-label" for="age">Age: </label>
		</div>
		<div class="col-sm-3">
			<input class="form-control" type="number" min=18 max=99 name="age" id="playerage" required> 
		</div>
	</div>
	<div class="row">
		<a class="btn btn-primary col-1 offset-2" href="details?team=${teamName}">Back</a>
		<input class="btn btn-primary col-1 ml-5" type="submit" value="Create">
	</div>
 </form>
</body>
</html>