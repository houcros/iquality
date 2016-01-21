<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">

    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9">
    <meta http-equiv="X-UA-Compatible" content="IE=9">

    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico" type="image/x-icon">
    <title>iQuality</title>
    <!--Core CSS -->
    <link href="${pageContext.servletContext.contextPath}/resources/bs3/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/jquery-ui/jquery-ui-1.10.1.custom.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/jvector-map/jquery-jvectormap-1.2.2.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/clndr.css" rel="stylesheet">
    <!--clock css-->
    <link href="${pageContext.servletContext.contextPath}/resources/js/css3clock/css/style.css" rel="stylesheet">
    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/js/morris-chart/morris.css">
    <!-- switch -->
	<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-switch.css" />
	<!-- Toggle -->
	<link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-toggle.min.css" rel="stylesheet">
	<!--icheck-->
	<link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/minimal.css" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/style-responsive.css" rel="stylesheet"/>
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
<!-- header start -->
<c:import url="/WEB-INF/pages/tags/header.jsp"/>
<!-- header end -->
<!-- sidebar start -->
<c:import url="/WEB-INF/pages/tags/sidebar.jsp"/>
<!-- sidebar end -->

<!--main content start-->
		<section id="main-content">
			<section class="wrapper">

				<!--mini statistics start-->
				<div class="row row-eq-height">
					<div class="col-sm-12 col-md-3">
						<div class="row">
						<div class="col-sm-6 col-md-12">
							<section class="panel">
								<div class="panel-body">
									<div class="daily-visit">
										<h4 class="widget-h">Calidad de datos</h4>
										<!--                    <li class="pull-left visit-chart-value">3233</li> -->
										<div>
											<h2 class="text-primary center">
												<i class="fa fa-arrow-up"></i>1.2%
											</h2>
											<!--                    	<div id="daily-visit-chart" style="width:100%; height: 100px; display: block"></div> -->
											<p>Respecto al mes anterior</p>
										</div>
										<span class="pull-right"><a href="#myModal"
											data-toggle="modal"><i class="fa fa-info-circle"></i></a></span>
										<div id="myModal" class="modal fade" tabindex="-1"
											role="dialog" aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title">M&eacute;todo de
															c&aacute;lculo</h4>
													</div>
													<div class="modal-body">
														<p>Lorem ipsum dolor sit amet, consectetur adipiscing
															elit. Stoici scilicet. Quis Aristidem non mortuum
															diligit? In schola desinis. Stoicos roga. Quo igitur,
															inquit, modo? Quam ob rem tandem, inquit, non satisfacit?
															Quaerimus enim finem bonorum. Quid Zeno? Quid iudicant
															sensus? Conferam tecum, quam cuique verso rem subicias;
															Ille incendat? Sint ista Graecorum;</p>
														<span class="m-y-1"><img
															src="https://latex.codecogs.com/gif.latex?\displaystyle\sum_{i=1}^{n}&space;c_i&space;\times&space;p_i"
															title="\displaystyle\sum_{i=1}^{n} c_i \times p_i" /></span>
														<p>Si enim ad populum me vocas, eum. Iam in altera
															philosophiae parte. Istam voluptatem, inquit, Epicurus
															ignorat? Duo Reges: constructio interrete. Is es profecto
															tu. Quo tandem modo? Nescio quo modo praetervolavit
															oratio. Quid enim? Haeret in salebra. Videsne quam sit
															magna dissensio? Non laboro, inquit, de nomine. Cur id
															non ita fit? Hoc est non dividere, sed frangere.</p>
														<span class="m-y-1"><img
															src="https://latex.codecogs.com/gif.latex?\frac{n!}{k!(n-k)!}&space;=&space;\binom{n}{k}"
															title="\frac{n!}{k!(n-k)!} = \binom{n}{k}" /></span>
														<p>Si enim ad populum me vocas, eum. Iam in altera
															philosophiae parte. Istam voluptatem, inquit, Epicurus
															ignorat? Duo Reges: constructio interrete. Is es profecto
															tu. Quo tandem modo? Nescio quo modo praetervolavit
															oratio. Quid enim? Haeret in salebra. Videsne quam sit
															magna dissensio? Non laboro, inquit, de nomine. Cur id
															non ita fit? Hoc est non dividere, sed frangere.</p>
													</div>
													<div class="modal-footer">
														<!--                                     	<span>iQuality</span> -->
														<button class="btn btn-default" data-dismiss="modal"
															aria-hidden="true">Cerrar</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</section>
						</div>
						<div class="col-sm-6 col-md-12">
							<section class="panel">
								<div class="panel-body">
									<div class="top-stats-panel">
										<h4 class="widget-h">Ejecuciones</h4>
										<div class="sm-pie"></div>
									</div>
								</div>
							</section>
						</div>
					</div>
					</div>
					<div class="col-sm-12 col-md-9">
								<!--earning graph start-->
								<section class="panel">
									<!--             <header class="panel-heading">Evoluci&oacute;n de la calidad de las reglas</header> -->
									<div class="panel-body">
										<div class="top-stats-panel">
											<h4 class="widget-h">Evoluci&oacute;n de la calidad</h4>
											<!--                 	<div id="graph-area" class="main-chart"> -->
											<div class="col-sm-10 p-r-0">
												<div id="morris-line" class="main-chart"></div>
											</div>
											<div class="col-sm-2 p-l-1">
												<div class="form-group">
													<label class="col-sm-12 control-label">Par&aacute;metros</label>

													<div class="col-sm-12 icheck minimal myicheck p-x-0">
														<div class="checkbox single-row">
															<input id="check-dimA" type="checkbox"
																class="my-checkbox-dim m-r-0" checked> <label
																class="p-l-0">Integridad</label>
														</div>
														<div class="checkbox single-row">
															<input id="check-dimB" type="checkbox"
																class="my-checkbox-dim m-r-0" checked> <label
																class="p-l-0 m-l-0">Completitud</label>
														</div>
														<div class="checkbox single-row">
															<input id="check-dimC" type="checkbox"
																class="my-checkbox-dim m-r-0" checked> <label
																class="p-l-0">Duplicidad</label>
														</div>
														<div class="checkbox single-row">
															<input id="check-dimD" type="checkbox"
																class="my-checkbox-dim m-r-0" checked> <label
																class="p-l-0">Conformidad</label>
														</div>
														<div class="checkbox single-row">
															<input id="check-dimE" type="checkbox"
																class="my-checkbox-dim m-r-0" checked> <label
																class="p-l-0">Precisi&oacute;n</label>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</section>
								<!--earning graph end-->
							</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<section class="panel">
								<header class="panel-heading"> Entidades </header>
								<div class="panel-body">
									<div class="row">
									<div class="col-md-4">
											<table class="table table-hover general-table" style="table-layout: fixed;">
												<tbody>
													<tr>
														<td style="width: 22px;">
															<a href="tabla-entidad">
																<img src="/iQuality/resources/images/details_open.png">
															</a>
														</td>
														<td style="width: 10px;" class="random-change"><a href="javascript:;">Empresa</a></td>
														<td style="width: 10px;"><span
															class="sparkline pull-left"></span></td>
														<td style="width: 10px;"><span
																class="badge label-info r-activity m-x-1">72%</span></td>
													</tr>
													<tr>
														<td style="width: 22px;">
															<a href="tabla-entidad">
																<img src="/iQuality/resources/images/details_open.png">
															</a>
														</td>
														<td style="width: 10px;" class="random-change"><a href="javascript:;">Cliente</a></td>
														<td style="width: 10px;"><span
															class="sparkline pull-left"></span></td>
														<td style="width: 10px;"><span
																class="badge label-warning r-activity m-x-1">67%</span></td>
													</tr>
													<tr>
														<td style="width: 22px;">
															<a href="tabla-entidad">
																<img src="/iQuality/resources/images/details_open.png">
															</a>
														</td>
														<td style="width: 10px;" class="random-change"><a href="javascript:;">Saldo</a></td>
														<td style="width: 10px;"><span
															class="sparkline pull-left"></span></td>
														<td style="width: 10px;"><span
																class="badge label-danger r-activity m-x-1">34%</span></td>
													</tr>
													<tr>
														<td style="width: 22px;" class="random-change">
															<a href="tabla-entidad">
																<img src="/iQuality/resources/images/details_open.png">
															</a>
														</td>
														<td style="width: 10px;" class="random-change"><a href="javascript:;">Capital</a></td>
														<td style="width: 10px;"><span
															class="sparkline pull-left"></span></td>
														<td style="width: 10px;"><span
																class="badge label-success r-activity m-x-1">89%</span></td>
													</tr>
													<tr>
														<td style="width: 22px;">
															<a href="tabla-entidad">
																<img src="/iQuality/resources/images/details_open.png">
															</a>
														</td>
														<td style="width: 10px;" class="random-change"><a href="javascript:;">Contabilidad</a></td>
														<td style="width: 10px;"><span
															class="sparkline pull-left"></span></td>
														<td style="width: 10px;"><span
																class="badge label-success r-activity m-x-1">86%</span></td>
													</tr>
												</tbody>
											</table>

										</div>
									<div class="col-md-8">
										<div class="container">
											<div class="row">
												<div class="col-md-2">
													<div class="form-group text-center">
														<input
															id="dial-dimA" type="text" value="75" class="dial"
															name="dial-dimA">
														<p style="font-weight:700;">Integridad</p>
													</div>
												</div>
												<div class="col-md-2">
													<div class="form-group text-center">
														<input
															id="dial-dimB" type="text" value="97" class="dial"
															name="dial-dimB">
														<p style="font-weight:700;">Completitud</p>	
													</div>
												</div>
												<div class="col-md-2">
													<div class="form-group text-center">
														<input
															id="dial-dimC" type="text" value="64" class="dial"
															name="dial-dimC">
														<p style="font-weight:700;">Duplicidad</p>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col-md-3">
													<div class="form-group text-center">
														<input
															id="dial-dimD" type="text" value="84" class="dial"
															name="dial-dimD">
														<p style="font-weight:700;">Conformidad</p>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group text-center">
														<input
															id="dial-dimE" type="text" value="90" class="dial"
															name="dial-dimE">
														<p style="font-weight:700;">Precisi&oacute;n</p>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							</section>
						</div>
					</div>
				<!--mini statistics end-->
			</section>
		</section>
		<!--main content end-->

<!--right sidebar start -->
<c:import url="/WEB-INF/pages/tags/right-sidebar.jsp"/>
<!--right sidebar end -->


</section>
<!-- Placed js at the end of the document so the pages load faster -->
<!--Core js-->
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui/jquery-ui-1.10.1.custom.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/bs3/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="${pageContext.servletContext.contextPath}/resources/js/skycons/skycons.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo/jquery.scrollTo.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/calendar/clndr.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/calendar/moment-2.2.1.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/evnt.calendar.init.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jvector-map/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jvector-map/jquery-jvectormap-us-lcc-en.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/gauge/gauge.js"></script>
<!--clock init-->
<script src="${pageContext.servletContext.contextPath}/resources/js/css3clock/js/css3clock.js"></script>
<!--Easy Pie Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/easypiechart/jquery.easypiechart.js"></script>
<!--Sparkline Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/sparkline/jquery.sparkline.js"></script>
<!--Morris Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/morris-chart/morris.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/morris-chart/raphael-min.js"></script>
<!--jQuery Flot Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.tooltip.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.resize.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.pie.resize.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.animator.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.growraf.js"></script>
<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/dashboard.js"></script> --%>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.customSelect.min.js" ></script>
<!--common script init for all pages-->
<script src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>
<!--script for this page-->

<!-- Mi script personal -->
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs-index.js"></script>

<!-- Cookies -->
<script src="${pageContext.servletContext.contextPath}/resources/js/cookie-master/js.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.hoverIntent.minified.js"></script>

<!-- Toggle -->
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<!-- icheck -->
<script src="${pageContext.servletContext.contextPath}/resources/js/iCheck/jquery.icheck.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/ckeditor/ckeditor.js"></script>
<!--icheck init -->
<script src="${pageContext.servletContext.contextPath}/resources/js/icheck-init.js"></script>
<!-- Knob -->
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.knob.min.js"></script>

</body>
</html>