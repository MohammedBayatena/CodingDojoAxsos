<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/22/2021
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex flex-column border mt-5">
    <header class="d-flex justify-content-between  align-items-center">
        <div>
            <h3></h3>
        </div>
        <a class="m-2" href="/dashboard">Dashboard</a>
    </header>
    <h1 class="align-self-center">Song Info</h1>
    <p>Name: ${song.getTitle()}</p>
    <p>Artist: ${song.artist}</p>
    <p>Rating: ${song.getRating()}</p>
    <a href="/delete/${song.id}">delete</a>
</div>

</body>
</html>
