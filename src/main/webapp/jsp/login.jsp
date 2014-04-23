<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<link href="/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="/resources/css/login.css" rel="stylesheet" type="text/css">
<link href="/resources/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Car Lot</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<form class="form-signin" name="f"
			action="<c:url value="j_spring_security_check"/>" method="POST">
			<h2 class="form-signin-heading">Sign in:</h2>
			<input id="username" class="form-control" type="text" name="j_username" placeholder="Username" required autofocus>
			<input id="password" class="form-control" type="password" name="j_password" placeholder="Password" required>
			<c:if test="${'fail' eq param.auth}">
				<div id="failed">Login Failed:
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
			</c:if>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		</form>
	</div>
	<script src="/resources/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="/resources/js/login.js" type="text/javascript"></script>
	<script src="/resources/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>