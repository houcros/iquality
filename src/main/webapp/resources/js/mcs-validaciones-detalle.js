$(document).ready(function() {

	// Settings para ocultar las columnas que no se deben mostrar
    var colSettings = [];
    var numCols = $.cookie('numCols');
    for (i = parseInt(numCols); i < 25; ++i){ // Desharcodear el 25 (50) (?)
    	colSettings.push({ "bVisible": false, "aTargets": [ i ], "bSortable": false });
    }
    
    // Inicializo tabla con los settings de arriba
    var oTable = $('#hidden-table-validacion-tecnica-detalle').dataTable( {
        "aoColumnDefs": colSettings,
        "aaSorting": [[1, 'asc']],
        "oLanguage": langParams    
        });

    // Pongo los datos básicos a partir de las cookies dejadas
    // en la pantalla anterior
    $('#dBas-vali-det-1').append('  ' + $.cookie('detVali_Entid'));
    $('#dBas-vali-det-2').append('  ' + $.cookie('detVali_Valid'));
    $('#dBas-vali-det-3').append('  ' + $.cookie('detVali_Fecha'));
    
});