(function ($) {
    "use strict";
    $(document).ready(function () {
    	
//    	$('#select-ambito-datos').select2({
//            placeholder: "Seleccione una tabla",
//            allowClear: false
//        });

    	// Actualizar vista al cargar Excel
    	var url = 'carga/upload';
		$('#fileupload').fileupload(
				{
					url : url,
					dataType : 'json',
					done : function(e, data) {
						$.each(data.result.files, function(index, file) {
							$('<p/>').text(file.name).appendTo('#files');
						});
					},
					progressall : function(e, data) {
						var progress = parseInt(data.loaded / data.total
								* 100, 10);
						$('#progress .progress-bar').css('width',
								progress + '%');
					}
				}).prop('disabled', !$.support.fileInput).parent()
				.addClass($.support.fileInput ? undefined : 'disabled')
				.bind('fileuploaddone', function (e, data) { console.log("Hecho.")})
				.bind('fileuploadfail', function (e, data) { console.log(data)});
    	
    });
})(jQuery);
