<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%

System.out.println("entro al ctUsuario ADD");

	String action = request.getParameter("action");
	//System.out.print(session.getAttribute("value"));
	System.out.println("Este es el parametro: "+request.getParameter("cCompania"));

	if (action.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="syConfigUsuCtrl?action=update" />
<%
	} else {
%>
<c:url var="actionUrl" value="syConfigUsuCtrl?action=add" />

<%
	}
%>

<form id="AddUsuComp_Form" class="pure-form pure-form-aligned"
	method="post" action="${actionUrl}">

	<fieldset>
		<legend></legend>

		<table id="table_ctUsuario" >
			<thead >
				<tr>
					<th width="25">Usuario</th>
					<th width="55">Nombre</th>
					<th width="25">Puesto</th>
					<th width="25">Activar</th>
				</tr>
			</thead>

			<tbody>
			
				<c:forEach items="${list_Usuario}" var="ctUsuario">
					<tr>
					<% System.out.println("Entra al primer for"); %>
					<c:if test = "${ ctUsuario.lActivo == true }">
					<% System.out.println("Estan activos"); %>
						<c:forEach items="${list_syUsuCompania}" var="syUsuCompania">
						<% System.out.println("Entra al segundo for"); %>
							<c:if test = "${syUsuCompania.cCveCia ne 'SINERGIT'}">
							<% System.out.println("Entra al primer if"); %>
								<c:if test = "${syUsuCompania.cUsuario eq ctUsuario.cUsuario}" >
								<% System.out.println("Entra al segundo if"); %>
									<td><c:out value="${ctUsuario.cUsuario}" /></td>
									<td><c:out value="${ctUsuario.cNombre}" /></td>
									<td><c:out value="${ctUsuario.iPuesto}" /></td>
									<td><input type="checkbox" name="id" value="true"></td>
								</c:if>
							</c:if>
						</c:forEach>
						</c:if>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>

	</fieldset>

</form>