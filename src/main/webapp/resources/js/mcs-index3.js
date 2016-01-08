(function ($) {
	"use strict";
	$(document).ready(function () {
		
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
		$( ".defaultSlider" ).on( "slidechange", function( event, ui ) {
			// Si decidimos hacerlo con spans
			$($(this).parent().parent().find('span')[0]).text(ui.value+' %');
			// Si decidimos hacerlo con inputs
			$($(this).parent().parent().find('input')[0]).val(ui.value);
			// Logger.info
			console.log('value'+ui.value);
		});
	});

})(jQuery);
