/**
 * 
 */

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
		$('#ctPrograma_Dialog').dialog("option", "title", 'Editar Menu');
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
			"Save" : function() {
				$('#ctPrograma_Form').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#ctPrograma_Form'));
			$(this).dialog('close');
		}
	});

});