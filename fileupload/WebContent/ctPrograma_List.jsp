<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ctPrograma</title>
<link href="css/pure-0.4.2.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="css/font-awesome-4.0.3/css/font-awesome.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="css/jquery-ui-1.10.4.custom.css" rel="stylesheet"
	type="text/css" media="screen" />
</head>
<body>

		<div style="width: 95%; margin: 0 auto;">

		<div id="ctPrograma_Dialog" style="display: none;">
		 <%@ include file="ctPrograma_Add.jsp"%>
		
		</div>

		<h1>Lista Programa</h1>

		<button class="pure-button pure-button-primary"
			onclick="add_ctPrograma()">
			<i class="fa fa-plus"></i> Agregar Programa
		</button>

		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="20">ID Programa</th>
					<th width="30">ID Menu</th>
					<th width="20">Programa</th>
					<th width="30">Estatus</th>
					<th width="20">Nombre</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach items="${lista_ctPrograma}" var="ctPrograma">
					<tr>

						<td><c:out value="${ctPrograma.iPrograma}" /></td>
						<td><c:out value="${ctPrograma.iMenu}" /></td>
						<td><c:out value="${ctPrograma.cPrograma}" /></td>
						<td><c:out value="${ctPrograma.lActivo}" /></td>
						<td><c:out value="${ctPrograma.cNombre}" /></td>
						
						<td><nobr>
								<button class="pure-button pure-button-primary"
									onclick="edit_ctCompania(${book.id});">

									<i class="fa fa-pencil"></i> Editar
								</button>

								<a class="pure-button pure-button-primary"
									onclick="return confirm('Are you sure you want to delete this book?');"
									href="delete/${book.id}"> <i class="fa fa-times"></i>Eliminar
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
 	<script type="text/javascript" src="js/view/ctPrograma.js"></script>
 	
</body>
</html>