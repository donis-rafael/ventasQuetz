<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
<head>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/usuario/guardar" var="urlForm" />
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
                    <h1 class="page-header">${ accion } Usuario</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-md-offset-2 col-lg-7">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Datos Personales
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-offset-2 col-md-8">
                                <spring:hasBindErrors name="usuario">
									<div class='alert alert-danger' role='alert'>
										Por favor corrija los siguientes errores:
										<ul>
											<c:forEach var="error" items="${errors.allErrors}">
												<li><spring:message message="${error}" /></li>
											</c:forEach>
										</ul>
									</div>
								</spring:hasBindErrors>
                                    <form:form action="${ urlForm }" method="POST" modelAttribute="usuario">
                                    	<div class="form-group">
	                                    	<label class="control-label" for="inputError">Primer Nombre</label>
			                                <form:input type="text" class="form-control" path="nombre" id="nombre" required="required" />
			                                    
			                                <label class="control-label" for="inputError">Segundo Nombre</label>
				                            <form:input type="text" class="form-control" path="nombre2" id="nombre2" />
			                            </div>
                                        <div class="form-group">
	                                        <label class="control-label" for="inputError">Primer Apellido</label>
			                                <form:input type="text" class="form-control" path="apellido" id="apellido" required="required"/>
			                                    
			                                <label class="control-label" for="inputError">Segundo Apellido</label>
				                            <form:input type="text" class="form-control" path="apellido2" id="apellido2" />
			                            </div>
                                    	<div class="form-group">
                                    		<label class="control-label">Estado</label>
                                    		<form:select data-style="btn btn-link" id="estado" path="estado" class="form-control">
								        		<form:option value="1" selected="true" >Activo</form:option>
								            	<form:option value="0">Inactivo</form:option>               
								   			</form:select>
                                    	</div>
                                    	<div class="form-group">
                                    		<label >Rol</label>
												<select data-style="btn btn-link" id="exampleFormControlSelect1" name="rolUsu" class="form-control">
												<c:forEach items="${ roles }" var="rol">
													<c:choose>
														<c:when test="${rolAsignado.nombre != rol.nombre}">
															<option value="${ rol.nombre }">${ rol.nombre }</option>
														</c:when>
														<c:otherwise>
															<option value="${ rol.nombre }" selected>${ rol.nombre }</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>        
								   				</select>
                                    	</div>
                                    
                                    	<div class="form-group">
                                    		<div>
												<label >Usuario</label>
												<c:choose>
													<c:when test="${accion=='Nuevo'}">
														<form:input type="text" class="form-control" path="usuario" id="usuario" required="required"/>
													</c:when>
													<c:otherwise>
														<form:input type="text" class="form-control" path="usuario" id="usuario" readonly="true"/>
													</c:otherwise>
												</c:choose>
											</div>
											<div>
												<label>Contraseña</label>
												<form:input type="password" class="form-control" path="contrasenia" id="contrasenia" required="required"/>
											</div>
	                                    </div>
    	                                <form:hidden path="id"/>
										<button type="submit" class="btn btn-primary">Guardar</button>
                                    </form:form>
                                </div>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
        </div>
</body>

<jsp:include page="../includes/scripts.jsp"></jsp:include>
</html>