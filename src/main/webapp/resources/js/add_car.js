var defaultPrice = 20000;
var semiPrice = 50000;
var semiMaxFuel = 50;
var defaultMaxFuel = 20;

$(document).ready(function(){
	$("#price").prop("disabled", true);
	setFieldsDefault();

	$("#carType").change(function() {
		setFieldsOnSelectChange();
	});
	
	$("#onSale").change(function() {
		setSalesPriceField();
	});
})

function setFieldsDefault(){
	$('#hybrid').attr('checked', false);
	$('#onSale').attr('checked', false);
	$("#price").val(null);
	$("#carType").val("");
	$("#fuelLevel").val(0);
}