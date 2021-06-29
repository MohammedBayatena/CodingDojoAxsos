<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/29/2021
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Edit Event Info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>
<div class="container d-flex align-items-start flex-column">
    <h1 class="mt-1">${eventdata.name}</h1>
    <h6 class="mt-1">Edit Event:</h6>
    <form:form modelAttribute="event" method="post" action="/edit/${event.id}" cssClass="align-self-start">

        <div class="row mb-3">
            <label for="inputfname" class="col-sm-4 col-form-label text-nowrap">Event Name:</label>
            <div class="col-sm-8">
                <form:input type="text" path="name" class="form-control" id="inputfname"
                            required="required" value="${eventdata.name}"/>
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
                <form:input type="text" path="location" class="form-control" id="inputlocation" required="required"
                            value="${eventdata.location}"/>
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
                <button type="submit" class="btn btn-primary btn-dark">Save</button>
            </div>
        </div>
    </form:form>
    <div>
        <form:errors path="event.*" cssClass="alert alert-warning d-flex align-items-center"/>
    </div>
</div>


</body>
</html>
