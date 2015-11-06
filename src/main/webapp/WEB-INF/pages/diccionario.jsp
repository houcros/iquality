<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ThemeBucket">
<link rel="shortcut icon"
	href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico"
	type="image/x-icon">

<title>Tree View</title>

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

<!-- switch -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-switch.css" />

<!--external css-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/js/fuelux/css/tree-style.css" />

<!-- Custom styles for this template -->
<link
	href="${pageContext.servletContext.contextPath}/resources/css/style.css"
	rel="stylesheet">
<link
	href="${pageContext.servletContext.contextPath}/resources/css/style-responsive.css"
	rel="stylesheet" />

<!-- jsTree themes -->
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/jstree/default/style.min.css" />


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

		<!--header start -->
		<c:import url="/WEB-INF/pages/tags/header.jsp" />
		<!--header end -->

		<!--sidebar start -->
		<c:import url="/WEB-INF/pages/tags/sidebar.jsp" />
		<!--sidebar end -->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper site-min-height">

				<!-- BEGIN PAGE CONTENT-->
				<div class="column">
					<div class="col-md-4">
						<div class="panel" id="dict-explorador-indicadores">
							<div class="panel-heading mi-panel-heading">Explorador de indicadores</div>
							<div class="panel-body">
								<div class="mi-search-bar">
									<input id="plugins4_q" type="text" class="form-control search"
										placeholder=" Search">
								</div>
								<div id="jstree" class="">
									<!-- 									<ul> -->
									<!-- 										<li>Root node 1 -->
									<!-- 											<ul> -->
									<!-- 												<li id="child_node_1">Child node 1</li> -->
									<!-- 												<li>Child node 2</li> -->
									<!-- 											</ul> -->
									<!-- 										</li> -->
									<!-- 										<li>Root node 2</li> -->
									<!-- 									</ul> -->
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="column">
					<div class="col-md-8">
						<div class="panel" id="dict-ficha-definicion">
							<div class="panel-heading mi-panel-heading">
								Ficha de definici&oacute;n <span class="tools pull-right">
									<a class="fa fa-chevron-down" href="javascript:;"
									style="color: white"></a>
								</span>
							</div>
							<div class="panel-body">
								<!--tab nav start-->
								<section class="panel">
									<header class="panel-heading tab-bg-dark-navy-blue ">
										<ul class="nav nav-tabs">
											<li class="active"><a data-toggle="tab"
												href="#tab-datos-basicos">Datos b&aacute;sicos</a></li>
											<li class=""><a data-toggle="tab"
												href="#tab-datos-entidad">Datos de entidad</a></li>
											<li class=""><a data-toggle="tab"
												href="#tab-reglas-certificacion">Reglas de
													certificaci&oacute;n</a></li>
										</ul>
									</header>
									<div id="content-tabs-dicha-definicion" class="panel-body">
										<div class="tab-content">
											<div id="tab-datos-basicos" class="tab-pane active">
												<!-- page start-->

												<div class="row">
													<div class="col-md-9">
														<!-- BEGIN Portlet PORTLET-->
														<div class="row">
															<div class="col-md-12">
																<div class="panel panel-info">
																	<div class="panel-heading tarjetita-heading">Definici&oacute;n</div>
																	<div class="panel-body tarjetita-body">Duis mollis, est non
																		commodo luctus, nisi erat porttitor ligula, eget
																		lacinia odio sem nec elit. Cras mattis consectetur
																		purus sit amet fermentum. Duis mollis.</div>
																</div>
															</div>
														</div>
														<!-- END Portlet PORTLET-->

														<!-- BEGIN Portlet PORTLET-->
														<div class="row">
															<div class="col-md-12">
																<div class="panel panel-info">
																	<div class="panel-heading tarjetita-heading">Comentarios</div>
																	<div class="panel-body tarjetita-body">Duis mollis, est non
																		commodo luctus, nisi erat porttitor ligula, eget
																		lacinia odio sem nec elit. Cras mattis consectetur
																		purus sit amet fermentum. Duis mollis. Duis mollis,
																		est non commodo luctus, nisi erat porttitor ligula,
																		eget lacinia odio sem nec elit. Cras mattis
																		consectetur purus sit amet fermentum. Duis mollis.
																		Duis mollis, est non commodo luctus, nisi erat
																		porttitor ligula, eget lacinia odio sem nec elit. Cras
																		mattis consectetur purus sit amet fermentum. Duis
																		mollis.</div>
																</div>
															</div>
														</div>
														<!-- END Portlet PORTLET-->
													</div>
													<div class="col-md-3">
														<div class="row">
															<div class="col-md-12">
																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-primary">
																			<div class="panel-heading tarjetita-heading">
																				Nombre
																			</div>
																			<div class="panel-body tarjetita-body">Empresa</div>
																		</div>
																	</div>
																</div>
																<!-- END Portlet PORTLET-->

																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-info">
																			<div class="panel-heading tarjetita-heading">
																				Formato
																			</div>
																			<div class="panel-body tarjetita-body">Alfanumérico</div>
																		</div>
																	</div>
																</div>
																<!-- END Portlet PORTLET-->

																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-info">
																			<div class="panel-heading tarjetita-heading">
																				Responsable
																			</div>
																			<div class="panel-body tarjetita-body">Contabilidad</div>
																		</div>
																	</div>
																</div>
																<!-- END Portlet PORTLET-->
															</div>
														</div>
													</div>
												</div>
											</div>
											<div id="tab-datos-entidad" class="tab-pane">
																			<div class="row">
													<div class="col-md-9">
														<!-- BEGIN Portlet PORTLET-->
														<div class="row">
															<div class="col-md-12">
																<div class="panel panel-info">
																	<div class="panel-heading tarjetita-heading">M&eacute;todo de obtenci&oacute;n</div>
																	<div class="panel-body tarjetita-body">Duis mollis, est non
																		commodo luctus, nisi erat porttitor ligula, eget
																		lacinia odio sem nec elit. Cras mattis consectetur
																		purus sit amet fermentum. Duis mollis.</div>
																</div>
															</div>
														</div>
														<!-- END Portlet PORTLET-->

														<!-- BEGIN Portlet PORTLET-->
														<div class="row">
															<div class="col-md-12">
																<div class="panel panel-info">
																	<div class="panel-heading tarjetita-heading">Trazabilidad del componente</div>
																	<div class="panel-body tarjetita-body">
																		<div id="jstree-stub">
																			<ul>
																				<li>Root node 1
																					<ul>
																						<li>Child node 1</li>
																						<li><a href="#">Child node 2</a></li>
																					</ul>
																				</li>
																			</ul>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<!-- END Portlet PORTLET-->
													</div>
													<div class="col-md-3">
														<div class="row">
															<div class="col-md-12">
																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-primary">
																			<div class="panel-heading tarjetita-heading">
																				Origen
																			</div>
																			<div class="panel-body tarjetita-body">
																				<p>Sistema: GTC</p>
																				<p>Tipo: Corporativo</p>
																			</div>
																		</div>
																	</div>
																</div>
																<!-- END Portlet PORTLET-->

																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-info">
																			<div class="panel-heading tarjetita-heading">
																				Hist&oacute;rico
																			</div>
																			<div class="panel-body tarjetita-body">5 a&ntilde;os + a&ntilde;o en curso</div>
																		</div>
																	</div>
																</div>
																<!-- END Portlet PORTLET-->

																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-info">
																			<div class="panel-heading tarjetita-heading">
																				Caracte&iacute;sticas de actualizaci&oacute;n 
																			</div>
																			<div class="panel-body tarjetita-body">
																				<p>Periodo: Mensual</p>
																				<p>Tipo: Sustituci&oacute;n blah blah</p>
																			</div>
																		</div>
																	</div>
																</div>
																<!-- END Portlet PORTLET-->
															</div>
														</div>
													</div>
												</div>
											</div>
											<div id="tab-reglas-certificacion" class="tab-pane">
												<a class="fa fa-book" href="#"></a>
												&nbsp;&nbsp;Validacion para saldo fin de mes por empresa y periodo.
											</div>
										</div>
									</div>
								</section>
								<!--tab nav end-->
							</div>
						</div>
					</div>
				</div>
				<!-- END PAGE CONTENT-->
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
	<script class="include" type="text/javascript"
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>
	<!--Easy Pie Chart-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/easypiechart/jquery.easypiechart.js"></script>
	<!--Sparkline Chart-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/sparkline/jquery.sparkline.js"></script>
	<!--jQuery Flot Chart-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.tooltip.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.resize.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.pie.resize.js"></script>

	<!-- switch -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/my-custom-bootstrap-switch.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/toggle-init.js"></script>

	<!--tree-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/fuelux/js/tree.min.js"></script>


	<!--common script init for all pages-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>

	<!--script for this page-->
<!-- 	<script -->
<%-- 		src="${pageContext.servletContext.contextPath}/resources/js/tree.js"></script> --%>

	<!-- Mi script personal -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/my-custom-scripts-diccionario.js"></script>

	<!-- Cookies -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/cookie-master/js.cookie.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.cookie.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.dcjqaccordion.2.7.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.hoverIntent.minified.js"></script>

	<!-- jsTree -->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jstree/jstree.js"></script>

<!-- 	<script> -->
<!--  		jQuery(document).ready(function() { -->
<!--  			TreeView.init(); -->
<!--  		}); -->
<!-- 	</script> -->





</body>
</html>
