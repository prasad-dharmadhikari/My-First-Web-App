<%--
  Created by IntelliJ IDEA.
  User: Prasad Dharmadhikari
  Date: 24-04-2020
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    Hi <%= request.getAttribute("user")%> Login successful.......
</h1>
<a href="login.html">Login Page</a>
</body>
</html>
