<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title"/></title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<tiles:getAsString name='specialStyleSheet'/>">
</head>
<body>
	<div id="wrap">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
<script src="/resources/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="/resources/js/bootstrap/bootstrap.min.js"	type="text/javascript"></script>
<script src="<tiles:getAsString name='specialScript'/>"	type="text/javascript"></script>
</html>