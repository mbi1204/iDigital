<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

	String action = request.getParameter("action");
	String sCompania = request.getParameter("cCveCia");
	
	if (action.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="syConfigUsuCtrl?action=update&cCveCia=${param.cCveCia}" />
<%
	} else {
%>
<c:url var="actionUrl"
	value="syConfigUsuCtrl?action=add&cCveCia=${param.cCveCia}" />

<%
	}
%>

<form id="AddUsuComp_Form" class="pure-form pure-form-aligned"
	method="post" action="${actionUrl}">

	<fieldset>

		<legend></legend>
		<table id="table_ctUsuario">
			<thead>
				<tr>
					<th width="25">Usuario</th>
					<th width="55">Nombre</th>
					<th width="25">Puesto</th>
					<%
							if (action.equals("update")) {
					%>
						<th width="25">Activo</th>
					<%
								}else{
					%>
					<th width="25">Seleccionar</th>
					<%
								}
					%>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list_UsuCompania}" var="ctUsuario">
					<tr>
						<td><c:out value="${ctUsuario.cUsuario}" /></td>
						<td><c:out value="${ctUsuario.cNombre}" /></td>
						<td><c:out value="${ctUsuario.puesto.cPuesto}" /></td>
						<%
							if (action.equals("update")) {
						%>
						<td><input type="radio" id="lActivo" name="lActivo" value="true"
							${ctUsuario.lActivo ? 'checked':''}> SI</td>
		
						<td><input type="radio" id="lActivo" name="lActivo" value="false"
							${not ctUsuario.lActivo ? 'checked':''}> NO</td>
						
						<td><input type="hidden" id ="cUsuarios" name="cUsuarios" value="${ctUsuario.cUsuario}"></td>
						<%
								} else{
						%>
						<td><input type="checkbox" id ="cUsuarios" name="cUsuarios" value="${ctUsuario.cUsuario}"></td>
						<%
								}
						%>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</fieldset>

</form>