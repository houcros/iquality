<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
<!--                 <li> -->
<%--                     <a href="${pageContext.servletContext.contextPath}"> --%>
<!--                         <i class="fa fa-terminal"></i> -->
<!--                         <span>Inicio</span> -->
<!--                     </a> -->
<!--                 </li> -->
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>Diccionario de conceptos</span>
                    </a>
                    <ul class="sub">
                        <li><a href="${pageContext.servletContext.contextPath}/diccionario">Diccionario</a></li>
                        <li><a href="horizontal_menu.html">Gestionar certificaciones</a></li>
                        <li><a href="language_switch.html">Gestionar dimensiones</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/api/updateDictionaryCache">Recargar</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-tachometer"></i>
                        <span>Control de procesos</span>
                    </a>
                    <ul class="sub">
                        <li><a href="general.html">Cargar ficheros</a></li>
                        <li><a href="buttons.html">Consultar certificaciones</a></li>
                        <li><a href="${pageContext.servletContext.contextPath}/pases">Control de ejecución</a></li>
                        <li><a href="slider.html">Planificar cargas</a></li>
                        <li><a href="tree_view.html">Parametrizar certificaciones</a></li>
                    </ul>
                </li>
                <li>
                    <a href="fontawesome.html">
                        <i class="fa fa-road"></i>
                        <span>Gestión de escenarios</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-users"></i>
                        <span>Gestión de usuarios</span>
                    </a>
                    <ul class="sub">
                        <li><a href="basic_table.html">Gestionar usuarios</a></li>
                        <li><a href="responsive_table.html">Gestionar perfiles</a></li>
                    </ul>
                </li>
                <li>
                    <a href="login.html">
                        <i class="fa fa-user"></i>
                        <span>Login Page</span>
                    </a>
                </li>
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->