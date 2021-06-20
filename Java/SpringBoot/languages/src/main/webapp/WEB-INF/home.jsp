<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/20/2021
  Time: 9:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

<div class="container p-3">
    <h1>Languages</h1>
    <table class="table table-bordered table-striped table-hover">
        <thead>
        <th>Name</th>
        <th>Creator</th>
        <th>Version</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${languages}" var="lang">
            <tr>
                <td><a href="languages/${lang.getId()}"><c:out value="${lang.getName()}"/></a></td>
                <td><c:out value="${lang.getCreator()}"/></td>
                <td><c:out value="${lang.getVersion()}"/></td>
                <td>
                    <form id="delete${lang.getId()}" style="display: inline-block;" action="languages/${lang.getId()}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <a href="#" onclick="doSubmit(${lang.getId()})">Delete</a>
                    </form>
                    <a href="/languages/${lang.getId()}/edit">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form:form action="/languages" method="post" modelAttribute="language">
        <div class="row col-sm-5">
            <form:errors path="name" class="alert alert-warning"/>
        </div>
        <div class="row m-2">
            <div class="col-sm-2">
                <form:label path="name" class="form-label">Language Name: </form:label>
            </div>
            <div class="col-sm-3">
                <form:input class="form-control" path="name"/>
            </div>
        </div>
        <div class="row col-sm-5">
            <form:errors path="creator" class="alert alert-warning"/>
        </div>
        <div class="row m-2">
            <div class="col-sm-2">
                <form:label path="creator" class="form-label">Creator Name: </form:label>
            </div>
            <div class="col-sm-3">
                <form:input path="creator" class="form-control"/>
            </div>
        </div>
        <div class="row col-sm-5">
            <form:errors path="version" class="alert alert-warning"/>
        </div>
        <div class="row m-2">
            <div class="col-sm-2">
                <form:label path="version" class="form-label">Version: </form:label>
            </div>
            <div class="col-sm-3">
                <form:input path="version" class="form-control"/>
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
        document.getElementById("delete"+id).submit();
    }
</script>

</body>
</html>
