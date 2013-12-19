
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Login Page</title>
<meta name="description" content="Login Page">
<meta name="author" content="Grant Person">
<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
</head>
<body>
	<form action="Lobby" method="post" id="login">
		<h1>Login</h1>
		<fieldset id="inputs">
			<input id="username" name="userName" type="text" placeholder="Username" autofocus
				required> <input id="password" name="password" type="password"
				placeholder="Password" required>
		</fieldset>
		<fieldset>
			<input type="submit" id="submit" value="Login"> <a href="">Forgot
				password?</a>
		</fieldset>
	</form>

</body>
</html>