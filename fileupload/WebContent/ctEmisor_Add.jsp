<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="ctEmisorCtrl?action=add" />

<form id="ctEmisor_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

	<fieldset>
		<legend></legend>
		<table>

			<tr>
				<td><label for="iEmisor">Emisor</label></td>
				<td><input id="iEmisor" name="iEmisor" type="text" maxlength="15"
					placeholder="Id Emisor"></td>
			</tr>

			<tr>
				<td><label for="cCveCia">CveCia</label></td>
				<td><input id="cCveCia" name="cCveCia" type="text" placeholder="CveCia">
				</td>
			</tr>

			<tr>
				<td><label for="cRazonSocial">Razon Social</label></td>
				<td><input id="cRazonSocial" name="cRazonSocial" type="text" placeholder="Razon Social"></td>
			</tr>

			<tr>
				<td><label for="cRFC">RFC</label></td>
				<td><input id="cRFC" name="cRFC" type="text" placeholder="RFC">
				</td>
			</tr>

			<tr>
				<td><label for="cCURP">Curp</label></td>
				<td><input id=cCURP name="cCURP" type="text"
					placeholder="cCURP"></td>
			</tr>


			<tr>
				<td><label for="cCalle">Calle</label></td>
				<td><input id="cCalle" name="cCalle" type="text"
					placeholder="Calle"></td>
			</tr>

			<tr>
				<td><label for="cNumeroInterior">Num. Interior</label></td>
				<td><input id="cNumeroInterior" name="cNumeroInterior" type="text" placeholder="NumeroInterior"></td>
			</tr>
			
			<tr>
				<td><label for="cNumeroExterior">Num. Exterior</label></td>
				<td><input id="cNumeroExterior" name="cNumeroExterior" type="text" placeholder="NumeroExterior"></td>
			</tr>

			<tr>
				<td><label for="cMpioDelg">Deleg /Mpio</label></td>
				<td><input id="cMpioDelg" name="cMpioDelg" type="text"
					placeholder="MpioDelg"></td>
			</tr>
			
			<tr>
				<td><label for="cEmail">Email</label></td>
				<td><input id="cEmail"  name="cEmail" type="text" placeholder="E Mail"></td>
			</tr>
			
			<tr>
				<td><label for="cPais">Pais</label></td>
				<td><input id="cPais" name="cPais" type="text" placeholder="Pais"></td>
			<tr>
			
			<tr>
				<td><label for="cEstado">Estado</label></td>
				<td><input id="cEstado" name="cEstado" type="text" placeholder="Estado"></td>
			<tr>

			<tr>
				<td><label for="cCP">Codigo Postal</label></td>
				<td><input id="cCP"  name="cCP" type="text" placeholder="CP"></td>
			</tr>

			<tr>
				<td><label for="dtFechaAlta">Fecha de Alta</label></td>
				<td><input id="dtFechaAlta" name="dtFechaAlta" type="date" placeholder="Fecha de Alta"></td>
			</tr>

			
			<tr>
				<td><label for="dtFechaCancel">Fecha de Cancelar</label></td>
				<td><input id="dtFechaCancel" name="dtFechaCancel" type="date" placeholder="Fecha de Cancelar"></td>
			</tr>

			<tr>
				<td><label for="lActivo">Activo?</label></td>
				<td><input id="lActivo" name="lActivo" type="text" placeholder="lActivo"></td>
			</tr>
			
			<tr>
				<td><label for="cAlias">Alias</label></td>
				<td><input id="cAlias" name="cAlias" type="text" placeholder="Alias"></td>
			</tr>

		</table>

	</fieldset>

</form>