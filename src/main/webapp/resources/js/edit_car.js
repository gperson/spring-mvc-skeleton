$(document).ready(function(){
	$("#price").prop("disabled", true);
	$("#carType").prop("disabled", true);
	$("#hybrid").prop("disabled", true);
	
	setFieldsOnSelectChange();
	
	$("#onSale").change(function() {
		setSalesPriceField();
	});
})
