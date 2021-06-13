<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>


<%
//Got Parameters from get
int width = request.getParameter("width") != null ? Integer.parseInt(request.getParameter("width")) : 5; 
int height = request.getParameter("height") != null ? Integer.parseInt(request.getParameter("height")) : 5;
%>




<% for ( int row = 0 ; row < height ; row++){   %>
	<div class="row">
		<% for ( int cell= 0 ; cell < width ; cell++){   %>
		
			<% if( (row+cell) % 2 == 0){ %>
				<h1 class="cell color1" ></h1>
			<% }else{ %>
				<h1 class="cell color2" ></h1>
			<% } %>	
			
		<% } %>
	</div>
	<% } %>
	






</body>
</html>