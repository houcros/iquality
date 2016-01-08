(function ($) {
	"use strict";
	$(document).ready(function () {
		if ($.fn.plot) {

			// No funciona dentro de tabla; pq?!
			var myvalues = [100,200,459,234,600,800,345,987,675,457,765];
			$('.mysparkline').sparkline('html', {
				type: 'line', 
				resize: 'true', 
				height: '100%', 
				width: '100', 
				lineWidth: 1, 
				minSpotColor: 'false',
				maxSpotColor: 'false',
				lineColor: 'red',
				spotColor: 'red',
				fillColor: '',
				highlightLineColor: '#4694E8',
				highlightSpotColor: '#e1b8ff',
				spotRadius: 1
			});
			// Sí funciona, pero sólo me deja ponerle los datos
			$('.inlinesparkline').sparkline(); 
		}
	});

})(jQuery);
