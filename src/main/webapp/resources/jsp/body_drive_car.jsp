<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="page-header">
		<h1>Drive Car</h1>
	</div>
</div>
<div id="container">
	<div class="row container">
		<div class="col-xs-12 col-sm-9">
			<div>
				<div class="alert ${alertType}">
					<strong>${message}</strong>
				</div>
				<form:form commandName="selectCarForm" method="POST"
					class="form-horizontal">
					<div class="form-group">
						<label for="carId" class="col-sm-3">Select Car to Drive:</label>
						<div class="col-sm-5">
							<form:select id="carId" class="form-control" path="carId">
								<option value="" disabled selected>Select Car</option>
								<c:forEach var="cars" items="${lot}">
									<option value="${cars.carId}">${cars.carId}</option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-5">
							<form:button type="submit" class="btn btn-large btn-success">Drive</form:button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>