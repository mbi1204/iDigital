
function add_ctUsuario() {

	$.get("ctUsuarioCtrl?action=add", function(result) {
		$("#ctUsuario_Dialog").html(result);
		$('#ctUsuario_Dialog').dialog("option", "title", 'Agregar Usuario');
		$("#ctUsuario_Dialog").dialog('open');
	});

}

function update_ctUsuario(cUsuario) {

	$.get("ctUsuarioCtrl?action=update&cUsuario=" + cUsuario, function(result) {
		$("#ctUsuario_Dialog").html(result);
		$('#ctUsuario_Dialog').dialog("option", "title", 'Editar Usuario');
		$("#ctUsuario_Dialog").dialog('open');
	});

}


function resetDialog(form) {

}

$(document).ready(function() {

	$('#ctUsuario_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Guardar" : function() {
				$('#ctUsuario_Form').submit();
			},
			"Cancelar" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#ctUsuario_Form'));
			$(this).dialog('close');
		}
	});

});



