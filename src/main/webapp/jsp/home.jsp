<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="/resources/css/home.css">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/bootstrap/bootstrap.css">
</head>
<body>
	<%@ include file="/resources/html/header.html" %>
	<div class="row">
		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			<div class="list-group">
				<a id="driveCar" href="#" class="list-group-item active">Drive Car</a>
				<a id="addCar" href="/newCar" class="list-group-item active">Add Car</a>
			</div>
		</div>
		<!--/span-->

		<div id="cars" class="col-xs-12 col-sm-9">
			<div class="row">
				<c:forEach var="car" items="${lot}">
					<div class="col-6 col-sm-6 col-lg-4 car">
						<h2>${car.carId}</h2>
						<img alt="" src="${car.image}">
					</div>
				</c:forEach>
			</div>
			<!--/row-->
		</div>
		<!--/span-->
	</div>
	<!--/row-->
	<script src="/resources/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="/resources/js/home.js" type="text/javascript"></script>
	<script src="/resources/js/bootstrap/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>