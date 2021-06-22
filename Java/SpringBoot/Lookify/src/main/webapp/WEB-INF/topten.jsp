<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/21/2021
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Top Ten</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex flex-column">

    <header class="d-flex justify-content-between  align-items-center">
        <h1>Top 10 Songs</h1>
        <a class="m-2" href="/dashboard">Dashboard</a>
    </header>
    <h4 class="m-2">Songs</h4>
    <table class="table table-bordered table-hover table-striped">
        <thead>
        <th>Name</th>
        <th>Rating</th>
        </thead>
        <tbody>
        <c:forEach items="${songs}" var="song">
            <tr>
                <td>${song.getTitle()}</td>
                <td>${song.getRating()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
