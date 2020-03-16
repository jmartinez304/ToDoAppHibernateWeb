<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all items in the To-Do list</title>
<link rel="stylesheet" href="styles.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h2>All Items:</h2>
	<c:forEach var="item" items="${listOfItems}">
            Item ID: ${item.itemId} <br>
            List Entry: ${item.itemEntry} <br>
            -------------------------------------<br>
	</c:forEach>

	<h2>Other actions available:</h2>
	<form action="index.jsp" method="get">
		<input type="submit" value="Go to home page" name="homePage" />
		&nbsp; &nbsp;<br>
	</form>
	<form action="saveItem.jsp" method="get">
		<input type="submit" value="Add an Item to the To-Do List"
			name="addItem" /> &nbsp; &nbsp;<br>
	</form>
	<form action="ToDoListController" method="POST">
		<input type="submit" name="deleteItemSelection"
			value="Delete an Item from the To-Do List"> &nbsp; &nbsp;<br>
	</form>


</body>
</html>