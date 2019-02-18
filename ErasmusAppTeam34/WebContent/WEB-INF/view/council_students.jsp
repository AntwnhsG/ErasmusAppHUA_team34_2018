<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>ErasmusApp/ListAllStds</title>
<!-- reference our style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>A list of all students</h2>
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
				<c:forEach var="tempStudents" items="${studs}">

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
			<button formaction = "getApplications">Show student's applications</button>
		</form>
		<form>
			<button formaction = "home">Home</button>
		</form>
		</div>
		</div>
</body>
</html>