<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

System.out.println("entro al ctMenu ADD");

	String action2 = request.getParameter("action");
	//String sCompania = request.getParameter("cCveCia");
	
	if (action2.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="syConfigUsuCtrl?action=update" />
<%
	} else {
%>
<c:url var="actionUrl"
	value="syConfigUsuCtrl?action=add" />

<%
	}
%>

<form id="AddUsuMenu_Form" class="pure-form pure-form-aligned"
	method="post" action="${actionUrl}">

	<fieldset>

		<legend></legend>
		<table id="table_ctMenu">
			<thead>
				<tr>
					<th width="25">Menu</th>
					<%
							if (action2.equals("update")) {
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
				<c:forEach items="${list_UsuMenu}" var="ctMenu">
					<tr>
						<td><c:out value="${ctMenu.cMenu}" /></td>
						
						<%
							if (action2.equals("update")) {
						%>
						<td><input type="radio" id="lActivo" name="lActivo" value="true"
							${ctMenu.lActivo ? 'checked':''}> SI</td>
		
						<td><input type="radio" id="lActivo" name="lActivo" value="false"
							${not ctMenu.lActivo ? 'checked':''}> NO</td>
						
						<td><input type="hidden" id ="cUsuarios" name="cUsuarios" value="${ctMenu.iMenu}"></td>
						<%
								} else{
						%>
						<td><input type="checkbox" id ="cUsuarios" name="cUsuarios" value="${ctMenu.iMenu}"></td>
						<%
								}
						%>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</fieldset>

</form>