<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="ctMenuCtrl?action=add" />

<form id="ctMenu_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

	<fieldset>
		<legend></legend>
		<table>

			<tr>
				<td><label for="iMenu">ID Programa</label></td>
				<td><input id="iMenu" name="iMenu" type="text" maxlength="15"
					placeholder="Clave del menu"></td>
			</tr>

			<tr>
				<td><label for="cMenu">Menu</label></td>
				<td><input id="cMenu" name="cMenu" type="text" placeholder="Menu">
				</td>
			</tr>

			<tr>
				<td><label for="lActivo">Estatus</label></td>
				<td><input id="lActivo" name="lActivo" type="text" placeholder="Estatus"></td>
			</tr>


		</table>


	</fieldset>


</form>