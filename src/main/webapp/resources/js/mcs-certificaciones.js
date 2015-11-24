$(document).ready(function() {

    /*
     * Insert a 'details' column to the table
     */
    var nCloneTh = document.createElement( 'th' );
    var nCloneTd = document.createElement( 'td' );
    nCloneTd.innerHTML = '<img src="/iQuality/resources/images/details_open.png" style="cursor:pointer;">';
    nCloneTd.className = "center";

    $('#hidden-table-certificaciones-negocio thead tr').each( function () {
        this.insertBefore( nCloneTh, this.childNodes[0] );
    } );

    $('#hidden-table-certificaciones-negocio tbody tr').each( function () {
        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
    } );

    /*
     * Inicializo la tabla sin mostrar id_metrica, id_mes y certificacion
     */
    var oTable = $('#hidden-table-certificaciones-negocio').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] },
            { "bVisible": false, "aTargets": [ 1 ], "bSortable": false },
            { "bVisible": false, "aTargets": [ 2 ], "bSortable": false },
            { "bVisible": false, "aTargets": [ 3 ], "bSortable": false }
        ],
        "aaSorting": [[1, 'asc']],
        "oLanguage": langParams    });

    /*
     * Dejo caer las cookies que usaré en la pantalla de detalle y sigo el link
     */
    $(document).on('click','#hidden-table-certificaciones-negocio tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        var aData = oTable.fnGetData( nTr );
        
        $.cookie('detCert_idMet', aData[1], { path : '/iQuality/resultado-certificaciones/1/detalle'});
        $.cookie('detCert_idMes', aData[2], { path : '/iQuality/resultado-certificaciones/1/detalle'});
        $.cookie('detCert_Certi', aData[3], { path : '/iQuality/resultado-certificaciones/1/detalle'});
        $.cookie('detCert_Fecha', aData[4], { path : '/iQuality/resultado-certificaciones/1/detalle'});
        $.cookie('detCert_Indic', aData[9], { path : '/iQuality/resultado-certificaciones/1/detalle'});
        
        window.location += "/detalle?idMet=" + aData[1] + "&idMes=" + aData[2];
        
    } );
    
} );