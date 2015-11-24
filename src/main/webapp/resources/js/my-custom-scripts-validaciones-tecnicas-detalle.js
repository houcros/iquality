$(document).ready(function() {

    $('#dynamic-table').dataTable( {
        "aaSorting": [[ 4, "desc" ]]
    } );


    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var colSettings = [];
    var numCols = $.cookie('numCols');
    for (i = parseInt(numCols); i < 25; ++i){ // Desharcodear el 25 (50) (?)
    	colSettings.push({ "bVisible": false, "aTargets": [ i ], "bSortable": false });
    }
    
    var oTable = $('#hidden-table-validacion-tecnica-detalle').dataTable( {
        "aoColumnDefs": colSettings,
        "aaSorting": [[1, 'asc']]
    });

    $('#dBas-vali-det-1').append('  ' + $.cookie('detVali_Entid'));
    $('#dBas-vali-det-2').append('  ' + $.cookie('detVali_Valid'));
    $('#dBas-vali-det-3').append('  ' + $.cookie('detVali_Fecha'));
    
    
    // DEBUG
//    console.log($.cookie('detCert_idMet'));
//    console.log($.cookie('detCert_idMes'));
    
    
    
    
    
    // Obtengo todos los parámetros que pueda haber en la query
    var urlParams;
    (window.onpopstate = function () {
        var match,
            pl     = /\+/g,  // Regex for replacing addition symbol with a space
            search = /([^&=]+)=?([^&]*)/g,
            decode = function (s) { return decodeURIComponent(s.replace(pl, " ")); },
            query  = window.location.search.substring(1);

        urlParams = {};
        while (match = search.exec(query))
           urlParams[decode(match[1])] = decode(match[2]);
    })();
    
    
    
    /*
     * Intento de recuperar el estado de la búsqueda a partir de la query en la URL
     * Falta terminar (no funciona el KeyPress event para simular el enter en el
     * campo de búsqueda)
     */
    if(urlParams['search'] !== ""){
    	$( '#hidden-table-pases_filter:first-child' ).find( 'input' ).first().val( urlParams['search'] );
    	$( '#hidden-table-pases_filter:first-child' ).find( 'input' ).first().attr('id', 'mi-search-input')
//    	$( '#hidden-table-pases_filter:first-child' ).find( 'input' ).first().trigger($.Event('keypress', {which : 13}));
        $( '#mi-search-input' ).focus();
//    	$( '#mi-search-input' ).trigger($.Event('keypress', {which : 13}));
    	var e = $.Event("keypress");
    	e.which = 13; //choose the one you want
//    	e.keyCode = 13;
    	$( '#mi-search-input' ).trigger(e);
    }
    
} );