<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="actionUrl" value="ctProgramaCtrl?action=add" />

<form id="ctPrograma_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

	<fieldset>
		<legend></legend>
		<table>

			<tr>
				<td><label for="iPrograma">ID Programa</label></td>
				<td><input id="iPrograma" name="iPrograma" type="text" maxlength="15"
					placeholder="Clave del programa"></td>
			</tr>

			<tr>
				<td><label for="iMenu">ID Menu</label></td>
				<td><input id="iMenu" name="iMenu" type="text" placeholder="Clave del menu">
				</td>
			</tr>

			<tr>
				<td><label for="cPrograma">Programa</label></td>
				<td><input id="cPrograma" name="cPrograma" type="text" placeholder="Nombre del programa"></td>
			</tr>

			<tr>
				<td><label for="lActivo">Estatus</label></td>
				<td><input id="lActivo" name="lActivo" type="text" placeholder="Estatus">
				</td>
			</tr>

			<tr>
				<td><label for="cNombre">Nombre</label></td>
				<td><input id="cNombre" name="cNombre" type="text"
					placeholder="Nombre"></td>
			</tr>


		</table>


	</fieldset>


</form>