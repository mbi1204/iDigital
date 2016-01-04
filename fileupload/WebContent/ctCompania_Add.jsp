<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String action = request.getParameter("action");

	if (action.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="ctCompaniaCtrl?action=update" />
<%
	} else {
%>
<c:url var="actionUrl" value="ctCompaniaCtrl?action=add" />

<%
	}
%>

<form id="ctCompania_Form" class="pure-form pure-form-aligned"
	method="post" action="${actionUrl}">

	<fieldset>
		<legend></legend>
		<table>



			<tr>
				<td><label for="cCveCia">Clave</label></td>

				<%
					if (action.equals("update")) {
				%>

				<td><input id="cCveCia" name="cCveCia" type="text"
					maxlength="15" value="<c:out value="${ctCompania.cCveCia}" />"
					placeholder="Clave de la compañia" readonly="readonly"></td>

				<%
					} else {

						System.out.println("ento al otro caso");
				%>
				<td><input id="cCveCia" name="cCveCia" type="text"
					maxlength="15" value="" placeholder="Clave de la compañia"></td>
				<%
					}
				%>

			</tr>

			<tr>
				<td><label for="cRazonS">Razon Social</label></td>
				<td><input id="cRazonS" name="cRazonS" type="text"
					placeholder="Razon Social" size="60"
					value="<c:out value="${ctCompania.cRazonS}" />"></td>
			</tr>

			<tr>
				<td><label for="cRFC">RFC</label></td>
				<td><input id="cRFC" name="cRFC" type="text" placeholder="RFC"
					value="<c:out value="${ctCompania.cRazonS}" />"></td>
			</tr>

			<tr>
				<td><label for="cCalle">Calle</label></td>
				<td><input id="cCalle" name="cCalle" type="text" size="60"
					placeholder="Calle" value="<c:out value="${ctCompania.cCalle}" />">
				</td>
			</tr>

			<tr>
				<td><label for="cNExterior">Num Exterior</label></td>
				<td><input id="cNExterior" name="cNExterior" type="text"
					value="<c:out value="${ctCompania.cNExterior}" />"
					placeholder="Num Exterior"></td>
			</tr>


			<tr>
				<td><label for="cNInterior">Num Interior</label></td>
				<td><input id="cNInterior" name="cNInterior" type="text"
					value="<c:out value="${ctCompania.cNInterior}" />"
					placeholder="Num Interior"></td>
			</tr>

			<tr>
				<td><label for="cColonia">Colonia</label></td>
				<td><input id="cColonia" name="cColonia" type="text"
					placeholder="Colonia"
					value="<c:out value="${ctCompania.cColonia}" />"></td>
			</tr>

			<tr>
				<td><label for="cMpioDeleg">Deleg /Mpio</label></td>
				<td><input id="cMpioDeleg" name="cMpioDeleg" type="text"
					value="<c:out value="${ctCompania.cMpioDeleg}" />"
					placeholder="Deleg/Mpio"></td>
			</tr>

			<tr>
				<td><label for="iCP">Codigo Postal</label></td>
				<td><input id="iCP" name="iCP" type="text" placeholder="CP"
					value="<c:out value="${ctCompania.iCP}" />"></td>
			</tr>

			<tr>
				<td><label for="cCiudad">Ciudad</label></td>
				<td><input id="cCiudad" name="cCiudad" type="text"
					placeholder="Ciudad"
					value="<c:out value="${ctCompania.cCiudad}" />"></td>
			</tr>

			<tr>
				<td><label for="cEstado">Estado</label></td>
				<td><input id="cEstado" name="cEstado" type="text"
					placeholder="Estado"
					value="<c:out value="${ctCompania.cEstado}" />"></td>
			<tr>
				<td><label for="cTelefono">Telefono</label></td>
				<td><input id="cTelefono" name="cTelefono" type="text"
					placeholder="Telefono"
					value="<c:out value="${ctCompania.cTelefono}" />"></td>
			</tr>


			<tr>
				<td><label for="cEmail">Email</label></td>
				<td><input id="cEmail" name="cEmail" type="text" size="40"
					placeholder="E Mail" value="<c:out value="${ctCompania.cEmail}" />"></td>
			</tr>


			<tr>
				<td><label for="cContacto">Contacto</label></td>
				<td><input id="cContacto" name="cContacto" type="text" size="40"
					placeholder="Contacto"
					value="<c:out value="${ctCompania.cContacto}" />"></td>
			</tr>


			<tr>
				<td><label for="cPais">Pais</label></td>
				<td><input id="cPais" name="cPais" type="text"
					placeholder="Pais" value="<c:out value="${ctCompania.cPais}" />"></td>
			</tr>

			<%
				if (action.equals("update")) {
			%>

			<tr>
				<td><label for="lActivo">Activo?</label></td>
				<td><input type="radio" name="lActivo" value="true"
					${ctCompania.lActivo ? 'checked':''}> SI</td>
					
				<td><input type="radio" name="lActivo" value="false"
					${not ctCompania.lActivo ? 'checked':''}> NO</td>



			</tr>

			<%
				}
			%>


		</table>
	</fieldset>

</form>

