function add_ctPrograma() {
		$.get("ctProgramaCtrl?action=add", function(result) {
		$("#ctPrograma_Dialog").html(result);
		$('#ctPrograma_Dialog').dialog("option", "title", 'Agregar Programa');
		$("#ctPrograma_Dialog").dialog('open');
	});
}


function update_ctPrograma(iMenu,iPrograma) {

	$.get("ctProgramaCtrl?action=update&iMenu=" + iMenu+"&iPrograma="+iPrograma, function(result) {
		$("#ctPrograma_Dialog").html(result);
		$('#ctPrograma_Dialog').dialog("option", "title", 'Editar Programa');
		$("#ctPrograma_Dialog").dialog('open');
	});

}

function resetDialog(form) {

}

$(document).ready(function() {

	$('#ctPrograma_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Guardar" : function() {
				$('#ctPrograma_Form').submit();
			},
			"Cancelar" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#ctPrograma_Form'));
			$(this).dialog('close');
		}
	});

});