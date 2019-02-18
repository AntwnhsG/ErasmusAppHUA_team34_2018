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
<style>
	table.minimalistBlack {
  border: 3px solid #000000;
  width: 100%;
  text-align: left;
  border-collapse: collapse;
}
table.minimalistBlack td, table.minimalistBlack th {
  border: 1px solid #000000;
  padding: 5px 4px;
}
table.minimalistBlack tbody td {
  font-size: 13px;
}
table.minimalistBlack thead {
  background: #CFCFCF;
  background: -moz-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  background: -webkit-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  background: linear-gradient(to bottom, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  border-bottom: 3px solid #000000;
}
table.minimalistBlack thead th {
  font-size: 15px;
  font-weight: bold;
  color: #000000;
  text-align: left;
}
table.minimalistBlack tfoot {
  font-size: 14px;
  font-weight: bold;
  color: #000000;
  border-top: 3px solid #000000;
}
table.minimalistBlack tfoot td {
  font-size: 14px;
}
</style>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>All the universities registered by the secretary in the system</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
	<form action = "createApplication">
		<table class="minimalistBlack">
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