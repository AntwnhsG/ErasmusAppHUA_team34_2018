<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>
	<form>
		<input type = "hidden" value = "${stud_id}" name = "stud_id">
		
		<button type = "submit" formaction ="home">Home</button>
		
		<button type = "submit" formaction ="createAppForm">Fill an Application</button>
		 
		<button type = "submit" formaction ="student_Profile">My profile</button>
		
				<!--  	<a href="myApplications">My applications</a>  -->
		<button type = "submit" formaction ="myApplications">My applications</button>
		
		<button type = "submit" formaction ="Log_Out">Log Out</button>
${appCreatedMessage}
${message}
</form>
</body>
</html>