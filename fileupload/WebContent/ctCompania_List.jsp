<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript"
	src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>

</head>
<body>

	<table id="dg" title="Compañias" class="easyui-datagrid"
		style="width: 2000px; height: 550px" toolbar="#toolbar"
		pagination="false" rownumbers="true" fitColumns="true"
		singleSelect="true"		   >
		<thead>
			<tr>
				<th field="cCveCia" width="20">Compañia</th>
				<th field="cRazonS" width="30">Razon Social</th>
				<th field="cCalle" width="20">Calle</th>
				<th field="cNExterior" width="6">Num Ext</th>
				<th field="cNInterior" width="6">Num Int</th>
				<th field="cColonia" width="20">Colonia</th>
				<th field="cMpioDeleg" width="20">Municipio</th>
				<th field="iCP" width="8">CP</th>
				<th field="cCiudad" width="15">Ciudad</th>
				<th field="cEstado" width="14">Estado</th>
				<th field="cTelefono" width="20">Telefono</th>
				<th field="cEmail" width="20">Email</th>
				<th field="cContacto" width="20">Contacto</th>
				<th field="cPais" width="10">Pais</th>
				<th field="lActivo" width="10">Activa?</th>


			</tr>			
		</thead>
		
		<tbody>

			<c:forEach items="${lista_ctCompania}" var="ctCompania">
			 <tr>

				<td><c:out value="${ctCompania.cCveCia}" /></td>
				<td><c:out value="${ctCompania.cRazonS}" /></td>
				<td><c:out value="${ctCompania.cCalle}" /></td>
				<td><c:out value="${ctCompania.cNExterior}" /></td>
				<td><c:out value="${ctCompania.cNInterior}" /></td>
				<td><c:out value="${ctCompania.cColonia}" /></td>
				<td><c:out value="${ctCompania.cMpioDeleg}" /></td>
				<td><c:out value="${ctCompania.iCP}" /></td>
				<td><c:out value="${ctCompania.cCiudad}" /></td>
				<td><c:out value="${ctCompania.cEstado}" /></td>
				<td><c:out value="${ctCompania.cTelefono}" /></td>
				<td><c:out value="${ctCompania.cEmail}" /></td>
				<td><c:out value="${ctCompania.cContacto}" /></td>
				<td><c:out value="${ctCompania.cPais}" /></td>
				<td><c:out value="${ctCompania.lActivo}" /></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>

	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true" onclick="NewCompania()">Nueva Compañia</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-edit" plain="true" onclick="editUser()">Editar Compañia</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" onclick="destroyUser()">Eliminar compañia</a>
	</div>



	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 600px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">Compañia</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>Compañia:</label> <input name="cCveCia"
					class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>Razon Social:</label> <input name="cRazonS"
					class="easyui-textbox" required="true">
			</div>
			<div class="fitem">
				<label>Calle:</label> <input name="cCalle" class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>Num Exterior:</label> <input name="cNExterior"
					class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>Num Interior:</label> <input name="cNInterior"
					class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>Colonia:</label> <input name="cColonia"
					class="easyui-textbox">
			</div>

			<div class="fitem">
				<label>Delegacion / Municipio:</label> <input name="cMpioDeleg"
					class="easyui-textbox">
			</div>

			<div class="fitem">
				<label> CP:</label> <input name="iCP" class="easyui-textbox">
			</div>

			<div class="fitem">
				<label>Ciudad:</label> <input name="cCiudad" class="easyui-textbox">
			</div>


			<div class="fitem">
				<label>Estado:</label> <input name="cEstado" class="easyui-textbox">
			</div>

			<div class="fitem">
				<label>Telefono:</label> <input name="cTelefono"
					class="easyui-textbox">
			</div>


			<div class="fitem">
				<label>cEmail:</label> <input name="cEmail" class="easyui-textbox">
			</div>


			<div class="fitem">
				<label>Contacto:</label> <input name="cContacto"
					class="easyui-textbox">
			</div>

			<div class="fitem">
				<label>Pais:</label> <input name="cPais" class="easyui-textbox">
			</div>
			
				<div class="fitem">
				<label>Activo:</label> <input name="lActivo" class="easyui-textbox">
			</div>



		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="saveUser()" style="width: 90px">Save</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width: 90px">Cancel</a>
	</div>

	<script type="text/javascript">
		var url;
		function NewCompania() {			
			
			$('#dlg').dialog('open').dialog('center').dialog('setTitle',
					'Nueva Compañia');
			$('#fm').form('clear');
			url = 'ctCompaniaCtrl?action=add';
		}
		
		function editUser() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('center').dialog('setTitle',
						'Edit User');
				$('#fm').form('load', row);											
				url = 'ctCompaniaCtrl?action=edit';
			}
		}
		function saveUser() {
			$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
				
					
				alert("salio del suseso");	
				
					var result = eval('(' + result + ')');
					if (result.errorMsg) {
						alert ("aqui voy error");
						
						
						$.messager.show({
							title : 'Error',
							msg : result.errorMsg
						});
					} else {
						alert ("aqui voy corecto");
						
						$('#dlg').dialog('close'); // close the dialog
						$('#dg').datagrid('reload'); // reload the user data
					}
				}
				
				
				
			});
			
			$('#dlg').dialog('close'); // close the dialog
			$('#dg').datagrid('reload'); // reload the user data
		}
		function destroyUser() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm',
						'Are you sure you want to destroy this user?',
						function(r) {
							if (r) {
								$.post('destroy_user.php', {
									id : row.id
								}, function(result) {
									if (result.success) {
										$('#dg').datagrid('reload'); // reload the user data
									} else {
										$.messager.show({ // show error message
											title : 'Error',
											msg : result.errorMsg
										});
									}
								}, 'json');
							}
						});
			}
		}
	</script>
	
	
	<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>


</body>
</html>