<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico">

    <title>Detalle de una certificaci&oacute;n de negocio</title>

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
					<div class="col-md-12">
						<div class="panel" id="datos-basicos-certificacion-detalle">
							<div class="panel-heading mi-panel-heading">Datos
								b&aacute;sicos</div>
							<div class="panel-body">
								<div class="">
									<p id="dBas-cert-det-1"><b>Fecha:</b></p>
									<p id="dBas-cert-det-2"><b>Indicador:</b></p>
									<p id="dBas-cert-det-3"><b>Certificaci&oacute;n:</b></p>
									<p id="dBas-cert-det-4"><b>M&eacute;trica evaluada:</b></p>
								</div>
							</div>
						</div>
					</div>
				</div>

					<div class="row">
						<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading mi-panel-heading">
								<div class="row">
									<div class="col-md-9">
											Detalle funcional de la certificaci&oacute;n
									</div>
								</div>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<table cellpadding="0" cellspacing="0" border="0"
										class="display table table-bordered" id="hidden-table-certificaciones-negocio-detalle">
										<thead>
											<tr>
												<th><div style="width: 75px;">${headerDim1}</div></th>
												<th><div style="width: 75px;">${headerDim2}</div></th>
												<th><div style="width: 75px;">${headerDim3}</div></th>
												<th><div style="width: 75px;">${headerDim4}</div></th>
												<th><div style="width: 75px;">${headerDim5}</div></th>
												<th><div style="width: 75px;">${headerDim6}</div></th>
												<th><div style="width: 75px;">Valor evaluado</div></th>
												<th><div style="width: 75px;">Estado</div></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allTableItems}" var="item">
												<tr class="gradeA">
													<td class="center hidden-phone">${item.valDimension1}</td>
													<td class="center hidden-phone">${item.valDimension2}</td>
													<td class="center hidden-phone">${item.valDimension3}</td>
													<td class="center hidden-phone">${item.valDimension4}</td>
													<td class="center hidden-phone">${item.valDimension5}</td>
													<td class="center hidden-phone">${item.valDimension6}</td>
													<td class="center hidden-phone">${item.hcValMetricaAct}</td>
													<td class="center hidden-phone"><c:choose>
															<c:when test="${item.status=='OK'}">
																<span class="label label-success label-mini">${item.status}</span>
															</c:when>
															<c:when test="${item.status=='KO'}">
																<span class="label label-danger label-mini">${item.status}</span>
															</c:when>
															<c:when test="${item.status=='PDTE'}">
																<span class="label label-warning label-mini">${item.status}</span>
															</c:when>
															<c:otherwise>
																<span class="label label-inverse label-mini">${item.status}</span>
															</c:otherwise>
														</c:choose></td>
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
<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/dynamic_table_init.js"></script> --%>

<!-- Mi script personal -->
<script src="${pageContext.servletContext.contextPath}/resources/js/lang-sett-es.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs-certificaciones-detalle.js"></script>
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
