<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="page-header">
		<h1>${title}</h1>
	</div>
</div>
<div id="container">
	<div class="row container">
		<div class="col-xs-12 col-sm-9">
			<h3>Car Details</h3>
			<div class="alert ${alertType}">
				<strong>${message}</strong>
			</div>
			<div>
				<form:form commandName="carForm" method="POST"
					class="form-horizontal">
					<div class="form-group">
						<label for="carType" class="col-sm-3">Car Type:</label>
						<div class="col-sm-5">
							<form:select id="carType" class="form-control" path="carType">
								<form:options id="options" path="options" items="${optionsMap}" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="price" class="col-sm-3">Price:</label>
						<div class="col-sm-5">
							<form:input type="number" class="form-control" id="price"
								path="price" placeholder="Price" />
						</div>
					</div>
					<div class="form-group">
						<label for="fuelLevel" class="col-sm-3">Current Fuel
							Level:</label>
						<div class="col-sm-5">
							<form:input type="number" min="0" max="20" class="form-control"
								id="fuelLevel" path="fuelLevel" placeholder="Current Fuel Level" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3">Is a hybrid:</label>
						<div class="col-sm-5">
							<div class="checkbox">
								<form:checkbox id="hybrid" path="hybrid" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3">Is on sale:</label>
						<div class="col-sm-5">
							<div class="checkbox">
								<form:checkbox id="onSale" path="onSale" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<form:button type="submit" class="btn btn-large btn-success">Submit</form:button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>