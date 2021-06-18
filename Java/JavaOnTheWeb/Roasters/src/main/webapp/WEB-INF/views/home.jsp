<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Roasters Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" 
crossorigin="anonymous">
<style>
     <%@ include file="style.css"%>
</style>
</head>
<body>


<header>
<div class="d-flex justify-content-between">
<h2>Prototype Roaster</h2>
<div>
<a class="mr-5" href="Home">Home</a>
<a class="mr-5" href="teams">New Team</a>
</div>

</div>
</header>

<table class="table table-striped table-hover border ">

<thead>
	<tr>
		<th>Team</th>
		<th>Player</th>
		<th>Action</th>
	</tr>
</thead>

<tbody>
	<c:forEach var="team" items="${teamslist}">
         <tr>
		<td>${team.getName()}</td>
		<td>${team.getNoOfPlayers()}</td>
		<td>
			<a href="details?team=${team.getName()}">Details</a>
			<a href="delete?team=${team.getName()}">Delete</a>
		</td>
	</tr>
    </c:forEach>
</tbody>

</table>


</body>
</html>