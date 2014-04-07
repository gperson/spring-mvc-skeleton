<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="/resources/css/home.css">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
</head>
<body>
	<div id="wrapper">
	<div id="header" class="primaryColor"><h1>Grant's Car Lot</h1></div>
	<nav>
		<span><a href="/manage_users">Manage Users</a></span>
		<span id="current_user">Logged in as: ${username}</span>
	</nav>
	<div id="main_content" class="primaryColor">
	<table>
		<c:forEach var="bean" items="${test}">
			<tr>
				<td>${bean.id }</td>
				<td>${bean.text }</td>
			</tr>
		</c:forEach>
	</table>
	<form action="j_spring_security_logout">
		<input type="submit" value="Logout">
	</form>
	</div>
	</div>
</body>
</html>