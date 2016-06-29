$(document).ready( function(){
	
	 $('#assetForm').formValidation({
	        framework: 'bootstrap',
	        err: {
	            container: function($field, validator) {
	                return $field.parent().next(".messageContainer");
	            }
	        },
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	name: {
	                validators: {
	                    notEmpty: {
	                        message: 'The asset name is required and cannot be empty'
	                    }
	                }
	            },
	            serie: {
	                validators: {
	                    notEmpty: {
	                        message: 'The asset serie is required and cannot be empty'
	                    }
	                }
	            }
	        }
	    });
});