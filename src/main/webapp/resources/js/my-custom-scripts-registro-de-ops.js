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
    nCloneTd.innerHTML = '<img src="/iQuality/resources/images/details_open.png">';
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

    
    function fnFormatDetailsCustom ( oTable, nTr )
    {
    	var aData = oTable.fnGetData( nTr );
    	var sOut = "";

    	$.ajax({
    		url : "/iQuality/api/traza-de-operacion/" + aData[1],
    		async: false,
    		success : function(data){
    			$.each( data, function( index, value ){
    				sOut += "<p><b>[" + value['fecha'] + " | " 
    				+ value['idTraza'] + "] " + value['categoria'] + ":</b> "
    				+ value['mensaje'] + "</p>";
    			});
    		}
    	});
    	return sOut;
    }
    
    $(document).on('click','#hidden-table-jobs tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        if ( oTable.fnIsOpen(nTr) )
        {
            /* This row is already open - close it */
            this.src = "/iQuality/resources/images/details_open.png";
            oTable.fnClose( nTr );
        }
        else
        {
            /* Open this row */
            this.src = "/iQuality/resources/images/details_close.png";
            oTable.fnOpen( nTr, fnFormatDetailsCustom(oTable, nTr), 'details' );
        }
    });
    
//    $(document).on('click','#hidden-table-jobs tbody td img',function () {
//        var nTr = $(this).parents('tr')[0];
//        var aData = oTable.fnGetData( nTr );
//        
//        $.ajax({
//        	url : "/iQuality/api/traza-de-operacion/" + aData[1],
//        	success : function(data){
//        		$('#panel-traza').html("");
//        		$.each( data, function( index, value ){
//        			$('#panel-traza').append("<p><b>[" + value['fecha'] + " | " 
//        					+ value['idTraza'] + "] " + value['categoria'] + ":</b> "
//        					+ value['mensaje'] + "</p>");
//        		});
//        	}
//        });
//        
//    });
    
} );