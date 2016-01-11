(function ($) {
	"use strict";
	$(document).ready(function () {
		
		// Función auxiliar para obtener el color a partir del peso
		function _getColor(peso){
			if (peso < 20) return '#B4DDF8';
			if (peso < 40) return '#81C3ED';
			if (peso < 60) return '#59ACE2';
			if (peso < 80) return '#59ACE2';
			return '#157DC0';
		}
		
		// Creo los sliders
		var totalSliders = 0;
		$( ".defaultSlider" ).each(function() {
			++totalSliders;
			// read initial values from markup and remove that
			var value = parseInt( $( this ).text(), 10 );
			$( this ).empty().slider({
				value: value,
				range: "min",
				step: 0.2,
				animate: true,
				orientation: "horizontal",
			});
		});
		
		// Los conecto
		$('div.defaultSlider').slider().linkedSliders(). 
	    filter('all').slider('value', 100); 
		
		// Actualizar displays
		$( ".defaultSlider" ).on( "slidechange, slide", function( event, ui ) {
			// Si decidimos hacerlo con spans
			$($(this).parent().parent().find('span')[0]).text(ui.value+' %');
			$($(this).parent().parent().find('span')[0]).css('background-color', _getColor(ui.value));
			// Si decidimos hacerlo con inputs
//			$($(this).parent().parent().find('input')[0]).val(ui.value);
			// Logger.info
//			console.log('value'+ui.value);
			var logString = '';
			$( ".defaultSlider" ).each(function(index, element) {
				logString += 'slider ' + index + ': ' + $(element).value;
				console.log($(element));
			});
//			console.log(logString);
		});
		
		
        // Toggle entre sliders manual y guiado
		$('#toggle-manual').change(function(){
			if($(this).prop('checked')){ // Inicializo linked sliders
				console.log('conecto sliders');
				$('div.defaultSlider').slider().linkedSliders(). 
			    filter('all').slider('value', 100); 
			}
			else{ // Unlink sliders
				console.log('desconecto sliders');
				$('div.defaultSlider').linkedSliders('destroy'); 
			}
		});
//		$('#btn-toggle-linked').toggle(function() { 
//			$(this).text('Guiado'); 
//			$('div.defaultSlider').linkedSliders('destroy'); 
//		}, 
//		function() { 
//			$(this).text('Manual'); 
//			$('div.defaultSlider').linkedSliders(); 
//		});
	});

})(jQuery);
