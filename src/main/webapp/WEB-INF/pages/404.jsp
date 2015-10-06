<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keyword" content="">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/resources/images/favicon.ico" type="image/x-icon">

    <title>404</title>

    <!-- Bootstrap core CSS -->
<%--     <link href="<c:url value="/resources/css/bootstrap.min.css" rel="stylesheet" /> --%>
    <link href="${pageContext.servletContext.contextPath}/resources/bs3/css/bootstrap.min.css" rel="stylesheet">

    <link href="${pageContext.servletContext.contextPath}/resources/bs3/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="${pageContext.servletContext.contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="${pageContext.servletContext.contextPath}/resources/css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>




  <body class="body-404">

    <div class="error-head"> </div>

    <div class="container ">

      <section class="error-wrapper text-center">
          <h1><img src="${pageContext.servletContext.contextPath}/resources/images/404.png" alt=""></h1>
          <div class="error-desk">
              <h2>page not found</h2>
              <p class="nrml-txt">We Couldn't Find This Page</p>
              <p class="nrml-txt">${test}</p>
              <h5>Counter : ${counter}</h5>
          </div>
          <a href="index.html" class="back-btn"><i class="fa fa-home"></i> Back To Home</a>
      </section>

    </div>


  </body>
</html>
