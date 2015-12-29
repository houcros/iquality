<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a href="${pageContext.servletContext.contextPath}">
                        <i class="fa fa-tachometer"></i>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.servletContext.contextPath}/diccionario">
                        <i class="fa fa-book"></i>
                        <span>Diccionario de conceptos</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-tasks"></i>
                        <span>Reglas de calidad</span>
                    </a>
                    <ul class="sub">
                        <li><a href="${pageContext.servletContext.contextPath}/resultado-certificaciones/1">Consultar reglas</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/parametrizar-certificaciones/1">Parametrizar reglas</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-rocket"></i>
                        <span>Control de procesos</span>
                    </a>
                    <ul class="sub">
                        <li><a href="${pageContext.servletContext.contextPath}/pases">Control de ejecuci&oacute;n</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/planificar-cargas">Gesti&oacute;n de pases</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/carga">Cargar ficheros</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-cog"></i>
                        <span>Administraci&oacute;n</span>
                    </a>
                    <ul class="sub">
                        <li><a href="${pageContext.servletContext.contextPath}">Gesti&oacute;n de escenarios</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}">Gesti&oacute;n de usuarios</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}">Gesti&oacute;n de perfiles</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/api/updateDictionaryCache"><i class="fa fa-refresh"></i>Recargar diccionario</a></li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.servletContext.contextPath}/login">
                        <i class="fa fa-user"></i>
                        <span>Iniciar sesi&oacute;n</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.servletContext.contextPath}">
                        <i class="fa fa-question-circle"></i>
                        <span>Ayuda</span>
                    </a>
                </li>
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->