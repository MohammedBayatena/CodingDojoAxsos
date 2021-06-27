<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/26/2021
  Time: 8:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Question</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container" style="width: 700px;">
    <h1>What is Your Question?</h1>
    <form action="/questions/new" method="post" class="d-flex flex-column">
        <c:if test="${texterror != null}">
            <div class="alert alert-warning">
                <c:out value="${texterror}"/>
            </div>
        </c:if>
        <div class="row m-1">
            <textarea rows="5" placeholder="Enter Your Question: " name="text" class="form-control;"
                      style="resize: none;"></textarea>
        </div>
        <div class="row m-1">
            <c:if test="${tagerror != null}">
                <div class="alert alert-warning">
                    <c:out value="${tagerror}"/>
                </div>
            </c:if>
            <input type="text" name="tags" placeholder="Enter Tags as comma separated values: ">
        </div>
        <div class="row m-1 align-self-end">
            <input value="Submit" type="submit" class="btn btn-primary">
        </div>
    </form>
</div>


</body>
</html>
