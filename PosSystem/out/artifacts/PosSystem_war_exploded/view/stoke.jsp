<%--
  Created by IntelliJ IDEA.
  User: bbk
  Date: 2/7/17
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome to Stoke</h1>
<a href="/logout">Log Out</a>
<h1><a href="/stoke">Stoke</a>
    <a href="/view/sales.jsp"> Sales</a>
    <a href="/view/index.jsp"> Home</a></h1>
<h1>Item Details</h1>
<table>
    <tr>
        <th> ID</th>
        <th> Name</th>
        <th> Quantity</th>
        <th>Purchase Price</th>
        <th>Selling Price</th>
        <th>Added By</th>
        <th>Added Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="stock" items="${view}">

        <tr>
            <td>${stock.itemId}</td>
            <td>${stock.itemName}</td>
            <td>${stock.itemQny}</td>
            <td>${stock.itemPurchase}</td>
            <td>${stock.itemSale}</td>
            <td>${stock.itemAddedby}</td>
            <td>${stock.itemDate}</td>

            <td><a href="/edit?itemId=${stock.itemId}" >Edit</a>||<a href="/delete?itemId=${stock.itemId}" >Delete</a></td>
        </tr>

    </c:forEach>
</table>

<a href="/view/add.jsp">Add Stoke</a>

</body>
</html>
