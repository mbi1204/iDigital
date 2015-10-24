/**
 * 
 */


function add_ctPuesto() {

	$.get("ctPuestoCtrl?action=add", function(result) {
		$("#ctPuesto_Dialog").html(result);
		$('#ctPuesto_Dialog').dialog("option", "title", 'Agregar Puesto');
		$("#ctPuesto_Dialog").dialog('open');
	});

}

function update_ctPuesto(iPuesto) {

	$.get("ctPuestoCtrl?action=update&iPuesto=" + iPuesto, function(result) {
		$("#ctPuesto_Dialog").html(result);
		$('#ctPuesto_Dialog').dialog("option", "title", 'Editar Puesto');
		$("#ctPuesto_Dialog").dialog('open');
	});

}

function resetDialog(form) {

}

$(document).ready(function() {

	$('#ctPuesto_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#ctPuesto_Form').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#ctPuesto_Form'));
			$(this).dialog('close');
		}
	});

});