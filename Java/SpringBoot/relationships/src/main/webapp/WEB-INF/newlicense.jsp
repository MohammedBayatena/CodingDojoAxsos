<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/25/2021
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>New License</title>
</head>
<body>

<div class="container d-flex align-items-center flex-column p-5">
    <h1>New License</h1>
    <form:form method="post" action="/licenses/new" modelAttribute="license"
               class="d-flex flex-column align-items-start">
        <div class="row m-1 col-12">
            <form:select path="person" placeholder="Enter Person" class="form-select" required="required">
                <c:forEach items="${persons}" var="person">
                    <form:option value="${person}">${person.firstName} ${person.lastName}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="row m-1 col-12">
            <form:input path="state" placeholder="Enter State" class="form-control col-5"
                        required="required"/>
        </div>
        <div class="row m-1 col-12">
            <form:input type="date" path="expirationDate" placeholder="Enter State" class="form-control col-5"
                        required="required"/>
        </div>
        <div class=" align-self-end">
            <input value="Create" type="submit" class="btn btn-primary">
        </div>
    </form:form>
</div>


</body>
</html>
