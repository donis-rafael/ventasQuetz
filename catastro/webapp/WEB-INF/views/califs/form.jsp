<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
<head>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/calificar/guardar" var="urlForm" />
	<title>Calificación de Puesto</title>
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
                    <h1 class="page-header">${ accion } Calificación de Puesto</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-md-offset-2 col-lg-7">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Califique
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-offset-2 col-md-8">
                                <spring:hasBindErrors name="califica">
									<div class='alert alert-danger' role='alert'>
										Por favor corrija los siguientes errores:
										<ul>
											<c:forEach var="error" items="${errors.allErrors}">
												<li><spring:message message="${error}" /></li>
											</c:forEach>
										</ul>
									</div>
								</spring:hasBindErrors>
                                    <form:form action="${ urlForm }" method="POST" modelAttribute="califica">
                                    	<div class="form-group">
                                    		<label >Seleccione el Puesto</label>
												<select data-style="btn btn-link" id="exampleFormControlSelect1" name="puestCalif" class="form-control">
												<c:forEach items="${ puestos }" var="pues">
													<c:choose>
														<c:when test="${cateAsignada.nombre != pues.nombre}">
															<option value="${ pues.nombre }">${ pues.nombre }</option>
														</c:when>
														<c:otherwise>
															<option value="${ pues.nombre }" selected>${ pues.nombre }</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>        
								   				</select>
                                    	</div>
                                    	<div class="form-group">
                                    		<label >Califique</label>
												<select data-style="btn btn-link" id="exampleFormControlSelect1" name="punteoCalif" class="form-control">
												<c:forEach items="${ punteos }" var="punto">
													<c:choose>
														<c:when test="${cateAsignada.descripcion != punto.descripcion}">
															<option value="${ punto.punteo }">${ punto.descripcion }</option>
														</c:when>
														<c:otherwise>
															<option value="${ punto.punteo }" selected>${ punto.descripcion }</option>
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