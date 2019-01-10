<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
	<form>
		<input type = "hidden" value = "${stud_id}" name = "stud_id">
		
		<a href="home">Home</a>
		<br>
		<button type = "submit" formaction ="createAppForm">Fill an Application</button>
		 <br>
		<button type = "submit" formaction ="student_Profile">My profile</button>
		<br>
				<!--  	<a href="myApplications">My applications</a>  -->
		<button type = "submit" formaction ="myApplications">My applications</button>
		<br>
		<button type = "submit" formaction ="Log_Out">Log Out</button>
${appCreatedMessage}
${message}
</form>
</body>
</html>