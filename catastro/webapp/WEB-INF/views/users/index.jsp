<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
	<spring:url value="/usuario/nuevo" var="urlNew" />
	<spring:url value="/usuario/ver" var="urlSee" />
	<spring:url value="/usuario/editar" var="urlEdit" />
	<spring:url value="/usuario/eliminar" var="urlDelete" />
	<title>Admin. Usuarios</title>
	<jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body>
<div class="wrapper">

<jsp:include page="../includes/navBar.jsp"></jsp:include>
    <jsp:include page="../includes/sidebar.jsp">
    	<jsp:param name="menu" value="${ menu }"/>
    </jsp:include>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Administración de Usuarios</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Usuarios
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <a href="${ urlNew }" type="button" class="btn btn-outline btn-default">Nuevo</a>
                        <br />
                        <br />
                        <c:if test="${ mensaje != null }">
                        	<div class="alert alert-success">
                                ${ mensaje }
                            </div>
						</c:if>
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombres</th>
                                        <th>Apellidos</th>
                                        <th>Estado</th>
                                        <th>Usuario</th>
                                        <th>Rol</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${ usuarios }" var="usu">
                                    <tr class="odd gradeX">
                                        <td>${ usu.id }</td>
                                        <td>${ usu.nombre } ${ usu.nombre2 }</td>
                                        <td>${ usu.apellido } ${ usu.apellido2 }</td>
                                        <c:choose>
                                        	<c:when test="${ usu.estado == 1 }">
                                        		<td class="center"><span class="badge badge-success">Activo</span></td>
                                        	</c:when>
									        <c:otherwise>
									    		<td class="center"><span class="badge badge-danger">Inactivo</span></td>
									        </c:otherwise>
									    </c:choose>
                                        <td>${ usu.usuario }</td>
                                        <td>${ usu.rol.nombre }</td>
                                        <td>
                                        <a href="${ urlEdit }/${ usu.id }" title="Editar" class="btn btn-success"><i class="fa fa-edit fa-fw"></i></a>
                                        <a href="${ urlDelete }/${ usu.id }" 
                                        	onclick='return confirm("¿Seguro desea Eliminar ${ usu.nombre }?")' 
									        class="btn btn-danger" 
									        role="button" 
									        title="Eliminar" >
									        <i class="fa fa-trash-o fa-fw"></i>
									    </a>
                                        </td>
                                    </tr>
                	            </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
        </div>
        <!-- /#page-wrapper -->
</div>
</body>

<jsp:include page="../includes/scripts.jsp"></jsp:include>

</html>