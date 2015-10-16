<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

		<h1>Lista Menu</h1>

		<button class="pure-button pure-button-primary"
			onclick="addCompania()">
			<i class="fa fa-plus"></i> Agregar Menu
		</button>

		<table class="pure-table pure-table-bordered pure-table-striped">
			<thead>
				<tr>
					<th width="20">ID Menu</th>
					<th width="30">Menu</th>
					<th width="20">Estatus</th>

				</tr>
			</thead>

			<tbody>

				<c:forEach items="${lista_ctMenu}" var="ctMenu">
					<tr>

						<td><c:out value="${ctMenu.iMenu}" /></td>
						<td><c:out value="${ctMenu.cMenu}" /></td>
						<td><c:out value="${ctMenu.lActivo}" /></td>
						
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