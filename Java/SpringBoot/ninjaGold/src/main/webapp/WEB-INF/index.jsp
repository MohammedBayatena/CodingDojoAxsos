<%--
  Created by IntelliJ IDEA.
  User: Hatsune Miku
  Date: 6/17/2021
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link href="css/style.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div>
    <div class="gold">
        <h2>Your Gold: <span class="goldamount">${goldamount}</span></h2>
    </div>

    <div class="forms">

        <div class="formcard blur">
            <h2>Farm</h2>
            <p>(earns 10-20 golds)</p>
            <form action="process_money" method="post">
                <input class=" btn btn-primary" type="submit" value="Find Gold!">
                <input type="hidden" name="formtype" value="farm">
            </form>
        </div>

        <div class="formcard blur">
            <h2>Cave</h2>
            <p>(earns 5-10 golds)</p>
            <form action="process_money" method="post">
                <input class=" btn btn-primary" type="submit" value="Find Gold!">
                <input type="hidden" name="formtype" value="cave">
            </form>
        </div>


        <div class="formcard blur">
            <h2>House</h2>
            <p>(earns 2-5 golds)</p>
            <form action="process_money" method="post">
                <input class=" btn btn-primary" type="submit" value="Find Gold!">
                <input type="hidden" name="formtype" value="house">
            </form>
        </div>

        <div class="formcard blur">
            <h2>Casino</h2>
            <p>(earns/takes 0-50 golds)</p>
            <form action="process_money" method="post">
                <input class=" btn btn-primary" type="submit" value="Find Gold!">
                <input type="hidden" name="formtype" value="casino">
            </form>
        </div>

    </div>

    <div class="activities">
        <h2>Activities:</h2>
        <p class="bordered blur">
            <c:forEach items="${activities}" var="item">
                <c:if test="${item.type.equals('farm') }">
                    <span class="green">
                        Earned ${item.rand} from the farm! (${item.date})
                    </span><br>
                </c:if>
                <c:if test="${item.type.equals('cave') }">
                    <span class="green">
                        Earned ${item.rand} from the cave! (${item.date})
                    </span><br>
                </c:if>
                <c:if test="${item.type.equals('house') }">
                    <span class="green">
                        Earned ${item.rand} from the house! (${item.date})
                    </span><br>
                </c:if>
                <c:if test="${item.type.equals('casino') }">
                    <c:if test="${item.win.equals('1') }">
                        <span class="green">
                            Entered a casino and earned ${item.rand} golds...Yay!.. (${item.date})
                        </span><br>
                    </c:if>
                    <c:if test="${item.win.equals('0') }">
                        <span class="red">
                            Entered a casino and lost ${item.rand} golds...Ouch!.. (${item.date})
                        </span><br>
                    </c:if>
                </c:if>
            </c:forEach>
        </p>
    </div>
</div>

</body>
</html>