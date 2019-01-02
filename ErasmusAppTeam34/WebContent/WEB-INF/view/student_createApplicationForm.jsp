<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "createApplication">

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
	${Uni_infoAddedMessage}
</body>
</html>