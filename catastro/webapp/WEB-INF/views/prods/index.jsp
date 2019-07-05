<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
	<spring:url value="/producto/nuevo" var="urlNew" />
	<spring:url value="/producto/editar" var="urlEdit" />
	<spring:url value="/producto/eliminar" var="urlDelete" />
	<title>Productos</title>
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
                    <h1 class="page-header">Administración de Productos</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Productos
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
                                        <th>Nombre</th>
                                        <th>Precio</th>
                                        <th>Catalogo</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${ productos }" var="prod">
                                    <tr class="odd gradeX">
                                        <td>${ prod.id }</td>
                                        <td>${ prod.nombre }</td>
                                        <td>${ prod.precio }</td>
									    <td>${ prod.catalogo.nombre }</td>
                                        <td>
                                        <a href="${ urlEdit }/${ prod.id }" title="Editar" class="btn btn-success"><i class="fa fa-edit fa-fw"></i></a>
                                        <a href="${ urlDelete }/${ prod.id }" 
                                        	onclick='return confirm("¿Seguro desea Eliminar ${ prod.nombre }?")' 
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