(function ($) {
	"use strict";
	$(document).ready(function () {
		
		var updateOthers = function(event, ui){
			console.log(event);
			console.log(ui);
		}
		
		for(var i = 1; i < 9; ++i){
			var id = '#ex'+i.toString();
			var slider = new Slider(id, {
				formatter: function(value) {
					return 'Current value: ' + value;
				}
			}).on('change', updateOthers(event, ui));
		}
		
//		$('div.mySlider').slider().linkedSliders().slider('value', 100);
		
	});

})(jQuery);
