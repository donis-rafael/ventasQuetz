    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<spring:url value="/resources" var="urlPublic" />
	
	
	<!-- jQuery -->
    <script src="${ urlPublic }/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${ urlPublic }/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${ urlPublic }/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${ urlPublic }/vendor/raphael/raphael.min.js"></script>
    <script src="${ urlPublic }/vendor/morrisjs/morris.min.js"></script>
    <script src="${ urlPublic }/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${ urlPublic }/dist/js/sb-admin-2.js"></script>