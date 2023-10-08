<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
    import="org.example.models.Player" import="org.example.models.Monster" import="org.example.models.statuses.Status"
    import="java.util.ArrayList" import="java.util.regex.Matcher" import="java.util.regex.Pattern" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
        </head>

        <body>
            <%
            int health=8;
            ArrayList<Status> statuses;
            ArrayList<String> hr=new ArrayList();
            ArrayList<String> mStatuses=new ArrayList();
            Player player=(Player)session.getAttribute("player");
            Monster monster=(Monster)session.getAttribute("monster");
            ArrayList<String> map=(ArrayList)session.getAttribute("registry");
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
            <style>
                ul,
                li {
                    padding: 0;
                    margin: 0;
                    list-style: none;
                }

                * {
                    font-family: sans-serif;
                }

                .stats {
                    padding: 5px;
                    background-color:white;
                    border: 1px black solid;
                }
                .player{
                	display: flex;
                	
                }
                .player-stats{
                	flex:1
                }
                .main{
                    margin-bottom: auto;
                    display:contents;
                }
                .monster{
                	width:300px;
                	align-self:center;
                }
                .registry{
                	border:1px solid black;
                	height:110px;
                	overflow:scroll;
                	background-color:white;
                }
                .container{
                	flex:1;
                	display:flex;
                	flex-direction: column;
                	padding:10px;
                	padding-bottom:0px;
                }
                .weapon{
                	background-color:white;
                	border:1px solid black;
                	padding:5px;
                }
                body {
                    display: flex;
                    flex-direction: column;
                    background-image: url("pxfuel.jpg");
                    background-size: contain;
                    background-size: 100%;
                }

                html,
                body {
                    margin: 0;
                    height: 100%;
                    font-size:20px;
                }
                h3,p{
                	font-size:20px;
                	margin:0;
                }
            </style>
         <div class="container">
            <div class="main">
            	<div style="display:flex">
            	<ul class="stats" style="flex:1">
                    <li style="font-weight:bold">Monster</li>
                    <li>Health: <%= monster.getHealth() %> /<%= monster.getMaxHealth() %>
                    </li>
                    <li>Attack: <%= monster.getAttack() %>
                    </li>
                    <li>Defence: <%= monster.getDefence() %>
                    </li>
                    <ul style="display:flex; gap:5px;">
                    	<li>Statuses:</li>
                        <c:forEach var="var" items="<%= mStatuses %>">
                            <li>
                                <c:out value="${var}" />
                            </li>
                        </c:forEach>

                    </ul>
                    
                </ul>
                <div class="weapon">
                	<h3>Weapon</h1>
                	<p>Min damage: <%= monster.getWeapon().getDamageMin() %></p>
                	<p>Max damage: <%= monster.getWeapon().getDamageMax() %></p>
                </div>
            	</div>
                
                <img class="monster" src="<%=monster.getImage() %>"/>
            </div>
            
			<h3 style="color:white">Registry</h3>
			<ul class="registry">
                <c:forEach items="<%=map %>" var="entry">
                    <li>${entry}</li>
                </c:forEach>
            </ul>
			
            
            <div class="player">
                <ul class="stats player-stats">
                    <li style="font-weight:bold">Player</li>
                    <li>Health: <%= player.getHealth() %> /<%= player.getMaxHealth() %>
                    </li>
                    <li>Attack: <%= player.getAttack() %>
                    </li>
                    <li>Defence: <%= player.getDefence() %>
                    </li>
                    <ul style="display:flex; gap:5px;">
                    	<li>Statuses:</li>
                        <c:forEach var="var" items="<%= hr %>">
                            <li>
                                <c:out value="${var}" />
                            </li>
                        </c:forEach>

                    </ul>
                </ul>
                <div class="weapon">
                	<h3>Weapon</h1>
                	<p>Min damage: <%= player.getWeapon().getDamageMin() %></p>
                	<p>Max damage: <%= player.getWeapon().getDamageMax() %></p>
                </div>
                <jsp:include page="menu.jsp" />
            </div>
            </div>
            
        </body>

        </html>