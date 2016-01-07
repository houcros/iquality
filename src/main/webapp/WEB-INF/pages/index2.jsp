<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">

    <meta http-equiv=”X-UA-Compatible” content=”IE=EmulateIE9”>
    <meta http-equiv=”X-UA-Compatible” content=”IE=9”>

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
<div class="row">
    <div class="col-md-12">
        <section class="panel">
        	<header class="panel-heading">
        		Detalles de tabla
								<div class="btn-group pull-right">
									<a
										href="dashboard-settings">
										<button id="btn-nuevo-pase-def" class="btn btn-primary">
											Administrar <i class="fa fa-cog"></i>
										</button>
									</a>
								</div>
			</header>
            <div class="panel-body">
                <div class="top-stats-panel">
<!--                     <h4 class="widget-h">Detalles de tabla</h4> -->
					<div class="row">
	                    <div class="col-md-4">
		                    <!--widget start-->
	                        <aside class="profile-nav alt">
	                            <section class="panel">
	                                <div class="user-heading alt gray-bg">
	                                    <h1>Tabla X</h1>
	<!--                                     <p>Descripcion</p> -->
	                                </div>
	
	                                <ul class="nav nav-pills nav-stacked">
	                                    <li><a href="javascript:;">Atributo 1<span class="badge label-success pull-right r-activity">80%</span></a></li>
	                                    <li><a href="javascript:;">Atributo 2<span class="badge label-danger pull-right r-activity">15%</span></a></li>
	                                    <li><a href="javascript:;">Atributo 3<span class="badge label-success pull-right r-activity">89%</span></a></li>
	                                    <li><a href="javascript:;">Atributo 4<span class="badge label-warning pull-right r-activity">62%</span></a></li>
	                                </ul>
	
	                            </section>
	                        </aside>
	                        <!--widget end-->
	                    </div>
	                    <div class="col-md-8 vcenter">
		                                    <section class="panel">
                    <div class="panel-body">
                        <table class="table  table-hover general-table">
                            <thead>
                            <tr>
                                <th>Regla</th>
                                <th class="hidden-phone">Descripci&oacute;n</th>
                                <th>Peso (%)</th>
                                <th>Evoluci&oacute;n</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><a href="#">REG1</a></td>
                                <td class="hidden-phone">Lorem Ipsum dorolo imit</td>
                                <td><span class="label label-info label-mini">06</span></td>
                                <td>
									<div class="sparkline" data-type="line" data-resize="true" data-height="2.5rem" data-width="45%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="blue" data-spot-color="blue" data-fill-color="" data-highlight-line-color="#ffffff" data-highlight-spot-color="#e1b8ff" data-spot-radius="1.5" data-data="[100,200,459,234,200,210,145,187,175,257,165]"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="#">REG2</a>
                                </td>
                                <td class="hidden-phone">Lorem Ipsum dorolo</td>
                                <td><span class="label label-warning label-mini">12</span></td>
                                <td>
									<div class="sparkline" data-type="line" data-resize="true" data-height="2.5rem" data-width="45%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="blue" data-spot-color="blue" data-fill-color="" data-highlight-line-color="#ffffff" data-highlight-spot-color="#e1b8ff" data-spot-radius="1.5" data-data="[300,100,259,234,600,800,345,487,275,557,733]"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="#">REG3</a>
                                </td>
                                <td class="hidden-phone">Lorem Ipsum dorolo</td>
                                <td><span class="label label-success label-mini">22</span></td>
                                <td>
                                	<div class="sparkline" data-type="line" data-resize="true" data-height="2.5rem" data-width="45%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="blue" data-spot-color="blue" data-fill-color="" data-highlight-line-color="#ffffff" data-highlight-spot-color="#e1b8ff" data-spot-radius="1.5" data-data="[50,70,54,234,600,234,345,789,576,754,567]"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="#">REG4</a>
                                </td>
                                <td class="hidden-phone">Lorem Ipsum dorolo</td>
                                <td><span class="label label-danger label-mini">20</span></td>
                                <td>
                                   <div class="sparkline" data-type="line" data-resize="true" data-height="2.5rem" data-width="45%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="blue" data-spot-color="blue" data-fill-color="" data-highlight-line-color="#ffffff" data-highlight-spot-color="#e1b8ff" data-spot-radius="1.5" data-data="[100,200,459,234,600,800,345,987,675,457,765]"></div>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#">REG5</a></td>
                                <td class="hidden-phone">Lorem Ipsum dorolo imit</td>
                                <td><span class="label label-primary label-mini">03</span></td>
                                <td>
                                   <div class="sparkline" data-type="line" data-resize="true" data-height="2.5rem" data-width="45%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="blue" data-spot-color="blue" data-fill-color="" data-highlight-line-color="#ffffff" data-highlight-spot-color="#e1b8ff" data-spot-radius="1.5" data-data="[50,20,45,23,60,55,35,47,75,45,35]"></div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="#">REG6</a>
                                </td>
                                <td class="hidden-phone">Lorem Ipsum dorolo</td>
                                <td><span class="label label-warning label-mini">27</span></td>
                                <td>
                                	<div class="sparkline" data-type="line" data-resize="true" data-height="2.5rem" data-width="45%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="blue" data-spot-color="blue" data-fill-color="" data-highlight-line-color="#ffffff" data-highlight-spot-color="#e1b8ff" data-spot-radius="1.5" data-data="[67,40,45,34,78,99,124,356,566,433,400]"></div>
                                </td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </section>
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
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs-index2.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.customSelect.min.js" ></script>
<!--common script init for all pages-->
<script src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>
<!--script for this page-->

<!-- Mi script personal -->
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs.js"></script>

<!-- Cookies -->
<script src="${pageContext.servletContext.contextPath}/resources/js/cookie-master/js.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.hoverIntent.minified.js"></script>



</body>
</html>