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
    <title>DashBoard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex flex-column">
    <header class="d-flex justify-content-between  align-items-center">
        <div>
            <h3>Songs by artist: ${artist}</h3>
        </div>
        <form class="d-flex align-items-center m-0 p-0" action="/search" method="post">
            <input class="form-control m-2" type="text" name="songSearch" required></input>
            <input class="btn btn-primary" type="submit" value="New Search">
        </form>
        <a class="m-2" href="/dashboard">Dashboard</a>
    </header>
    <h1 class="align-self-center">Songs</h1>
    <table class="table table-bordered table-hover table-striped">
        <thead>
        <th>Name</th>
        <th>Rating</th>
        <th>actions</th>
        </thead>
        <tbody>
        <c:forEach items="${songs}" var="song">
            <tr>
                <td><a href="/songs/${song.id}">${song.getTitle()}</a></td>
                <td>${song.getRating()}</td>
                <td><a href="/delete/${song.id}">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
