<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.png">

    <title>Jobs del pase ${id}</title>

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
                    <header class="panel-heading">
                        Registro de operaciones del job ${idJob} del pase ${idEjecucion}
                        <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-cog"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                    </header>
                    <div class="panel-body">
                    <div class="adv-table">
                    <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-jobs">
                    <thead>
                    <tr>
                        <th>Id Operaci&oacute;n</th>
                        <th class="hidden-phone">Fecha inicio</th>
                        <th class="hidden-phone">Duraci&oacute;n (s)</th>
                        <th class="hidden-phone">Fecha datos</th>
                        <th>Operaci&oacute;n</th>
                        <th>Tipo de operaci&oacute;n</th>
                        <th class="hidden-phone">Estado</th>
                        <th class="hidden-phone">Escenario</th>
                        <th class="hidden-phone">Filas Actualizadas</th>
                        <th class="hidden-phone">Filas Cargadas</th>
                        <th class="hidden-phone">Filas le&iacute;das</th>
                        <th class="hidden-phone">Filas Rechazadas</th>
                        <th class="hidden-phone">Filas Descartadas</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${allTableItems}" var="item">
					    <tr class="gradeA">      
<!-- 					    <tr class="gradeX">       -->
<!-- 					    <tr class="gradeC">       -->
<!-- 					    <tr class="gradeU">       -->
					        <td class="center hidden-phone">${item.idOperacion}</td>
					        <td class="center hidden-phone">${item.fechaInicio}</td>
					        <td class="center hidden-phone">${item.fcDuracion}</td>
					        <td class="center hidden-phone">${item.fechaDatos}</td>
					        <td class="center hidden-phone">${item.idOperacion}</td>
					        <td class="center hidden-phone">${item.tipoDeOperacion}</td>
					        <td class="center hidden-phone">
					        	<c:choose>
								    <c:when test="${item.estado=='OK'}">
										<span class="label label-success label-mini">${item.estado}</span>
								    </c:when>
								    <c:when test="${item.estado=='KO'}">
										<span class="label label-danger label-mini">${item.estado}</span>
								    </c:when>     
								    <c:when test="${item.estado=='PDTE'}">
										<span class="label label-warning label-mini">${item.estado}</span>
								    </c:when>   
								    <c:otherwise>
										<span class="label label-inverse label-mini">${item.estado}</span>
								    </c:otherwise>
								</c:choose>
					        </td>
					        <td class="center hidden-phone">${item.descripcionEscenario}</td>   
					        <td class="center hidden-phone">${item.fcFilasCargadas}</td>   
					        <td class="center hidden-phone">${item.fcFilasActualizadas}</td>   
					        <td class="center hidden-phone">${item.fcFilasLeidas}</td>   
					        <td class="center hidden-phone">${item.fcFilasRechazadas}</td>   
					        <td class="center hidden-phone">${item.fcFilasDescartadas}</td>   
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
<!--Easy Pie Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/easypiechart/jquery.easypiechart.js"></script>
<!--Sparkline Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/sparkline/jquery.sparkline.js"></script>
<!--jQuery Flot Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.tooltip.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.resize.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.pie.resize.js"></script>

<!--dynamic table-->
<script type="text/javascript" language="javascript" src="${pageContext.servletContext.contextPath}/resources/js/advanced-datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/data-tables/DT_bootstrap.js"></script>
<!--common script init for all pages-->
<script src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>

<!-- Mi script personal -->
<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/my-custom-scripts-jobs.js"></script> --%>

<!--dynamic table initialization -->
<script src="${pageContext.servletContext.contextPath}/resources/js/dynamic_table_init.js"></script>



</body>
</html>
