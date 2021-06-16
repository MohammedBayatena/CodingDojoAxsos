<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/16/2021
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Counter</title>
</head>
<body>
    <p> You have visited <%= request.getRequestURL() %> ${counter} times <a href="/">Test another visit?</a></p>
</body>
</html>
