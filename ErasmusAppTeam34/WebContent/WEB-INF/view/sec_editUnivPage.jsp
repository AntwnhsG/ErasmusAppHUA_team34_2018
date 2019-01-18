<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table.ShowTable {
	border: 1px solid #3042EE;
	background-color: #EEEEEE;
	width: 100%;
	text-align: left;
	border-collapse: collapse;
}

table.ShowTable td, table.ShowTable th {
	border: 2px solid #AAAAAA;
	padding: 4px 2px;
}

table.ShowTable tbody td {
	font-size: 15px;
	color: #333333;
}

table.ShowTable tr:nth-child(even) {
	background: #C9F5BD;
}

table.ShowTable thead {
	background: #191919;
	background: -moz-linear-gradient(top, #525252 0%, #303030 66%, #191919 100%);
	background: -webkit-linear-gradient(top, #525252 0%, #303030 66%, #191919 100%);
	background: linear-gradient(to bottom, #525252 0%, #303030 66%, #191919 100%);
	border-bottom: 2px solid #444444;
}

table.ShowTable thead th {
	font-size: 15px;
	font-weight: bold;
	color: #5EE5D0;
	border-left: 2px solid #D0E4F5;
}

table.ShowTable thead th:first-child {
	border-left: none;
}

table.ShowTable tfoot td {
	font-size: 8px;
}

table.ShowTable tfoot .links {
	text-align: right;
}

table.ShowTable tfoot .links a {
	display: inline-block;
	background: #1C6EA4;
	color: #FFFFFF;
	padding: 2px 8px;
	border-radius: 5px;
}
</style>
</head>
<body>
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
		<tbody>
				<tr>
					<td>${university.university_id}</td>
					<td>${university.country}</td>
					<td>${university.city}</td>
					<td>${university.univ_name}</td>
					<td>${university.available_room}</td>
				</tr>
		</tbody>		
	</table>
	<form action = "updateUniv">
		<label> 
			<b>Column</b>
		</label> 
		<input type = "text" placeholder="Enter Column Name" name="columnName"required>
		new value is: 
		<label> 
			<b>Value</b>
		</label> 
		<input type = "text" placeholder= "Enter New Value" name="newValue"required>
		<input type = "hidden" name ="id" value = "${university.university_id}">
		
		<button type="submit">submit</button>		
	</form>
	${message}
</body>
</html>