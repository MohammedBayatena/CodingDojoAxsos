<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/16/2021
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Time</title>
    <link href="css/timestyle.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/timealert.js"></script>
</head>
<body>

<div class="center">
    <h1><c:out value="${time}"/></h1>
</div>

</body>
</html>



