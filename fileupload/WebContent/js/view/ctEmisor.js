function add_ctEmisor() {
		$.get("ctEmisorCtrl?action=add", function(result) {
		$("#ctEmisor_Dialog").html(result);
		$('#ctEmisor_Dialog').dialog("option", "title", 'Agregar Emisor');
		$("#ctEmisor_Dialog").dialog('open');
	});
}


function update_ctEmisor(cCveCia) {

	$.get("ctEmisorCtrl?action=update&cCveCia=" + cCveCia, function(result) {
		$("#ctEmisor_Dialog").html(result);
		$('#ctEmisor_Dialog').dialog("option", "title", 'Editar Emisor');
		$("#ctEmisor_Dialog").dialog('open');
	});

}

function resetDialog(form) {

}

$(document).ready(function() {

	$('#ctEmisor_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#ctEmisor_Form').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#ctEmisor_Form'));
			$(this).dialog('close');
		}
	});

});