<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErasmusApp/AddSec</title>
</head>
<body>
	<form action = "addSecretary">

		<label> 
			<b>ID</b>
		</label> 
			<input type="text" name="id"required>
			<br>
		<label> 
			<b>username</b>
		</label> 
		<input type="text"  name="username"required>
		<br>
		<label> 
			<b>Password</b>
		</label> 
		<input type="password"  name="password"required>
		<br>
		<label> 
			<b>First Name</b>
		</label> 
		<input type="text"  name="first_name"required>
		<br>
		<label> 
			<b>Last Name</b>
		</label> 
		<input type="text"  name="last_name"required>
		<br>
		<label> 
			<b>Email</b>
		</label> 
		<input type="text" name="email"required>
			<br>
		<label> 
			<b>Enabled</b>
		</label> 
		<input type="number"  name="enabled"required>
			
		<button type="submit">submit</button>			
			
	</form>
</body>
</html>