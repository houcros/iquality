var Script = function () {

//    $.validator.setDefaults({
//        submitHandler: function(form) {
////        	$(form).ajaxSubmit();
//        	// or
////        	form.submit();
//        	alert("submitted!"); 
//        }
//    });

    $().ready(function() {

        // validate forms on keyup and submit
        $("#wizard-form-cert-1").validate({
            rules: {
            	codigoError: {
            		required : true,
            		minlength : 2
            	},
            	descripcionError: "required"
            },
            messages: {
            	codigoError: {
            		required : "Introduzca un c&oacute;digo de error.",
            		minlength : "El c&oacute;digo de error debe constar de al menos dos caracteres."
            	},
            	descripcionError: "Introduzca una descripci&oacute;n del error."
            }
        });

        $("#wizard-form-cert-2").validate({
        	rules: {
        		metrica: "required",
        		formula: {
        			required : true,
        			minlength : 10
        		},
        		descripcionMetrica: {
        			required : true,
        			minlength : 10
        		}
        	},
        	messages: {
        		metrica: "Se necesita una m&eacute;trica para la certificaci&oacute;n",
        		formula: {
        			required : "Introduzca una f&oacute;rmula.",
        			minlength : "La f&oacute;rmula debe constar de al menos 10 caracteres."
        		},
        		descripcionMetrica: {
        			required : "Introduzca un c&oacute;digo de error.",
        			minlength : "La descripci&oacute;n de la m&eacute;trica debe constar de al menos 10 caracteres."
        		}
        	}
        });
        
        $("#wizard-form-cert-4").validate({
        	rules: {
        		condicion: {
        			required : true,
        			minlength : 10
        		}
        	},
        	messages: {
        		condicion: {
        			required : "Introduzca una condici&oacute;n.",
        			minlength : "La condici&oacute;n debe constar de al menos 10 caracteres."
        		},
        	}
        });
    });


}();