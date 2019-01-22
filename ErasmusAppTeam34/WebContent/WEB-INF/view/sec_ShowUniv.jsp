<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Student Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
<form>
	<table class="ShowTable">
		<thead>
			<tr>
				<th>University ID</th>
				<th>Name</th>
				<th>Country</th>
				<th>City</th>
				<th>Available Room</th>
				<th>Options</th>
			</tr>
		</thead>
<!-- PRINT ALL THE UNIVERSITIES FROM THE DATABASE INSIDE A TABLE-->
		<tbody>
			<c:forEach var="tempUniversities" items="${universities}">
				<tr>
					<td>${tempUniversities.university_id}</td>
					<td>${tempUniversities.univ_name}</td>
					<td>${tempUniversities.country}</td>
					<td>${tempUniversities.city}</td>
					<td>${tempUniversities.available_room}</td>
					<td>
						<label for="SelectRadio"> 
							<b>Select</b>
						</label>
						<input type ="radio" name ="id" value ="${tempUniversities.university_id}" required>
					</td>
				</tr>								
			</c:forEach>			
		</tbody>		
	</table>
	<button type ="submit" formaction = "showUniversity">Edit</button> 
	<button type ="submit" formaction = "deleteUni">Delete</button>
	</form>
	</div>
	</div>
</body>
</html>