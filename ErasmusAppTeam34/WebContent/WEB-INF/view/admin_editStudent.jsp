<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "editStudent">
		<label> 
			<b>Column</b>
		</label> 
		<!--  
		<input type = "text" placeholder="Enter Column Name" name="columnName"required>
		-->
		<select name = "columnName" required>
			<option value = "ID">ID</option>
			<option value ="username">username</option>	
			<option value ="First Name">Student First Name</option>
			<option value ="Last Name">Student Last Name</option>
			<option value ="Email">Email</option>
			<option value ="Current Semester">Current Semester</option>	
			<option value ="Not Passed Courses">Not Passed Courses</option>
			<option value ="Number of Applications">Number of Applications</option>	
			<option value = "Enabled">Enabled</option>
				
		</select>
		new value is: 
		<label> 
			<b>Value</b>
		</label> 
		<input type = "text" placeholder= "Enter New Value" name="newValue"required>
		<input type = "hidden" name ="id" value = "${student_id}">
		
		<button type="submit">submit</button>
	</form>
</body>
</html>