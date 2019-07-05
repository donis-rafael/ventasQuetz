<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
	<spring:url value="/resources" var="urlPublic" />
	<spring:url value="/" var="urlRoot" />
	<jsp:include page="../includes/head.jsp"></jsp:include>
	<title>Gracias por Calificar</title>
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
                	<h1 class="col-md-offset-3 col-lg-10">Gracias por Calificar</h1>
            	</div>
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-md-offset-3 col-lg-10">
            		<h1 class="center">!Esperamos que Vuelva Pronto!</h1>
                </div>
            </div>
            <!-- /.row -->
            
             <div class="row">
                <div class="col-md-offset-5 col-lg-12">
            		<a href="${ urlRoot }" type="button" class="btn btn-outline btn-default">Inicio</a>
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