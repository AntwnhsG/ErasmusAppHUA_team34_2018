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
	<form action = "createApplication">
		<table class="ShowTable">
		<thead>
			<tr>
				<th>University ID</th>
				<th>Name</th>
				<th>Country</th>
				<th>City</th>
				<th>Available Room</th>
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
				</tr>								
			</c:forEach>			
		</tbody>		
	</table>
<br>

			<input type="hidden" value="${sID}" name="stud_id"required>
			
			<label for="firstName"> 
				<b>First Name</b>
			</label> 
				<input type="text" placeholder="Enter your name" name="studFirstName" required> 
				<br>
			<label for="lastName"> 
				<b>Last Name</b>
			</label> 
				<input type="text" placeholder="Enter Last Name" name="studLastName"required>
				<br>
			<label for="email"> 
				<b>Email</b>
			</label> 
			<input type="text" placeholder="Enter your Email" name="studEmail"required> 
			<br>
			Can you speak the native language of the university's country?
			<label for="yesRadio"> 
				<b>Yes</b>
			</label> 
			<input type ="radio" name = "language_button" value ="YES" required>
			<label for="noRadio"> 
				<b>No</b>
			</label>
			<input type ="radio" name ="language_button" value ="NO" required>
			<br>
			<label for="university_id"> 
				<b>University_ID</b>
			</label> 
			<input type="number" placeholder="Enter University's ID" name="univ_id"required>
			<br>
			
			
			<button type="submit">submit</button>			
		
	</form>
	</div>
	</div>
	${Uni_infoAddedMessage}
</body>
</html>