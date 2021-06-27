<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/26/2021
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Questions Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container d-flex flex-column">
    <h1>Questions Dashboard</h1>
    <table class="table table-striped table-bordered table-light">
        <thead>
        <th>Question</th>
        <th>Tags</th>
        </thead>
        <tbody>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td>
                    <a href="questions/${question.id}">${question.text}</a>
                </td>
                <td>
                    <c:forEach items="${question.tags}" var="tag">
                        ${tag.subject},
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/questions/new" class="align-self-end">New Question</a>
</div>
</body>
</html>
