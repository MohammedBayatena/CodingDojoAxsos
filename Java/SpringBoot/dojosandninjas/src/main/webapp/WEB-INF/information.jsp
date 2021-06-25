<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/26/2021
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Information</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<div class="container">
    <h1>Information</h1>

    <c:if test="${info.isEmpty()}">
        <h2>No Dojos Yet!!</h2>
    </c:if>

    <c:if test="${!info.isEmpty()}">
        <table class="table table-striped table-bordered">
            <thead>
            <th>Dojo Name</th>
            <th>Ninja Count</th>
            </thead>
            <tbody>
            <c:forEach items="${info}" var="dojo">
                <tr>
                    <td>${dojo.key}</td>
                    <td>${dojo.value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>


</body>
</html>
