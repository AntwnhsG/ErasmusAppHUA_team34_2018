<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "addStudent">

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
			<b>password</b>
		</label> 
		<input type="text"  name="password"required>
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
			<b>Current Semester</b>
		</label> 
		<input type="number" name="currentSemester"required>
					<br>
		<label> 
			<b>Not Passed Courses(num)</b>
		</label> 
		<input type="number" name="NPC"required>
		<br>
		<label> 
			<b>Enabled</b>
		</label> 
		<input type="number"  name="enabled"required>
			
		<button type="submit">submit</button>			
			
	</form>
</body>
</html>
</body>
</html>