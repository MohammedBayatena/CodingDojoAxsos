<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/21/2021
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>New Song</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>

<div class="container d-flex flex-column">
    <header class="d-flex justify-content-between  align-items-center">
        <h1>Add a new Song: </h1>
        <a class="m-2 align-self-end" href="/dashboard">Dashboard</a>
    </header>

    <form:form action="" method="post" modelAttribute="song">
        <%--        <input type="hidden" name="_method" value="post">--%>
        <div class="row col-4">
            <form:errors class="alert alert-warning" path="title"/>
        </div>
        <div class="row  m-2">
            <div class="col-sm-2"><form:label class="form-label" path="title">Title</form:label></div>
            <div class="col-sm-4"><form:input class="form-control" path="title"/></div>
        </div>
        <div class="row col-4">
            <form:errors class="alert alert-warning" path="artist"/>
        </div>
        <div class="row  m-2">
            <div class="col-sm-2"><form:label class="form-label" path="artist">Artist</form:label></div>
            <div class="col-sm-4"><form:input class="form-control" path="artist"/></div>
        </div>

        <div class="row col-4">
            <form:errors class="alert alert-warning" path="rating"/>
        </div>
        <div class="row  m-2">
            <div class="col-sm-2"><form:label class="form-label" path="rating">Rating</form:label></div>
            <div class="col-sm-4"><form:input type="number" min="1" max="10" value="1" class="form-control"
                                              path="rating"/></div>
        </div>
        <div class="row  m-2">
            <div class="col-2 offset-sm-6">
                <input type="submit" value="Add Song" class="btn btn-primary"/>
            </div>
        </div>


    </form:form>


</div>


</body>
</html>
