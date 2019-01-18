<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri ="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sec:authorize access="isAuthenticated()">
		<h1> Welcome</h1>
		<br>
	<sec:authorize access="hasRole('USER')">
		<form>
			<button type = "submit" formaction ="student/">Fill an Application</button>

			${appCreatedMessage}
			${message}
		</form>	
	</sec:authorize>
	<sec:authorize access="hasRole('ADMIN')">
	<form>
		<button type = "submit" formaction ="admin/">StudentsProfile</button>
	</form>
	</sec:authorize>
	<sec:authorize access="hasRole('SECRETARY')">
		<form>	
		<button type ="submit" formaction ="sec/">Proceed</button>
	</form>
	${message}
	${Uni_infoAddedMessage}
	</sec:authorize>
	</sec:authorize>
</body>
</html>