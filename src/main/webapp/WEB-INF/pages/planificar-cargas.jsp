<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico">

    <title>Pases definidos en el sistema</title>

    <!--Core CSS -->
    <link href="${pageContext.servletContext.contextPath}/resources/bs3/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!--dynamic table-->
    <link href="${pageContext.servletContext.contextPath}/resources/js/advanced-datatable/css/demo_page.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/resources/js/advanced-datatable/css/demo_table.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/js/data-tables/DT_bootstrap.css" />

    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/style-responsive.css" rel="stylesheet" />

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

<section id="container" >
<!--header start-->
<c:import url="/WEB-INF/pages/tags/header.jsp"/>
<!--header end-->

<!--sidebar start -->
<c:import url="/WEB-INF/pages/tags/sidebar.jsp"/>
<!--sidebar end -->

<!--main content start-->
    <section id="main-content">
        <section class="wrapper">
        <!-- page start-->
        
        <div class="row">
            <div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading mi-panel-heading">
								<div class="row">
									<div class="col-md-9">Registro de pases</div>
									<div class="col-md-3">
									</div>
								</div>
							</header>
							<div class="panel-body">
								<div class="adv-table">
								 <div class="clearfix">
                                <div class="btn-group">
                                    <button id="btn-nuevo-pase-def" class="btn btn-primary">
                                        Nuevo <i class="fa fa-plus"></i>
                                    </button>
                                </div>
<!--                                 <div class="btn-group pull-right"> -->
<!--                                     <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">Tools <i class="fa fa-angle-down"></i> -->
<!--                                     </button> -->
<!--                                     <ul class="dropdown-menu pull-right"> -->
<!--                                         <li><a href="#">Print</a></li> -->
<!--                                         <li><a href="#">Save as PDF</a></li> -->
<!--                                         <li><a href="#">Export to Excel</a></li> -->
<!--                                     </ul> -->
<!--                                 </div> -->
                            </div>
                            <div class="space15"></div>
									<table cellpadding="0" cellspacing="0" border="0"
										class="display table table-bordered" id="hidden-table-pases-def">
										<thead>
											<tr>
												<th><div style="width: 20px;"></div></th>
												<th>Sistema</th>
												<th>Software</th>
												<th><div style="width: 50px;">Id pase</div></th>
												<th><div style="width: 90px;">Pase</div></th>
												<th><div style="width: 90px;">Pase at&iacute;pico</div></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allTableItems}" var="item">
												<tr class="gradeA">
													<!-- 					    <tr class="gradeX">       -->
													<!-- 					    <tr class="gradeC">       -->
													<!-- 					    <tr class="gradeU">       -->
													<td class="center">
<%-- 														<a href=${requestScope['javax.servlet.forward.request_uri']}${"/detalle?idMet="}${item.idMetrica}${"&idMes="}${item.idMes}> --%>
														<a href="#">
															<img src="/iQuality/resources/images/details_open.png">
														</a>
													</td>
													<td class="center hidden-phone">${item.sistema}</td>
													<td class="center hidden-phone">${item.software}</td>
													<td class="center hidden-phone">${item.id}</td>
													<td class="center hidden-phone">${item.nombre}</td>
													<td class="center hidden-phone">${item.esAtipico}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

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
<c:import url="/WEB-INF/pages/tags/right-sidebar.jsp"/>
<!--right sidebar end -->

</section>

<!-- Placed js at the end of the document so the pages load faster -->

<!--Core js-->
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/bs3/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>

<!--dynamic table-->
<script type="text/javascript" language="javascript" src="${pageContext.servletContext.contextPath}/resources/js/advanced-datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/data-tables/DT_bootstrap.js"></script>
<!--common script init for all pages-->
<script src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>

<!--dynamic table initialization -->
<script src="${pageContext.servletContext.contextPath}/resources/js/dynamic_table_init.js"></script>

<!-- Mi script personal -->
<script src="${pageContext.servletContext.contextPath}/resources/js/lang-sett-es.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs-pases-def.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs.js"></script>

<!-- Cookies -->
<script src="${pageContext.servletContext.contextPath}/resources/js/cookie-master/js.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.hoverIntent.minified.js"></script>

<!-- URL utility -->
<script src="${pageContext.servletContext.contextPath}/resources/js/URI.js-gh-pages/src/URI.min.js"></script>

</body>
</html>
