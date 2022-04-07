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

	<form action='./removekysymys' method='post'>
	<h2>Are you sure you want to remove the following:</h2>
		Kysymys: <input type='text' name='kysymys' value='${sessionScope.kysymys.KYSYMYS }'readonly><br>
		<input type="hidden" name="id" value="${sessionScope.kysymys.id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>