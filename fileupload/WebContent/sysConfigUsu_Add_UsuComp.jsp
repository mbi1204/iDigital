<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="ctCompaniaCtrl?action=update" />



<%-- <form id="AddUsuComp_Form" class="pure-form pure-form-aligned"
	method="post" action="${actionUrl}">

	<fieldset>
		<legend></legend>

		<table id="table_ctUsuario" >
			<thead >
				<tr>
					<th width="20">Usuario</th>
					<th width="50">Nombre</th>
					<th width="20">Puesto</th>
					

				</tr>
			</thead>

			<tbody>

				<c:forEach items="${list_Usuario}" var="ctUsuario">
					<tr>

						<td><c:out value="${ctUsuario.cUsuario}" /></td>
						<td><c:out value="${ctUsuario.cNombre}" /></td>
						<td><c:out value="${ctUsuario.iPuesto}" /></td>


					</tr>
				</c:forEach>
			</tbody>
		</table>


	</fieldset>

</form> --%>