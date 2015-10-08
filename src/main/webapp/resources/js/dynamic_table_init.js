function fnFormatDetails ( oTable, nTr )
{
    var aData = oTable.fnGetData( nTr );
    var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
    sOut += '<tr><td>Rendering engine:</td><td>'+aData[1]+' '+aData[4]+'</td></tr>';
    sOut += '<tr><td>Link to source:</td><td>Could provide a link here</td></tr>';
    sOut += '<tr><td>Extra info:</td><td>And any further details here (images etc)</td></tr>';
    sOut += '</table>';

    return sOut;
}

// Mi intento de adaptar la tabla escondida
function fnFormatDetailsCustom ( oTable, nTr )
{
    var aData = oTable.fnGetData( nTr );
	var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
	
	$.ajax({
		  url: "lk_met_pla_ctrl_pase/api/"+aData[2],
		  async: false,
		  success: function( data ) {
				
//			  alert( "Data Loaded: " + data.id_sistema + data.id_ejecucion + data.id_software +
//					  data.id_pase + data.de_pase + data.id_fecha_inicio + data.id_fecha_inicio_real +
//					  data.id_fecha_fin_real + data.id_estado + data.id_sn_habilitado + data.id_anyo + data.id_mes +
//					  data.id_escenario + data.id_fecha_creacion + data.id_fecha_modificacion + data.id_pid);

			  sOut += '<tr><td>id_ejecucion:</td><td>'+'Test ejecucion'+'</td></tr>';
			
			  sOut += '<tr><td>id_sistema:</td><td>'+data.id_sistema+'</td></tr>';
			  sOut += '<tr><td>id_ejecucion:</td><td>'+data.id_ejecucion+'</td></tr>';
			  sOut += '<tr><td>id_software:</td><td>'+data.id_software+'</td></tr>';
			  sOut += '<tr><td>id_pase:</td><td>'+data.id_pase+'</td></tr>';
			  sOut += '<tr><td>de_pase:</td><td>'+data.de_pase+'</td></tr>';
			  sOut += '<tr><td>id_fecha_inicio:</td><td>'+data.id_fecha_inicio+'</td></tr>';
			  sOut += '<tr><td>id_fecha_inicio_real:</td><td>'+data.id_fecha_inicio_real+'</td></tr>';
			  sOut += '<tr><td>id_fecha_fin_real:</td><td>'+data.id_fecha_fin_real+'</td></tr>';
			  sOut += '<tr><td>id_estado:</td><td>'+data.id_estado+'</td></tr>';
			  sOut += '<tr><td>id_sn_habilitado:</td><td>'+data.id_sn_habilitado+'</td></tr>';
			  sOut += '<tr><td>id_anyo:</td><td>'+data.id_anyo+'</td></tr>';
			  sOut += '<tr><td>id_mes:</td><td>'+data.id_mes+'</td></tr>';
			  sOut += '<tr><td>id_escenario:</td><td>'+data.id_escenario+'</td></tr>';
			  sOut += '<tr><td>id_fecha_creacion:</td><td>'+data.id_fecha_creacion+'</td></tr>';
			  sOut += '<tr><td>id_fecha_modificacion:</td><td>'+data.id_fecha_modificacion+'</td></tr>';
			  sOut += '<tr><td>id_pid:</td><td>'+data.id_pid+'</td></tr>';
		  }
		});
	
//	var res = $.getJSON( "lk_met_pla_ctrl_pase/api/437" ).done(function( data ) {
//		
//		  alert( "Data Loaded: " + data.id_sistema + data.id_ejecucion + data.id_software +
//				  data.id_pase + data.de_pase + data.id_fecha_inicio + data.id_fecha_inicio_real +
//				  data.id_fecha_fin_real + data.id_estado + data.id_sn_habilitado + data.id_anyo + data.id_mes +
//				  data.id_escenario + data.id_fecha_creacion + data.id_fecha_modificacion + data.id_pid);
//
//		  sOut += '<tr><td>id_ejecucion:</td><td>'+'Test ejecucion'+'</td></tr>';
//		
//		  sOut += '<tr><td>id_sistema:</td><td>'+data.id_sistema+'</td></tr>';
//		  sOut += '<tr><td>id_ejecucion:</td><td>'+data.id_ejecucion+'</td></tr>';
//		  sOut += '<tr><td>id_software:</td><td>'+data.id_software+'</td></tr>';
//		  sOut += '<tr><td>id_pase:</td><td>'+data.id_pase+'</td></tr>';
//		  sOut += '<tr><td>de_pase:</td><td>'+data.de_pase+'</td></tr>';
//		  sOut += '<tr><td>id_fecha_inicio:</td><td>'+data.id_fecha_inicio+'</td></tr>';
//		  sOut += '<tr><td>id_fecha_inicio_real:</td><td>'+data.id_fecha_inicio_real+'</td></tr>';
//		  sOut += '<tr><td>id_fecha_fin_real:</td><td>'+data.id_fecha_fin_real+'</td></tr>';
//		  sOut += '<tr><td>id_estado:</td><td>'+data.id_estado+'</td></tr>';
//		  sOut += '<tr><td>id_sn_habilitado:</td><td>'+data.id_sn_habilitado+'</td></tr>';
//		  sOut += '<tr><td>id_anyo:</td><td>'+data.id_anyo+'</td></tr>';
//		  sOut += '<tr><td>id_mes:</td><td>'+data.id_mes+'</td></tr>';
//		  sOut += '<tr><td>id_escenario:</td><td>'+data.id_escenario+'</td></tr>';
//		  sOut += '<tr><td>id_fecha_creacion:</td><td>'+data.id_fecha_creacion+'</td></tr>';
//		  sOut += '<tr><td>id_fecha_modificacion:</td><td>'+data.id_fecha_modificacion+'</td></tr>';
//		  sOut += '<tr><td>id_pid:</td><td>'+data.id_pid+'</td></tr>';
//
//	});
	
//	console.log(res);
//	console.log(res.responseJSON.responseText);
	
	sOut += '<tr><td>id_sistema:</td><td>'+ 'TEST' +'</td></tr>';
//	sOut += '<tr><td>id_ejecucion:</td><td>'+res.id_ejecucion+'</td></tr>';
	
	sOut += '</table>';
	
    return sOut;
}


$(document).ready(function() {

    $('#dynamic-table').dataTable( {
        "aaSorting": [[ 4, "desc" ]]
    } );

    /*
     * Insert a 'details' column to the table
     */
    var nCloneTh = document.createElement( 'th' );
    var nCloneTd = document.createElement( 'td' );
    nCloneTd.innerHTML = '<img src="resources/images/details_open.png">';
    nCloneTd.className = "center";

    $('#hidden-table-info thead tr').each( function () {
        this.insertBefore( nCloneTh, this.childNodes[0] );
    } );

    $('#hidden-table-info tbody tr').each( function () {
        this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
    } );

    /*
     * Initialse DataTables, with no sorting on the 'details' column
     */
    var oTable = $('#hidden-table-info').dataTable( {
        "aoColumnDefs": [
            { "bSortable": false, "aTargets": [ 0 ] }
        ],
        "aaSorting": [[1, 'asc']]
    });

    /* Add event listener for opening and closing details
     * Note that the indicator for showing which row is open is not controlled by DataTables,
     * rather it is done here
     */
    $(document).on('click','#hidden-table-info tbody td img',function () {
        var nTr = $(this).parents('tr')[0];
        if ( oTable.fnIsOpen(nTr) )
        {
            /* This row is already open - close it */
            this.src = "resources/images/details_open.png";
            oTable.fnClose( nTr );
        }
        else
        {
            /* Open this row */
            this.src = "resources/images/details_close.png";
            oTable.fnOpen( nTr, fnFormatDetailsCustom(oTable, nTr), 'details' );
        }
    } );
} );