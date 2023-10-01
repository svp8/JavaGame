<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
		function goToStart(){
			window.location.replace("http://localhost:8080/game/start");
		}
	</script>
<body>
<form action="/game/main" method="post">
    <input type="submit" name="button" value="attack" />	
    <input type="submit" name="button" value="heal" />
</form>
<button onclick="goToStart()">Start again</button>
</body>
</html>