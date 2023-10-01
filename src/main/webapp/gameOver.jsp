<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<p>Game over</p>
<script>
function goToStart(){
	window.location.replace("http://localhost:8080/game/start");
}
</script>
<button onclick="goToStart()">Start again</button>
</body>
</html>