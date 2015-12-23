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
<link
	href="${pageContext.servletContext.contextPath}/resources/css/prettify.css"
	rel="stylesheet">

<!-- Select2 -->
<link
	href="${pageContext.servletContext.contextPath}/resources/css/select2.min.css"
	rel="stylesheet">

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
													<li><a href="#tab1" data-toggle="tab">Mensaje de
															error</a></li>
													<li><a href="#tab2" data-toggle="tab">M&eacute;trica</a></li>
													<li><a href="#tab3" data-toggle="tab">Dimensiones
															de la m&eacute;trica</a></li>
													<li><a href="#tab4" data-toggle="tab">Condici&oacute;n
															de la certificaci&oacute;m</a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-8 col-md-offset-2">
											<div id="bar"
												class="progress progress-xs progress-striped active">
												<div class="progress-bar" role="progressbar"
													aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
													style="width: 0%;"></div>
											</div>
										</div>
									</div>
									<div class="tab-content">
										<div class="tab-pane" id="tab1">
											<form class="cmxform form-horizontal" id="wizard-form-cert-1"
												method="post" action="#">
												<div class="form-group">
													<label for="codigoError" class="col-lg-2 control-label">C&oacute;digo
														de error</label>
													<div class="col-lg-8">
														<input type="text" class="form-control"
															placeholder="C&oacute;digo" id="input-codigo-error"
															name="codigoError">
													</div>
												</div>
												<div class="form-group">
													<label for="descripcionError"
														class="col-lg-2 control-label">Descripci&oacute;n
														de error</label>
													<div class="col-lg-8">
														<input type="text" class="form-control"
															placeholder="Descripci&oacute;n"
															id="input-descripcion-error" name="descripcionError">
													</div>
												</div>
											</form>
										</div>
										<div class="tab-pane" id="tab2">
											<form class="cmxform form-horizontal" method="post" action=""
												id="wizard-form-cert-2">
												<div class="form-group">
													<label for="metrica" class="col-lg-2 control-label">M&eacute;trica</label>
													<div class="col-lg-8">
														<input type="text" class="form-control"
															placeholder="M&eacute;trica" id="input-metrica"
															name="metrica">
													</div>
												</div>
												<div class="form-group">
													<label for="tabla" class="col-lg-2 control-label">Tabla</label>
													<div class="col-lg-8">
														<select class="form-control m-bot15" id="select-tabla"
															name="tabla" style="width: 100%">
															<c:forEach items="${allTables}" var="table">
																<option value="${table.left}">${table.right}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label for="campoTemporal" class="col-lg-2 control-label">Campo
														temporal de la tabla</label>
													<div class="col-lg-8">
														<select class="form-control m-bot15"
															id="select-campo-temporal" name="campoTemporal">
															<!-- Rellenar con JS -->
															<option>11</option>
															<option>12</option>
															<option>13</option>
															<option>14</option>
															<option>15</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label for="formula" class="col-lg-2 control-label">F&oacute;rmula</label>
													<div class="col-lg-8">
														<textarea class="form-control" rows="6" name="formula"
															id="textarea-formula"></textarea>
													</div>
												</div>
												<div class="form-group">
													<label for="descripcionMetrica"
														class="col-lg-2 control-label">Descripci&oacute;n
														de la m&eacute;trica</label>
													<div class="col-lg-8">
														<textarea class="form-control" rows="6"
															name="descripcionMetrica"
															id="textarea-descripcion-metrica"></textarea>
													</div>
												</div>
												<div class="form-group">
													<label for="filtroFormula" class="col-lg-2 control-label">Filtro
														f&oacute;rmula</label>
													<div class="col-lg-8">
														<textarea class="form-control" rows="6"
															name="filtroFormula" id="textarea-filtro-formula"></textarea>
													</div>
												</div>
												<div class="form-group">
													<label for="tipoMetrica" class="col-lg-2 control-label">Tipo
														de m&eacute;trica</label>
													<div class="col-lg-8">
														<select class="form-control m-bot15"
															id="select-tipo-metrica" name="tipoMetrica">
															<!-- Rellenar con JS -->
															<option>11</option>
															<option>12</option>
															<option>13</option>
															<option>14</option>
															<option>15</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label for="tipoCertificacion"
														class="col-lg-2 control-label">Tipo de
														certificaci&oacute;n</label>
													<div class="col-lg-8">
														<select class="form-control m-bot15"
															id="select-tipo-certificacion" name="tipoCertificacion">
															<!-- Rellenar con JS -->
															<option>11</option>
															<option>12</option>
															<option>13</option>
															<option>14</option>
															<option>15</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label for="tipoCertificacionHistorica"
														class="col-lg-2 control-label">Tipo de
														certificaci&oacute;n hist&oacute;rica</label>
													<div class="col-lg-8">
														<select class="form-control m-bot15"
															id="select-tipo-certificacion-historica"
															name="tipoCertificacionHistorica">
															<!-- Rellenar con JS -->
															<option>11</option>
															<option>12</option>
															<option>13</option>
															<option>14</option>
															<option>15</option>
														</select>
													</div>
												</div>
											</form>
										</div>
										<div class="tab-pane" id="tab3">
											<form class="cmxform form-horizontal" method="post" action=""
												id="wizard-form-cert-3">
												<div class="row">
													<div class="col-md-4">
														<div class="form-group">
															<label for="tablaDimension"
																class="col-md-12 control-label" style="text-align: left">Tabla de
																dimensi&oacute;n </label>
															<div class="col-md-12">
																<select id="select-tabla-dimension" style="width: 100%"
																	class="populate placeholder"
																	name="tablaDimension">
																	<optgroup label="Alaskan/Hawaiian Time Zone">
																		<option value="AK">Alaska</option>
																		<option value="HI">Hawaii</option>
																	</optgroup>
																	<optgroup label="Pacific Time Zone">
																		<option value="CA">California</option>
																		<option value="NV">Nevada</option>
																		<option value="OR">Oregon</option>
																		<option value="WA">Washington</option>
																	</optgroup>
																	<optgroup label="Mountain Time Zone">
																		<option value="AZ">Arizona</option>
																		<option value="CO">Colorado</option>
																		<option value="ID">Idaho</option>
																		<option value="MT">Montana</option>
																		<option value="NE">Nebraska</option>
																		<option value="NM">New Mexico</option>
																		<option value="ND">North Dakota</option>
																		<option value="UT">Utah</option>
																		<option value="WY">Wyoming</option>
																	</optgroup>
																	<optgroup label="Central Time Zone">
																		<option value="AL">Alabama</option>
																		<option value="AR">Arkansas</option>
																		<option value="IL">Illinois</option>
																		<option value="IA">Iowa</option>
																		<option value="KS">Kansas</option>
																		<option value="KY">Kentucky</option>
																		<option value="LA">Louisiana</option>
																		<option value="MN">Minnesota</option>
																		<option value="MS">Mississippi</option>
																		<option value="MO">Missouri</option>
																		<option value="OK">Oklahoma</option>
																		<option value="SD">South Dakota</option>
																		<option value="TX">Texas</option>
																		<option value="TN">Tennessee</option>
																		<option value="WI">Wisconsin</option>
																	</optgroup>
																	<optgroup label="Eastern Time Zone">
																		<option value="CT">Connecticut</option>
																		<option value="DE">Delaware</option>
																		<option value="FL">Florida</option>
																		<option value="GA">Georgia</option>
																		<option value="IN">Indiana</option>
																		<option value="ME">Maine</option>
																		<option value="MD">Maryland</option>
																		<option value="MA">Massachusetts</option>
																		<option value="MI">Michigan</option>
																		<option value="NH">New Hampshire</option>
																		<option value="NJ">New Jersey</option>
																		<option value="NY">New York</option>
																		<option value="NC">North Carolina</option>
																		<option value="OH">Ohio</option>
																		<option value="PA">Pennsylvania</option>
																		<option value="RI">Rhode Island</option>
																		<option value="SC">South Carolina</option>
																		<option value="VT">Vermont</option>
																		<option value="VA">Virginia</option>
																		<option value="WV">West Virginia</option>
																	</optgroup>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label for="campoDimension"
																class="col-md-12 control-label" style="text-align: left">Campo
																dimensi&oacute;n</label>
															<div class="col-md-12">
																<select class="form-control m-bot15" style="width: 100%"
																	id="select-campo-dimension" name="campoDimension">
																	<!-- Rellenar con JS -->
																	<option>11</option>
																	<option>12</option>
																	<option>13</option>
																	<option>14</option>
																	<option>15</option>
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-4">
														<div class="form-group">
															<label for="relacionDimension"
																class="col-md-12 control-label" style="text-align: left">Relaci&oacute;n
																dimensi&oacute;n</label>
															<div class="col-md-12">
																<select class="form-control m-bot15" style="width: 100%"
																	id="select-relacion-dimension" name="relacionDimension">
																	<!-- Rellenar con JS -->
																	<option>11</option>
																	<option>12</option>
																	<option>13</option>
																	<option>14</option>
																	<option>15</option>
																</select>
															</div>
														</div>
													</div>
												</div>
											</form>
										</div>
										<div class="tab-pane" id="tab4">
											<form class="cmxform form-horizontal" method="post" action=""
												id="wizard-form-cert-4">
												<div class="form-group">
													<label for="condicion" class="col-lg-2 control-label">Condici&oacute;n</label>
													<div class="col-lg-8">
														<textarea class="form-control" rows="6" name="condicion"
															id="textarea-condicion"></textarea>
													</div>
												</div>
												<div class="form-group">
													<label for="tablaResultados"
														class="col-md-12 control-label" style="text-align: left">Tabla
														de resultados</label>
													<div class="col-md-12">
														<select class="form-control m-bot15"
															id="select-tabla-resultados" name="tablaResultados">
															<!-- Rellenar con JS -->
															<option>11</option>
															<option>12</option>
															<option>13</option>
															<option>14</option>
															<option>15</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label for="campoResultados"
														class="col-md-12 control-label" style="text-align: left">Campo
														de resultados</label>
													<div class="col-md-12">
														<select class="form-control m-bot15"
															id="select-campo-resultados" name="campoResultados">
															<!-- Rellenar con JS -->
															<option>11</option>
															<option>12</option>
															<option>13</option>
															<option>14</option>
															<option>15</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label for="validarCondicion"
														class="col-sm-3 control-label">Validar
														condici&oacute;n</label>

													<div class="col-sm-9 icheck " id="radio-validar-condicion">

														<div class="square-green">
															<div class="radio ">
																<input tabindex="3" type="radio" name="validarCondicion"
																	value="y"> <label>Sí</label>
															</div>
														</div>

														<div class="square-red">
															<div class="radio ">
																<input tabindex="3" type="radio" name="validarCondicion"
																	value="n" checked> <label>No</label>
															</div>
														</div>

													</div>
												</div>
												<div class="form-group">
													<label for="condicionError" class="col-sm-3 control-label">Condici&oacute;n
														error</label>

													<div class="col-sm-9 icheck" id="radio-condicion-error">

														<div class="square-green">
															<div class="radio ">
																<input tabindex="3" type="radio" name="condicionError"
																	value="y"> <label>Sí</label>
															</div>
														</div>

														<div class="square-red">
															<div class="radio ">
																<input tabindex="3" type="radio" name="condicionError"
																	value="n" checked> <label>No</label>
															</div>
														</div>

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

	<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/select-init.js"></script> --%>


	<!--common script init for all pages-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>

	<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/toggle-init.js"></script> --%>

	<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/advanced-form.js"></script> --%>

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
		src="${pageContext.servletContext.contextPath}/resources/js/mcs-wizard-cert.js"></script>

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
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/select2.min.js"></script>

	<!-- Form Validation -->
	<script type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.validate.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/mcs-validation-wizard-cert.js"></script>

	<!-- Convert to JSON -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.serialize-object.min.js"></script>

</body>
</html>
