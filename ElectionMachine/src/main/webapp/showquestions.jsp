<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Question" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All question rows</title>
</head>
<body>

<table>
<tr>
	<th>ID</th>
	<th>Breed</th>
	<th>Actions</th>
</tr>
<c:forEach var="question" items="${sessionScope.allQuestions }">
	<tr>
		<td>${question.id }</td>
		<td>${question.question}</td>
		<td>
			<a href="/editquestion?id=${game.id }">Edit</a>
		</td>
		<td>
			<a href="/removequestion?id=${game.id }">Remove</a>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>