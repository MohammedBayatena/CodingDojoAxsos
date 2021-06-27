<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/28/2021
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Question Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex flex-column">
    <h1 class="m-2">${question.text}</h1>
    <h4 class="m-2">Tags : <c:forEach items="${question.tags}" var="tag">
        <span style="border: black solid 1px; box-shadow: black 2px 2px; padding: 3px;">${tag.subject}</span>
    </c:forEach></h4>
    <div class="d-flex justify-content-between mt-5">
        <div>
            <table class="table table-striped table-bordered m-2">
                <thead>
                <th>Answers</th>
                </thead>
                <tbody>
                <c:if test="${question.answers.isEmpty()}">
                    <tr>
                        <td>Such an Empty Place. Add an Answer!</td>
                    </tr>
                </c:if>
                <c:if test="${!question.answers.isEmpty()}">
                    <c:forEach items="${question.answers}" var="answer">
                        <tr>
                            <td>${answer.answer}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
        <div>
            <form:form action="/questions/${question.id}" method="post" modelAttribute="answero">
                <form:textarea cssClass="form-control m-2" cssStyle="resize: none;" path="answer"
                               placeholder="Enter an Answer:"/>
                <form:errors path="answer" cssClass="alert alert-warning m-2"/>
                <input class="btn btn-primary m-2" type="submit" value="Answer it!">
            </form:form>
        </div>
    </div>

</div>


</body>
</html>
