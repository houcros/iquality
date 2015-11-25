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
					var type = data.instance.get_type(data.selected[0], false);
					if(type == "INDICADOR" || type == "ATRIBUTO" || type == "ATRIBUTO_MAESTRO"){
//					if(!data.selected[0].match(new RegExp(/^j/))){
						console.log(data.selected[0]);
						console.log(type);
						$.ajax({
							url: "api/descripcionComponente/" + type + "/" + data.selected[0],
//							async: false,
							success: function( data ){
								
								$('#dict-ficha-definicion').children().first().text(data.nombre);
								$('#tarj-responsable').text(data.responsable);
								$('#tarj-definicion').text(data.definicion);
								$('#tarj-comentarios').text(data.comentarios);
								
								$('#tarj-historico-ent').text(data.historico);
								$('#tarj-metodo-obtencion-ent').text(data.metodoObtencion);
								
								switch(type){
								case "INDICADOR":
									
									$('#master-toggle-container').hide();
									$('.show-on-atr').hide();
									$('.show-on-ent').hide();
									$('.show-on-master').hide();
									$('.show-on-indic').show();
									
									$('#tarj-unidad-medida').text(data.unidadMedida);
									$('#tarj-periodo-acumulado').text(data.periodoAcumulado);
									
									var s = "";
									var icon = "<a class=\"fa fa-book\" href=\"#\"></a>&nbsp;&nbsp;";
									for(var i = 0; i < data.certificaciones.length; ++i){
										s += icon + data.certificaciones[i] + "<br>";
									}
									if (s == "") s = "<i>Indicador sin certificaciones</i>";
									$('#div-certificaciones').html(s);
									
									break;
									
								case "ATRIBUTO":
								case "LITERAL":
									
									$('#master-toggle-container').hide();
									$('.show-on-indic').hide();
									$('.show-on-master').hide();
									$('.show-on-atr').show();
									$('.show-on-ent').show();
									
									$('#tarj-formato').text(data.formato);
									$('#tarj-caracteristicas-act-ent').text(data.periodoActualizacion + " " + data.tipoActualizacion);
									
									break;
									
								case "ATRIBUTO_MAESTRO":
									
									$('#master-toggle-container').show();
									$('#master-toggle').prop('checked', true).change();
									$('.show-on-indic').hide();
									$('.show-on-atr').hide();
									$('.show-on-ent').hide();
									$('.show-on-master').show();
									
									$('#tarj-formato').text(data.formato);
									$('#tarj-caracteristicas-act-ent').text(data.periodoActualizacion + " " + data.tipoActualizacion);
									
									$('#tarj-historico-master').text(data.historicoMaestro);
									$('#tarj-metodo-obtencion-master').text(data.metodoObtencionMaestro);
									$('#tarj-caracteristicas-act-master').text(data.periodoActualizacionMaestro + " " + data.tipoActualizacionMaestro);

									break;
								}
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
	
	$(function() {
		$('#master-toggle').change(function() {
			if($(this).prop('checked')){
				$(".show-on-ent").hide();
				$(".show-on-master").show();
			}
			else{
				$(".show-on-ent").show();
				$(".show-on-master").hide();
			}
		})
	});

});