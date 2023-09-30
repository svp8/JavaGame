<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="org.example.models.Player"
    import="org.example.models.Monster"
    import="org.example.models.statuses.Status"
    import="java.util.ArrayList"
    import="java.util.regex.Matcher"
import="java.util.regex.Pattern"
    %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%
int health=8;
ArrayList<Status> statuses;
ArrayList<String> hr=new ArrayList();
ArrayList<String> mStatuses=new ArrayList();
Player player=(Player)session.getAttribute("player");
Monster monster=(Monster)session.getAttribute("monster");
if(player!=null){
	health=player.getHealth();
	statuses=player.getStatuses();
	for(Status s:statuses){
		Pattern pattern = Pattern.compile("class org.example.models.statuses.(\\w+)");
        String mydata = s.getClass().toString();

        Matcher matcher = pattern.matcher(mydata);
        if(matcher.matches()) {
            hr.add(matcher.group(1)+": "+s.getDuration());
        }
		
	}
	
}
if(monster!=null){
	statuses=monster.getStatuses();
	for(Status s:statuses){
		Pattern pattern = Pattern.compile("class org.example.models.statuses.(\\w+)");
        String mydata = s.getClass().toString();

        Matcher matcher = pattern.matcher(mydata);
        if(matcher.matches()) {
            mStatuses.add(matcher.group(1)+": "+s.getDuration());
        }
		
	}
	
}
%>
<ul>
<li>Name</li>
<li>Health: <%= player.getHealth() %> /<%= player.getMaxHealth() %> </li>
<li>Attack: <%= player.getAttack() %></li>
<li>Defence: <%= player.getDefence() %></li>
<li>Statuses:</li>
<ul>
<c:forEach var="var" items="<%= hr %>">
<li><c:out value="${var}"/></li>
</c:forEach>

</ul>
</ul>

<ul>
<li>Name</li>
<li>Health: <%= monster.getHealth() %> /<%= monster.getMaxHealth() %> </li>
<li>Attack: <%= monster.getAttack() %></li>
<li>Defence: <%= monster.getDefence() %></li>
<li>Statuses:</li>
<ul>
<c:forEach var="var" items="<%= mStatuses %>">
<li><c:out value="${var}"/></li>
</c:forEach>

</ul>
</ul>
<jsp:include page="menu.jsp"/>
</body>
</html>