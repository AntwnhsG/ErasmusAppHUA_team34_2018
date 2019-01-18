<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<input type ="hidden" name ="id" value ="${id}">
	<label>
		<b>Column Name</b>
	</label>
	<input type ="text" name = "columnName" required>
	<br>
	<label>
		<b>New Value</b>
	</label>
	<input type ="text" name = "nValue" required>
	<br>
	<button type ="submit" formaction ="editApplication">Edit</button>
</form>
</body>
</html>