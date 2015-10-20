<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="ctUsuarioCtrl?action=add" />

<form id="ctUsuario_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

		<fieldset>
				<legend></legend>
				<table>
		
					<tr>
						<td><label for="cUsuario">Usuario</label></td>
						<td><input id="cUsuario" name="cUsuario" type="text" maxlength="15"
							placeholder="Usuario"></td>
					</tr>
		
					<tr>
						<td><label for="cNombre">Nombre</label></td>
						<td><input id="cNombre" name="cNombre" type="text" placeholder="Nombre">
						</td>
					</tr>
		
					<tr>
						<td><label for="cPassword">Password</label></td>
						<td><input id="cPassword" name="cPassword" type="text" placeholder="Password"></td>
					</tr>
		
					<tr>
						<td><label for="lActivo">Activo?</label></td>
						<td><input id="lActivo" name="lActivo" type="text" placeholder="Activo">
						</td>
					</tr>
		
					<tr>
						<td><label for="dtFechaAlta">Fecha de Alta</label></td>
						<td><input id="dtFechaAlta" name="dtFechaAlta" type="date"
							placeholder="Fecha de Alta"></td>
					</tr>
		
		
					<tr>
						<td><label for="iPuesto">Puesto</label></td>
						<td><input id="iPuesto" name="iPuesto" type="text"
							placeholder="Puesto"></td>
					</tr>
		
					
					</table>
		
		
			</fieldset>
		

</form>