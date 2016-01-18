<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%

	String action3 = request.getParameter("action");
	
	if (action3.equalsIgnoreCase("updatePrograma")) {
%>
<c:url var="actionUrl" value="syConfigUsuCtrl?action=updatePrograma" />
<%
	} else {
%>
<c:url var="actionUrl"
	value="syConfigUsuCtrl?action=addPrograma" />

<%
	}
%>

<form id="AddUsuPrograma_Form" class="pure-form pure-form-aligned"
	method="post" action="${actionUrl}">

	<fieldset>

		<legend></legend>
		<table id="table_ctPrograma">
			<thead>
				<tr>
					<th width="25">Programa</th>
					<%
							if (action3.equals("updatePrograma")) {
					%>
					<th width="25">Activo</th>
					<%
								}else{
					%>
					<th width="25">Seleccionar</th>
					<%
								}
					%>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list_UsuMenu}" var="ctPrograma">
					<tr>
						<td id="cMenu"><c:out value="${ctPrograma.cMenu}" /></td>
						
						<%
							if (action3.equals("updatePrograma")) {
						%>
						<td><input type="radio" id="lActivo" name="lActivo" value="true"
							${ctPrograma.lActivo ? 'checked':''}> SI</td>
		
						<td><input type="radio" id="lActivo" name="lActivo" value="false"
							${not ctPrograma.lActivo ? 'checked':''}> NO</td>
						
						<td><input type="hidden" id ="iMenu" name="iMenu" value="${ctPrograma.iMenu}"></td>
						<%
								} else{
						%>
						<td><input type="checkbox" id ="iMenus" name="iMenus" value="${ctPrograma.iMenu}"></td>
						<%
								}
						%>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</fieldset>

</form>