<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
<html lang="en">
<head>
	<spring:url value="/resources" var="urlPublic" />
	<jsp:include page="includes/head.jsp"></jsp:include>
	<title>Catastro Mercado Quetzaltenango</title>
</head>

<body class="">

<div class="wrapper">
    
    <jsp:include page="includes/navBar.jsp"></jsp:include>
    <jsp:include page="includes/sidebar.jsp">
    	<jsp:param name="menu" value="${ menu }"/>
    </jsp:include>

      <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Página Inicial</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
            <h1 class="center">BIENVENIDO/A</h1>
            </div>
            <!-- /.row -->
            
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->


</body>

<jsp:include page="includes/scripts.jsp"></jsp:include>

</html>