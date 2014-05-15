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

function setSalesPriceField(){
	if($("#onSale").is(':checked')){
		$("#price").val(($("#price").val()*.8));
	}
	else{
		if($("#carType").val() === "semi"){
			$("#price").val(semiPrice);
		}
		else{
			$("#price").val(defaultPrice);
		}
	}
}

function setFieldsOnSelectChange(){
	if($("#carType").val() === ""){
		$("#price").val(null);
	}
	else if($("#carType").val() === "semi"){
		$("#price").val(semiPrice);
	}
	else{
		$("#price").val(defaultPrice);
	}
	
	if($("#carType").val() === "semi"){
		$("#fuelLevel").prop("max",semiMaxFuel);
	}
	else{
		$("#fuelLevel").prop("max",defaultMaxFuel);
		if($("#fuelLevel").val() > defaultMaxFuel){
			$("#fuelLevel").val(defaultMaxFuel);
		}
	}
	setSalesPriceField();
}