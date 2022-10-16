<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit contact</title>
<link href="css/site.css" rel="stylesheet">
</head>
<body>

<form method="POST" action="./UpdateController">
		<input type="hidden" name="id"  value="${contact.id}"> 
		<input type="text" name="name" placeholder="Enter Name" value="${contact.name}"> 
		<input type="email" name="email" placeholder="Enter Email" value="${contact.email}"> 
		<input type="submit" value="submit">
	</form>

</body>
</html>