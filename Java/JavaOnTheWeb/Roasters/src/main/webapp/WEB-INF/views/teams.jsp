<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teams</title>
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
			<h2>${teamName}</h2>
			<div>
				<a class="mr-5" href="Home">Home</a>
				<a class="mr-5" href="players?team=${teamName}">New Player</a>
			</div>
		</div>
	</header>
	
	<table class="table table-striped table-hover border ">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teamslist}">
		         <c:if test="${team.getName().equals(teamName)}">
		         <c:forEach var="player" items="${team.getPlayers()}">
			    	<tr>
						<td>${player.getFirstName()}</td>
						<td>${player.getLastName()}</td>
						<td>${player.getAge()}</td>
						<td>
							<a href="delete?team=${teamName}&firstname=${player.getFirstName()}&lastname=${player.getLastName()}">Delete</a>
						</td>
					</tr>
		          </c:forEach>         
				</c:if>
		    </c:forEach>
		</tbody>
	</table>
</body>
</html>