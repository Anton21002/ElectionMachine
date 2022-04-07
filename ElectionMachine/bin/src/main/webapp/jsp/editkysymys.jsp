<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Kysymys" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Kysymys</title>
</head>
<body>

	<form action='./editkysymys' method='post'>
		<h1>kysymys</h1>
		Kysymys: <input type='text' name='KYSYMYS' value='${sessionScope.kysymys.KYSYMYS }'><br>
		<input type="hidden" name="id" value="${sessionScope.kysymys.id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>