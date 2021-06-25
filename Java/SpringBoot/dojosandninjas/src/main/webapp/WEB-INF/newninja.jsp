<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/25/2021
  Time: 11:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Ninja</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex align-items-center flex-column p-5">
    <h1>New Ninja</h1>
    <form:form method="post" action="/ninjas/new" modelAttribute="ninja"
               class="d-flex flex-column align-items-start">
        <div class="row m-1 col-12">
            <form:select path="dojo" placeholder="Select Dojo" class="form-select" required="required">
                <c:forEach items="${dojos}" var="dojo">
                    <form:option value="${dojo}">${dojo.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="row m-1 col-12">
            <form:input path="firstName" placeholder="Enter First Name" class="form-control col-5"
                        required="required"/>
        </div>
        <div class="row m-1 col-12">
            <form:input path="lastName" placeholder="Enter Last Name" class="form-control col-5"
                        required="required"/>
        </div>
        <div class="row m-1 col-12">
            <form:input path="age" placeholder="Enter Age" type="number" min="10" max="99" value="x" class="form-control col-5"
                        required="required"/>
        </div>
        <div class=" align-self-end">
            <input value="Create" type="submit" class="btn btn-primary">
        </div>
    </form:form>
</div>


</body>
</html>
