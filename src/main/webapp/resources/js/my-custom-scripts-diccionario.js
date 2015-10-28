$(document).ready(function () {
//	Custom para actualizar la cache del diccionario
/////////////////////////////////////////////////////////
	$('#update-dictionary-button').click(function(){

		$(this).prop('disabled', true);

		$.ajax({
			url: "api/updateDictionaryCache",
//			async: false,
			success: function() {
				$('#update-dictionary-button').prop('disabled', false);
				alert( "Diccionario de conceptos recargado." );
			}
		});

		alert( "Recargando el diccionario de conceptos." +
		"\nPor favor, espere." );
	});
/////////////////////////////////////////////////////////
});