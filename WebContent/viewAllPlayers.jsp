<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="EditPlayerServlet">
<table>
<c:forEach items = "${requestScope.allPlayers}" var="currentPlayer">
<tr>
	<td><input type="radio" name="id" value="${currentPlayer.playerId}">${currentPlayer.playerId}</td>
	<td>${currentPlayer.firstName}</td>
	<td>${currentPlayer.lastName}</td>
	<td>${currentPlayer.phoneNumber}</td>
	<td>${currentPlayer.screenName}</td>
	<td>${currentPlayer.getTeam().getTeamId()}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="Delete Selected Player" name="doThisToPlayer"/>
<input type="submit" value="Add New Player" name="doThisToPlayer"/>
<input type="submit" value="Back To Menu" name="doThisToPlayer"/>
	</form>

</body>
</html>