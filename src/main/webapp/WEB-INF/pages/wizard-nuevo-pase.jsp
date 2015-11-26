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

                        <div id="wizard">
                            <h2>Primer paso</h2>

									<section>
										<form class="form-horizontal" method="get">
											<div class="form-group">
<!-- 												<label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Sistema</label> -->
												<label class="col-lg-2 control-label">Sistema</label>
												<div class="col-lg-8">
												<select
													class="form-control m-bot15">
													<option>DataMar Solvencia</option>
													<option>iQuality</option>
												</select></div>
												
											</div>
											<div class="form-group">
												<label class="col-lg-2 control-label">Nombre del
													pase</label>
												<div class="col-lg-8">
													<input type="text" class="form-control"
														placeholder="Nombre">
												</div>
											</div>
											<div class="form-group">
												<label class="col-sm-3 control-label">Checkboxes</label>

												<div class="col-sm-9 icheck ">

													<div class="square-green">
														<div class="radio ">
															<input tabindex="3" type="radio" name="demo-radio">
															<label>Sí </label>
														</div>
													</div>

													<div class="square-red">
														<div class="radio ">
															<input tabindex="3" type="radio" name="demo-radio">
															<label>No </label>
														</div>
													</div>

												</div>
											</div>
										</form>
									</section>

									<h2>Segundo paso</h2>
                            <section>
                                <div class="form-group last">
        <label class="control-label col-md-3">Searchable</label>
        <div class="col-md-9">
        <select name="country" class="multi-select" multiple="" id="my_multi_select3" >
        <option value="AF">Afghanistan</option>
        <option value="AL">Albania</option>
        <option value="DZ">Algeria</option>
        <option value="AS">American Samoa</option>
        <option value="AD">Andorra</option>
        <option value="AO">Angola</option>
        <option value="AI">Anguilla</option>
        <option value="AQ">Antarctica</option>
        <option value="AR">Argentina</option>
        <option value="AM">Armenia</option>
        <option value="AW">Aruba</option>
        <option value="AU">Australia</option>
        <option value="AT">Austria</option>
        <option value="AZ">Azerbaijan</option>
        <option value="BS">Bahamas</option>
        <option value="BH">Bahrain</option>
        <option value="BD">Bangladesh</option>
        <option value="BB">Barbados</option>
        <option value="BY">Belarus</option>
        <option value="BE">Belgium</option>
        <option value="BZ">Belize</option>
        <option value="BJ">Benin</option>
        <option value="BM">Bermuda</option>
        <option value="BT">Bhutan</option>
        <option value="BO">Bolivia</option>
        <option value="BA">Bosnia and Herzegowina</option>
        <option value="BW">Botswana</option>
        <option value="BV">Bouvet Island</option>
        <option value="BR">Brazil</option>
        <option value="IO">British Indian Ocean Territory</option>
        <option value="BN">Brunei Darussalam</option>
        <option value="BG">Bulgaria</option>
        <option value="BF">Burkina Faso</option>
        <option value="BI">Burundi</option>
        <option value="KH">Cambodia</option>
        <option value="CM">Cameroon</option>
        <option value="CA">Canada</option>
        <option value="CV">Cape Verde</option>
        <option value="KY">Cayman Islands</option>
        <option value="CF">Central African Republic</option>
        <option value="TD">Chad</option>
        <option value="CL">Chile</option>
        <option value="CN">China</option>
        <option value="CX">Christmas Island</option>
        <option value="CC">Cocos (Keeling) Islands</option>
        <option value="CO">Colombia</option>
        <option value="KM">Comoros</option>
        <option value="CG">Congo</option>
        <option value="CD">Congo, the Democratic Republic of the</option>
        <option value="CK">Cook Islands</option>
        <option value="CR">Costa Rica</option>
        <option value="CI">Cote d'Ivoire</option>
        <option value="HR">Croatia (Hrvatska)</option>
        <option value="CU">Cuba</option>
        <option value="CY">Cyprus</option>
        <option value="CZ">Czech Republic</option>
        <option value="DK">Denmark</option>
        <option value="DJ">Djibouti</option>
        <option value="DM">Dominica</option>
        <option value="DO">Dominican Republic</option>
        <option value="EC">Ecuador</option>
        <option value="EG">Egypt</option>
        <option value="SV">El Salvador</option>
        <option value="GQ">Equatorial Guinea</option>
        <option value="ER">Eritrea</option>
        <option value="EE">Estonia</option>
        <option value="ET">Ethiopia</option>
        <option value="FK">Falkland Islands (Malvinas)</option>
        <option value="FO">Faroe Islands</option>
        <option value="FJ">Fiji</option>
        <option value="FI">Finland</option>
        <option value="FR">France</option>
        <option value="GF">French Guiana</option>
        <option value="PF">French Polynesia</option>
        <option value="TF">French Southern Territories</option>
        <option value="GA">Gabon</option>
        <option value="GM">Gambia</option>
        <option value="GE">Georgia</option>
        <option value="DE">Germany</option>
        <option value="GH">Ghana</option>
        <option value="GI">Gibraltar</option>
        <option value="GR">Greece</option>
        <option value="GL">Greenland</option>
        <option value="GD">Grenada</option>
        <option value="GP">Guadeloupe</option>
        <option value="GU">Guam</option>
        <option value="GT">Guatemala</option>
        <option value="GN">Guinea</option>
        <option value="GW">Guinea-Bissau</option>
        <option value="GY">Guyana</option>
        <option value="HT">Haiti</option>
        <option value="HM">Heard and Mc Donald Islands</option>
        <option value="VA">Holy See (Vatican City State)</option>
        <option value="HN">Honduras</option>
        <option value="HK">Hong Kong</option>
        <option value="HU">Hungary</option>
        <option value="IS">Iceland</option>
        <option value="IN">India</option>
        <option value="ID">Indonesia</option>
        <option value="IR">Iran (Islamic Republic of)</option>
        <option value="IQ">Iraq</option>
        <option value="IE">Ireland</option>
        <option value="IL">Israel</option>
        <option value="IT">Italy</option>
        <option value="JM">Jamaica</option>
        <option value="JP">Japan</option>
        <option value="JO">Jordan</option>
        <option value="KZ">Kazakhstan</option>
        <option value="KE">Kenya</option>
        <option value="KI">Kiribati</option>
        <option value="KP">Korea, Democratic People's Republic of</option>
        <option value="KR">Korea, Republic of</option>
        <option value="KW">Kuwait</option>
        <option value="KG">Kyrgyzstan</option>
        <option value="LA">Lao People's Democratic Republic</option>
        <option value="LV">Latvia</option>
        <option value="LB">Lebanon</option>
        <option value="LS">Lesotho</option>
        <option value="LR">Liberia</option>
        <option value="LY">Libyan Arab Jamahiriya</option>
        <option value="LI">Liechtenstein</option>
        <option value="LT">Lithuania</option>
        <option value="LU">Luxembourg</option>
        <option value="MO">Macau</option>
        <option value="MK">Macedonia, The Former Yugoslav Republic of</option>
        <option value="MG">Madagascar</option>
        <option value="MW">Malawi</option>
        <option value="MY">Malaysia</option>
        <option value="MV">Maldives</option>
        <option value="ML">Mali</option>
        <option value="MT">Malta</option>
        <option value="MH">Marshall Islands</option>
        <option value="MQ">Martinique</option>
        <option value="MR">Mauritania</option>
        <option value="MU">Mauritius</option>
        <option value="YT">Mayotte</option>
        <option value="MX">Mexico</option>
        <option value="FM">Micronesia, Federated States of</option>
        <option value="MD">Moldova, Republic of</option>
        <option value="MC">Monaco</option>
        <option value="MN">Mongolia</option>
        <option value="MS">Montserrat</option>
        <option value="MA">Morocco</option>
        <option value="MZ">Mozambique</option>
        <option value="MM">Myanmar</option>
        <option value="NA">Namibia</option>
        <option value="NR">Nauru</option>
        <option value="NP">Nepal</option>
        <option value="NL">Netherlands</option>
        <option value="AN">Netherlands Antilles</option>
        <option value="NC">New Caledonia</option>
        <option value="NZ">New Zealand</option>
        <option value="NI">Nicaragua</option>
        <option value="NE">Niger</option>
        <option value="NG">Nigeria</option>
        <option value="NU">Niue</option>
        <option value="NF">Norfolk Island</option>
        <option value="MP">Northern Mariana Islands</option>
        <option value="NO">Norway</option>
        <option value="OM">Oman</option>
        <option value="PK">Pakistan</option>
        <option value="PW">Palau</option>
        <option value="PA">Panama</option>
        <option value="PG">Papua New Guinea</option>
        <option value="PY">Paraguay</option>
        <option value="PE">Peru</option>
        <option value="PH">Philippines</option>
        <option value="PN">Pitcairn</option>
        <option value="PL">Poland</option>
        <option value="PT">Portugal</option>
        <option value="PR">Puerto Rico</option>
        <option value="QA">Qatar</option>
        <option value="RE">Reunion</option>
        <option value="RO">Romania</option>
        <option value="RU">Russian Federation</option>
        <option value="RW">Rwanda</option>
        <option value="KN">Saint Kitts and Nevis</option>
        <option value="LC">Saint LUCIA</option>
        <option value="VC">Saint Vincent and the Grenadines</option>
        <option value="WS">Samoa</option>
        <option value="SM">San Marino</option>
        <option value="ST">Sao Tome and Principe</option>
        <option value="SA">Saudi Arabia</option>
        <option value="SN">Senegal</option>
        <option value="SC">Seychelles</option>
        <option value="SL">Sierra Leone</option>
        <option value="SG">Singapore</option>
        <option value="SK">Slovakia (Slovak Republic)</option>
        <option value="SI">Slovenia</option>
        <option value="SB">Solomon Islands</option>
        <option value="SO">Somalia</option>
        <option value="ZA">South Africa</option>
        <option value="GS">South Georgia and the South Sandwich Islands</option>
        <option value="ES">Spain</option>
        <option value="LK">Sri Lanka</option>
        <option value="SH">St. Helena</option>
        <option value="PM">St. Pierre and Miquelon</option>
        <option value="SD">Sudan</option>
        <option value="SR">Suriname</option>
        <option value="SJ">Svalbard and Jan Mayen Islands</option>
        <option value="SZ">Swaziland</option>
        <option value="SE">Sweden</option>
        <option value="CH">Switzerland</option>
        <option value="SY">Syrian Arab Republic</option>
        <option value="TW">Taiwan, Province of China</option>
        <option value="TJ">Tajikistan</option>
        <option value="TZ">Tanzania, United Republic of</option>
        <option value="TH">Thailand</option>
        <option value="TG">Togo</option>
        <option value="TK">Tokelau</option>
        <option value="TO">Tonga</option>
        <option value="TT">Trinidad and Tobago</option>
        <option value="TN">Tunisia</option>
        <option value="TR">Turkey</option>
        <option value="TM">Turkmenistan</option>
        <option value="TC">Turks and Caicos Islands</option>
        <option value="TV">Tuvalu</option>
        <option value="UG">Uganda</option>
        <option value="UA">Ukraine</option>
        <option value="AE">United Arab Emirates</option>
        <option value="GB">United Kingdom</option>
        <option value="US">United States</option>
        <option value="UM">United States Minor Outlying Islands</option>
        <option value="UY">Uruguay</option>
        <option value="UZ">Uzbekistan</option>
        <option value="VU">Vanuatu</option>
        <option value="VE">Venezuela</option>
        <option value="VN">Viet Nam</option>
        <option value="VG">Virgin Islands (British)</option>
        <option value="VI">Virgin Islands (U.S.)</option>
        <option value="WF">Wallis and Futuna Islands</option>
        <option value="EH">Western Sahara</option>
        <option value="YE">Yemen</option>
        <option value="ZM">Zambia</option>
        <option value="ZW">Zimbabwe</option>
        </select>
        </div>
        </div>
                            </section>

                            <h2>Tercer paso</h2>
                            <section>
                                <form class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Bill Name 1</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" placeholder="Phone">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Bill Name 2</label>
                                        <div class="col-lg-8">
                                            <input type="text" class="form-control" placeholder="Mobile">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">Status</label>
                                        <div class="col-lg-8">
                                            <textarea class="form-control" cols="60" rows="5"></textarea>
                                        </div>
                                    </div>
                                </form>
                            </section>

                            <h2>Paso final</h2>
                            <section>
                                <p>Congratulations This is the Final Step</p>
                            </section>
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
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/bs3/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
<script class="include" type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/easypiechart/jquery.easypiechart.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.nicescroll.js"></script>

<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-switch.js"></script>

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

</body>
</html>
