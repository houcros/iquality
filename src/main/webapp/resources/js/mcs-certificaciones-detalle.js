$(document).ready(function() {

	// Settings para ocultar las columnas que no se deben mostrar
    var colSettings = [];
    var numDims = $.cookie('numDims');
    for (i = parseInt(numDims); i < 6; ++i){ // Desharcodear el 6 (?)
    	colSettings.push({ "bVisible": false, "aTargets": [ i ], "bSortable": false });
    }
    
    // Inicializo tabla con los settings de arriba
    var oTable = $('#hidden-table-certificaciones-negocio-detalle').dataTable( {
        "aoColumnDefs": colSettings,
        "aaSorting": [[1, 'asc']],
        "oLanguage": langParams   
        });
    
    // Pongo los datos básicos a partir de las cookies dejadas
    // en la pantalla anterior
    $('#dBas-cert-det-1').append('  ' + $.cookie('detCert_Fecha'));
    $('#dBas-cert-det-2').append('  ' + $.cookie('detCert_Indic'));
    $('#dBas-cert-det-3').append('  ' + $.cookie('detCert_Certi'));
    $('#dBas-cert-det-4').append('  testing');
   
} );