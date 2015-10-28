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
					<div class="col-md-6">
						<div class="panel">
							<div class="panel-heading">
								Explorador de indicadores 
								<span class="tools pull-right">
									<button id="update-dictionary-button" type="button" class="btn btn-info">
										<i class="fa fa-refresh"></i>
										" Recargar diccionario"
									</button>
									<a class="fa fa-chevron-down" href="javascript:;"></a>
									<a class="fa fa-cog" href="javascript:;"></a>
								</span>
							</div>
							<div class="panel-body">
								<div id="FlatTree1" class="tree tree-solid-line">
									<div class="tree-folder" style="display: none;">
										<div class="tree-folder-header">
											<i class="fa fa-folder"></i>
											<div class="tree-folder-name"></div>
										</div>
										<div class="tree-folder-content"></div>
										<div class="tree-loader" style="display: none"></div>
									</div>
									<div class="tree-item" style="display: none;">
										<i class="tree-dot"></i>
										<div class="tree-item-name"></div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="column">
					<div class="col-md-6">
						<div class="panel">
							<div class="panel-heading">
								Ficha de definici&oacute;n <span class="tools pull-right">
									<a class="fa fa-chevron-down" href="javascript:;"></a>
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
									<div class="panel-body">
										<div class="tab-content">
											<div id="tab-datos-basicos" class="tab-pane active">
												<!-- page start-->

												<div class="row">
													<div class="col-sm-12">
														<div class="row-fluid" id="draggable_portlets">
															<div class="col-md-6 column sortable">
																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-primary">
																			<div class="panel-heading tarjeta">
																				Nombre <span class="tools pull-right"> <a
																					class="fa fa-chevron-down" href="javascript:;"></a>
																				</span>
																			</div>
																			<div class="panel-body">Empresa</div>
																		</div>

																	</div>
																</div>
																<!-- END Portlet PORTLET-->
																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-info">
																			<div class="panel-heading">
																				Responsable <span class="tools pull-right"> <a
																					class="fa fa-chevron-down" href="javascript:;"></a>
																				</span>
																			</div>
																			<div class="panel-body">Contabilidad</div>
																		</div>

																	</div>
																</div>
															</div>
															<div class="col-md-6 column sortable">
																<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-info">
																			<div class="panel-heading">
																				Definici&oacute;n <span class="tools pull-right">
																					<a class="fa fa-chevron-down" href="javascript:;"></a>
																				</span>
																			</div>
																			<div class="panel-body">Duis mollis, est non
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
																			<div class="panel-heading">
																				Formato <span class="tools pull-right"> <a
																					class="fa fa-chevron-down" href="javascript:;"></a>
																				</span>
																			</div>
																			<div class="panel-body">Alfanumérico</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="row-fluid" id="draggable_portlets">
															<div class="col-md-12 column sortable">
															<!-- BEGIN Portlet PORTLET-->
																<div class="row">
																	<div class="col-md-12">
																		<div class="panel panel-info">
																			<div class="panel-heading">
																				Comentarios <span class="tools pull-right"> <a
																					class="fa fa-chevron-down" href="javascript:;"></a>
																				</span>
																			</div>
																			<div class="panel-body">Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.
                                        Cras mattis consectetur purus sit amet fermentum. Duis mollis.
                                        Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.
                                        Cras mattis consectetur purus sit amet fermentum. Duis mollis. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.
                                        Cras mattis consectetur purus sit amet fermentum. Duis mollis.</div>
																		</div>

																	</div>
																</div>
																<!-- END Portlet PORTLET-->
															</div>
														</div>
													</div>
												</div>
											</div>
											<div id="tab-datos-entidad" class="tab-pane">AboutAboutAboutAboutAboutAboutAboutAboutAboutAbout</div>
											<div id="tab-reglas-certificacion" class="tab-pane">ProfileProfileProfileProfileProfileProfileProfileProfile</div>
										</div>
									</div>
								</section>
								<!--tab nav end-->
							</div>
						</div>
					</div>
				</div>
				<!-- Mi JSON tree oculto -->
				<div class="column">
					<div class="col-md-12">
						<p>${jsonTree}</p>
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


	<!--tree-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/fuelux/js/tree.min.js"></script>


	<!--common script init for all pages-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>

	<!--script for this page-->
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/tree.js"></script>

	<!-- Mi script personal -->
	<script src="${pageContext.servletContext.contextPath}/resources/js/my-custom-scripts-diccionario.js"></script>
	
	<script>
		jQuery(document).ready(function() {
			TreeView.init();
		});
	</script>





</body>
</html>
