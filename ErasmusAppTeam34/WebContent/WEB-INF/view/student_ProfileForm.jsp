<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post">
	<table class="ShowTable">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Current Semester</th>
				<th>Not Passed Courses(num)</th>
				<th>Number of Applications</th>
			</tr>
		</thead>

		<tbody>
				<tr>
					<td>${student.student_id}</td> 
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.email}</td>
					<td>${student.current_semester}</td>
					<td>${student.num_not_passed_courses}</td>
					<td>${student.numOfApps}</td>
				</tr>											
		</tbody>		
	</table>
	</form>
</body>
</html>