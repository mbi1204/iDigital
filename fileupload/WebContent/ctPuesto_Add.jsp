<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String action = request.getParameter("action");

	if (action.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="ctPuestoCtrl?action=update" />
<%
	} else {
%>
<c:url var="actionUrl" value="ctPuestoCtrl?action=add" />

<%
	}
%>

<form id="ctPuesto_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

		<fieldset>
				<legend></legend>
		<table>

			<tr>
				<td><label for="iPuesto">Id Puesto</label></td>
				<%
							if (action.equals("update")) {
						%>

				<td><input id="iPuesto" name="iPuesto" type="text"
					maxlength="15" value="<c:out value="${ctPuesto.iPuesto}" />"
					placeholder="Clave del programa" readonly="true"></td>

				<%
							} else {

								System.out.println("ento al otro caso");
						%>
				<td><input id="iPuesto" name="iPuesto" type="text"
					maxlength="15" placeholder="ID Puesto"></td>
				<%
									}
						%>
			</tr>

			<tr>
				<td><label for="cPuesto">Puesto</label></td>
				<td><input id="cPuesto" name="cPuesto" type="text"
					value="<c:out value="${ctPuesto.cPuesto}" />" placeholder="Puesto">
				</td>
			</tr>

			<%
				if (action.equals("update")) {
			%>

			<tr>
				<td><label for="lActivo">Activo?</label></td>
				<td><input type="radio" name="lActivo" value="true"
					${ctPuesto.lActivo ? 'checked':''}> SI</td>

				<td><input type="radio" name="lActivo" value="false"
					${not ctPuesto.lActivo ? 'checked':''}> NO</td>


			</tr>

			<%
				}
			%>


		</table>


	</fieldset>
		

</form>