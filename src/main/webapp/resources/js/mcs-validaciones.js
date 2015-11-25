$(document).ready(function() {

    /*
     * Insert a 'details' column to the table
     */
//    var nCloneTh = document.createElement( 'th' );
//    var nCloneTd = document.createElement( 'td' );
//    nCloneTd.innerHTML = '<img src="/iQuality/resources/images/details_open.png" style="cursor:pointer;">';
//    nCloneTd.className = "center";
//
//    $('#hidden-table-validaciones-tecnicas thead tr').each( function () {
//        this.insertBefore( nCloneTh, this.childNodes[0] );
//    } );
//
//    $('#hidden-table-validaciones-tecnicas tbody tr').each( function () {
//        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
//    } );

    /*
     * Inicializo la tabla sin mostrar id_metrica e id_mes
     */
    var oTable = $('#hidden-table-validaciones-tecnicas').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] },
            { "bVisible": false, "aTargets": [ 1 ], "bSortable": false },
            { "bVisible": false, "aTargets": [ 2 ], "bSortable": false }
        ],
        "aaSorting": [[1, 'asc']],
        "oLanguage": langParams
    });

    /*
     * Dejo caer las cookies que usaré en la pantalla de detalle y sigo el link
     */
    $(document).on('click','#hidden-table-validaciones-tecnicas tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        var aData = oTable.fnGetData( nTr );

        if (aData[9].indexOf('KO') > -1){
            $.cookie('detVali_Fecha', aData[3], { path : '/iQuality/resultado-certificaciones/2/detalle'});
            $.cookie('detVali_Entid', aData[6], { path : '/iQuality/resultado-certificaciones/2/detalle'});
            $.cookie('detVali_Valid', aData[7], { path : '/iQuality/resultado-certificaciones/2/detalle'});
            
            window.location += "/detalle?idMet=" + aData[1] + "&idMes=" + aData[2];
        }
        else{
        	alert("Nada interesante que ver.");
        }

    } );
    
} );