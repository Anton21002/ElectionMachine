<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Kysymys" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All datatable rows</title>
</head>
<body>

<table>
<tr>
	<th>ID</th>
	<th>Kysymys</th>
	<th>Actions</th>
</tr>
<c:forEach var="kysymys" items="${sessionScope.allkysymys }">
	<tr>
		<td>${kysymys.id }</td>
		<td>${kysymys.KYSYMYS }</td>
		<td>
			<a href="/editkysymys?id=${kysymys.id }">Edit</a>
		</td>
		<td>
			<a href="/removekysymys?id=${kysymys.id }">Remove</a>
		</td>
	</tr>
</c:forEach>
</table>
</body>
</html>