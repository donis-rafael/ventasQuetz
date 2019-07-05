<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
<head>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/puesto/guardar" var="urlForm" />
	<title>Admin. Puestos</title>
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
                    <h1 class="page-header">${ accion } Puesto</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-md-offset-2 col-lg-7">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Ingrese los Datos
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-offset-2 col-md-8">
                                <spring:hasBindErrors name="puesto">
									<div class='alert alert-danger' role='alert'>
										Por favor corrija los siguientes errores:
										<ul>
											<c:forEach var="error" items="${errors.allErrors}">
												<li><spring:message message="${error}" /></li>
											</c:forEach>
										</ul>
									</div>
								</spring:hasBindErrors>
                                    <form:form action="${ urlForm }" method="POST" modelAttribute="puesto">
                                    	<div class="form-group">
	                                    	<label class="control-label" for="inputError">Nombre del Puesto</label>
			                                <form:input type="text" class="form-control" path="nombre" id="nombre" required="required" />
			                            </div>
                                    	<div class="form-group">
                                    		<label >Categoria</label>
												<select data-style="btn btn-link" id="exampleFormControlSelect1" name="categPuesto" class="form-control">
												<c:forEach items="${ categorias }" var="cate">
													<c:choose>
														<c:when test="${cateAsignada.nombre != cate.nombre}">
															<option value="${ cate.nombre }">${ cate.nombre }</option>
														</c:when>
														<c:otherwise>
															<option value="${ cate.nombre }" selected>${ cate.nombre }</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>        
								   				</select>
                                    	</div>
                                    	<div class="form-group">
                                    		<label >Mercado</label>
												<select data-style="btn btn-link" id="exampleFormControlSelect1" name="mercadito" class="form-control">
												<c:forEach items="${ mercados }" var="merca">
													<c:choose>
														<c:when test="${mercadoAsignado.nombre != merca.nombre}">
															<option value="${ merca.nombre }">${ merca.nombre }</option>
														</c:when>
														<c:otherwise>
															<option value="${ merca.nombre }" selected>${ merca.nombre }</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>        
								   				</select>
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