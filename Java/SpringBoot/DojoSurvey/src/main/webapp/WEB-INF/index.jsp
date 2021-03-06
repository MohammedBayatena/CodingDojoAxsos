<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/17/2021
  Time: 10:12 PM
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
    <title>Dojo Survey</title>

</head>
<body>

<div class="container d-flex justify-content-center shadow p-3 mb-5 bg-body rounded  ">
    <form action="/result" method="post">

        <div class="form-group row">
            <label for="name" class="col-2 col-form-label">Name</label>
            <div class="col-10">
                <input type="text" required class="form-control col-10" id="name" placeholder="Name" name="name">
            </div>
        </div>

        <div class="form-group row">
            <label class="col-2 col-form-label" for="dojolocation">Dojo Location</label>
            <div class="col-10">
                <select class="custom-select col-10" id="dojolocation" name="dojolocation">
                    <option selected>Choose...</option>
                    <option value="Ramallah">Ramallah</option>
                    <option value="Nablus">Nablus</option>
                    <option value="Birzeit">Birzeit</option>
                </select>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-2 col-form-label" for="favlang">Favourite Language </label>
            <div class="col-10">
                <select class="custom-select col-10" id="favlang" name="favlang">
                    <option selected>Choose...</option>
                    <option value="Java">Java</option>
                    <option value="Python">Python</option>
                    <option value="C#">C#</option>
                </select>
            </div>
        </div>


        <fieldset class="form-group">
            <div class="row">
                <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                <div class="col-sm-10">
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="Male"
                               checked>
                        <label class="form-check-label" for="gridRadios1">
                            Male
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios2" value="Female">
                        <label class="form-check-label" for="gridRadios2">
                            Female
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios3" value="Others">
                        <label class="form-check-label" for="gridRadios3">
                            Others
                        </label>
                    </div>
                </div>
            </div>
        </fieldset>

        <fieldset class="form-group">
            <div class="row">
                <legend class="col-form-label col-sm-3 pt-0">Where did you hear about us?</legend>
                <div class="col-sm-8">

                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="gridCheck1" name="gridCheck"
                               value="Social Media">
                        <label class="form-check-label" for="gridCheck1">
                            Social Media
                        </label>
                    </div>

                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="gridCheck2" name="gridCheck"
                               value="Friends and Family">
                        <label class="form-check-label" for="gridCheck2">
                            Friends and Family
                        </label>
                    </div>

                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="gridCheck3" name="gridCheck"
                               value="TV or Radio ADs">
                        <label class="form-check-label" for="gridCheck3">
                            TV or Radio ADs
                        </label>
                    </div>
                </div>
            </div>
        </fieldset>

        <div class="form-group row">
            <label class="col-3 col-form-label" for="comments">Any Comments?</label>
            <div class="col-7">
                <textarea class="form-control" id="comments" rows="3" name="comments"></textarea>
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-10 d-flex justify-content-end">
                <button type="submit" class="btn btn-dark">Submit</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
