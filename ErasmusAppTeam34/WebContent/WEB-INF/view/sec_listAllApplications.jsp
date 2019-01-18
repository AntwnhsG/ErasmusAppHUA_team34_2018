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
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Students ID</th>
					<th>Understanding of Local language</th>
					<th>University ID</th>
					<th>Approved</th>
					<th>Option</th>
				</tr>
			</thead>
<!-- PRINT ALL THE UNIVERSITIES FROM THE DATABASE INSIDE A TABLE-->
			<tbody>
				<c:forEach var="tempApplications" items="${apps}">
					<tr>
						<td>${tempApplications.app_Id}</td>
						<td>${tempApplications.stud_firstName}</td>
						<td>${tempApplications.stud_lastName}</td>
						<td>${tempApplications.stud_email}</td>
						<td>${tempApplications.stud_id}</td>
						<td>${tempApplications.languageOption}</td>
						<td>${tempApplications.univ_id}</td>
						<td>${tempApplications.isApproved}</td>
						<td>
							<label for="SelectRadio"> 
								<b>Select</b>
							</label>
							<input type ="radio" name ="id" value ="${tempApplications.app_Id}" required>
							<input type = "hidden" name = "student_id" value = "${tempApplications.stud_id}">
						</td>
					</tr>								
				</c:forEach>			
			</tbody>		
		</table>
		<button type ="submit" formaction ="showEditPage">Edit</button>
		<button type = "submit" formaction ="deleteApp">Delete</button>
	</form>
		</div>
	</div>
</body>
</html>