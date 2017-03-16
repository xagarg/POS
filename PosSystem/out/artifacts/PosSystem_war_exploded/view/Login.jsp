<%--
  Created by IntelliJ IDEA.
  User: deepak
  Date: 2/2/2017
  Time: 7:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">

</head>
<body>
<div class="form-style-8">

    <h2 style="color: white">Enter Username And Password to Login </h2>
    <form action="/login" method="post">
        <input type="text" name="uname" placeholder="User Name"><br>
        <input type="password" name="pword" placeholder="Password"><br>
        <input type="submit" value="Login">
    </form>
    <h5>${Error}</h5>
    <h3><a href="/view/register.jsp">Sign up!!!</a></h3>
</div>

</body>
</html>
