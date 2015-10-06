<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.png">

    <title>Dynamic Table</title>

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
                        Dynamic Table
                        <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-cog"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                    </header>
                    <div class="panel-body">
                    <div class="adv-table">
                    <table  class="display table table-bordered table-striped" id="dynamic-table">
                    <thead>
                    <tr>
                        <th>Rendering engine</th>
                        <th>Browser</th>
                        <th>Platform(s)</th>
                        <th class="hidden-phone">Engine version</th>
                        <th class="hidden-phone">CSS grade</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="gradeX">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 4.0</td>
                        <td>Win 95+</td>
                        <td class="center hidden-phone">4</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 5.0</td>
                        <td>Win 95+</td>
                        <td class="center hidden-phone">5</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 5.5</td>
                        <td>Win 95+</td>
                        <td class="center hidden-phone">5.5</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 6</td>
                        <td>Win 98+</td>
                        <td class="center hidden-phone">6</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet Explorer 7</td>
                        <td>Win XP SP2+</td>
                        <td class="center hidden-phone">7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>AOL browser (AOL desktop)</td>
                        <td>Win XP</td>
                        <td class="center hidden-phone">6</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 1.0</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 1.5</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 2.0</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 3.0</td>
                        <td>Win 2k+ / OSX.3+</td>
                        <td class="center hidden-phone">1.9</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Camino 1.0</td>
                        <td>OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Camino 1.5</td>
                        <td>OSX.3+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape 7.2</td>
                        <td>Win 95+ / Mac OS 8.6-9.2</td>
                        <td class="center hidden-phone">1.7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape Browser 8</td>
                        <td>Win 98SE+</td>
                        <td class="center hidden-phone">1.7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape Navigator 9</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.0</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.1</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.1</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.2</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.2</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.3</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.3</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.4</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.4</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.5</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.5</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.6</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.6</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.7</td>
                        <td>Win 98+ / OSX.1+</td>
                        <td class="center hidden-phone">1.7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.8</td>
                        <td>Win 98+ / OSX.1+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Seamonkey 1.1</td>
                        <td>Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Epiphany 2.20</td>
                        <td>Gnome</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 1.2</td>
                        <td>OSX.3</td>
                        <td class="center hidden-phone">125.5</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 1.3</td>
                        <td>OSX.3</td>
                        <td class="center hidden-phone">312.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 2.0</td>
                        <td>OSX.4+</td>
                        <td class="center hidden-phone">419.3</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 3.0</td>
                        <td>OSX.4+</td>
                        <td class="center hidden-phone">522.1</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>OmniWeb 5.5</td>
                        <td>OSX.4+</td>
                        <td class="center hidden-phone">420</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>iPod Touch / iPhone</td>
                        <td>iPod</td>
                        <td class="center hidden-phone">420.1</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>S60</td>
                        <td>S60</td>
                        <td class="center hidden-phone">413</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 7.0</td>
                        <td>Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 7.5</td>
                        <td>Win 95+ / OSX.2+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 8.0</td>
                        <td>Win 95+ / OSX.2+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 8.5</td>
                        <td>Win 95+ / OSX.2+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.0</td>
                        <td>Win 95+ / OSX.3+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.2</td>
                        <td>Win 88+ / OSX.3+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.5</td>
                        <td>Win 88+ / OSX.3+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera for Wii</td>
                        <td>Wii</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Nokia N800</td>
                        <td>N800</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Nintendo DS browser</td>
                        <td>Nintendo DS</td>
                        <td class="center hidden-phone">8.5</td>
                        <td class="center hidden-phone">C/A<sup>1</sup></td>
                    </tr>
                    <tr class="gradeC">
                        <td>KHTML</td>
                        <td>Konqureror 3.1</td>
                        <td>KDE 3.1</td>
                        <td class="center hidden-phone">3.1</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>KHTML</td>
                        <td>Konqureror 3.3</td>
                        <td>KDE 3.3</td>
                        <td class="center hidden-phone">3.3</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>KHTML</td>
                        <td>Konqureror 3.5</td>
                        <td>KDE 3.5</td>
                        <td class="center hidden-phone">3.5</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Tasman</td>
                        <td>Internet Explorer 4.5</td>
                        <td>Mac OS 8-9</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Tasman</td>
                        <td>Internet Explorer 5.1</td>
                        <td>Mac OS 7.6-9</td>
                        <td class="center hidden-phone">1</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Tasman</td>
                        <td>Internet Explorer 5.2</td>
                        <td>Mac OS 8-X</td>
                        <td class="center hidden-phone">1</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Misc</td>
                        <td>NetFront 3.1</td>
                        <td>Embedded devices</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Misc</td>
                        <td>NetFront 3.4</td>
                        <td>Embedded devices</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Misc</td>
                        <td>Dillo 0.8</td>
                        <td>Embedded devices</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Misc</td>
                        <td>Links</td>
                        <td>Text only</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Misc</td>
                        <td>Lynx</td>
                        <td>Text only</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Misc</td>
                        <td>IE Mobile</td>
                        <td>Windows Mobile 6</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Misc</td>
                        <td>PSP browser</td>
                        <td>PSP</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeU">
                        <td>Other browsers</td>
                        <td>All others</td>
                        <td>-</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">U</td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>Rendering engine</th>
                        <th>Browser</th>
                        <th>Platform(s)</th>
                        <th class="hidden-phone">Engine version</th>
                        <th class="hidden-phone">CSS grade</th>
                    </tr>
                    </tfoot>
                    </table>
                    </div>
                    </div>
                </section>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        DataTables hidden row details example
                        <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-cog"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                    </header>
                    <div class="panel-body">
                    <div class="adv-table">
                    <table cellpadding="0" cellspacing="0" border="0" class="display table table-bordered" id="hidden-table-info">
                    <thead>
                    <tr>
                        <th>Rendering engine</th>
                        <th>Browser</th>
                        <th class="hidden-phone">Platform(s)</th>
                        <th class="hidden-phone">Engine version</th>
                        <th class="hidden-phone">CSS grade</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="gradeX">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 4.0</td>
                        <td class="hidden-phone">Win 95+</td>
                        <td class="center hidden-phone">4</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 5.0</td>
                        <td class="hidden-phone">Win 95+</td>
                        <td class="center hidden-phone">5</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 5.5</td>
                        <td class="hidden-phone">Win 95+</td>
                        <td class="center hidden-phone">5.5</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet
                            Explorer 6</td>
                        <td class="hidden-phone">Win 98+</td>
                        <td class="center hidden-phone">6</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>Internet Explorer 7</td>
                        <td class="hidden-phone">Win XP SP2+</td>
                        <td class="center hidden-phone">7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Trident</td>
                        <td>AOL browser (AOL desktop)</td>
                        <td class="hidden-phone">Win XP</td>
                        <td class="center hidden-phone">6</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 1.0</td>
                        <td class="hidden-phone">Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 1.5</td>
                        <td class="hidden-phone">Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 2.0</td>
                        <td class="hidden-phone">Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Firefox 3.0</td>
                        <td class="hidden-phone">Win 2k+ / OSX.3+</td>
                        <td class="center hidden-phone">1.9</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Camino 1.0</td>
                        <td class="hidden-phone">OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Camino 1.5</td>
                        <td class="hidden-phone">OSX.3+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape 7.2</td>
                        <td class="hidden-phone">Win 95+ / Mac OS 8.6-9.2</td>
                        <td class="center hidden-phone">1.7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape Browser 8</td>
                        <td class="hidden-phone">Win 98SE+</td>
                        <td class="center hidden-phone">1.7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Netscape Navigator 9</td>
                        <td class="hidden-phone">Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.0</td>
                        <td class="hidden-phone">Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.1</td>
                        <td class="hidden-phone">Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.1</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.2</td>
                        <td class="hidden-phone">Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.2</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.3</td>
                        <td class="hidden-phone">Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.3</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.4</td>
                        <td class="hidden-phone">Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.4</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.5</td>
                        <td class="hidden-phone">Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.5</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.6</td>
                        <td class="hidden-phone">Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">1.6</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.7</td>
                        <td class="hidden-phone">Win 98+ / OSX.1+</td>
                        <td class="center hidden-phone">1.7</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Mozilla 1.8</td>
                        <td class="hidden-phone">Win 98+ / OSX.1+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Seamonkey 1.1</td>
                        <td class="hidden-phone">Win 98+ / OSX.2+</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Gecko</td>
                        <td>Epiphany 2.20</td>
                        <td class="hidden-phone">Gnome</td>
                        <td class="center hidden-phone">1.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 1.2</td>
                        <td class="hidden-phone">OSX.3</td>
                        <td class="center hidden-phone">125.5</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 1.3</td>
                        <td class="hidden-phone">OSX.3</td>
                        <td class="center hidden-phone">312.8</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 2.0</td>
                        <td class="hidden-phone">OSX.4+</td>
                        <td class="center hidden-phone">419.3</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>Safari 3.0</td>
                        <td class="hidden-phone">OSX.4+</td>
                        <td class="center hidden-phone">522.1</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>OmniWeb 5.5</td>
                        <td class="hidden-phone">OSX.4+</td>
                        <td class="center hidden-phone">420</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>iPod Touch / iPhone</td>
                        <td class="hidden-phone">iPod</td>
                        <td class="center hidden-phone">420.1</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Webkit</td>
                        <td>S60</td>
                        <td class="hidden-phone">S60</td>
                        <td class="center hidden-phone">413</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 7.0</td>
                        <td class="hidden-phone">Win 95+ / OSX.1+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 7.5</td>
                        <td class="hidden-phone">Win 95+ / OSX.2+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 8.0</td>
                        <td class="hidden-phone">Win 95+ / OSX.2+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 8.5</td>
                        <td class="hidden-phone">Win 95+ / OSX.2+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.0</td>
                        <td class="hidden-phone">Win 95+ / OSX.3+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.2</td>
                        <td class="hidden-phone">Win 88+ / OSX.3+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera 9.5</td>
                        <td class="hidden-phone">Win 88+ / OSX.3+</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Opera for Wii</td>
                        <td class="hidden-phone">Wii</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Nokia N800</td>
                        <td class="hidden-phone">N800</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Presto</td>
                        <td>Nintendo DS browser</td>
                        <td class="hidden-phone">Nintendo DS</td>
                        <td class="center hidden-phone">8.5</td>
                        <td class="center hidden-phone">C/A<sup>1</sup></td>
                    </tr>
                    <tr class="gradeC">
                        <td>KHTML</td>
                        <td>Konqureror 3.1</td>
                        <td class="hidden-phone">KDE 3.1</td>
                        <td class="center hidden-phone">3.1</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>KHTML</td>
                        <td>Konqureror 3.3</td>
                        <td class="hidden-phone">KDE 3.3</td>
                        <td class="center hidden-phone">3.3</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeA">
                        <td>KHTML</td>
                        <td>Konqureror 3.5</td>
                        <td class="hidden-phone">KDE 3.5</td>
                        <td class="center hidden-phone">3.5</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Tasman</td>
                        <td>Internet Explorer 4.5</td>
                        <td class="hidden-phone">Mac OS 8-9</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Tasman</td>
                        <td>Internet Explorer 5.1</td>
                        <td class="hidden-phone">Mac OS 7.6-9</td>
                        <td class="center hidden-phone">1</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Tasman</td>
                        <td>Internet Explorer 5.2</td>
                        <td class="hidden-phone">Mac OS 8-X</td>
                        <td class="center hidden-phone">1</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Misc</td>
                        <td>NetFront 3.1</td>
                        <td>Embedded devices</td>
                        <td class="center">-</td>
                        <td class="center">C</td>
                    </tr>
                    <tr class="gradeA">
                        <td>Misc</td>
                        <td>NetFront 3.4</td>
                        <td class="hidden-phone">Embedded devices</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">A</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Misc</td>
                        <td>Dillo 0.8</td>
                        <td class="hidden-phone">Embedded devices</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Misc</td>
                        <td>Links</td>
                        <td class="hidden-phone">Text only</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeX">
                        <td>Misc</td>
                        <td>Lynx</td>
                        <td class="hidden-phone">Text only</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">X</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Misc</td>
                        <td>IE Mobile</td>
                        <td class="hidden-phone">Windows Mobile 6</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeC">
                        <td>Misc</td>
                        <td>PSP browser</td>
                        <td class="hidden-phone">PSP</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">C</td>
                    </tr>
                    <tr class="gradeU">
                        <td>Other browsers</td>
                        <td>All others</td>
                        <td class="hidden-phone">-</td>
                        <td class="center hidden-phone">-</td>
                        <td class="center hidden-phone">U</td>
                    </tr>
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

<!--dynamic table initialization -->
<script src="${pageContext.servletContext.contextPath}/resources/js/dynamic_table_init.js"></script>



</body>
</html>
