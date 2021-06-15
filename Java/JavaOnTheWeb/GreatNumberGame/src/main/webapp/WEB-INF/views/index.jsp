<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Great Number Game</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" 
crossorigin="anonymous">
<style>
     <%@ include file="style.css"%>
</style>
</head>
<body>

<div class="container d-flex flex-column align-items-center m-3 p-3">

<h2>Welcome to the Great Number Game!</h2>
<p>I am thinking of a number between 1 and 100</p>
<p> Take a guess!</p>


<%  if( request.getAttribute("message") != null && request.getAttribute("message").equals("Correct!") ){ %>
			<div class="rectangle" style="background-color: green;">
	<% }else{ %>
			<div class="rectangle">
	<%} %>

	<%  if( request.getAttribute("message")== null){ %>
	<p>play</p>
	<% }else{ %>
	<p><c:out value="${message}"/></p>
	<%} %>
	
</div>


<form action="/GreatNumberGame/guess" method="post" class="d-flex flex-column align-items-center">
	<input class="m-1" type="number" placeholder="Enter a Number" min=0 max=100 name="guessednum" required >	
	<%  if( request.getAttribute("message") != null && request.getAttribute("message").equals("Correct!") ){ %>
			<a href="/GreatNumberGame/" class="btn btn-primary">Play Again!</a>
	<% }else{ %>
			<input class="btn btn-primary" type="submit" value="Submit">
	<%} %>
</form>

</div>






</body>
</html>