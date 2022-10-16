<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>
<link href="css/site.css" rel="stylesheet">
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${contacts}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.name}</td>
				<td>${c.email}</td>
				<td><a href="./UpdateController?id=${c.id}">edit</a></td>
				<td><a href="./DeleteController?id=${c.id}">Delete</a></td>	
			</tr>
		</c:forEach>
	</table>
	<br>
	<form method="POST" action="./contacts">
		<input type="text" name="name" placeholder="Enter Name"> 
		<input type="email" name="email" placeholder="Enter Email">
		<input type="submit" value="submit">
	</form>

</body>
</html>