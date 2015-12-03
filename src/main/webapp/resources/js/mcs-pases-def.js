$(document).ready(function() {

    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#hidden-table-pases-def').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] }
        ],
        "aaSorting": [[1, 'asc']],
        "oLanguage": langParams    });

//    $("#btn-nuevo-pase-def").click(function(){
//    	window.location += "/wizard-nuevo-pase";
//    });
//    $(document).on('click','#hidden-table-pases-def tbody td img',function () {
//        var nTr = $(this).parents('tr')[0];
//        var aData = oTable.fnGetData( nTr );
//        window.location = "pases/" + aData[1] + "/jobs";
//    } );
    
} );