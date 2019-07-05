<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/" var="urlRoot" />
	<spring:url value="/puesto/iniciaD" var="urlIni" />
	<jsp:include page="../includes/head.jsp"></jsp:include>
	<title>Crear Deuda</title>
</head>

<body class="">

<div class="wrapper">
    
    <jsp:include page="../includes/navBar.jsp"></jsp:include>
    <jsp:include page="../includes/sidebar.jsp">
    	<jsp:param name="menu" value="${ menu }"/>
    </jsp:include>

      <div id="page-wrapper">            
            <div class="row">
            	<div class="col-lg-12">
                	<h1 class="col-md-offset-3 col-lg-10">Manejo de Deuda</h1>
            	</div>
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-md-offset-3 col-lg-10">
            		<h1 class="center">El Puesto no tiene Deuda</h1>
                </div>
            </div>
            <!-- /.row -->
            
             <div class="row">
                <div class="col-md-offset-5 col-lg-12">
            		<a href="${ urlIni }/${ idPuesto }" type="button" class="btn btn-lg btn-danger">Crear Deuda</a>
            		<a href="${ urlRoot }puesto/index" type="button" class="btn btn-lg btn-info">Cancelar</a>
                </div>
            </div>
            <!-- /.row -->
            
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


</body>

<jsp:include page="../includes/scripts.jsp"></jsp:include>

</html>