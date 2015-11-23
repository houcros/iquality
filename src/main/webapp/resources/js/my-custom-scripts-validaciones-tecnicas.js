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

    $('#hidden-table-validaciones-tecnicas thead tr').each( function () {
        this.insertBefore( nCloneTh, this.childNodes[0] );
    } );

    $('#hidden-table-validaciones-tecnicas tbody tr').each( function () {
        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
    } );

    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#hidden-table-validaciones-tecnicas').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] },
            { "bVisible": false, "aTargets": [ 1 ], "bSortable": false },
            { "bVisible": false, "aTargets": [ 2 ], "bSortable": false }
        ],
        "aaSorting": [[1, 'asc']]
    });

    $(document).on('click','#hidden-table-validaciones-tecnicas tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        var aData = oTable.fnGetData( nTr );

        $.cookie('detCert_idMet', aData[1], { path : '/iQuality/resultado-certificaciones/2/detalle'});
        $.cookie('detCert_idMes', aData[2], { path : '/iQuality/resultado-certificaciones/2/detalle'});
        
        window.location += "/detalle?idMet=" + aData[1] + "&idMes=" + aData[2];
    } );
    
    
//    $('<div class="span6"><div id="hidden-table-pases_escenario" class="dataTables_length"><label><select class="form-control"><option value="1" selected="selected">1</option></select>&nbsp;Escenario</label></div></div>').insertAfter($('#hidden-table-pases_length').parent());
//    $('<div class="span6"><div id="hidden-table-pases_software" class="dataTables_length"><label><select class="form-control"><option value="Versi&oacute;n inicial" selected="selected">Inicial</option></select>&nbsp;Software</label></div></div>').insertAfter($('#hidden-table-pases_length').parent());
//	$( '#hidden-table-pases_filter:first-child' ).find( 'input' ).first().val( '373' );
    
    /*
     * Intento de recuperar el estado de la búsqueda a partir de la query en la URL
     * Falta terminar (no funciona el KeyPress event para simular el enter en el
     * campo de búsqueda)
     */
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