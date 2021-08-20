<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="addData" method="post">
<input type="text" placeholder="First Name" name="fname" required><br/>
<input type= "text" placeholder ="Last Name" name= "lname" required><br/>
<input type = "email" placeholder = Email name="email" required><br/>
<input type = "text" placeholder= Phone name="phone" maxlength="10" required><br/>
<input type="submit" value="MakeEntry">

</form>

</div>
<div align="center">
<form action="find">
<input type="submit" value = "Display all Data">
</form>
</div>
</body>
</html>