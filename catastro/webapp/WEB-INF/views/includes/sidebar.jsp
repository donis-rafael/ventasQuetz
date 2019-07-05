<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<spring:url value="/" var="urlRoot" />

<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li><a href="${ urlRoot }"><i class="fa fa-home fa-fw"></i> Inicio</a></li>
			<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Administración
			<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<li><a href="${ urlRoot }usuario/index">Usuarios</a></li>
					<li><a href="${ urlRoot }categoria/index">Categorias</a></li>
					<li><a href="${ urlRoot }mercado/index">Mercados</a></li>
					<li><a href="${ urlRoot }puesto/index">Puestos</a></li>
				</ul> <!-- /.nav-second-level --></li>
			<li><a href="${ urlRoot }catalogo/index"><i class="fa fa-file-text-o fa-fw"></i> Catálogos</a></li>
			<li><a href="${ urlRoot }producto/index"><i class="fa fa-briefcase fa-fw"></i> Productos</a></li>
			<li><a href="${ urlRoot }calificar/nuevo/0"><i class="fa fa-check-square-o fa-fw"></i> Calificar Puesto</a></li>
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->