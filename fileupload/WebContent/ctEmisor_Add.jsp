<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String action = request.getParameter("action");

	if (action.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="ctEmisorCtrl?action=update" />
<%
	} else {
%>
<c:url var="actionUrl" value="ctEmisorCtrl?action=add" />

<%
	}
%>

<form id="ctEmisor_Form" class="pure-form pure-form-aligned" 
method="post" action="${actionUrl}" >

	<fieldset>
		<legend></legend>
		<table>

			<tr>
				<td><label for="iEmisor">Clave</label></td>

				<%
				System.out.println("Entro a la vista");
					if (action.equals("update")) {
						System.out.println("ento al update");
				%>

				<td><input id="iEmisor" name="iEmisor" type="text"
					maxlength="15" value="<c:out value="${ctEmisor.iEmisor}" />"
					placeholder="Clave del Emisor" readonly="readonly"></td>

				<%
					} else {

						System.out.println("ento al otro caso");
				%>
				<td><input id="iEmisor" name="iEmisor" type="text"
					maxlength="15" value="<c:out value="${ctEmisor.iEmisor}" />"
					placeholder="Clave del Emisor"></td>
				<%
					}
				%>

			</tr>
			
			<tr>
			<td><label for="cCveCia">Clave Compañia</label></td>
			<td><input id="cCveCia" name="cCveCia" type="text"
					maxlength="15" value="${ctEmisor.cCveCia}" placeholder="Clave de la compañia"></td>
			</tr>

			<tr>
				<td><label for="cRazonSocial">Razon Social</label></td>
				<td><input id="cRazonSocial" name="cRazonSocial" type="text"
					placeholder="Razon Social"
					value="<c:out value="${ctEmisor.cRazonSocial}" />"></td>
			</tr>

			<tr>
				<td><label for="cRFC">RFC</label></td>
				<td><input id="cRFC" name="cRFC" type="text" placeholder="RFC"
					value="<c:out value="${ctEmisor.cRFC}" />"></td>
			</tr>

			<tr>
				<td><label for="cCURP">CURP</label></td>
				<td><input id="cCURP" name="cCURP" type="text"
					placeholder="Calle" value="<c:out value="${ctEmisor.cCURP}" />">
				</td>
			</tr>

			<tr>
				<td><label for="cCalle">Calle</label></td>
				<td><input id="cCalle" name="cCalle" type="text"
					value="<c:out value="${ctEmisor.cCalle}" />"
					placeholder="Num Exterior"></td>
			</tr>
			
			<tr>
				<td><label for="cNumeroExterior">Numero exterior</label></td>
				<td><input id="cNumeroExterior" name="cNumeroExterior" type="text"
					placeholder="Colonia"
					value="<c:out value="${ctEmisor.cNumeroExterior}" />"></td>
			</tr>
			
			<tr>
				<td><label for="cNumeroInterior">Numero Interior</label></td>
				<td><input id="cNumeroInterior" name="cNumeroInterior" type="text"
					value="<c:out value="${ctEmisor.cNumeroInterior}" />"
					placeholder="Num Interior"></td>
			</tr>

			<tr>
				<td><label for="cMpioDelg">Deleg /Mpio</label></td>
				<td><input id="cMpioDelg" name="cMpioDelg" type="text"
					value="<c:out value="${ctEmisor.cMpioDelg}" />"
					placeholder="Deleg/Mpio"></td>
			</tr>
			
			<tr>
				<td><label for="cEmail">Email</label></td>
				<td><input id="cEmail" name="cEmail" type="text"
					value="<c:out value="${ctEmisor.cEmail}" />"
					placeholder="E mail"></td>
			</tr>
			
			<tr>
				<td><label for="cPais">Pais</label></td>
				<td><input id="cPais" name="cPais" type="text"
					placeholder="Pais"
					value="<c:out value="${ctEmisor.cPais}" />"></td>
			</tr>
			
			<tr>
				<td><label for="cEstado">Estado</label></td>
				<td><input id="cEstado" name="cEstado" type="text"
					placeholder="Estado"
					value="<c:out value="${ctEmisor.cEstado}" />"></td>
			</tr>
			
			<tr>
				<td><label for="cCP">Codigo Postal</label></td>
				<td><input id="cCP" name="cCP" type="text" placeholder="CP"
					value="<c:out value="${ctEmisor.cCP}" />"></td>
			</tr>

			<tr>
				<td><label for="dtFechaAlta">Fecha alta</label></td>
				<td><input id="dtFechaAlta" name="dtFechaAlta" type="text"
					placeholder="Fecha de alta"
					value="<c:out value="${ctEmisor.dtFechaAlta}" />"></td>
			</tr>


			<tr>
				<td><label for="dtFechaCancel">Fecha baja</label></td>
				<td><input id="dtFechaCancel" name="dtFechaCancel" type="text"
					placeholder="Fecha de baja" value="<c:out value="${ctEmisor.dtFechaCancel}" />"></td>
			</tr>

			<tr>

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

			<tr>
				<td><label for="cAlias">Alias</label></td>
				<td><input id="cAlias" name="cAlias" type="text"
					placeholder="Alias"
					value="<c:out value="${ctEmisor.cAlias}" />"></td>
			</tr>			

		</table>

	</fieldset>

</form>