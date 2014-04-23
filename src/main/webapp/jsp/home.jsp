<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="/resources/css/home.css">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
<link rel="stylesheet" type="text/css"
	href="/resources/css/bootstrap/bootstrap.min.css">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Car Lot</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#inventory">Inventory</a>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="page-header">
			<h1>Current Lot</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
			<div class="list-group">
				<a href="#" class="list-group-item active">Link</a>
			</div>
		</div>
		<!--/span-->

		<div class="col-xs-12 col-sm-9">
			<div class="row">
				<div class="col-6 col-sm-6 col-lg-4">
					<h2>Heading</h2>
				</div>
				<!--/span-->
				<div class="col-6 col-sm-6 col-lg-4">
					<h2>Heading</h2>
				</div>
				<!--/span-->
				<div class="col-6 col-sm-6 col-lg-4">
					<h2>Heading</h2>
				</div>
				<!--/span-->
				<div class="col-6 col-sm-6 col-lg-4">
					<h2>Heading</h2>
				</div>
				<!--/span-->
				<div class="col-6 col-sm-6 col-lg-4">
					<h2>Heading</h2>
				</div>
				<!--/span-->
				<div class="col-6 col-sm-6 col-lg-4">
					<h2>Heading</h2>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
		</div>
		<!--/span-->
	</div>
	<!--/row-->
	<script src="/resources/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="/resources/js/bootstrap/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>