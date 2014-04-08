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
			<div id="username">Username: ${user}</div>
			<div id="password">Password: ${password}</div>
			<div id="authority">Authority: ${authority}</div>
			<div id="enabled">Enabled: ${enabled}</div>
		</div>
	</div>
</body>
</html>