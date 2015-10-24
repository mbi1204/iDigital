<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String action = request.getParameter("action");

	if (action.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="ctMenuCtrl?action=update" />
<%
	} else {
%>
<c:url var="actionUrl" value="ctMenuCtrl?action=add" />

<%
	}
%>

<form id="ctMenu_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

	<fieldset>
		<legend></legend>
		<table>

			<tr>
				<td><label for="iMenu">ID Menu</label></td>
				<%
					if (action.equals("update")) {
				%>

				<td><input id="iMenu" name="iMenu" type="text" maxlength="15"
					value="<c:out value="${ctMenu.iMenu}" />"
					placeholder="Clave del menu" readonly="readonly"></td>

				<%
					} else {

						System.out.println("ento al otro caso");
				%>
				<td><input id="iMenu" name="iMenu" type="text" maxlength="15"
					value="<c:out value="${ctMenu.iMenu}" />"
					placeholder="Clave del menu"></td>
				<%
					}
				%>
			</tr>

			<tr>
				<td><label for="cMenu">Menu</label></td>
				<td><input id="cMenu" name="cMenu" type="text" placeholder="Menu"
					value="<c:out value="${ctMenu.cMenu}" />">
				</td>
			</tr>

			<%
				if (action.equals("update")) {
			%>

			<tr>
				<td><label for="lActivo">Activo?</label></td>
				<td><input type="radio" name="lActivo" value="true"
					${ctMenu.lActivo ? 'checked':''}> SI</td>
					
				<td><input type="radio" name="lActivo" value="false"
					${not ctMenu.lActivo ? 'checked':''}> NO</td>

			</tr>

			<%
				}
			%>


		</table>
	</fieldset>
</form>