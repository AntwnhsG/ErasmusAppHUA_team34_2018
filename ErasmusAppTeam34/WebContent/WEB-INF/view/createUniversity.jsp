<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action = "setUniv">
<!--  
			<label for="id"> 
				<b>ID</b>
			</label> 
				<input type="number" placeholder="Enter university's ID" name="univ_id" required> 
				<br>
				-->
			<label for="country"> 
				<b>Country</b>
			</label> 
				<input type="text" placeholder="Enter in which country it's in" name="country"required>
				<br>
			<label for="city"> 
				<b>City</b>
			</label> 
			<input type="text" placeholder="Enter in which city it's in" name="city"required>
			<br>
			<label for="univ_name"> 
				<b>Name</b>
			</label> 
			<input type="text" placeholder="Enter the official university's name" name="univ_name"required>
			<br>
			<label for="available_room"> 
				<b>Room</b>
			</label> 
			<input type="number" placeholder="Enter how many students can be exchanged" name="available_room"required>
			<br>
			
			<button type="submit">submit</button>			
			
	</form>
</body>
</html>