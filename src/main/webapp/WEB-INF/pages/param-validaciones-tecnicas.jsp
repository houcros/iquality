<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico">

    <title>Condiciones de validaciones</title>

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
									<div class="col-md-9">
										<div class="btn-group my-btn-group">
											<button data-toggle="dropdown"
												class="btn dropdown-toggle custom-dropdown" type="button">
												VALIDACIONES <span class="caret"></span>
											</button>
											<ul class="dropdown-menu">
												<li><a href="${pageContext.servletContext.contextPath}/parametrizar-certificaciones/1">Certificaciones</a></li>
												<li><a href="#">Validaciones</a></li>
											</ul>
										</div>
									</div>
								</div>
							</header>
							<div class="panel-body">
								<div class="adv-table">
									<!--                     <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-info"> -->
									<div class="table-responsive"> 
									<table cellpadding="0" cellspacing="0" border="0"
										class="table table-bordered table-striped table-condensed display" id="hidden-table-certificaciones-negocio">
										<thead>
											<tr>
												<th><div style="width: 200px;">Descripci&oacute;n error</div></th>
												<th><div style="width: 100px;">Error</th>
												<th><div style="width: 100px;">Condici&oacute;n</div></th>
												<th><div style="width: 90px;">Tabla</div></th>
												<th><div style="width: 90px;">Campo</div></th>
												<th><div style="width: 70px;">Validar condici&oacute;n</div></th>
												<th><div style="width: 70px;">Condici&oacute;n error</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allTableItems}" var="item">
												<tr class="gradeA">
													<td class="center hidden-phone">${item.errorDescription}</td>
													<td class="center hidden-phone">${item.errorCode}</td>
													<td class="center hidden-phone">${item.condition}</td>
													<td class="center hidden-phone">${item.table}</td>
													<td class="center hidden-phone">${item.field}</td>
													<td class="center hidden-phone">${item.boolValidate}</td>
													<td class="center hidden-phone">${item.boolErrorCondition}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs-certificaciones-conditions.js"></script>
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
