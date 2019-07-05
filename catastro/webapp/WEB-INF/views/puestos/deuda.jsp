<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/puesto/guardar" var="urlForm" />
<spring:url value="/puesto/cancelar" var="urlCancel" />
<title>Admin. Puestos</title>
<jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body>

	<div class="wrapper">

		<jsp:include page="../includes/navBar.jsp"></jsp:include>
		<jsp:include page="../includes/sidebar.jsp">
			<jsp:param name="menu" value="${ menu }" />
		</jsp:include>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Manejo de Deuda ${ puesto.nombre }</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-md-offset-2 col-lg-7">
					<div class="panel panel-default">
						<div class="panel-heading">Ingrese los Datos</div>
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
									<c:if test="${ mensaje != null }">
										<div class="alert alert-danger">${ mensaje }</div>
									</c:if>
									<form:form action="${ urlForm }" method="POST"
										modelAttribute="puesto">
										<div class="form-group">
											<label class="control-label" for="inputError">Nombre
												del Puesto</label>
										</div>
										<div class="form-group">
											<label class="text-muted">${ puesto.nombre }</label>
										</div>
										<div class="form-group">
											<label>Categoria</label>
										</div>
										<div class="form-group">
											<label class="text-muted">${ puesto.categoria.nombre }</label>
										</div>
										<div class="form-group">
											<label>Mercado</label>
										</div>
										<div class="form-group">
											<label class="text-muted">${ puesto.mercado.nombre }</label>
										</div>
										<div class="form-group">
											<label>Ingrese Cantidad de Deuda (En Quetzáles)</label>
										</div>
										<div class="form-group">
											<form:input type="number" step="0.01" path="deuda"
												class="col-md-2" required="required" />
										</div>
										<br />
										<br />
										<input type="hidden" name="categPuesto"
											value="${ puesto.categoria.nombre }" />
										<input type="hidden" name="mercadito"
											value="${ puesto.mercado.nombre }" />
										<form:hidden path="id" />
										<form:hidden path="nombre" />
										<form:hidden path="fecha" />
										<div class="form-group">
											<button type="submit" class="btn btn-primary col-md-offset-5">Guardar</button>
											<c:if test="${ puesto.deuda > 0 }">
												<a href="${ urlCancel }/${ puesto.id }" type="button" class="btn btn-danger" onclick='return confirm("¿Seguro desea Eliminar la Deuda?")'>Eliminar Deuda</a>
											</c:if>
										</div>
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