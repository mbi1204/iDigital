<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configuracion de Usuarios</title>

<link href="css/pure-0.4.2.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="css/font-awesome-4.0.3/css/font-awesome.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="css/jquery-ui-1.10.4.custom.css" rel="stylesheet"
	type="text/css" media="screen" />
	

<style type="text/css">
th {
	text-align: left
}

td {
	border: 1px #DDD solid;
	padding: 5px;
	cursor: pointer;
}

.selected {
	background-color: orange;
}
</style>	
	

<script type="text/javascript" src="js/lib/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/lib/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="js/lib/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="js/view/sysConfigUsu.js"></script>


</head>
<body>



	<div id="addUsuComp_Dialog" style="display: none;">

		<%@ include file="sysConfigUsu_Add_UsuComp.jsp"%>

	</div>

	<h1>Configuracion de Usuarios</h1>
	<label for="cCompania">Compañia</label>

	<select name="cCompania">

		<c:forEach items="${list_ctCompania}" var="ctCompania">
			<option value="${ctCompania.cCveCia}">${ctCompania.cRazonS}</option>
		</c:forEach>
	</select>


	<button class="pure-button pure-button-primary"
		onclick="add_ctUsuario()">
		<i class="fa fa-plus"></i> Agregar Usuario
	</button>


</body>
</html>