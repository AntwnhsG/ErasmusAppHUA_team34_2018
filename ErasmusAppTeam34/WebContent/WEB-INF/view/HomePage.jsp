<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<h1> Welcome</h1>
		<br>
		<sec:authorize access="hasRole('USER')">
			<form action = "student/getStudent">
				Welcome to the erasmus exchange application
				<br>
				Please always check the information that is listed and the information that you submit!
				<br>
				<button type = "submit">PROCEED</button>
			</form>
		</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">
			<form>
				Welcome Administrator
				<br>
				Please always check the information that is listed and the information that you submit!
				<br>
				<button type = "submit" formaction ="admin/">StudentsProfile</button>
			</form>
		</sec:authorize>
		<sec:authorize access="hasRole('SECRETARY')">
			<form>
				Welcome. You have logged in as a secretary employee
				<br>
				Please always check the information that is listed and the information that you submit!
				<br>
				<button type ="submit" formaction ="sec/">Proceed</button>
			</form>
			<!-- 
			${message}
			${Uni_infoAddedMessage}
			 -->
		</sec:authorize>
		<sec:authorize access="hasRole('COUNCIL')">
			<form>
				
				<br>
				Please always check the information that is listed and the information that you submit!
				<br>
				<button formaction = "council/">PROCEED</button>
			</form>
		</sec:authorize>
	</sec:authorize>
</body>
</html>