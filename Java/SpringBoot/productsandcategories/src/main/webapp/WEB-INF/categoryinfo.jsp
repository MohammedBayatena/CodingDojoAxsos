<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/26/2021
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Category Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex flex-column">
    <h1 class="align-self-center m-4 p-2">${category.name}</h1>
    <div class="d-flex justify-content-around">
        <div>
            <h3>Products</h3>
            <ul class="list-group">
                <c:if test="${category.products.isEmpty()}">
                    <li class="list-group-item">No products yet!</li>
                </c:if>
                <c:if test="${!category.products.isEmpty()}">
                    <c:forEach items="${category.products}" var="product">
                        <li class="list-group-item">${product.name}</li>
                    </c:forEach>
                </c:if>
            </ul>
        </div>
        <form class="d-flex align-items-start" action="/categories/${category.id}/addprod" method="post">
            <p class="m-1">Add Product: </p>
            <div>
                <select class="m-1 form-select" name="product">
                    <c:forEach items="${prdouctslist}" var="proditem">
                        <option value="${proditem.id}">${proditem.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" class="btn btn-primary" value="Submit">
            </div>

        </form>
    </div>
</div>


</body>
</html>
