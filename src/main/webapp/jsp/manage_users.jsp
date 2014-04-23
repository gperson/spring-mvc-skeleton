<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Manage Users</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
</head>
<body>
	<div id="wrapper">
		<div id="header" class="primaryColor">
			<h1>Grant's Car Lot</h1>
		</div>
		<div id="main_content" class="primaryColor">
			<h3>User Information</h3>
			<form>
			<div>Username: <input id="username" value=${user}></div>
			<div>Password: <input id="password" type="password" value=${password}></div>
			<div>Authority: <input id="authority" value=${authority}></div>
			<div>Enabled: <input id="enabled" value=${enabled}></div>
			<div><input id="update" type="button" value="Update"></div>
			</form>
		</div>
	</div>
</body>
</html>