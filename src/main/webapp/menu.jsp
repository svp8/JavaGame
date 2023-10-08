<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<script>
		function goToStart(){
			window.location.replace("http://localhost:8080/game/start");
		}
	</script>
<style>
	.actions{
		display:flex;
		border:1px solid black;
		padding:5px;
		flex-direction:column;
		gap:5px;
		background-color:white;
		
	}
	.action{
		width:100px;
		height:50px;
		font-size:15px;
		
	}
</style>
<body>

<form class="actions" action="/game/main" method="post">
    <input class="action" type="submit" name="button" value="attack" />	
    <input class="action" type="submit" name="button" value="heal" />
</form>
<button onclick="goToStart()">Start again</button>
</body>
</html>