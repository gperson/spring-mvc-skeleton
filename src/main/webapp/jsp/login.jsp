<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page</title>
<link href="/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="/resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrapperLogin">
		<h1 align="center">Welcome</h1>
		<div align="center">
			<div id="loginContainer" class="box primaryColor">
				<h3>Login</h3>
				<hr>
				<form name="f" action="<c:url value="j_spring_security_check"/>"
					method="POST">
					<table>
						<tr>
							<td>User:</td>
							<td><input id="username" class="backGroundColor"
								onfocus="toggleBlurOff(this)" onBlur="toggleBlurOn(this)"
								type="text" name="j_username" value=""></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input id="password" class="backGroundColor"
								onfocus="toggleBlurOff(this)" onBlur="toggleBlurOn(this)"
								type="password" name="j_password" /></td>
						</tr>
					</table>
					<c:if test="${'fail' eq param.auth}">
						<div>
							Login Failed: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
						</div>
					</c:if>
					<div>
						<table id="buttonTable">
							<tr>
								<td id="forgotPasswordEntry"><input id="btnForgotPassword"
									class="button" name="forgotPassword" type="button"
									value="Forgot password?" /></td>
								<td id="loginEntry"><input id="btnLogin" class="button"
									name="submit" type="submit" value="Login " /></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
		<div id="footerLogin">Made by Grant Person</div>
	</div>
	<script src="/resources/js/login.js" type="text/javascript"></script>
</body>
</html>