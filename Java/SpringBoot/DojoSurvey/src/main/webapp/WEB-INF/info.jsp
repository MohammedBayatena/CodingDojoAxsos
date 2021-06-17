<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/17/2021
  Time: 10:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
    <title>Dojo Info</title>
</head>
<body>
<div class="container shadow bg-body rounded">

    <form action="/" method="post">

        <div class="form-group row">
            <label for="staticName" class="col-sm-4 col-form-label">Name</label>
            <div class="col-sm-5">
                <input type="text" readonly class="form-control-plaintext" id="staticName" value=${name}>
            </div>
        </div>

        <div class="form-group row">
            <label for="staticLocation" class="col-sm-4 col-form-label">Dojo Location</label>
            <div class="col-sm-5">
                <input type="text" readonly class="form-control-plaintext" id="staticLocation" value=${dojolocation}>
            </div>
        </div>

        <div class="form-group row">
            <label for="staticfavlang" class="col-sm-4 col-form-label">Favourite Language</label>
            <div class="col-sm-5">
                <input type="text" readonly class="form-control-plaintext" id="staticfavlang" value=${favlang}>
            </div>
        </div>

        <div class="form-group row">
            <label for="staticgender" class="col-sm-4 col-form-label">Gender</label>
            <div class="col-sm-5">
                <input type="text" readonly class="form-control-plaintext" id="staticgender" value=${gender}>
            </div>
        </div>

        <div class="form-group row ">
            <p class="col-sm-4 col-form-label">Comments</p>
            <div class="col-sm-5">
                <p style="display: inline-block;
                word-break: break-word;">${comments}</p>
            </div>
        </div>

        <div class="form-group row">
            <p class="col-sm-4 col-form-label">Heard about us from</p>
            <div class="col-sm-5">
                <p style="display: inline-block;
                word-break: break-word;">${hearaboutus}</p>
            </div>
        </div>

        <button type="submit" class="btn btn-dark mb-2">Go Back</button>

    </form>
</div>
</body>
</html>
