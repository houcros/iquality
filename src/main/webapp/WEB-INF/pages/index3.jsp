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
    <!-- Bootstrap slider -->
    <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-slider.min.css" rel="stylesheet"/>
	
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
        		Configuraci&oacute;n
			</header>
            <div class="panel-body">
                <div class="top-stats-panel">
<!--                     <h4 class="widget-h">Detalles de tabla</h4> -->
					<div class="row">
	                    <div class="col-md-3">
		                    <!--widget start-->
	                        <aside class="profile-nav alt">
	                            <section class="panel">
	                                <ul class="nav nav-pills nav-stacked">
	                                    <li><a href="javascript:;">Tabla 1</a></li>
	                                    <li><a href="javascript:;">Tabla 2</a></li>
	                                    <li><a href="javascript:;">Tabla 3</a></li>
	                                    <li><a href="javascript:;">Tabla 4</a></li>
	                                </ul>
	                            </section>
	                        </aside>
	                        <!--widget end-->
	                    </div>
	                    <div class="col-md-9">
		                	<section class="panel">
                    			<div class="panel-body">
                    				<div class="row">
                    					<div class="col-md-4" style="background-color:red">
                    					<aside class="profile-nav alt">
                    						<section class="panel">
	                                			<ul class="nav nav-pills nav-stacked">
				                                    <li><a href="javascript:;">Atributo 1</a></li>
				                                    <li><a href="javascript:;">Atributo 2</a></li>
				                                    <li><a href="javascript:;">Atributo 3</a></li>
				                                    <li><a href="javascript:;">Atributo 4</a></li>
				                                    <li><a href="javascript:;">Atributo 5</a></li>
				                                    <li><a href="javascript:;">Atributo 6</a></li>
				                                    <li><a href="javascript:;">Atributo 7</a></li>
				                                    <li><a href="javascript:;">Atributo 8</a></li>
				                                </ul>
	                           				</section>
	                           			</aside>
	                            		</div>
                    					<div class="col-md-8" style="background-color:green">
                    						<div class="row">
                    							<div class="col-sm-12 slider-box">
                    								<input id="ex1" class="mySlider" data-slider-id='ex1Slider' type="text" data-slider-min="0" data-slider-max="11.25" data-slider-step="1" data-slider-value="6" data-slider-precision="2"/>
                    					    	</div>
                    					    	<div class="col-sm-12 slider-box">
                    					    		<input id="ex2" class="mySlider" data-slider-id='ex2Slider' type="text" data-slider-min="0" data-slider-max="11.25" data-slider-step="1" data-slider-value="6" data-slider-precision="2"/>
                    					    	</div>
                    					    	<div class="col-sm-12 slider-box">
                    					    		<input id="ex3" class="mySlider" data-slider-id='ex3Slider' type="text" data-slider-min="0" data-slider-max="11.25" data-slider-step="1" data-slider-value="6" data-slider-precision="2"/>
                    					    	</div>
                    					    	<div class="col-sm-12 slider-box">
                    					    		<input id="ex4" class="mySlider" data-slider-id='ex4Slider' type="text" data-slider-min="0" data-slider-max="11.25" data-slider-step="1" data-slider-value="6" data-slider-precision="2"/>
                    					    	</div>
                    					    	<div class="col-sm-12 slider-box">
                    					    		<input id="ex5" class="mySlider" data-slider-id='ex5Slider' type="text" data-slider-min="0" data-slider-max="11.25" data-slider-step="1" data-slider-value="6" data-slider-precision="2"/>
                    					    	</div>
                    					    	<div class="col-sm-12 slider-box">
                    					    		<input id="ex6" class="mySlider" data-slider-id='ex6Slider' type="text" data-slider-min="0" data-slider-max="11.25" data-slider-step="1" data-slider-value="6" data-slider-precision="2"/>
                    					    	</div>
                    					    	<div class="col-sm-12 slider-box">
                    					    		<input id="ex7" class="mySlider" data-slider-id='ex7Slider' type="text" data-slider-min="0" data-slider-max="11.25" data-slider-step="1" data-slider-value="6" data-slider-precision="2"/>
                    					    	</div>
                    					    	<div class="col-sm-12 slider-box">
                    					    		<input id="ex8" class="mySlider" data-slider-id='ex8Slider' type="text" data-slider-min="0" data-slider-max="11.25" data-slider-step="1" data-slider-value="6" data-slider-precision="2"/>
                    					    	</div>
                    					    </div>
                    					</div>
                    				</div>
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
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.customSelect.min.js" ></script>
<!--common script init for all pages-->
<script src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>
<!--script for this page-->

<!-- Mi script personal -->
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs-index3.js"></script>

<!-- Cookies -->
<script src="${pageContext.servletContext.contextPath}/resources/js/cookie-master/js.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.hoverIntent.minified.js"></script>

<!-- Linked sliders -->
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.linkedsliders.js"></script>
<!-- Bootstrap slider -->
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-slider.min.js"></script>

</body>
</html>