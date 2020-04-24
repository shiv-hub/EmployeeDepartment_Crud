<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
</head>
<body>
<h1>Employee Details:</h1>
<form action="employee" method="post">
	
	ID:<input type="text" name="id"><br>  
	First Name:<input type="text" name="firstName"><br>
	Last Name :<input type="text" name="lastName"><br>
	Age:<input type="text" name="age"><br>
	<input type="submit">
	</form>
	<h2>result:</h2><br>
	feedback:${message}<br>
	id:${employee.id}<br>
	First Name:${employee.firstName}<br>
	Last Name:${employee.lastName}<br>
	Age:${employee.age}<br>
	



</body>
</html>