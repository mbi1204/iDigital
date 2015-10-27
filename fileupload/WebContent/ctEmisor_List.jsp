<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ctEmisor</title>
<link href="css/pure-0.4.2.css" rel="stylesheet" type="text/css"
	media="screen" />
<link href="css/font-awesome-4.0.3/css/font-awesome.css"
	rel="stylesheet" type="text/css" media="screen" />
<link href="css/jquery-ui-1.10.4.custom.css" rel="stylesheet"
	type="text/css" media="screen" />
</head>
<body>

	<div style="width: 95%; margin: 0 auto;">

		<div id="ctEmisor_Dialog" style="display: none;">
		
		 <%@ include file="ctEmisor_Add.jsp"%>
		
		</div>


		<h1>Lista Emisor</h1>

		<button class="pure-button pure-button-primary"
			onclick="add_ctEmisor()">
			<i class="fa fa-plus"></i> Agregar Emisor
		</button>

		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="20">ID Emisor</th>
					<th width="20">Compañia</th>
					<th width="30">Razon Social</th>
					<th width="20">RFC</th>
					<th width="20">CURP</th>
					<th width="20">Calle</th>
					<th width="6">Num Int</th>
					<th width="6">Num Ext</th>
					<th width="20">Municipio o Delegación</th>
					<th width="20">Email</th>
					<th width="10">Pais</th>
					<th width="14">Estado</th>
					<th width="8">CP</th>
					<th width="20">Alta</th>
					
					
					<th width="20">Alias</th>
					<th width="10">Activo?</th>
					<!-- <th width="12%"></th> -->


				</tr>
			</thead>

			<tbody>

				<c:forEach items="${lista_ctEmisor}" var="ctEmisor">
					<tr>

						<td><c:out value="${ctEmisor.iEmisor}" /></td>
						<td><c:out value="${ctEmisor.cCveCia}" /></td>
						<td><c:out value="${ctEmisor.cRazonSocial}" /></td>
						<td><c:out value="${ctEmisor.cRFC}" /></td>
						<td><c:out value="${ctEmisor.cCURP}" /></td>
						<td><c:out value="${ctEmisor.cCalle}" /></td>
						<td><c:out value="${ctEmisor.cNumeroInterior}" /></td>
						<td><c:out value="${ctEmisor.cNumeroExterior}" /></td>
						<td><c:out value="${ctEmisor.cMpioDelg}" /></td>
						<td><c:out value="${ctEmisor.cEmail}" /></td>
						<td><c:out value="${ctEmisor.cPais}" /></td>
						<td><c:out value="${ctEmisor.cEstado}" /></td>
						<td><c:out value="${ctEmisor.cCP}" /></td>
						<td><c:out value="${ctEmisor.dtFechaAlta}" /></td>
						
						
						<td><c:out value="${ctEmisor.cAlias}" /></td>
						<td><c:out value="${ctEmisor.lActivo ? 'SI':'NO'}" /></td>
						<td><nobr>
								<button class="pure-button pure-button-primary"
									onclick="update_ctEmisor(${ctEmisor.iEmisor});">

									<i class="fa fa-pencil"></i> Editar
								</button>

								<a class="pure-button pure-button-primary"
									onclick="return confirm('¿De verdad quieres eliminar este registro?');"
									href="ctEmisorCtrl?action=delete&iEmisor=${ctEmisor.iEmisor}"> <i class="fa fa-times"></i>Eliminar
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
			 <script type="text/javascript" src="js/view/ctEmisor.js"></script>

</body>
</html>