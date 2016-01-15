<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configuracion de Usuarios</title>

<link href="https://necolas.github.io/normalize.css/3.0.2/normalize.css" rel="stylesheet" type="text/css"
	media="screen" />
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

.hover { background-color: #111111; color: #B10DC9; }

.selected {
	background-color: orange;
}
</style>


<script type="text/javascript" src="js/lib/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/lib/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="js/lib/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="js/view/sysConfigUsu.js"></script>
<script type="text/javascript" src="js/view/sysConfigUsuMenu.js"></script>


</head>
<body>



	<div id="addUsuComp_Dialog" style="display: none;">

		<%@ include file="sysConfigUsu_Add_UsuComp.jsp"%>

	</div>

	<h1>Configuracion de Usuarios</h1>


	<label for="cCompania">Compañia: </label>


	<select id="cCompania" name="cCompania">
		<c:forEach items="${list_ctCompania}" var="ctCompania">
			<option value="${ctCompania.cCveCia}">${ctCompania.cRazonS}</option>
		</c:forEach>
	</select>


	<h1>Usuarios por compañia</h1>

	<button class="pure-button pure-button-primary"
		onclick="add_ctUsuario()">
		<i class="fa fa-plus"></i> Agregar Usuario
	</button>



	<table id="btn-toggle" class="pure-table pure-table-bordered pure-table-striped">
		<thead>
			<tr>
				<th width="20">Compañia</th>
				<th width="20">Usuario</th>
				<th width="50">Nombre</th>
				<th width="20">Estatus</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${list_syUsuCompania}" var="syUsuCompania">
				<tr>
					<td><c:out value="${syUsuCompania.cCveCia}" /></td>
					<td><c:out value="${syUsuCompania.cUsuario}" /></td>
					<td><c:out value="${syUsuCompania.ctUsu.cNombre}" /></td>
					<td><c:out value="${syUsuCompania.lActivo ? 'Activo':'Desactivo'}" /></td>
					<td><nobr>
							<button class="pure-button pure-button-primary"
								onclick="update_sysUsuCompania('${syUsuCompania.cCveCia}','${syUsuCompania.cUsuario}');">
								<i class="fa fa-pencil"></i> Editar
							</button>

							<a class="pure-button pure-button-primary"
								onclick="return confirm('¿De verdad quieres eliminar este registro?');"
								href="syConfigUsuCtrl?action=delete&cCveCia=${syUsuCompania.cCveCia}&cUsuario=${syUsuCompania.cUsuario}"></i>Eliminar
							</a>
						</nobr></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


	<section class="seccionToggle">
		<div class="wrap">
			<div id="addUsuMenu_Dialog" style="display: none;">
			<%@ include file="sysConfigUsu_Add_UsuMenu.jsp"%>			
		</div>

	<h1>Configuracion Menu de Usuario</h1>

	<h1>Menu por usuario</h1>

	<button class="pure-button pure-button-primary"
		onclick="add_ctMenu()">
		<i class="fa fa-plus"></i> Agregar Menu
	</button>

	<table id="menu" class="pure-table pure-table-bordered pure-table-striped">
		<thead>
			<tr>
				<th width="20">Usuario</th>
				<th width="20">Menu</th>
				<th width="20">Estatus</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${list_syUsuMenu}" var="syUsuMenu">
				<tr>
					<td><c:out value="${syUsuMenu.cUsuario}" /></td>
					<td><c:out value="${syUsuMenu.menu.cMenu}" /></td>
					<td><c:out value="${syUsuMenu.lActivo ? 'Activo':'Desactivo'}" /></td>
					<td><nobr>
							<button class="pure-button pure-button-primary"
								onclick="update_sysUsuMenu('${syUsuMenu.cUsuario}','${syUsuMenu.iMenu}');">
								<i class="fa fa-pencil"></i> Editar
							</button>

							<a class="pure-button pure-button-primary"
								onclick="return confirm('¿De verdad quieres eliminar este registro?');"
								href="syConfigUsuCtrl?action=deleteMenu&cUsuario=${syUsuMenu.cUsuario}&iMenu=${syUsuMenu.iMenu}"></i>Eliminar
							</a>
						</nobr></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
		</div>
	</section>
	
	 
	
	<section class="seccionTogglePrograma">
		<div class="wrap">
			<div id="addUsuMenu_Dialog" style="display: none;">
						
		</div>

	<h1>Configuracion Programas de Usuario</h1>

	<h1>Programas por usuario</h1>

	<button class="pure-button pure-button-primary"
		onclick="add_ctMenu()">
		<i class="fa fa-plus"></i> Agregar Programa
	</button>

	<table id="menu" class="pure-table pure-table-bordered pure-table-striped">
		<thead>
			<tr>
				<th width="20">Usuario</th>
				<th width="20">Programa</th>
				<th width="20">Estatus</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach items="${list_syUsuMenu}" var="syUsuMenu">
				<tr>
					<td><c:out value="${syUsuMenu.cUsuario}" /></td>
					<td><c:out value="${syUsuMenu.menu.cMenu}" /></td>
					<td><c:out value="${syUsuMenu.lActivo ? 'Activo':'Desactivo'}" /></td>
					<td><nobr>
							<button class="pure-button pure-button-primary"
								onclick="update_sysUsuMenu('${syUsuMenu.cUsuario}','${syUsuMenu.iMenu}');">
								<i class="fa fa-pencil"></i> Editar
							</button>

							<a class="pure-button pure-button-primary"
								onclick="return confirm('¿De verdad quieres eliminar este registro?');"
								href="syConfigUsuCtrl?action=deleteMenu&cUsuario=${syUsuMenu.cUsuario}&iMenu=${syUsuMenu.iMenu}"></i>Eliminar
							</a>
						</nobr></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
		</div>
	</section>
	
	
	
</body>
</html>