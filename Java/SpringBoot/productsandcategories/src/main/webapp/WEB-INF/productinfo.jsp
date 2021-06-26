<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/26/2021
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Product Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex flex-column">
    <h1 class="align-self-center m-4 p-2">${product.name}</h1>
    <div class="d-flex justify-content-around">
        <div>
            <h3>Categories</h3>
            <ul class="list-group">
                <c:if test="${product.categories.isEmpty()}">
                    <li class="list-group-item">No products yet!</li>
                </c:if>
                <c:if test="${!product.categories.isEmpty()}">
                    <c:forEach items="${product.categories}" var="category">
                        <li class="list-group-item">${category.name}</li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
        <form class="d-flex align-items-start" action="/products/${product.id}/addcat" method="post">
            <p class="m-1">Add Category: </p>
            <div>
                <select class="m-1 form-select" name="category">
                    <c:forEach items="${categorieslist}" var="catitem">
                        <option value="${catitem.id}">${catitem.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" class="btn btn-primary" value="Submit">
            </div>

        </form>
    </div>
</div>


</body>
</html>
