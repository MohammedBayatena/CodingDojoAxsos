<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" 
crossorigin="anonymous">
</head>
<body>
	<div class = "container m-3 d-flex justify-content-center">
		<div class="d-flex flex-column align-items-center justify-content-center">
			<a href="Counter" class="btn btn-primary"> Click me!</a>
			<h1> You have clicked this button <c:out value="${count}"/> times</h1>
		</div>
	</div>
</body>
</html>