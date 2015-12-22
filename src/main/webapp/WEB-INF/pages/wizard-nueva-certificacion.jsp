<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon"
	href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico">

<title>Crear nueva certificaci&oacute;n</title>

<!--Core CSS -->
<link
	href="${pageContext.servletContext.contextPath}/resources/bs3/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-reset.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<!-- Steps -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/jquery.steps.css?1">

<!--icheck-->
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/minimal.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/red.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/green.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/blue.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/yellow.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/purple.css"
	rel="stylesheet">

<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/square.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/red.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/green.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/blue.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/yellow.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/purple.css"
	rel="stylesheet">

<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/grey.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/red.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/green.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/blue.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/yellow.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/purple.css"
	rel="stylesheet">

<!-- Multiselect -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/js/jquery-multi-select/css/multi-select.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/js/jquery-tags-input/jquery.tagsinput.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/js/select2/select2.css" />

<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath}/resources/css/style.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/css/style-responsive.css"
	rel="stylesheet" />

<!-- Wizard -->
<link href="${pageContext.servletContext.contextPath}/resources/css/prettify.css"	rel="stylesheet">
	
	<!-- Select2 -->
<link href="${pageContext.servletContext.contextPath}/resources/css/select2.min.css" rel="stylesheet">
	
<!-- Custom -->
<%-- <link href="${pageContext.servletContext.contextPath}/resources/css/mcs-wizard.css" rel="stylesheet"> --%>

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
				<!-- page start-->

				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading mi-panel-heading"> Nueva
								certificaci&oacute;n </header>
							<div class="panel-body">

								<div id="rootwizard">
									<div class="navbar">
										<div class="navbar-inner">
											<div class="container">
												<ul>
													<li><a href="#tab1" data-toggle="tab">Mensaje de error</a></li>
													<li><a href="#tab2" data-toggle="tab">M&eacute;trica</a></li>
													<li><a href="#tab3" data-toggle="tab">Dimensiones de la m&eacute;trica</a></li>
													<li><a href="#tab3" data-toggle="tab">Condici&oacute;n de la certificaci&oacute;m</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="row">
									<div class="col-md-8 col-md-offset-2">
									<div id="bar" class="progress progress-xs progress-striped active">
										<div class="progress-bar" role="progressbar" aria-valuenow="0"
											aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>
									</div>
									</div>
									</div>
									<div class="tab-content">
										<div class="tab-pane" id="tab1">
											<form class="cmxform form-horizontal" id="wizard-form"
												method="post" action="#">
												<div class="form-group">
													<label for="codigoError" class="col-lg-2 control-label">C&oacute;digo de error</label>
													<div class="col-lg-8">
														<input type="text" class="form-control"
															placeholder="C&oacute;digo" id="codigo-error" name="codigoError">
													</div>
												</div>
												<div class="form-group">
													<label for="descripcionError" class="col-lg-2 control-label">Descripci&oacute;n de error</label>
													<div class="col-lg-8">
														<input type="text" class="form-control"
															placeholder="Descripci&oacute;n" id="descripcion-error" name="descripcionError">
													</div>
												</div>
												<div class="form-group">
													<label for="esAtipico" class="col-sm-3 control-label">Es
														atípico</label>

													<div class="col-sm-9 icheck ">

														<div class="square-green">
															<div class="radio ">
																<input tabindex="3" type="radio" name="esAtipico"
																	value="S"> <label>Sí</label>
															</div>
														</div>

														<div class="square-red">
															<div class="radio ">
																<input tabindex="3" type="radio" name="esAtipico"
																	value="N" checked> <label>No</label>
															</div>
														</div>

													</div>
												</div>
											</form>
										</div>
										<div class="tab-pane" id="tab2">
											<form class="cmxform form-horizontal" method="post" action=""
												id="wizard-form-2">

												<div class="form-group">
													<label for="jobs" class="control-label col-md-3">Jobs
														disponibles</label>
													<div class="col-md-9">
														<select multiple name="jobs" class="multi-select"
															id="multi_select_jobs">
															<c:forEach items="${allJobs}" var="job">
																<option value="${job.jobID}">${job.jobID}</option>
															</c:forEach>
														</select>
													</div>
												</div>
											</form>
										</div>
										<div class="tab-pane" id="tab3">
											<form class="cmxform form-horizontal" method="post" action=""
												id="wizard-form-3">
												<div class="form-group">
													<label class="col-lg-2 control-label">Jobs de este
														pase</label>
													<div class="col-lg-8">
														<select class="form-control m-bot15" id="desplegable-jobs">
															<!-- Rellenar con JS -->
														</select>
													</div>
												</div>
												<div class="form-group last"></div>
											</form>
										</div>
										<div class="tab-pane" id="tab4">
											<form class="cmxform form-horizontal" id="wizard-form"
												method="post" action="#">
												<div class="form-group">
													<label for="nombrePase" class="col-lg-2 control-label">Nombre
														del pase</label>
													<div class="col-lg-8">
														<input type="text" class="form-control"
															placeholder="Nombre" id="nompase" name="nombrePase"
															th:field="*{nombrePase}">
													</div>
												</div>
											</form>
										</div>
										<ul class="pager wizard">
											<li class="previous"><a href="javascript:;">Anterior</a></li>
											<li class="next"><a href="javascript:;">Siguiente</a></li>
											<li class="finish" style="float: right;"><a
												style="background-color: #95b75d; color: #fff;"
												href="javascript:;">Terminar</a></li>
										</ul>
									</div>
								</div>

							</div>
						</section>
						<section class="panel">
														<form class="cmxform form-horizontal" method="post" action="" id="wizard-form-4">
							<div class="form-group">
							<label class="control-label col-md-3">Dependencias
														disponibles</label>
							<div class="col-md-6">
							<select multiple style="width:100%" class="" id="desplegable-dependencias">
							</select>
							</div>
							</div>
							</form>
						</section>
					</div>
				</div>
				<!-- page end-->
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
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/bs3/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script class="include" type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/easypiechart/jquery.easypiechart.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>

	<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-switch.js"></script> --%>

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/fuelux/js/spinner.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-daterangepicker/moment.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-multi-select/js/jquery.multi-select.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-multi-select/js/jquery.quicksearch.js"></script>

	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>

	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-tags-input/jquery.tagsinput.js"></script>

	<script
		src="${pageContext.servletContext.contextPath}/resources/js/select-init.js"></script>


	<!--common script init for all pages-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>

	<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/toggle-init.js"></script> --%>

	<script
		src="${pageContext.servletContext.contextPath}/resources/js/advanced-form.js"></script>

	<!-- Wizard -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/wizard/jquery.bootstrap.wizard.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/wizard/prettify.js"></script>


	<!-- Steps -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-steps/jquery.steps.js"></script>

	<!-- icheck -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/iCheck/jquery.icheck.js"></script>
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/ckeditor/ckeditor.js"></script>

	<!--icheck init -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/icheck-init.js"></script>

	<!-- Mi script personal -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/mcs.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/mcs-wizard.js"></script>

	<!-- Cookies -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/cookie-master/js.cookie.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.cookie.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.hoverIntent.minified.js"></script>

	<!-- URL utility -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/URI.js-gh-pages/src/URI.min.js"></script>

	<!-- Select2 -->
	<script src="${pageContext.servletContext.contextPath}/resources/js/select2.min.js"></script>
	
	<!-- 	Form Validation -->
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.validate.min.js"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/mcs-validation-wizard-cert.js"></script>
	
	<!-- Convert to JSON -->
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.serialize-object.min.js"></script>

</body>
</html>
