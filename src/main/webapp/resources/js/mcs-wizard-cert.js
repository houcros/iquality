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
 * Variable para ir guardando los datos a enviar
 */
datos = {};

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
		},
		// No permitir navegar por las pills
		onTabClick: function(tab, navigation, index){
			return false;
		},
		// Validar el paso actual cuando click en *next*
		onNext: function(tab, navigation, index){
			switch(index){
			case 1:
				console.log("Validar paso 1");
				var isValid = $("#wizard-form-cert-1").valid();
				if(!isValid) return isValid;
				datos['codigoError'] = $('#input-codigo-error').val();
				datos['descripcionError'] = $('#intput-descripcion-error').val();
				console.log(JSON.stringify(datos));
				return isValid;
				break;
			case 2:
				console.log("Validar paso 2");
				var isValid = $("#wizard-form-cert-2").valid();
				if(!isValid) return isValid;
				datos['metrica'] = $('#input-metrica').val();
				datos['sistema'] = $('#select-sistema').val();
				datos['tabla'] = $('#select-tabla').val();
				datos['campoTemporal'] = $('#select-campo-temporal').val();
				datos['formula'] = $('#textarea-formula').val();
				datos['descripcionMetrica'] = $('#textarea-descripcion-metrica').val();
				datos['filtroFormula'] = $('#textarea-filtro-formula').val();
				datos['tipoMetrica'] = $('#select-tipo-metrica').val();
				datos['tipoCertificacion'] = $('#select-tipo-certificacion').val();
				datos['tipoCertificacionHistorica'] = $('#select-tipo-certificacion-historica').val();
				console.log(JSON.stringify(datos));
				return isValid;
				break;
			case 3:
				console.log("Validar paso 3");
				var isValid = $("#wizard-form-cert-3").valid();
				if(!isValid) return isValid;
				datos['tablaDimension'] = $('#select-tabla-dimension').val();
				datos['campoDimension'] = $('#select-campo-dimension').val();
				datos['relacionDimension'] = $('#select-relacion-dimension').val();
				console.log(JSON.stringify(datos));
				return isValid;
				break;
			// El último paso se valida al clickar finish
			}
		}
	});

	$('#rootwizard .finish').click(function() {
		
		// El último paso se valida al clickar finish
		console.log("Validar paso 4 y terminar");
		var isValid = $("#wizard-form-cert-4").valid();
		if(!isValid) return isValid;
		
		datos['condicion'] = $('#textarea-condicion').val();
		datos['tablaResultados'] = $('#select-tabla-resultados').val();
		datos['campoResultados'] = $('#select-campo-resultados').val();
		datos['validarCondicion'] = $("#radio-validar-condicion input[type='radio']:checked").val();
		datos['condicionError'] = $("#radio-condicion-error input[type='radio']:checked").val();
		console.log("---");
		console.log(JSON.stringify(datos));
		
		$.ajax({
			'type': 'POST',
			'url': '/iQuality/parametrizar-certificaciones/post-wizard',
//			'data': datosBasicos, 
			'data': JSON.stringify(datos), 
//			'dataType': 'json',
			'headers': {
				'Accept': 'application/json',
		        'Content-Type': 'application/json' 
			}
		}).done(function(rdata){
			console.log(rdata);
			window.location = rdata.redirect;
			alert('Pase creado.');
		}).fail(function(rdata){
			console.log(rdata);
			window.location = rdata.error;
			alert('Error al crear.');
		});
		
	});
	window.prettyPrint && prettyPrint()

	/*
	 * Inicializo los selects
	 */
    $("#select-tabla-dimension").select2({
        placeholder: "Seleccione una tabla",
        allowClear: false
    });
	$('#select-tabla').select2();
    $('#select-campo-dimension').select2();
    $('#select-relacion-dimension').select2();
    
});
