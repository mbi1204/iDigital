<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String action = request.getParameter("action");

	if (action.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="ctProgramaCtrl?action=update" />
<%
	} else {
%>
<c:url var="actionUrl" value="ctProgramaCtrl?action=add" />

<%
	}
%>

<form id="ctPrograma_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

	<fieldset>
		<legend></legend>
		<table>

			<tr>
				<td><label for="iPrograma">ID Programa</label></td>
				<%
					if (action.equals("update")) {
				%>

				<td><input id="iPrograma" name="iPrograma" type="text" maxlength="15" 
				value="<c:out value="${ctPrograma.iPrograma}" />"
					placeholder="Clave del programa" readonly="readonly"></td>

				<%
					} else {

						System.out.println("ento al otro caso");
				%>
				<td><input id="iPrograma" name="iPrograma" type="text" maxlength="15"
					placeholder="Clave del programa" ></td>
				<%
					}
				%>
				
			</tr>

			<tr>
				<td><label for="iMenu">ID Menu</label></td>
				<td><input id="iMenu" name="iMenu" type="text" placeholder="Clave del menu"
				value="<c:out value="${ctPrograma.iMenu}" />"
				placeholder="Clave del Menu" readonly="readonly">
				</td>
			</tr>

			<tr>
				<td><label for="cPrograma">Programa</label></td>
				<td><input id="cPrograma" name="cPrograma" type="text" placeholder="Nombre del programa"
				value="<c:out value="${ctPrograma.cPrograma}" />"></td>
			</tr>

			

			<tr>
				<td><label for="cNombre">Nombre</label></td>
				<td><input id="cNombre" name="cNombre" type="text"
					placeholder="Nombre" value="<c:out value="${ctPrograma.cNombre}" />"></td>
			</tr>
			
			<%
				if (action.equals("update")) {
			%>

			<tr>
				<td><label for="lActivo">Activo?</label></td>
				<td><input type="radio" name="lActivo" value="true"
					${ctPrograma.lActivo ? 'checked':''}> SI</td>
					
				<td><input type="radio" name="lActivo" value="false"
					${not ctPrograma.lActivo ? 'checked':''}> NO</td>


			</tr>

			<%
				}
			%>


		</table>


	</fieldset>


</form>