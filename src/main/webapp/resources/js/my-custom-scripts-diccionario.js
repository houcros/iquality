$(document).ready(function () {
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
					'animation': 100
				},
				"types": {
//					"SECCION":{
//						"icon": "/iQuality/resources/images/folder-1.png"
//					},
//					"SUBSECCION":{
//						"icon": "/iQuality/resources/images/folder-2.png"
//					},
//					"ENTIDAD":{
//						"icon": "/iQuality/resources/images/folder-3.png"
//					},
					"DIMENSION":{
						"icon": "/iQuality/resources/images/dimension.png"
					},
					"JERARQUIA":{
						"icon": "/iQuality/resources/images/jerarquia.png"
					},
					"ATRIBUTO_MAESTRO":{
						"icon": "/iQuality/resources/images/atributo-solo-maestro.png"
					},
					"ATRIBUTO":{
						"icon": "/iQuality/resources/images/atributo.png"
					},
					"INDICADOR":{
						"icon": "/iQuality/resources/images/indicador.png"
					},
					"LITERAL":{
						"icon": "/iQuality/resources/images/atributo-solo-maestro.png"
					}
				},
				"plugins" : [
				             "search",
				             "types"
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
//					console.log(data);
					if(!data.selected[0].match(new RegExp(/^j/))){
						console.log(data.selected[0]);	
						$.ajax({
							url: "api/descripcionComponente/" + data.selected[0],
							async: false,
							success: function( data ){
								$('#tarj-definicion').text(data.definicion);
								$('#tarj-comentarios').text(data.comentarios);
								$('#tarj-nombre').text(data.nombre);
								$('#tarj-formato').text(data.formato);
								$('#tarj-responsable').text(data.responsable);
							}
						});
					}
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