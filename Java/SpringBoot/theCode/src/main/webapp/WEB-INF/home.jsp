<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/16/2021
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<form class="d-flex container align-items-center justify-content-center flex-column" action="/secret" method="post">
    <h1>What is the code?</h1>
    <p class="m-1"><c:out value="${message}"/></p>
    <div>
        <input class="m-2 form-control" type="text" placeholder="Enter Code" name="code" required>
    </div>
    <input class="btn btn-primary" type="submit" value="Try Code">
</form>

</body>
</html>
