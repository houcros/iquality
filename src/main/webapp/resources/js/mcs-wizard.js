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

// Inicializo wizard
$(document).ready(function() {
	$('#rootwizard').bootstrapWizard({
		onTabShow : function(tab, navigation, index) {
			var $total = navigation.find('li').length;
			var $current = index + 1;
			var $percent = ($current / $total) * 100;
			$('#rootwizard .progress-bar').css({
				width : $percent + '%'
			});
			
			// *Custom*
			// Cuando estoy en la ultima tab pongo los jobs que el usuario selecciono
			if(index === 2){
//				console.log("In last tab");
				selectedOps = $('#multi_select_jobs').val();
//				console.log(selectedOps);
				var opts = "";
				for (i = 0; i < selectedOps.length; ++i){
					opts += "<option value=\""+selectedOps[i]+"\">"+selectedOps[i]+"</option>";
				}
//				console.log(opts);
				$("#tab3 select").html(opts);
			}
		}
	});
	
	$('#rootwizard .finish').click(function() {
		alert('Finished!, Starting over!');
		$('#rootwizard').find("a[href*='tab1']").trigger('click');
	});
	window.prettyPrint && prettyPrint()
	
	// *Custom*
	// Poner dependencias disponibles en multiselect cuando cambio el job seleccionado
	$( "#tab3 select" ).change(function() {
//		  console.log( "Handler for .change() called." );
		  var ind = $("#desplegable-jobs option:selected").index() // Índice seleccionado
		  var val = $("#desplegable-jobs").val(); // En este caso .val() devuelve lo mismo que .text()
//		  console.log(ind, val);
		  
		  
		  if(selectedOps == null) alert("No has seleccionado ningún job!");
//		  console.log(selectedOps);
		  $("#desplegable-dependencias").empty().select2("destroy");
		  for (var i = 0; i < selectedOps.length; ++i){
//			  console.log(i);
			  if(i !== ind){
				  $("#desplegable-dependencias").append("<option value='"+i+"'>"+selectedOps[i]+"</option>");
//				  console.log("Added " + selectedOps[i]);
			  }
		  }
		  $("#desplegable-dependencias").select2();
//		  console.log(deps);

	});
	

});

// Inicializo los multi-select
$(document).ready(function() {
	
	$('#multi_select_jobs').multiSelect(searchableParams);
//	$('#multi_select_dependencias').multiSelect(searchableParams);
//	$("#desplegable-dependencias").select2();
	
});