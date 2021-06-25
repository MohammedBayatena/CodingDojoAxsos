<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/25/2021
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Dojo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>


<div class="container d-flex align-items-center flex-column p-5">
    <h1>New Dojo</h1>
    <form:form action="/dojos/new" method="post" modelAttribute="dojo" class="d-flex flex-column align-items-start">
        <div class="row m-1">
            <form:input path="name" placeholder="Enter Dojo Name" class="form-control col-5" required="required"/>
        </div>
        <div class=" align-self-end">
            <input value="Create" type="submit" class="btn btn-primary">
        </div>
    </form:form>
</div>


</body>
</html>
