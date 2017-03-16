<%@ page import="operation.DatabaseOperation" %><%--
  Created by IntelliJ IDEA.
  User: bbk
  Date: 2/7/17
  Time: 8:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>POS System</title>
  </head>
  <body>
  <a href="/logout">Log Out</a>
  <h1> Welcome to POS System </h1>
  <h1><a href="/stoke">Stoke</a>
  <a href="/view/sales.jsp"> Sales</a>
    <a href="/view/index.jsp"> Home</a></h1>

  <h3>Total No of item : <% DatabaseOperation databaseOperation= new DatabaseOperation();
    out.println(" "+databaseOperation.countStock());%></h3>
  <h3>Stoke value:<%
    out.println(" "+databaseOperation.sumStock());%></h3>
  <h3>Total No of Sell:<%
    out.println(" "+databaseOperation.countSales());%></h3>
  <h3>Sell Value:<%
    out.println(" "+databaseOperation.sumSales());%></h3>

  </body>
</html>
