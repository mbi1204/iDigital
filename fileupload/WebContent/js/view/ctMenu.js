/**
 * 
 */
function add_ctMenu() {

	$.get("ctMenuCtrl?action=add", function(result) {
		$("#ctMenu_Dialog").html(result);
		$('#ctMenu_Dialog').dialog("option", "title", 'Agregar Menu');
		$("#ctMenu_Dialog").dialog('open');
	});

}

function update_ctMenu(iMenu) {
	$.get("ctMenuCtrl?action=update&iMenu=" + iMenu, function(result) {
		$("#ctMenu_Dialog").html(result);
		$('#ctMenu_Dialog').dialog("option", "title", 'Editar Menu');
		$("#ctMenu_Dialog").dialog('open');
		
	});

}

function resetDialog(form) {

}

$(document).ready(function() {

	$('#ctMenu_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#ctMenu_Form').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#ctMenu_Form'));
			$(this).dialog('close');
		}
	});

});