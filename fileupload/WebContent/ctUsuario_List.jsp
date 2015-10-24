<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ctUsuario</title>

<link href="css/pure-0.4.2.css" rel="stylesheet" type="text/css" media="screen" />
<link href="css/font-awesome-4.0.3/css/font-awesome.css" rel="stylesheet" type="text/css" media="screen" />
<link href="css/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css" media="screen" />
</head>

<body>
<div style="width: 95%; margin: 0 auto;">

		<div id="ctUsuario_Dialog" style="display: none;">
		 <%@ include file="ctUsuario_Add.jsp"%>
		
		</div>

		<h1>Lista Usuario</h1>

		<button class="pure-button pure-button-primary"
			onclick="add_ctUsuario()">
			<i class="fa fa-plus"></i> Agregar Usuario
		</button>

		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="20">Usuario</th>
					<th width="30">Nombre</th>
					<th width="20">Password</th>
					<th width="30">Estatus</th>
					<th width="20">Alta</th>
					<th width="20">Puesto</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach items="${lista_ctUsuario}" var="ctUsuario">
					<tr>

						<td><c:out value="${ctUsuario.cUsuario}" /></td>
						<td><c:out value="${ctUsuario.cNombre}" /></td>
						<td><c:out value="${ctUsuario.cPassword}" /></td>
						<td><c:out value="${ctUsuario.lActivo ? 'SI':'NO'}" /></td>
						<td><c:out value="${ctUsuario.dtFechaAlta}" /></td>
						<td><c:out value="${ctUsuario.iPuesto}" /></td>
						
						<td><nobr>
								<button class="pure-button pure-button-primary"
									onclick="update_ctUsuario('${ctUsuario.cUsuario}');">

									<i class="fa fa-pencil"></i> Editar
								</button>

								<a class="pure-button pure-button-primary"
									onclick="return confirm('Are you sure you want to delete this book?');"
									href="ctUsuarioCtrl?action=delete&cUsuario=${ctUsuario.cUsuario}"> <i class="fa fa-times"></i>Eliminar
								</a>

							</nobr></td>

					</tr>
				</c:forEach>
			</tbody>


		</table>
	</div>
	
			 <script type="text/javascript" src="js/lib/jquery-1.10.2.js"></script>
			 <script type="text/javascript" src="js/lib/jquery-ui-1.10.4.custom.js"></script>
			 <script type="text/javascript" src="js/lib/jquery.ui.datepicker.js"></script>
			 <script type="text/javascript" src="js/view/ctUsuario.js"></script>
			 
</body>
</html>