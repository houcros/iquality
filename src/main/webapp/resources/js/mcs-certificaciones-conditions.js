$(document).ready(function() {

	/*
	 * Inicializo la tabla
	 */
	var oTable = $('#hidden-table-certificaciones-negocio').dataTable( {
		"aoColumnDefs": [
		                 { "bSortable": false, "aTargets": [ 0 ] }
		                 ],
		                 "aaSorting": [[1, 'asc']],
		                 "oLanguage": langParams    });

} );

