(function($){
	$(document).ready(function () {
    	/*==START MY TWEAKS==*/
    	
    	/*==Check cookie y abrir menú==*/
    	var checkCookie = Cookies.get("nav-item");
    	  if (checkCookie != "") {
    	    $('#nav-accordion > li > ul > li > a:eq('+checkCookie+')').parent().addClass('active');
    	  }
    	  
    	/*==Creo cookie para estado de la nav-accordion==*/
    	$('#nav-accordion > li > ul > li > a').click(function(){
    	      var navIndex = $('#nav-accordion > li > ul > li > a').index(this);
    	      Cookies.set("nav-item", navIndex /*, { path: '/iQuality/' }*/);
    	  });
    	
    	/*==END MY TWEAKS==*/
	});
});