<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="ctPuestoCtrl?action=add" />

<form id="ctPuesto_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

		<fieldset>
				<legend></legend>
				<table>
		
					<tr>
						<td><label for="iPuesto">Id Puesto</label></td>
						<td><input id="iPuesto" name="iPuesto" type="text" maxlength="15"
							placeholder="ID Puesto"></td>
					</tr>
		
					<tr>
						<td><label for="cPuesto">Puesto</label></td>
						<td><input id="cPuesto" name="cPuesto" type="text" placeholder="Puesto">
						</td>
					</tr>
		
					<tr>
						<td><label for="lActivo">Activo?</label></td>
						<td><input id="lActivo" name="lActivo" type="text" placeholder="Activo"></td>
					</tr>
		
										
					</table>
		
		
			</fieldset>
		

</form>