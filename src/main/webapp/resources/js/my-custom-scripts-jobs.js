$(document).ready(function() {

    $('#dynamic-table').dataTable( {
        "aaSorting": [[ 4, "desc" ]]
    } );

    /*
     * Insert a 'details' column to the table
     */
    var nCloneTh = document.createElement( 'th' );
    var nCloneTd = document.createElement( 'td' );
    // TODO path harcodeado, tiene que haber una manera mejor de hacer esto 
    // Montar mi API que me devuelva el path ???
    nCloneTd.innerHTML = '<img src="../../resources/images/details_open.png">';
    nCloneTd.className = "center";

    $('#hidden-table-jobs thead tr').each( function () {
        this.insertBefore( nCloneTh, this.childNodes[0] );
    } );

    $('#hidden-table-jobs tbody tr').each( function () {
        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
    } );

    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#hidden-table-jobs').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] }
        ],
        "aaSorting": [[1, 'asc']]
    });

    $(document).on('click','#hidden-table-jobs tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        var aData = oTable.fnGetData( nTr );
        window.location = "jobs/" + aData[1] + "/registro-de-actividad";
    } );
} );