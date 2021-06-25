<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/25/2021
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Person Info</title>
</head>
<body>
<div class="container d-flex align-items-center flex-column">
    <h1 class="">${person.firstName} ${person.lastName} </h1>
    <div class="p-2">
        <p>License Number: ${person.license.number}</p>
        <p>State: ${person.license.state}</p>
        <p>Expiration Date: ${person.license.expirationDate}</p>
    </div>
</div>
</body>
</html>
