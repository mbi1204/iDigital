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
				<td><label for="cColonia">Colonia</label></td>
				<td><input id="cColonia" name="cColonia" type="text" placeholder="Colonia"></td>
			</tr>

			<tr>
				<td><label for="cMpioDeleg">Deleg /Mpio</label></td>
				<td><input id="cMpioDeleg" name="cMpioDeleg" type="text"
					placeholder="Deleg/Mpio"></td>
			</tr>

			<tr>
				<td><label for="iCP">Codigo Postal</label></td>
				<td><input id="iCP"  name="iCP" type="text" placeholder="CP"></td>
			</tr>

			<tr>
				<td><label for="cCiudad">Ciudad</label></td>
				<td><input id="cCiudad" name="cCiudad" type="text" placeholder="Ciudad"></td>
			</tr>

			<tr>
				<td><label for="cEstado">Estado</label></td>
				<td><input id="cEstado" name="cEstado" type="text" placeholder="Estado"></td>
			<tr>
				<td><label for="cTelefono">Telefono</label></td>
				<td><input id="cTelefono" name="cTelefono" type="text" placeholder="Telefono"></td>
			</tr>


			<tr>
				<td><label for="cEmail">Email</label></td>
				<td><input id="cEmail"  name="cEmail" type="text" placeholder="E Mail"></td>
			</tr>


			<tr>
				<td><label for="cContacto">Contacto</label></td>
				<td><input id="cContacto" name="cContacto" type="text" placeholder="Contacto"></td>
			</tr>


			<tr>
				<td><label for="cPais">Pais</label></td>
				<td><input id="cPais" name="cPais" type="text" placeholder="Pais"></td>



			<tr>
				<td><label for="lActivo">Activo?</label></td>
				<td><input id="lActivo" name="lActivo" type="text" placeholder="lActivo"></td>
			</tr>


		</table>


	</fieldset>


</form>

