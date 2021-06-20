<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/20/2021
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex flex-column">
    <header class="align-self-end m-2">
        <form id="delete${lang.getId()}" style="display: inline-block;" action="/languages/${lang.getId()}"
              method="post">
            <input type="hidden" name="_method" value="delete">
            <a href="#" onclick="doSubmit(${lang.getId()})">Delete</a>
        </form>
        <a href="/languages">Dashboard</a>
    </header>
    <h1 class="m-2 p-2">Edit ${lang.getName()}: </h1>
    <form:form action="/languages/${lang.getId()}" method="post" modelAttribute="language">
        <input type="hidden" name="_method" value="put">
        <form:errors path="name" class="alert alert-warning"/>
        <div class="row m-2">
            <div class="col-sm-2">
                <form:label path="name" class="form-label">Language Name: </form:label>
            </div>
            <div class="col-sm-3">
                <form:input class="form-control"  value="${lang.getName()}" path="name"/>
            </div>
        </div>

        <form:errors path="creator" class="alert alert-warning"/>
        <div class="row m-2">
            <div class="col-sm-2">
                <form:label path="creator" class="form-label">Creator Name: </form:label>
            </div>
            <div class="col-sm-3">
                <form:input path="creator" value="${lang.getCreator()}" class="form-control"/>
            </div>
        </div>

        <form:errors path="version" class="alert alert-warning"/>
        <div class="row m-2">
            <div class="col-sm-2">
                <form:label path="version" class="form-label">Version: </form:label>
            </div>
            <div class="col-sm-3">
                <form:input path="version" value="${lang.getVersion()}" class="form-control"/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-2 offset-sm-4">
                <input type="submit" value="Submit" class="btn btn-primary"/>
            </div>
        </div>

    </form:form>
</div>
<script>
    function doSubmit(id) {
        document.getElementById("delete" + id).submit();
    }
</script>

</body>
</html>
