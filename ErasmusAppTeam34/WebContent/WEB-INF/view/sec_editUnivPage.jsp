<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErasmusApp/Sec/EditUniversities</title>
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
</head>
<body>
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
		<select name = "columnName" required>
			<option value = "University ID">University ID</option>
			<option value ="Name">Name</option>
			<option value ="Country">Country</option>
			<option value ="City">City</option>
			<option value ="Available Room">Available Room</option>				
		</select>
		<!--  
		<input type = "text" placeholder="Enter Column Name" name="columnName"required>
		-->
		new value is: 
		<label> 
			<b>Value</b>
		</label> 
		<input type = "text" placeholder= "Enter New Value" name="newValue"required>
		<input type = "hidden" name ="id" value = "${university.university_id}">
		
		<button type="submit">submit</button>		
	</form>
	<form>
		<button formaction = "home">Home</button>
	</form>
	${message}
</body>
</html>