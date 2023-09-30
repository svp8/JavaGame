<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/game/MainServlet" method="post">
    <input type="submit" name="age" value="${age}" />
    <input type="submit" name="button2" value="Button 2" />
    <input type="submit" name="button3" value="Button 3" />
</form>
</body>
</html>