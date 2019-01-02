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
	<table class="ShowTable">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>My ID</th>
				<th>Understanding of Local language</th>
				<th>University ID</th>
				<th>Approved</th>
			</tr>
		</thead>
<!-- PRINT ALL THE UNIVERSITIES FROM THE DATABASE INSIDE A TABLE-->
		<tbody>
			<c:forEach var="tempApplications" items="${applications}">
				<tr>
					<td>${tempApplications.stud_firstName}</td>
					<td>${tempApplications.stud_lastName}</td>
					<td>${tempApplications.stud_email}</td>
					<td>${tempApplications.stud_id}</td>
					<td>${tempApplications.languageOption}</td>
					<td>${tempApplications.univ_id}</td>
					<td>${tempApplications.isApproved}</td>
				</tr>								
			</c:forEach>			
		</tbody>		
	</table>
</body>
</html>