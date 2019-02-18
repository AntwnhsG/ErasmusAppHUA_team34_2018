<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErasmusApp/EditSec</title>
</head>
<body>
	<form action = "editSecretary">
		<label> 
			<b>Column</b>
		</label> 
		<select name = "columnName" required>
			<option value = "ID">ID</option>
			<option value = "username">username</option>
			<option value = "First Name">Employee First Name</option>
			<option value = "Last Name">Employee Last Name</option>
			<option value = "Email">Email</option>
			<option value = "Enabled">Enabled</option>
		</select>
		<!-- 
		<input type = "text" placeholder="Enter Column Name" name="columnName"required>
		 -->
		new value is: 
		<label> 
			<b>Value</b>
		</label> 
		<input type = "text" placeholder= "Enter New Value" name="newValue"required>
		<input type = "hidden" name ="id" value = "${sec_id}">
		
		<button type="submit">submit</button>
	</form>
</body>
</html>