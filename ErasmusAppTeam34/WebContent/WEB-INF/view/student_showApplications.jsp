<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>ErasmusApp/Student/MyApplications</title>
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
			<h2>All your applications registered in the system</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
	<table class="minimalistBlack">
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
	</div>
	</div>
	<form action = "home">
		<button type = "submit">Home</button>
	</form>
</body>
</html>