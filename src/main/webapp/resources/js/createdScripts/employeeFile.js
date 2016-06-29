$(document).ready(function() {
	var indexRow = 0;
	
	$("#employeeSearch tr.employee-row").each(function(index, row) {
		disableEditBtn($(row));
	});

	function disableEditBtn(row) {		
		if (row.find(".edit-flag").prop("checked")) {
			console.log($("#employeeSearch tr.employee-row").index(row));
			$("#row" + indexRow +"disableEditBtn").addClass('disabled');
		}		
		indexRow = indexRow + 1; 
	};

	$(".datepicker").datepicker({
		format : 'mm/dd/yyyy',
		todayHighlight : true,
		autoclose : true,
	});

	// $('#employeeForm').formValidation({
	// framework: 'bootstrap',
	// err: {
	// container: function($field, validator) {
	// return $field.parent().next(".messageContainer");
	// }
	// },
	// icon: {
	// valid: 'glyphicon glyphicon-ok',
	// invalid: 'glyphicon glyphicon-remove',
	// validating: 'glyphicon glyphicon-refresh'
	// },
	// fields: {
	// firstName: {
	// validators: {
	// notEmpty: {
	// message: 'The first name is required and cannot be empty'
	// }
	// }
	// },
	// secondName: {
	// validators: {
	// notEmpty: {
	// message: 'The second name is required and cannot be empty'
	// }
	// }
	// }
	// }
	// });

	$('#employeeSearch').DataTable({
		"bFilter" : false,
		"scrollX" : true
	});

});