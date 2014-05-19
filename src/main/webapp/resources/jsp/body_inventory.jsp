<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="page-header">
		<h1>Inventory of Cars</h1>
	</div>
</div>
<div class="row">
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Car Id</th>
					<th>Type</th>
					<th>Price</th>
					<th>Fuel Type</th>
					<th>Fuel Level</th>
					<th>Max Fuel</th>
					<th>Fuel Used to Drive</th>
					<th>On Sale</th>
					<th>Hybrid</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="car" items="${lot}">
					<tr>
						<td>${car.carId}</td>
						<td>${car.carType}</td>
						<td>${car.price}</td>
						<td>${car.fuel}</td>
						<td>${car.fuelLevel}</td>
						<td>${car.fuelCapcity}</td>
						<td>${car.fuelUsedToDrive}</td>
						<td>${car.onSale}</td>
						<td>${car.hybrid}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>