<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="page-header">
		<h1>Current Lot</h1>
	</div>
</div>
<div class="row">				
	<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
		<div class="list-group">
			<a id="driveCar" href="#" class="list-group-item">Drive
				Car</a> <a id="addCar" href="/addCar" class="list-group-item">Add
				Car</a>
		</div>
	</div>
	<div id="cars" class="col-xs-12 col-sm-9">
		<div class="row">
			<c:forEach var="car" items="${lot}">
				<div class="col-6 col-sm-6 col-lg-4 car">
					<a href="/viewCar?car=${car.carId}"><img alt="" src="${car.image}"></a>
				</div>
			</c:forEach>
		</div>
	</div>
</div>