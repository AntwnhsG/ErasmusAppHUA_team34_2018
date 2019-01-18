<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "editSecretary">
		<label> 
			<b>Column</b>
		</label> 
		<input type = "text" placeholder="Enter Column Name" name="columnName"required>
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