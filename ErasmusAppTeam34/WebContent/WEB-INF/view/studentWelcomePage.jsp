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
		<input type = "hidden" value = "${param.username}" name = "username">
		Welcome to the erasmus exchange application
		<br>
		Please always double check the information that is listed and the information that you submit!
		<br>
		<button type = "submit" formaction = "student/getStudent">PROCEED</button>>
	</form>
</body>
</html>