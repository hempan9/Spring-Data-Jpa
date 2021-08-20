<%--
  Created by IntelliJ IDEA.
  User: hobject
  Date: 8/20/21
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Wizard</title>
    <h3 align="center" >Welcome delete wizard using first name</h3>
</head>
<body bgcolor="#7fffd4">
<form action="/deletebyname" method="delete" >
    <div align="center">
        <input type="text" placeholder="Enter First Name" name="fname">
        <input type="submit" name="Delete">
    </div>
</form>
</body>
</html>
