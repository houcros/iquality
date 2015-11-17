$(document).ready(function() {

    $('#dynamic-table').dataTable( {
        "aaSorting": [[ 4, "desc" ]]
    } );

    /*
     * Insert a 'details' column to the table
     */
    var nCloneTh = document.createElement( 'th' );
    var nCloneTd = document.createElement( 'td' );
    nCloneTd.innerHTML = '<img src="/iQuality/resources/images/details_open.png" style="cursor:pointer;">';
    nCloneTd.className = "center";

    $('#hidden-table-pases thead tr').each( function () {
        this.insertBefore( nCloneTh, this.childNodes[0] );
    } );

    $('#hidden-table-pases tbody tr').each( function () {
        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
    } );

    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var colSettings = [{ "bVisible": false, "aTargets": [ 0 ], "bSortable": false}]; // Esta columna la devería suprimir en verdad
    var numDims = $.cookie('numDims');
    for (i = parseInt(numDims) + 1; i <= 6; ++i){
    	colSettings.push({ "bVisible": false, "aTargets": [ i ], "bSortable": false });
    }
    
    var oTable = $('#hidden-table-pases').dataTable( {
        "aoColumnDefs": colSettings,
        "aaSorting": [[1, 'asc']]
    });

    $(document).on('click','#hidden-table-pases tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        var aData = oTable.fnGetData( nTr );
//        window.location = "pases/" + aData[1] + "/jobs";
        window.location = "#";
    } );
    	
    // DEBUG
//    console.log($.cookie('detCert_idMet'));
//    console.log($.cookie('detCert_idMes'));
//    console.log($.cookie('detCert_Certi'));
//    console.log($.cookie('detCert_Fecha'));
//    console.log($.cookie('detCert_Indic'));
    
    $('#dBas-cert-det-1').append('  ' + $.cookie('detCert_Fecha'));
    $('#dBas-cert-det-2').append('  ' + $.cookie('detCert_Indic'));
    $('#dBas-cert-det-3').append('  ' + $.cookie('detCert_Certi'));
    $('#dBas-cert-det-4').append('  testing');
    
    
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