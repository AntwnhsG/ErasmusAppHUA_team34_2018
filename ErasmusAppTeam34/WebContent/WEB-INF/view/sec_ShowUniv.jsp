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
<title>ErasmusApp/Sec/Universities</title>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>All registered universities in the system</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
<form>
	<table class="minimalistBlack">
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
	<form>
		<button formaction = "Home">Home</button>
	</form>
	</div>
	</div>
</body>
</html>