<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Ignacio lucero at Indra">
<link rel="shortcut icon"
	href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico">
<title>Cargar archivos</title>
<!--Core CSS -->
<link
	href="${pageContext.servletContext.contextPath}/resources/bs3/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-reset.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/jvector-map/jquery-jvectormap-1.2.2.css"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath}/resources/css/style.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/css/style-responsive.css"
	rel="stylesheet" />
<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-fileupload/jquery.fileupload.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-fileupload/jquery.fileupload-ui.css">
<!-- CSS adjustments for browsers with JavaScript disabled -->
<noscript>
	<link rel="stylesheet"
		href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-fileupload/jquery.fileupload-noscript.css">
</noscript>
<noscript>
	<link rel="stylesheet"
		href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-fileupload/jquery.fileupload-ui-noscript.css">
</noscript>
<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]>
    <script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<section id="container">
		<!--header start-->
		<c:import url="/WEB-INF/pages/tags/header.jsp" />
		<!--header end-->

		<!--sidebar start -->
		<c:import url="/WEB-INF/pages/tags/sidebar.jsp" />
		<!--sidebar end -->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">Carga de ficheros Excel</h3>
							</div>
							<div class="panel-body">
								<!-- The fileinput-button span is used to style the file input field as button -->
								<span class="btn btn-success fileinput-button"> <i
									class="glyphicon glyphicon-plus"></i> <span>Select
										files...</span>
									<!-- The file input field used as target for the file upload widget -->
									<input id="fileupload" type="file" name="files[]" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" multiple>
								</span> <br> <br>
								<!-- The global progress bar -->
								<div id="progress" class="progress">
									<div class="progress-bar progress-bar-success"></div>
								</div>
								<!-- The container for the uploaded files -->
								<div id="files" class="files"></div>
								<br> <br>
							</div>
						</div>

					</div>
				</div>
			</section>
		</section>
		<!--main content end-->

		<!--right sidebar start -->
		<c:import url="/WEB-INF/pages/tags/right-sidebar.jsp" />
		<!--right sidebar end -->

	</section>
	<!-- Placed js at the end of the document so the pages load faster -->
	<!--Core js-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/bs3/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>
	<!--Multiple File Uploader-->
	<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/file-uploader/js/vendor/jquery.ui.widget.js"></script>
	<!-- The Iframe Transport is required for browsers without support for XHR file uploads -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/file-uploader/js/jquery.iframe-transport.js"></script>
	<!-- The basic File Upload plugin -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/file-uploader/js/jquery.fileupload.js"></script>
	<!-- Bootstrap JS is not required, but included for the responsive demo navigation -->
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<!-- My custom script -->
	<script src="${pageContext.servletContext.contextPath}/resources/js/mcs.js"></script>
	<!-- Cookies -->
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.cookie.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.dcjqaccordion.2.7.js"></script>

	<!-- The XDomainRequest Transport is included for cross-domain file deletion for IE 8 and IE 9 -->
	<!--[if (gte IE 8)&(lt IE 10)]>
<script src="${pageContext.servletContext.contextPath}/resources/js/file-uploader/js/cors/jquery.xdr-transport.js"></script>
<![endif]-->
	<!--common script init for all pages-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>
	<!-- The template to display files available for upload -->
	<script>
		/*jslint unparam: true */
		/*global window, $ */
		$(function() {
			'use strict';
			// Change this to the location of your server-side upload handler:
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
	</script>
</body>
</html>