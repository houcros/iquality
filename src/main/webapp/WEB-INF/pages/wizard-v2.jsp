<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico">

    <title>Crear nuevo pase</title>

    <!--Core CSS -->
    <link href="${pageContext.servletContext.contextPath}/resources/bs3/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />

	<!-- Steps -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/jquery.steps.css?1">
    
    <!--icheck-->
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/minimal.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/red.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/green.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/blue.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/yellow.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/minimal/purple.css" rel="stylesheet">

    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/square.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/red.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/green.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/blue.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/yellow.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/square/purple.css" rel="stylesheet">

    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/grey.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/red.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/green.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/blue.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/yellow.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/js/iCheck/skins/flat/purple.css" rel="stylesheet">
    
	<!-- Multiselect -->
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/js/jquery-multi-select/css/multi-select.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/js/jquery-tags-input/jquery.tagsinput.css" />

    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/js/select2/select2.css" />
    
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
    
    
    <!-- Include Bootstrap Wizard -->
<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap-wizard/1.2/jquery.bootstrap.wizard.min.js"></script>

<style type="text/css">
#installationForm .tab-content {
    margin-top: 20px;
}
</style>
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
                        Nuevo pase
                    </header>
                    <div class="panel-body">


									<section>
									
									<form id="installationForm" class="form-horizontal">
    <ul class="nav nav-pills">
        <li class="active"><a href="#basic-tab" data-toggle="tab">Site information</a></li>
        <li><a href="#database-tab" data-toggle="tab">Database</a></li>
    </ul>

    <div class="tab-content">
        <!-- First tab -->
        <div class="tab-pane active" id="basic-tab">
            <div class="form-group">
                <label class="col-xs-3 control-label">Site name</label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="name" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label">URL</label>
                <div class="col-xs-7">
                    <input type="text" class="form-control" name="url" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label">Owner email</label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="email" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label">Description</label>
                <div class="col-xs-7">
                    <textarea class="form-control" name="description" rows="6"></textarea>
                </div>
            </div>
        </div>

        <!-- Second tab -->
        <div class="tab-pane" id="database-tab">
            <div class="form-group">
                <label class="col-xs-3 control-label">Server IP</label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="dbServer" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label">Database name</label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="dbName" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label">Database user</label>
                <div class="col-xs-5">
                    <input type="text" class="form-control" name="dbUser" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-3 control-label">Password</label>
                <div class="col-xs-5">
                    <input type="password" class="form-control" name="dbPassword" />
                </div>
            </div>
        </div>

        <!-- Previous/Next buttons -->
        <ul class="pager wizard">
            <li class="previous"><a href="javascript: void(0);">Previous</a></li>
            <li class="next"><a href="javascript: void(0);">Next</a></li>
        </ul>
    </div>
</form>

<div class="modal fade" id="completeModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Complete</h4>
            </div>

            <div class="modal-body">
                <p class="text-center">The installation is completed</p>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">Visit the website</button>
            </div>
        </div>
    </div>
</div>
										
									</section>

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
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/bs3/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
<script class="include" type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/easypiechart/jquery.easypiechart.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>

<%-- <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-switch.js"></script> --%>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/fuelux/js/spinner.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-daterangepicker/moment.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-daterangepicker/daterangepicker.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-colorpicker/js/bootstrap-colorpicker.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-multi-select/js/jquery.multi-select.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery-multi-select/js/jquery.quicksearch.js"></script>

<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>

<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-tags-input/jquery.tagsinput.js"></script>

<script src="${pageContext.servletContext.contextPath}/resources/js/select2/select2.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/select-init.js"></script>


<!--common script init for all pages-->
<script src="${pageContext.servletContext.contextPath}/resources/js/scripts.js"></script>

<script src="${pageContext.servletContext.contextPath}/resources/js/toggle-init.js"></script>

<script src="${pageContext.servletContext.contextPath}/resources/js/advanced-form.js"></script>
<!--Easy Pie Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/easypiechart/jquery.easypiechart.js"></script>
<!--Sparkline Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/sparkline/jquery.sparkline.js"></script>
<!--jQuery Flot Chart-->
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.tooltip.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.resize.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/flot-chart/jquery.flot.pie.resize.js"></script>




<!-- Steps -->
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-steps/jquery.steps.js"></script>

<!-- icheck -->
<script src="${pageContext.servletContext.contextPath}/resources/js/iCheck/jquery.icheck.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/ckeditor/ckeditor.js"></script>

<!--icheck init -->
<script src="${pageContext.servletContext.contextPath}/resources/js/icheck-init.js"></script>

<!-- Mi script personal -->
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/mcs-wizard.js"></script>

<!-- Cookies -->
<script src="${pageContext.servletContext.contextPath}/resources/js/cookie-master/js.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.cookie.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-vertical-accordion-menu/jquery.hoverIntent.minified.js"></script>

<!-- URL utility -->
<script src="${pageContext.servletContext.contextPath}/resources/js/URI.js-gh-pages/src/URI.min.js"></script>



<script>
$(document).ready(function() {
    // You don't need to care about this function
    // It is for the specific demo
    function adjustIframeHeight() {
        var $body   = $('body'),
                $iframe = $body.data('iframe.fv');
        if ($iframe) {
            // Adjust the height of iframe
            $iframe.height($body.height());
        }
    }

    $('#installationForm')
        .formValidation({
            framework: 'bootstrap',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            // This option will not ignore invisible fields which belong to inactive panels
            excluded: ':disabled',
            fields: {
                name: {
                    validators: {
                        notEmpty: {
                            message: 'The site name is required'
                        }
                    }
                },
                url: {
                    validators: {
                        notEmpty: {
                            message: 'The URL is required'
                        },
                        uri: {
                            message: 'The URL is not valid'
                        }
                    }
                },
                email: {
                    validators: {
                        notEmpty: {
                            message: 'The email address is required'
                        },
                        emailAddress: {
                            message: 'The email address is not valid'
                        }
                    }
                },
                dbServer: {
                    validators: {
                        notEmpty: {
                            message: 'The server IP is required'
                        },
                        ip: {
                            message: 'The server IP is not valid'
                        }
                    }
                },
                dbName: {
                    validators: {
                        notEmpty: {
                            message: 'The database name is required'
                        }
                    }
                },
                dbUser: {
                    validators: {
                        notEmpty: {
                            message: 'The database user is required'
                        }
                    }
                }
            }
        })
        .bootstrapWizard({
            tabClass: 'nav nav-pills',
            onTabClick: function(tab, navigation, index) {
                return validateTab(index);
            },
            onNext: function(tab, navigation, index) {
                var numTabs    = $('#installationForm').find('.tab-pane').length,
                    isValidTab = validateTab(index - 1);
                if (!isValidTab) {
                    return false;
                }

                if (index === numTabs) {
                    // We are at the last tab

                    // Uncomment the following line to submit the form using the defaultSubmit() method
                    // $('#installationForm').formValidation('defaultSubmit');

                    // For testing purpose
                    $('#completeModal').modal();
                }

                return true;
            },
            onPrevious: function(tab, navigation, index) {
                return validateTab(index + 1);
            },
            onTabShow: function(tab, navigation, index) {
                // Update the label of Next button when we are at the last tab
                var numTabs = $('#installationForm').find('.tab-pane').length;
                $('#installationForm')
                    .find('.next')
                        .removeClass('disabled')    // Enable the Next button
                        .find('a')
                        .html(index === numTabs - 1 ? 'Install' : 'Next');

                // You don't need to care about it
                // It is for the specific demo
                adjustIframeHeight();
            }
        });

    function validateTab(index) {
        var fv   = $('#installationForm').data('formValidation'), // FormValidation instance
            // The current tab
            $tab = $('#installationForm').find('.tab-pane').eq(index);

        // Validate the container
        fv.validateContainer($tab);

        var isValidStep = fv.isValidContainer($tab);
        if (isValidStep === false || isValidStep === null) {
            // Do not jump to the target tab
            return false;
        }

        return true;
    }
});
</script>


</body>
</html>
