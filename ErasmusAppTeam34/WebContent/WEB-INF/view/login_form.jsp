<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

form {
	border: 3px solid #f1f1f1;
	width: 500px;
	margin-right: auto;
	margin-left: auto;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.container {
	width: 400px;
	margin-right: auto;
	margin-left: auto;
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

.wrapper {
	text-align: center;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
	<form>
		<div class="wrapper">
			<h2>Sign In</h2>
		</div>
	</form>
	
	<form action="processLoginForm" method = "post">
		<div class="container">
		
			<label for="uname"> 
				<b>Username</b>
			</label> 
			<input type="text" placeholder="Enter Username" name="username"required> 
			<label for="psw"> 
				<b>Password</b>
			</label> 
			<input type="password" placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>
			
		</div>
		<div class="wrapper">
		
			<button type="button" class="cancelbtn">Cancel</button>
			
		</div>
	</form>
</body>
</html>
