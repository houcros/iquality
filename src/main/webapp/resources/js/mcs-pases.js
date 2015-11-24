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
    var oTable = $('#hidden-table-pases').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] }
        ],
        "aaSorting": [[1, 'asc']],
        "oLanguage": langParams    });

    $(document).on('click','#hidden-table-pases tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        var aData = oTable.fnGetData( nTr );
        window.location = "pases/" + aData[1] + "/jobs";
    } );
    
    
    $('<div class="span6"><div id="hidden-table-pases_escenario" class="dataTables_length"><label><select class="form-control"><option value="1" selected="selected">1</option></select>&nbsp;Escenario</label></div></div>').insertAfter($('#hidden-table-pases_length').parent());
    $('<div class="span6"><div id="hidden-table-pases_software" class="dataTables_length"><label><select class="form-control"><option value="Versi&oacute;n inicial" selected="selected">Inicial</option></select>&nbsp;Software</label></div></div>').insertAfter($('#hidden-table-pases_length').parent());
//	$( '#hidden-table-pases_filter:first-child' ).find( 'input' ).first().val( '373' );
    
    var url = window.location.href;
    var search = new URI(url).query();
    var searchParam = search.split('=')[1];
    if(searchParam !== ""){
    	$( '#hidden-table-pases_filter:first-child' ).find( 'input' ).first().val( searchParam );
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