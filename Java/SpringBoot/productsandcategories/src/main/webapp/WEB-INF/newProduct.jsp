<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/26/2021
  Time: 1:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container d-flex align-items-center flex-column p-5">
    <h1>New Product</h1>
    <form:form method="post" action="/products/new" modelAttribute="product"
               class="d-flex flex-column align-items-start">
        <div class="row m-1 col-12">
            <form:input path="name" placeholder="Enter Product Name" class="form-control col-5"
                        required="required"/>
        </div>
        <div class="row m-1 col-12">
            <form:textarea path="description" placeholder="Enter Product Description" class="form-control col-5"
                           required="required" style="resize: none;"/>
        </div>
        <div class="row m-1 col-12">
            <form:input path="price" placeholder="Enter Product Price" class="form-control col-5"
                        required="required"/>
        </div>
        <div class=" align-self-end">
            <input value="Create" type="submit" class="btn btn-primary">
        </div>
    </form:form>
</div>


</body>
</html>
