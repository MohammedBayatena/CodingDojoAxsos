<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/25/2021
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1>All Students</h1>
    <table class="table table-striped table-bordered">
        <thead>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
        </thead>
        <tbody>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.firstName} ${student.lastName}</td>
                <td>${student.age}</td>
                <c:if test="${student.contact != null}">
                    <td>${student.contact.address}</td>
                    <td>${student.contact.city}</td>
                    <td>${student.contact.state}</td>
                </c:if>
                <c:if test="${student.contact == null}">
                    <td>Not Assigned yet!</td>
                    <td>Not Assigned yet!</td>
                    <td>Not Assigned yet!</td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
