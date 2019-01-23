<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Students</title>
<!-- reference our style sheet -->
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
		Students
		<form>
			<table>
				<tr>
					<th>ID</th>
					<th>username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Current Semester</th>
					<th>Not Passed Courses(num)</th>
					<th>Number of Applications</th>
					<th>Enabled</th>
					<th>Option</th>
				</tr>
				<c:forEach var="tempStudents" items="${students}">

					<tr>
						<td>${tempStudents.student_id}</td>
						<td>${tempStudents.username }</td> 
						<td>${tempStudents.firstName}</td>
						<td>${tempStudents.lastName}</td>
						<td>${tempStudents.email}</td>
						<td>${tempStudents.current_semester}</td>
						<td>${tempStudents.num_not_passed_courses}</td>
						<td>${tempStudents.numOfApps}</td>
						<td>${tempStudents.enabled}</td>
						<td>						
							<label for="SelectRadio"> 
								<b>Select</b>
							</label>
							<input type ="radio" name ="id" value ="${tempStudents.student_id}" required>
						</td>
					</tr>
				</c:forEach>
			</table>
			<button type ="submit" formaction = "showEditStudentForm">Edit</button> 
			<button type ="submit" formaction = "deleteStudent">Delete</button>
			<button type ="submit" formaction = "studChangePasswordForm">Change Password</button>
		</form>
		<form>
			<button type ="submit" formaction = "showAddStudentForm">Add</button> 
		</form>
					Secretary Employees	
		<form>			
			<table>
				<tr>
					<th>ID</th>
					<th>username</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Enabled</th>
					<th>Option</th>
				</tr>
				<c:forEach var="tempSecretaryEmps" items="${secretaryEmps}">

					<tr>
						<td>${tempSecretaryEmps.sec_id}</td> 
						<td>${tempSecretaryEmps.username}</td>
						<td>${tempSecretaryEmps.firstName}</td>
						<td>${tempSecretaryEmps.lastName}</td>
						<td>${tempSecretaryEmps.email}</td>
						<td>${tempSecretaryEmps.enabled}</td>
						<td>
							<label for="SelectRadio"> 
								<b>Select</b>
							</label>
							<input type ="radio" name ="id" value ="${tempSecretaryEmps.sec_id}" required>
						</td>
					</tr>
				</c:forEach>
			</table>
		<button type ="submit" formaction = "showSecEditForm">Edit</button> 
		<button type ="submit" formaction = "deleteSecretary">Delete</button>
		<button type ="submit" formaction = "secChangePasswordForm">Change Password</button>
	</form>
	<form>
		<button type ="submit" formaction = "showAddSecEmpForm">Add</button> 
	</form>
		</div>
	</div>
	<br>
	<form>
		<button formaction = "/home">Home</button>
	</form>
</body>
</html>