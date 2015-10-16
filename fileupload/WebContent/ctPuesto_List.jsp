<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ctMenu</title>
<link href="css/pure-0.4.2.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="css/font-awesome-4.0.3/css/font-awesome.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="css/jquery-ui-1.10.4.custom.css" rel="stylesheet"
	type="text/css" media="screen" />
</head>
<body>
<div style="width: 95%; margin: 0 auto;">

		<div id="ctCompania_add_Dialog" style="display: none;">
		
		</div>

		<h1>Lista Puesto</h1>

		<button class="pure-button pure-button-primary"
			onclick="addCompania()">
			<i class="fa fa-plus"></i> Agregar Puesto
		</button>

		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="20">ID Puesto</th>
					<th width="30">Puesto</th>
					<th width="20">Estatus</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach items="${lista_ctPuesto}" var="ctPuesto">
					<tr>

						<td><c:out value="${ctPuesto.iPuesto}" /></td>
						<td><c:out value="${ctPuesto.cPuesto}" /></td>
						<td><c:out value="${ctPuesto.lActivo}" /></td>
						
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
</body>
</html>