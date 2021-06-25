<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/25/2021
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dojo Info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h1>${dojo.name} Ninjas</h1>
    <c:if test="${dojo.ninjas.isEmpty()}">
        <h2>No Ninjas Yet!!</h2>
    </c:if>

    <c:if test="${!dojo.ninjas.isEmpty()}">
        <table class="table table-striped table-bordered">
            <thead>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
            </thead>
            <tbody>
            <c:forEach items="${dojo.ninjas}" var="ninja">
                <tr>
                    <td>${ninja.firstName}</td>
                    <td>${ninja.lastName}</td>
                    <td>${ninja.age}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>


</body>
</html>
