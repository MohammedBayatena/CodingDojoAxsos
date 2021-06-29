<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/29/2021
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Events</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<header class="d-flex justify-content-between">
    <h1 class="m-2">Welcome, <c:out value="${user.firstName} ${user.lastName}"/></h1>
    <a class="m-3" href="/logout">Logout</a>
</header>

<div class="container d-flex flex-column">
    <p class="m-2">Here are Some of the events in your state:</p>
    <table class="table table-striped table-bordered">
        <thead>
        <th>Name</th>
        <th>Date</th>
        <th>Location</th>
        <th>Host</th>
        <th>Action/Status</th>
        </thead>
        <tbody>
        <c:forEach items="${nearbyevents}" var="event">
            <tr>
                <td><a href="/events/${event.id}">${event.name}</a></td>
                <td><fm:formatDate value="${event.eventDate}" pattern="MMMM dd, yyyy" type="Date"/></td>
                <td>${event.location}</td>
                <td>${event.host.firstName}</td>
                <td>
                    <c:if test="${event.host == user}"><a href="/edit/${event.id}">Edit</a> <a
                            href="/delete/${event.id}">Delete</a></c:if>
                    <c:if test="${user.events.contains(event)}"><a>Joining</a> <a
                            href="/cancel/${event.id}">Cancel</a></c:if>
                    <c:if test="${!(user.events.contains(event)) and !(event.host == user) }"><a
                            href="/join/${event.id}">Join</a></c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <p class="m-2">Here are Some of the events in other states:</p>
    <table class="table table-striped table-bordered">
        <thead>
        <th>Name</th>
        <th>Date</th>
        <th>Location</th>
        <th>State</th>
        <th>Host</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach items="${farevents}" var="event">
            <tr>
                <td><a href="/events/${event.id}">${event.name}</a></td>
                <td><fm:formatDate value="${event.eventDate}" pattern="MMMM dd, yyyy" type="Date"/></td>
                <td>${event.location}</td>
                <td>${event.state}</td>
                <td>${event.host.firstName}</td>
                <td>
                    <c:if test="${event.host == user}"><a href="/edit/${event.id}">Edit</a> <a
                            href="/delete/${event.id}">Delete</a></c:if>
                    <c:if test="${user.events.contains(event)}"><a>Joining</a> <a
                            href="/cancel/${event.id}">Cancel</a></c:if>
                    <c:if test="${!(user.events.contains(event)) and !(event.host == user) }"><a
                            href="/join/${event.id}">Join</a></c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <form:form modelAttribute="event" method="post" action="/events" cssClass="align-self-start">

        <div class="row mb-3">
            <label for="inputfname" class="col-sm-4 col-form-label text-nowrap">Event Name:</label>
            <div class="col-sm-8">
                <form:input type="text" path="name" class="form-control" id="inputfname"
                            required="required"/>
            </div>
        </div>

        <div class="row mb-3">
            <label for="inputlname" class="col-sm-4 col-form-label text-nowrap">Date:</label>
            <div class="col-sm-8">
                <form:input type="date" path="eventDate" class="form-control" id="inputlname"
                            required="required"/>
            </div>
        </div>

        <div class="row mb-3">
            <label for="inputlocation" class="col-sm-4 col-form-label text-nowrap">Location:</label>
            <div class="col-sm-5">
                <form:input type="text" path="location" class="form-control" id="inputlocation" required="required"/>
            </div>
            <div class="col-sm-3">
                <form:select path="state" class="form-select" required="required">
                    <form:option value="CA">CA</form:option>
                    <form:option value="AZ">AZ</form:option>
                    <form:option value="WA">WA</form:option>
                    <form:option value="TX">TX</form:option>
                    <form:option value="NY">NY</form:option>
                </form:select>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col-sm-8 col-md-3 offset-sm-4 margin-collapse">
                <button type="submit" class="btn btn-primary btn-dark">Create</button>
            </div>
        </div>
    </form:form>
    <div>
        <form:errors path="event.*" cssClass="alert alert-warning d-flex align-items-center"/>
    </div>

</div>

</body>
</html>
