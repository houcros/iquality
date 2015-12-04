var searchableParams = {
		selectableHeader: "<input type='text' class='form-control search-input' autocomplete='off' placeholder='search...'>",
		selectionHeader: "<input type='text' class='form-control search-input' autocomplete='off' placeholder='search...'>",
		afterInit: function (ms) {
			var that = this,
			$selectableSearch = that.$selectableUl.prev(),
			$selectionSearch = that.$selectionUl.prev(),
			selectableSearchString = '#' + that.$container.attr('id') + ' .ms-elem-selectable:not(.ms-selected)',
			selectionSearchString = '#' + that.$container.attr('id') + ' .ms-elem-selection.ms-selected';

			that.qs1 = $selectableSearch.quicksearch(selectableSearchString)
			.on('keydown', function (e) {
				if (e.which === 40) {
					that.$selectableUl.focus();
					return false;
				}
			});

			that.qs2 = $selectionSearch.quicksearch(selectionSearchString)
			.on('keydown', function (e) {
				if (e.which == 40) {
					that.$selectionUl.focus();
					return false;
				}
			});
		},
		afterSelect: function () {
			this.qs1.cache();
			this.qs2.cache();
		},
		afterDeselect: function () {
			this.qs1.cache();
			this.qs2.cache();
		}
}

/*
 * Variable para guardar las depencencias seleccionadas para cada job
 */
estado = {};

$(document).ready(function() {
	/*
	 * Inicializo wizard
	 */
	$('#rootwizard').bootstrapWizard({
		onTabShow : function(tab, navigation, index) {
			// Update progress bar
			var $total = navigation.find('li').length;
			var $current = index + 1;
			var $percent = ($current / $total) * 100;
			$('#rootwizard .progress-bar').css({
				width : $percent + '%'
			});

			// *Custom*
			// Cuando estoy en la ultima tab pongo los jobs que el usuario selecciono
			if(index === 2){
				// Ademas hago el submit de los datos que tengo hasta ahora
//				console.log("strigify: ", $("#wizard-form").serializeJSON());
//				$.ajax({
//					'type': 'POST',
//					'url': '/iQuality/post-test',
//					'data': $("#wizard-form").serializeJSON(), 
////					'dataType': 'json',
//					'headers': {
//						'Accept': 'application/json',
//				        'Content-Type': 'application/json' 
//					},
//					'success': function(){
//						console.log('mandarina');
//					}
//				}).fail(alert("Error!"));
//				$("#wizard-form-2").submit()
				
				
				selectedOps = $('#multi_select_jobs').val();
				//if(selectedOps == null) alert("No has seleccionado ningún job!");
//				console.log("selectedOps on init: ", selectedOps);
				previousOpt = selectedOps[0];

				var opts = "";
				var optsToShow = [];
				for (var i = 0; i < selectedOps.length; ++i){
					opts += "<option value=\""+selectedOps[i]+"\">"+selectedOps[i]+"</option>";
					// Obtengo las opciones a mostrar para el primer elemento en el formato de data en select2
					if (i !== 0) optsToShow.push({'id':selectedOps[i], 'text':selectedOps[i]});
					// Inicialmente no hay nada seleccionado para guardar en el estado
					estado[selectedOps[i]] = [];
				}
				$("#tab3 select").html(opts);
				$("#desplegable-dependencias").select2({data:optsToShow});

				// TODO Meter el panel arriba
				// Muestro el panel en la última pestaña
				$("#desplegable-dependencias").closest("section").show();
			}
			else $("#desplegable-dependencias").closest("section").hide();
		},
		// Validar el paso actual cuando click en *next*
		onNext: function(tab, navigation, index){
			if(index === 1){
				console.log("Validar primer paso.");
				var validated = validateFirstStep();
				console.log("validated: ", validated);
				return validated;
			}
			// Agrego para validar el multiselect de jobs
			else if(index==2){
				console.log("Validar segundo paso.");
				var validated = validateSecondStep();
				console.log("validated: ", validated);
				return validated;
			}
		}
	});

	$('#rootwizard .finish').click(function() {
		
//		var datosBasicos = $("#wizard-form").serializeJSON();
		var datos = {
				'sistema':  $('#sistema').val(),
				'nombrePase': $('#nompase').val(),
				'esAtipico': $("#wizard-form input[type='radio']:checked").val(),
				'jobs': selectedOps,
				'estados': estado
		}
		
		console.log("---");
		console.log("datos-string: ", JSON.stringify(datos));
		
		$.ajax({
			'type': 'POST',
			'url': '/iQuality/post-test',
//			'data': datosBasicos, 
			'data': JSON.stringify(datos), 
//			'dataType': 'json',
			'headers': {
				'Accept': 'application/json',
		        'Content-Type': 'application/json' 
			},
			'success': function(){
				console.log('mandarina');
			}
		}).fail(alert("Error!"));
		
		alert('Finished!, Starting over!');
		$('#rootwizard').find("a[href*='tab1']").trigger('click');
	});
	window.prettyPrint && prettyPrint()

	
	/*
	 * Inicializo el multiselect
	 */
	$('#multi_select_jobs').multiSelect(searchableParams);


	/*
	 * Actualizar el estado cuando selecciono/deselecciono
	 */
	$("#desplegable-dependencias").on("select2:select", function (e) {

		var val = $("#desplegable-jobs").val(); // En este caso .val() devuelve lo mismo que .text()
		var selectedElem = e.params.data.text;
		estado[val].push(selectedElem);
	});

	$("#desplegable-dependencias").on("select2:unselect", function (e) {

		var val = $("#desplegable-jobs").val(); // En este caso .val() devuelve lo mismo que .text()
		var unselectedElem = e.params.data.text;
		var indxToRemove = $.inArray(unselectedElem, estado[val]);
		estado[val].splice(indxToRemove, 1);
	});

	/*
	 * Poner dependencias disponibles en multiselect cuando cambio el job seleccionado
	 */
	$( "#tab3 select" ).change(function() {

		var ind = $("#desplegable-jobs option:selected").index() // Índice seleccionado
		var val = $("#desplegable-jobs").val(); // En este caso .val() devuelve lo mismo que .text()

		// Muestro todas la opciones menos la seleccionada en el desplegable de jobs
		var optsToShow = [];
		selectedOps.forEach(function(entry){
			if(entry !== val) optsToShow.push({'id':entry, 'text':entry});
		});

		// Creo un select2 nuevo para poder inicializarlo con datos
		$("#desplegable-dependencias").empty().select2("destroy");
		$("#desplegable-dependencias").select2({data:optsToShow});

		// Obtengo las opciones guardadas en el estado
		var toSelect = [];
		estado[val].forEach(function(entry){
			toSelect.push(entry);
		});

		// Y las selecciono
		$("#desplegable-dependencias").val(toSelect).change();

	});


});
