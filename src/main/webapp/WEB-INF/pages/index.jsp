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
<div class="row">
<div class="col-md-3">
    <div class="col-md-12">
        <section class="panel">
            <div class="panel-body">
                    <div class="daily-visit">
                        <h4 class="widget-h">Calidad de datos</h4>
<!--                    <li class="pull-left visit-chart-value">3233</li> -->
						<div>
                        	<h2 class="text-primary center"><i class="fa fa-arrow-up"></i>1.2%</h2>
<!--                    	<div id="daily-visit-chart" style="width:100%; height: 100px; display: block"></div> -->
                        	<p>Respecto al mes anterior</p>
                        </div>
                        <span class="pull-right"><a href="#myModal" data-toggle="modal"><i class="fa fa-info-circle"></i></a></span>
                        <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">M&eacute;todo de c&aacute;lculo</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Stoici scilicet. Quis Aristidem non mortuum diligit?
										In schola desinis. Stoicos roga. Quo igitur, inquit, modo? Quam ob rem tandem, inquit, non satisfacit? Quaerimus enim finem bonorum.
										Quid Zeno? Quid iudicant sensus? Conferam tecum, quam cuique verso rem subicias; Ille incendat? Sint ista Graecorum;</p>
										<span class="m-y-1"><img src="https://latex.codecogs.com/gif.latex?\displaystyle\sum_{i=1}^{n}&space;c_i&space;\times&space;p_i" title="\displaystyle\sum_{i=1}^{n} c_i \times p_i" /></span>
										<p>Si enim ad populum me vocas, eum. Iam in altera philosophiae parte. Istam voluptatem, inquit, Epicurus ignorat? Duo Reges: constructio interrete. Is es profecto tu. Quo tandem modo?
										Nescio quo modo praetervolavit oratio. Quid enim? Haeret in salebra. Videsne quam sit magna dissensio? Non laboro, inquit, de nomine. Cur id non ita fit? Hoc est non dividere, sed frangere.</p>
										<span class="m-y-1"><img src="https://latex.codecogs.com/gif.latex?\frac{n!}{k!(n-k)!}&space;=&space;\binom{n}{k}" title="\frac{n!}{k!(n-k)!} = \binom{n}{k}" /></span>
										<p>Si enim ad populum me vocas, eum. Iam in altera philosophiae parte. Istam voluptatem, inquit, Epicurus ignorat? Duo Reges: constructio interrete. Is es profecto tu. Quo tandem modo?
										Nescio quo modo praetervolavit oratio. Quid enim? Haeret in salebra. Videsne quam sit magna dissensio? Non laboro, inquit, de nomine. Cur id non ita fit? Hoc est non dividere, sed frangere.</p>
                                    </div>
                                    <div class="modal-footer">
<!--                                     	<span>iQuality</span> -->
                                        <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cerrar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </section>
    </div>
    <div class="col-md-12">
        <section class="panel">
            <div class="panel-body">
                <div class="top-stats-panel">
                    <h4 class="widget-h">Ejecuciones</h4>
                    <div class="sm-pie">
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<div class="col-md-9">
<div class="row">
    <div class="col-md-12">
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
															<input id="check-dimA" type="checkbox" class="my-checkbox-dim m-r-0" checked>
															<label class="p-l-0">Integridad</label>
														</div>
														<div class="checkbox single-row">
															<input id="check-dimB" type="checkbox" class="my-checkbox-dim m-r-0" checked>
															<label class="p-l-0 m-l-0">Completitud</label>
														</div>
														<div class="checkbox single-row">
															<input id="check-dimC" type="checkbox" class="my-checkbox-dim m-r-0" checked>
															<label class="p-l-0">Duplicidad</label>
														</div>
														<div class="checkbox single-row">
															<input id="check-dimD" type="checkbox" class="my-checkbox-dim m-r-0" checked>
															<label class="p-l-0">Conformidad</label>
														</div>
														<div class="checkbox single-row">
															<input id="check-dimE" type="checkbox" class="my-checkbox-dim m-r-0" checked>
															<label class="p-l-0">Precisi&oacute;n</label>
														</div>
													</div>
												</div>
											</div>
										</div>
										<!--                 <div class="col-sm-2"> -->
											
<!-- 										</div> -->
            </div>
        </section>
        <!--earning graph end-->
    </div>
</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1">
        <section class="panel">
        	<header class="panel-heading">
                Entidades
            </header>
            <div class="panel-body">
            	<div class="row">
	                    <div class="col-md-4">
	                    	
	                    	<table class="table  table-hover general-table">
						                            <tbody>
						                            <tr>
	                                    				<td style="width:1em"><a href="tabla-entidad"><span class="badge label-success pull-left r-activity m-x-1">80%</span></a></td>
						                                <td style="width:6em"><a href="tabla-entidad">Tabla 1</a></td>
						                              	<td style="width:8em"><span class="sparkline pull-left"></span></td>
						                            </tr>
						                            <tr>
						                                <td style="width:1em"><a href="tabla-entidad"><span class="badge label-success pull-left r-activity m-x-1">80%</span></a></td>
						                                <td style="width:6em"><a href="tabla-entidad">Tabla 2</a></td>
						                              	<td style="width:8em"><span class="sparkline pull-left"></span></td>
						                            </tr>
						                            <tr>
						                            	<td style="width:1em"><a href="tabla-entidad"><span class="badge label-success pull-left r-activity m-x-1">80%</span></a></td>
						                                <td style="width:6em"><a href="tabla-entidad">Tabla 3</a></td>
						                              	<td style="width:8em"><span class="sparkline pull-left"></span></td>
						                            </tr>
						                            <tr>
						                            	<td style="width:1em"><a href="#"><span class="badge label-success pull-left r-activity m-x-1">80%</span></a></td>
						                                <td style="width:6em"><a href="#">Tabla 4</a></td>
						                              	<td style="width:8em"><span class="sparkline pull-left"></span></td>
						                            </tr>
						                            <tr>
						                            	<td style="width:1em"><a href="#"><span class="badge label-success pull-left r-activity m-x-1">80%</span></a></td>
						                                <td style="width:6em"><a href="#">Tabla 5</a></td>
						                              	<td style="width:8em"><span class="sparkline pull-left"></span></td>
						                            </tr>
						                          </tbody>
						                       	</table>
	                    	
	                    <!-- 
		                    widget start
	                        <aside class="profile-nav alt">
	                            <section class="panel">
	                                <ul class="nav nav-pills nav-stacked">
	                                    <li>
	                                    	<div class="row">
	                                    		<div class="col-md-8">
	                                    			<a href="tabla-entidad">Tabla 1<span class="badge label-success pull-left r-activity m-x-1">80%</span></a>
	                                    		</div>
	                                    		<div class="col-md-4">
	                                    			<span class="sparkline pull-left"></span>
	                                    		</div>
	                                    	</div>
	                                    </li>
	                                    <li>
		                                    <div class="row">
		                                    	<div class="col-md-8">
		                                    		<a href="tabla-entidad">Tabla 2<span class="badge label-danger pull-left r-activity m-x-1">15%</span></a>
		                                    	</div>
		                                    	<div class="col-md-4">
		                                    		<span class="sparkline pull-left"></span>
		                                    	</div>
		                                    </div>
	                                    </li>
	                                    <li>
	                                    	<div class="row">
		                                    	<div class="col-md-8">
		                                    		<a href="tabla-entidad">Tabla 3<span class="badge label-success pull-left r-activity m-x-1">89%</span></a>
		                                    	</div>
		                                    	<div class="col-md-4">
		                                    		<span class="sparkline pull-left"></span>
		                                    	</div>
		                                    </div>
	                                    </li>
	                                    <li>
	                                    	<div class="row">
		                                    	<div class="col-md-8">
		                                    		<a href="tabla-entidad">Tabla 4<span class="badge label-warning pull-left r-activity m-x-1">62%</span></a></a>
		                                    	</div>
		                                    	<div class="col-md-4">
		                                    		<span class="sparkline pull-left"></span>
		                                    	</div>
		                                    </div>
	                                    </li>
	                                </ul>
	
	                            </section>
	                        </aside>
	                        widget end
	                         -->
	                    </div>
	                    <div class="col-md-8">
	                    <div class="row">
		                    <div class="col-md-9">
<!-- 		                    	<div id="morris-line"></div> -->
		                    </div>
	                    </div>
	                    </div>
                    </div>
            
            
            
            <!-- 
				<div class="col-md-4">
					<div class="row">
    					<div class="col-md-6 tabla-enditad">
       						<div class="mini-stat clearfix" style="background-color:#ffdf7c;">
            					<div class="mini-stat-info">
               						<a href="tabla-entidad"><span>88%</span> Tabla 1</a>
                					<div class="sparkline" data-type="line" data-resize="true" data-height="35%" data-width="90%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="#C390D4" data-spot-color="#C390D4" data-fill-color="" data-highlight-line-color="#4694E8" data-highlight-spot-color="#e1b8ff" data-spot-radius="1" data-data="[100,200,459,234,600,800,345,987,675,457,765]">
                					</div>
            					</div>
        					</div>
    					</div>
    					<div class="col-md-6 tabla-enditad">
        					<div class="mini-stat clearfix" style="background-color:#ffdf7c;">
            					<div class="mini-stat-info">
                					<a href="tabla-entidad"><span>75%</span> Tabla 2</a>
                					<div class="sparkline" data-type="line" data-resize="true" data-height="35%" data-width="90%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="#C390D4" data-spot-color="#C390D4" data-fill-color="" data-highlight-line-color="#4694E8" data-highlight-spot-color="#e1b8ff" data-spot-radius="1" data-data="[100,200,459,234,600,800,345,987,675,457,765]">
                					</div>
            					</div>
        					</div>
    					</div>
					</div>
					<div class="row">
    					<div class="col-md-6 tabla-enditad">
       						<div class="mini-stat clearfix" style="background-color:#ffdf7c;">
            					<div class="mini-stat-info">
               						<a href="tabla-entidad"><span>55%</span> Tabla 3</a>
                					<div class="sparkline" data-type="line" data-resize="true" data-height="35%" data-width="90%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="#C390D4" data-spot-color="#C390D4" data-fill-color="" data-highlight-line-color="#4694E8" data-highlight-spot-color="#e1b8ff" data-spot-radius="1" data-data="[100,200,459,234,600,800,345,987,675,457,765]">
                					</div>
            					</div>
        					</div>
    					</div>
    					<div class="col-md-6 tabla-enditad">
        					<div class="mini-stat clearfix" style="background-color:#ffdf7c;">
            					<div class="mini-stat-info">
                					<a href="tabla-entidad"><span>100%</span> Tabla 4</a>
                					<div class="sparkline" data-type="line" data-resize="true" data-height="35%" data-width="90%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="#C390D4" data-spot-color="#C390D4" data-fill-color="" data-highlight-line-color="#4694E8" data-highlight-spot-color="#e1b8ff" data-spot-radius="1" data-data="[100,200,459,234,600,800,345,987,675,457,765]">
                					</div>
            					</div>
        					</div>
    					</div>
					</div>
				</div>
				<div class="col-md-8">
                	<div class="sparkline" data-type="line" data-resize="true" data-height="70%" data-width="90%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="#C390D4" data-spot-color="#C390D4" data-fill-color="" data-highlight-line-color="#4694E8" data-highlight-spot-color="#e1b8ff" data-spot-radius="3" data-data="[100,200,459,234,600,800,345,987,675,457,765]">
                	</div>
            	</div>
            	 -->
            </div>
        </section>
   </div>
</div>
<!-- <div class="row"> -->
<!--     <div class="col-md-4"> -->
<!--         widget graph start -->
<!--         <section class="panel"> -->
<!--             <div class="panel-body"> -->
<!--                 <div class="monthly-stats pink"> -->
<!--                     <div class="clearfix"> -->
<!--                         <h4 class="pull-left"> January 2013</h4> -->
<!--                         Nav tabs -->
<!--                         <div class="btn-group pull-right stat-tab"> -->
<!--                             <a href="#line-chart" class="btn stat-btn active" data-toggle="tab"><i class="ico-stats"></i></a> -->
<!--                             <a href="#bar-chart" class="btn stat-btn" data-toggle="tab"><i class="ico-bars"></i></a> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     Tab panes -->
<!--                     <div class="tab-content"> -->
<!--                         <div class="tab-pane active" id="line-chart"> -->
<!--                             <div class="sparkline" data-type="line" data-resize="true" data-height="75" data-width="90%" data-line-width="1" data-min-spot-color="false" data-max-spot-color="false" data-line-color="#ffffff" data-spot-color="#ffffff" data-fill-color="" data-highlight-line-color="#ffffff" data-highlight-spot-color="#e1b8ff" data-spot-radius="3" data-data="[100,200,459,234,600,800,345,987,675,457,765]"> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         <div class="tab-pane" id="bar-chart"> -->
<!--                             <div class="sparkline" data-type="bar" data-resize="true" data-height="75" data-width="90%" data-bar-color="#d4a7f5" data-bar-width="10" data-data="[300,200,500,700,654,987,457,300,876,454,788,300,200,500,700,654,987,457,300,876,454,788]"></div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="circle-sat"> -->
<!--                     <ul> -->
<!--                         <li class="left-stat-label"><span class="sell-percent">60%</span><span>Direct Sell</span></li> -->
<!--                         <li><span class="epie-chart" data-percent="45"> -->
<!--                         <span class="percent"></span> -->
<!--                         </span></li> -->
<!--                         <li class="right-stat-label"><span class="sell-percent">40%</span><span>Channel Sell</span></li> -->
<!--                     </ul> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </section> -->
<!--         widget graph end -->
<!--         widget graph start -->
<!--         <section class="panel"> -->
<!--             <div class="panel-body"> -->
<!--                 <ul class="clearfix prospective-spark-bar"> -->
<!--                     <li class="pull-left spark-bar-label"> -->
<!--                         <span class="bar-label-value"> $18887</span> -->
<!--                         <span>Prospective Label</span> -->
<!--                     </li> -->
<!--                     <li class="pull-right"> -->
<!--                         <div class="sparkline" data-type="bar" data-resize="true" data-height="40" data-width="90%" data-bar-color="#f6b0ae" data-bar-width="5" data-data="[300,200,500,700,654,987,457,300,876,454,788,300,200,500,700,654,987,457,300,876,454,788]"></div> -->
<!--                     </li> -->
<!--                 </ul> -->
<!--             </div> -->
<!--         </section> -->
<!--     </div> -->
<!-- </div> -->
</div>
<!--mini statistics end-->

<!--mini statistics start-->
<!--
<div class="row">
    <div class="col-md-3">
        <div class="mini-stat clearfix">
            <span class="mini-stat-icon orange"><i class="fa fa-gavel"></i></span>
            <div class="mini-stat-info">
                <span>320</span>
                New Order Received
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="mini-stat clearfix">
            <span class="mini-stat-icon tar"><i class="fa fa-tag"></i></span>
            <div class="mini-stat-info">
                <span>22,450</span>
                Copy Sold Today
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="mini-stat clearfix">
            <span class="mini-stat-icon pink"><i class="fa fa-money"></i></span>
            <div class="mini-stat-info">
                <span>34,320</span>
                Dollar Profit Today
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="mini-stat clearfix">
            <span class="mini-stat-icon green"><i class="fa fa-eye"></i></span>
            <div class="mini-stat-info">
                <span>32720</span>
                Unique Visitors
            </div>
        </div>
    </div>
</div>
-->
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

</body>
</html>