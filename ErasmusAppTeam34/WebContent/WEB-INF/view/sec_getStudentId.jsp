<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErasmusApp/Secretary</title>
</head>
<body>
	<form>
		<label>
			<b>Please type the student's id</b>
		</label>
		<input type = "number" value = "id" name = "id">
		<button type = "submit" formaction ="listApplications">Submit</button>
	</form>
	<form>
		<button formaction = "home">Home</button>
	</form>
</body>
</html>