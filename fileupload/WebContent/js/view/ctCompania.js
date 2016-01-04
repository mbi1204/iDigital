/**
 * 
 */

function add_ctCompania() {

	$.get("ctCompaniaCtrl?action=add", function(result) {
		$("#ctCompania_Dialog").html(result);
		$('#ctCompania_Dialog').dialog("option", "title", 'Agregar Compañia');
		$("#ctCompania_Dialog").dialog('open');
	});

}

function update_ctCompania(cCveCia) {

	$.get("ctCompaniaCtrl?action=update&cCveCia=" + cCveCia, function(result) {
		$("#ctCompania_Dialog").html(result);
		$('#ctCompania_Dialog').dialog("option", "title", 'Editar Compañia');
		$("#ctCompania_Dialog").dialog('open');
	});

}

function resetDialog(form) {

}

$(document).ready(function() {

	$('#ctCompania_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 800,
		buttons : {
			"Save" : function() {
				$('#ctCompania_Form').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#ctCompania_Form'));
			$(this).dialog('close');
		}
	});

});