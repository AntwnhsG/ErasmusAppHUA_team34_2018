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
		<select name = "columnName" required>
			<option value = "ID">ID</option>
			<option value ="First Name">Student First Name</option>
			<option value ="Last Name">Student Last Name</option>
			<option value ="Email">Email</option>
			<option value ="Students ID">Students ID</option>	
			<option value ="Understanding of Local language">Understanding of Local language</option>
			<option value ="University ID">University ID</option>	
			<option value ="Approved">Approved</option>		
		</select>
	<!--  
	<input type ="text" name = "columnName" required>
	-->
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