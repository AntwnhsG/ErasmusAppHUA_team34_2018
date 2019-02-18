<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErasmusApp/PasswordChangeStd</title>
</head>
<body>
	<form action = "studChangePassword">
		<label> 
			<b>New Password</b>
		</label> 
		<input type = "password" placeholder= "Enter New Password" name="password"required>
		<input type = "hidden" name ="id" value = "${id}">
		<button type="submit">submit</button>
	</form>
</body>
</html>