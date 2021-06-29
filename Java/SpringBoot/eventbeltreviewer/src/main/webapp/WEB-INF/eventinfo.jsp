<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/29/2021
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${event.name}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>

<div class="container d-flex justify-content-around">
    <div class="leftSector">
        <h1>${event.name}</h1>
        <p>Host: ${event.host.firstName} ${event.host.lastName}</p>
        <p>Date : <fm:formatDate value="${event.eventDate}" pattern="MMM, dd, yyyy"/></p>
        <p>Location: ${event.location}, ${event.state}</p>
        <p>People attending this event: </p>
        <table class="table table-striped table-bordered">
            <thead>
            <th>Name</th>
            <th>Location</th>
            </thead>
            <tbody>
            <c:forEach items="${event.users}" var="atendee">
                <tr>
                    <td>${atendee.firstName} ${atendee.lastName}</td>
                    <td>${atendee.address}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="rightsector mt-5">
        <h2 class="mt-2">Message Wall</h2>
        <div class="mt-2 form-control"
             style="overflow: scroll; overflow-x: hidden;  border: solid black 1px; word-break: break-word; max-width: 300px; max-height: 220px;">
            <c:forEach items="${event.messages}" var="message">
                <p>${message.author} Says: ${message.text}</p>
                <p>.......................</p>
            </c:forEach>
            <c:if test="${event.messages.isEmpty()}">
                Empty!
            </c:if>
        </div>

        <form:form modelAttribute="message" method="post" action="/events/${event.id}" cssClass="d-flex flex-column">
            <p>Add a comment</p>
            <form:errors path="text" cssClass="alert alert-warning"/>
            <form:textarea path="text" cssStyle="resize: none;" cssClass="form-input"></form:textarea>
            <input type="submit" value="Submit" class="btn btn-dark align-self-start mt-2">
        </form:form>

    </div>


</div>


</body>
</html>
