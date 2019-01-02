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
		<a href="userProfile">My profile</a> 
		<br>
				<!--  	<a href="myApplications">My applications</a>  -->
		<button type = "submit" formaction ="myApplications">My applications</button>
		<br>
		<a href="log_out">Log out</a>
${appCreatedMessage}
</form>
</body>
</html>