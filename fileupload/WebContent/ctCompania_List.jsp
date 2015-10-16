<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


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

		<h1>Lista Compa�ias</h1>

		<button class="pure-button pure-button-primary"
			onclick="addCompania()">
			<i class="fa fa-plus"></i> Agregar Compa�ia
		</button>

		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="20">Compa�ia</th>
					<th width="30">Razon Social</th>
					<th width="20">Calle</th>
					<th width="6">Num Ext</th>
					<th width="6">Num Int</th>
					<th width="20">Colonia</th>
					<th width="20">Municipio</th>
					<th width="8">CP</th>
					<th width="15">Ciudad</th>
					<th width="14">Estado</th>
					<th width="20">Telefono</th>
					<th width="20">Email</th>
					<th width="20">Contacto</th>
					<th width="10">Pais</th>
					<th width="10">Activa?</th>
					<th width="12%"></th>


				</tr>
			</thead>

			<tbody>

				<c:forEach items="${lista_ctCompania}" var="ctCompania">
					<tr>

						<td><c:out value="${ctCompania.cCveCia}" /></td>
						<td><c:out value="${ctCompania.cRazonS}" /></td>
						<td><c:out value="${ctCompania.cCalle}" /></td>
						<td><c:out value="${ctCompania.cNExterior}" /></td>
						<td><c:out value="${ctCompania.cNInterior}" /></td>
						<td><c:out value="${ctCompania.cColonia}" /></td>
						<td><c:out value="${ctCompania.cMpioDeleg}" /></td>
						<td><c:out value="${ctCompania.iCP}" /></td>
						<td><c:out value="${ctCompania.cCiudad}" /></td>
						<td><c:out value="${ctCompania.cEstado}" /></td>
						<td><c:out value="${ctCompania.cTelefono}" /></td>
						<td><c:out value="${ctCompania.cEmail}" /></td>
						<td><c:out value="${ctCompania.cContacto}" /></td>
						<td><c:out value="${ctCompania.cPais}" /></td>
						<td><c:out value="${ctCompania.lActivo}" /></td>
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