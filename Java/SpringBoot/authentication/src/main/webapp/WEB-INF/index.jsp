<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/29/2021
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Hello</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
</head>
<body>

<div class="container d-flex justify-content-around p-3 mt-5 blur justify-items-center">
    <div class="register">
        <h1 class="m-3 text-center">Register</h1>
        <form:form method="POST" action="/registration" modelAttribute="user">


            <div class="row mb-3">
                <label for="inputfname" class="col-sm-4 col-form-label text-nowrap">First Name:</label>
                <div class="col-sm-8">
                    <form:input type="text" path="firstName" class="form-control" id="inputfname"
                                required="required"/>
                </div>
            </div>

            <div class="row mb-3">
                <label for="inputlname" class="col-sm-4 col-form-label text-nowrap">Last Name:</label>
                <div class="col-sm-8">
                    <form:input type="text" path="lastName" class="form-control" id="inputlname"
                                required="required"/>
                </div>
            </div>

            <div class="row mb-3">
                <label for="inputemail" class="col-sm-4 col-form-label text-nowrap">Email:</label>
                <div class="col-sm-8">
                    <form:input type="email" path="email" class="form-control" id="inputemail" required="required"/>
                </div>
            </div>

            <div class="row mb-3">
                <label for="inputPassword" class="col-sm-4 col-form-label text-nowrap">Password:</label>
                <div class="col-sm-8">
                    <form:password path="password" class="form-control" id="inputPassword"
                                   required="required"/>
                </div>
            </div>
            <div class="row mb-0">
                <label for="inputPasswordConfirm" class="col-sm-4 col-form-label">Confirm Password:</label>
                <div class="col-sm-8">
                    <form:password path="passwordConfirmation" class="form-control" id="inputPasswordConfirm"
                                   required="required"/>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-8 col-md-3 offset-sm-4 margin-collapse">
                    <button type="submit" class="btn btn-primary btn-dark">Register</button>
                </div>
            </div>
        </form:form>
    </div>

    <div class="login">
        <h1 class="m-3 text-center">Login</h1>
        <form method="post" action="/login">
            <div class="row mb-3">
                <label for="inputemaillogin" class="col-sm-4 col-form-label">Email:</label>
                <div class="col-sm-8">
                    <input type="email" class="form-control" id="inputemaillogin" name="email" required>
                </div>
            </div>
            <div class="row mb-3">
                <label for="inputPasswordlogin" class="col-sm-4 col-form-label">Password:</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control" id="inputPasswordlogin" required name="password">
                </div>
            </div>

            <div class="row mb-3">
                <div class="col-sm-8 col-md-3 offset-sm-4 m-2">
                    <button type="submit" class="btn btn-primary btn-dark">Login</button>
                </div>
            </div>

        </form>

        <div>
            <form:errors path="user.*" cssClass="alert alert-warning d-flex align-items-center"/>
        </div>


    </div>


</div>


</body>
</html>
