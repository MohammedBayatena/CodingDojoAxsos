<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/20/2021
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex flex-column">
    <header class="align-self-end m-2">
        <a href="/languages">Dashboard</a>
    </header>
    <h1 class="m-2 align-self-start">${lang.getName()} Information:</h1>
    <div class="align-self-center d-flex align-items-start flex-column align-content-center">
        <h4> Language Name: <span style="font-family: cursive"><c:out value="${lang.getName()}"/></span></h4>
        <div class="d-flex flex-row">
            <h4> Language Creator:</h4>
            <h4 style="font-family: cursive"><c:out value="${lang.getCreator()}"/></h4>
        </div>
        <h4> Language Version: <span style="font-family: cursive"><c:out value="${lang.getVersion()}"/></span></h4>
    </div>
</div>


</body>
</html>
