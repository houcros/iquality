$(document).ready(function () {
//	Custom para actualizar la cache del diccionario
/////////////////////////////////////////////////////////
	$('#update-dictionary-button').click(function(){

		$(this).prop('disabled', true);

		$.ajax({
			url: "api/updateDictionaryCache",
//			async: false,
			success: function() {
				$('#update-dictionary-button').prop('disabled', false);
				alert( "Diccionario de conceptos recargado." );
			}
		});

		alert( "Recargando el diccionario de conceptos." +
		"\nPor favor, espere." );
	});
/////////////////////////////////////////////////////////
	
//	jsTree
/////////////////////////////////////////////////////////
	$(function () {
		$.ajax({
			url: "api/jsonTree-para-jsTree",
//			async: false,
			success: function( data ) {
				$('#jstree').jstree({ 'core': {
					'data': data.children,
//					'themes' : 'default,'
					'animation': 10
				},
				"plugins" : [
				             "search"
				             ]
				});
				
				var to = false;
				$('#plugins4_q').keyup(function () {
					if(to) { clearTimeout(to); }
					to = setTimeout(function () {
						var v = $('#plugins4_q').val();
						$('#jstree').jstree(true).search(v);
					}, 250);
				  });
				// 7 bind to events triggered on the tree
				$('#jstree').on("changed.jstree", function (e, data) {
					console.log(data.selected);
				});
				// 8 interact with the tree - either way is OK
//				$('button').on('click', function () {
//					$('#jstree').jstree(true).select_node('child_node_1');
//					$('#jstree').jstree('select_node', 'child_node_1');
//					$.jstree.reference('#jstree').select_node('child_node_1');
//				});
			}
		});
	});
/////////////////////////////////////////////////////////
	
	
	$('#jstree-stub').jstree();
});