<%--
  Created by IntelliJ IDEA.
  User: bbk
  Date: 2/7/17
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/logout">Log Out</a>
<h1><a href="/stoke">Stoke</a>
    <a href="/view/sales.jsp"> Sales</a>
    <a href="/view/index.jsp"> Home</a></h1>
<div class="form-style-8">

    <h2 style="color: white">Add Stock Info </h2>



    <form action="/add" method="post">
        Item Id:<input type="text" name="id" required><br>
        Item Name:<input type="text" name="name" required><br>
        Item Quantity:<input type="number" name="quantity" required><br>
        Item PurchasePrice:<input type="number" step="0.01" name="pprice" required><br>
        Item Selling Price:<input type="number" step="0.01" name="sprice" required><br>
        Item Added By:<input type="text" name="addedBy" required><br>
        Item Added Date:<input type="date" name="addedDate" required><br>
        <input type="submit" value="Add Item">
    </form>
</div>


</body>
</html>
