<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErasmusApp/SecretaryHome</title>
</head>
<body>
	<form>
		<button type ="submit" formaction ="univList">Collaborating Universities</button>
		<button type ="submit" formaction ="create">Register a University</button>
		<button type = "submit" formaction = "getStudentId">Show Students Applications</button>
		<button type = "submit" formaction = "Log_Out">Log Out</button>
	</form>
	${message}
</body>
</html>