<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico">

    <title>Registrarse</title>

    <!--Core CSS -->
    <link href="${pageContext.servletContext.contextPath}/resources/bs3/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-reset.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />

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
  <body class="login-body">

    <div class="container">

      <form class="form-signin" action="index.html">
        <h2 class="form-signin-heading">registrarse ahora</h2>
        <div class="login-wrap">
            <p> Introduzca sus datos personales abajo</p>
            <input type="text" class="form-control" placeholder="Nombre y apellidos" autofocus>
            <input type="text" class="form-control" placeholder="Direcci&oacute;n" autofocus>
            <input type="text" class="form-control" placeholder="Email" autofocus>
            <input type="text" class="form-control" placeholder="Ciudad" autofocus>
            <div class="radios">
                <label class="label_radio col-lg-6 col-sm-6" for="radio-01">
                    <input name="sample-radio" id="radio-01" value="1" type="radio" checked /> Hombre
                </label>
                <label class="label_radio col-lg-6 col-sm-6" for="radio-02">
                    <input name="sample-radio" id="radio-02" value="1" type="radio" /> Mujer
                </label>
            </div>

            <p> Introduzca los datos de su cuenta abajo</p>
            <input type="text" class="form-control" placeholder="Nombre de usuario" autofocus>
            <input type="password" class="form-control" placeholder="Contrase&ntilde;">
            <input type="password" class="form-control" placeholder="Repita contrase&ntilde;">
            <label class="checkbox">
                <input type="checkbox" value="agree this condition"> I agree to the Terms of Service and Privacy Policy
            </label>
            <button class="btn btn-lg btn-login btn-block" type="submit">Enviar</button>

            <div class="registration">
                Ya estoy registrado.
                <a class="" href="login">
                    Iniciar sesi&oacute;n
                </a>
            </div>

        </div>

      </form>

    </div>


    <!-- Placed js at the end of the document so the pages load faster -->

    <!--Core js-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/bs3/js/bootstrap.min.js"></script>

  </body>
</html>