<%--
  Created by IntelliJ IDEA.
  User: bbk
  Date: 2/7/17
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="" href="validator.js">
</head>
<body>
<h1>Welcome to Sales</h1>
<h1><a href="/stoke">Stoke</a>
    <a href="/view/sales.jsp"> Sales</a>
    <a href="/view/index.jsp"> Home</a>
</h1>

<a href="/logout">Log Out</a>
<div class="form-style-8">

    <h2 style="color: white">Selling Info</h2>

    <form action="/sales" method="post" onsubmit="myFunction()">

        Sale Id:<input type="text" name="sid" value="${id}" required ><br>
        Item Id:<input type="text" name="id" value="${itemid}" required><br>
        Date:<input type="date" name="date" value="${date}" required><br>
        Selling Price:<input type="number" step="0.01" name="sprice"  value="${price}" required><br>
        Item Quantity:<input type="number" name="qty"value="${qty}" required><br>
        Sold By:<input type="text" name="sby"value="${sale}" required><br>

        <input type="submit" value="Add To Cart">

    </form>


    <form action="/checkout" method="post">

    <input type="submit" value="Check Out">
    </form>

    <form action="/clear" method="post">

        <input type="submit" value="Clear">
    </form>

</div>
<h1>${cannotSale}</h1>

<h1>Item Details</h1>
<table>
    <tr>
        <th>--Sale Id-</th>
        <th>-Item Id-</th>
        <th>-Sold Date--</th>
        <th>-Selling Price-</th>
        <th>-Quantity-</th>
        <th>-Sold By-</th>
    </tr>
    <c:forEach var="sales" items="${cartList}">

        <tr>
            <td id="id" >${sales.saleId}</td>
            <td id="iid">${sales.itemId}</td>
            <td id="datess">${sales.soldDate}</td>5
            <td id="ppriccc">${sales.price}</td>
            <td id="iq">${sales.itemQty}</td>
            <td id="isb">${sales.soldBy}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
