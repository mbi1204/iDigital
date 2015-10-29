<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String action = request.getParameter("action");

	if (action.equalsIgnoreCase("update")) {
%>
<c:url var="actionUrl" value="ctUsuarioCtrl?action=update" />
<%
	} else {
%>
<c:url var="actionUrl" value="ctUsuarioCtrl?action=add" />

<%
	}
%>

	

<form id="ctUsuario_Form" class="pure-form pure-form-aligned" method="post" action="${actionUrl}" >

	<fieldset>
		<legend></legend>
		<table>

			<tr>
				<td><label for="cUsuario">Usuario</label></td>
				<%
					if (action.equals("update")) {
				%>

				<td><input id="cUsuario" name="cUsuario" type="text"
					maxlength="15" placeholder="Usuario" value="<c:out value="${ctUsuario.cUsuario}" />" readonly="readonly" ></td>

				<%
					} else {

						System.out.println("ento al otro caso");
				%>
				<td><input id="cUsuario" name="cUsuario" type="text"
					maxlength="15" placeholder="Usuario"></td>
				<%
					}
				%>
				
			</tr>

			<tr>
				<td><label for="cNombre">Nombre</label></td>
				<td><input id="cNombre" name="cNombre" type="text"
					placeholder="Nombre" value="<c:out value="${ctUsuario.cNombre}" />"></td>
			</tr>

			<tr>
				<td><label for="cPassword">Password</label></td>
				<td><input id="cPassword" name="cPassword" type="password"
					placeholder="Password" value="<c:out value="${ctUsuario.cPassword}" />"></td>
			</tr>

			

			<!-- <tr>
				<td><label for="dtFechaAlta">Fecha de Alta</label></td>
				<td><input id="dtFechaAlta" name="dtFechaAlta" type="date" 
					 value="<c:out value="${ctUsuario.dtFechaAlta}" />" placeholder="Fecha de Alta" 
					></td>
			</tr>
			 -->
			

			 <tr>
				<td><label for="iPuesto">Puesto</label></td>
				<td><input id="iPuesto" name="iPuesto" type="text"
					placeholder="Puesto" value="<c:out value="${ctUsuario.iPuesto}" />"></td>
			</tr>
			
			
			<!-- <tr>
				<td><label for="iPuesto">Puesto</label></td>
				<td><select id="iPuesto" items="${lista_ctPuesto}" itemValue="iPuesto" itemLabel="cPuesto" /></td>
			</tr>
				 -->
			<%
				if (action.equals("update")) {
			%>

			<tr>
				<td><label for="lActivo">Activo?</label></td>
				<td><input type="radio" name="lActivo" value="true"
					${ctUsuario.lActivo ? 'checked':''}> SI</td>
					
				<td><input type="radio" name="lActivo" value="false"
					${not ctUsuario.lActivo ? 'checked':''}> NO</td>


			</tr>

			<%
				}
			%>


		</table>


	</fieldset>


</form>