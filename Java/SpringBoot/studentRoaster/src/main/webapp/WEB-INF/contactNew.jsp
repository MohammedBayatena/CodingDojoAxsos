<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/25/2021
  Time: 10:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>New Contact</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex align-items-center flex-column p-5">
    <h1>New Contact</h1>
    <form:form method="post" action="/contact/new" modelAttribute="contact"
               class="d-flex flex-column align-items-start">
        <div class="row m-1 col-12">
            <form:select path="student" placeholder="Select Student" class="form-select" required="required">
                <c:forEach items="${students}" var="student">
                    <form:option value="${student}">${student.firstName} ${student.lastName}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="row m-1 col-12">
            <form:input path="address" placeholder="Enter Address" class="form-control col-5"
                        required="required"/>
        </div>
        <div class="row m-1 col-12">
            <form:input path="city" placeholder="Enter City" class="form-control col-5"
                        required="required"/>
        </div>
        <div class="row m-1 col-12">
            <form:input path="state" placeholder="Enter State" class="form-control col-5"
                        required="required"/>
        </div>
        <div class=" align-self-end">
            <input value="Create" type="submit" class="btn btn-primary">
        </div>
    </form:form>
</div>


</body>
</html>
