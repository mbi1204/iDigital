<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

System.out.println("entro al ctMenu ADD");

	String action2 = request.getParameter("action");
	
	if (action2.equalsIgnoreCase("updateMenu")) {
%>
<c:url var="actionUrl" value="syConfigUsuCtrl?action=updateMenu" />
<%
	} else {
%>
<c:url var="actionUrl"
	value="syConfigUsuCtrl?action=addMenu" />

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
							if (action2.equals("updateMenu")) {
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
						<td id="cMenu"><c:out value="${ctMenu.cMenu}" /></td>
						
						<%
							if (action2.equals("updateMenu")) {
						%>
						<td><input type="radio" id="lActivo" name="lActivo" value="true"
							${ctMenu.lActivo ? 'checked':''}> SI</td>
		
						<td><input type="radio" id="lActivo" name="lActivo" value="false"
							${not ctMenu.lActivo ? 'checked':''}> NO</td>
						
						<td><input type="hidden" id ="iMenu" name="iMenu" value="${ctMenu.iMenu}"></td>
						<%
								} else{
						%>
						<td><input type="checkbox" id ="iMenus" name="iMenus" value="${ctMenu.iMenu}"></td>
						<%
								}
						%>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</fieldset>

</form>