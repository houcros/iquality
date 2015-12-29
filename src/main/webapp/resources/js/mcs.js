(function($){
	$(document).ready(function () {

		/*==Mejora para contexto de sidebar==*/
		var pathnameParts = window.location.pathname.split('/');
		// Será del estilo: pathnameParts = ["", "iQuality", "pases", "373", "jobs"]
		if(pathnameParts.length > 2){
//			console.log(pathnameParts[2]);
			switch(pathnameParts[2]){
			case 'resultado-certificaciones':
				$('#nav-accordion > li > ul > li > a:eq(0)').parent().addClass('active');
				break;
			case 'parametrizar-certificaciones':
				$('#nav-accordion > li > ul > li > a:eq(1)').parent().addClass('active');
				break;
			case 'pases':
				$('#nav-accordion > li > ul > li > a:eq(2)').parent().addClass('active');
				break;
			case 'planificar-cargas':
				$('#nav-accordion > li > ul > li > a:eq(3)').parent().addClass('active');
				break;
			case 'carga':
				$('#nav-accordion > li > ul > li > a:eq(4)').parent().addClass('active');
				break;
			}
		}

		/*==Check cookie y abrir menú==*/
//		var checkCookie = Cookies.get("nav-item");
//		if (checkCookie != "") {
//			$('#nav-accordion > li > ul > li > a:eq('+checkCookie+')').parent().addClass('active');
//		}

		/*==Creo cookie para estado de la nav-accordion==*/
//		$('#nav-accordion > li > ul > li > a').click(function(){
//			var navIndex = $('#nav-accordion > li > ul > li > a').index(this);
//			Cookies.set("nav-item", navIndex /*, { path: '/iQuality/' }*/);
//		});

	});
})(jQuery);