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
//    nCloneTd.innerHTML = '<img src="/iQuality/resources/images/details_open.png">';
    nCloneTd.innerHTML = '<span><img src="/iQuality/resources/images/details_open.png" style="cursor:pointer;float:left;" class="show-regops"><img src="/iQuality/resources/images/lines-icon.png" style="cursor:pointer;float:right;" class="toggle-dependencias"></span>';
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
        "aaSorting": [[1, 'asc']],
        "oLanguage": langParams    });

 // Mi intento de adaptar la tabla escondida
    function fnFormatDetailsCustom ( oTable, nTr )
    {
        var aData = oTable.fnGetData( nTr );
//    	var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
        var sOut = '<div>'
    	
    	var pathnameParts = window.location.pathname.split('/');
        //pathnameParts = ["", "iQuality", "pases", "373", "jobs"]
    	var uriPath = "/iQuality/api/pases/" + pathnameParts[3] + "/jobs/" + aData[1] + "/dependencias";
    	
    	$.ajax({
    		  url: "/iQuality/api/pases/" + pathnameParts[3] + "/jobs/" + aData[1] + "/dependencias",
    		  async: false,
    		  success: function( data ) {
    			  console.log(uriPath);
    			  console.log(data);
    			  if (data.length === 0) sOut += '<span><p>Job sin dependencias</p></span>';
    				  
    			  $.each(data, function( index, value){
    				  sOut += '<span>Padre: '+value.idJobPadre+', con Estado: '+value.estado+'</span>';
//    				  sOut += '<tr><td>Job Padre:</td><td>'+value.idJobPadre+'</td></tr>';
//        			  sOut += '<tr><td>Estado:</td><td>'+value.estado+'</td></tr>';
    			  })
    			  
    		  }
    		});
    	
//    	sOut += '</table>';
    	sOut += '</div>';
    	
        return sOut;
    }
    
    $(document).on('click','.show-regops',function () {
        var nTr = $(this).parents('tr')[0];
        var aData = oTable.fnGetData( nTr );
        
//        var pathnameParts = window.location.pathname.split('/');
        //pathnameParts = ["", "iQuality", "pases", "373", "jobs"]
//        window.location = "pases/" + pathnameParts[3] + "/jobs/" + aData[1] + "/registro-de-operaciones";
        window.location = "jobs/" + aData[1] + "/registro-de-operaciones";
    } );
    
    
    $(document).on('click','.toggle-dependencias',function () {
        var nTr = $(this).parents('tr')[0];
        if ( oTable.fnIsOpen(nTr) )
        {
            /* This row is already open - close it */
            this.src = "/iQuality/resources/images/lines-icon.png";
            oTable.fnClose( nTr );
        }
        else
        {
            /* Open this row */
            this.src = "/iQuality/resources/images/vertical-lines-icon.png";
            oTable.fnOpen( nTr, fnFormatDetailsCustom(oTable, nTr), 'details' );
        }
    } );
    
} );