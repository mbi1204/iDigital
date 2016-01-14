
function add_ctMenu() {
	
	$.get("syConfigUsuCtrl?action=list_Menu", function(result) {
		$("#addUsuMenu_Dialog").html(result);
		$('#addUsuMenu_Dialog').dialog("option", "title", 'Agregar Menu');
		$('#addUsuMenu_Dialog').dialog('open');
	});
	
} 


function update_sysUsuMenu(cCveCia,cUsuario) {
	
	

	$.get("syConfigUsuCtrl?action=update&cCveCia=" + cCveCia+"&cUsuario="+cUsuario, function(result) {
		$("#addUsuMenu_Dialog").html(result);		
		$('#addUsuMenu_Dialog').dialog("option", "title", 'Editar Usuario');
		$("#addUsuMenu_Dialog").dialog('open');
	});

}

function resetDialog(form) {

}

$(document).ready(function() {
	
	

	$('#addUsuMenu_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Agregar" : function() {
				$('#AddUsuMenu_Form').submit();
			},
			"Cancelar" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#AddUsuMenu_Form'));
			$(this).dialog('close');
		}
	});
	
	
	$('#table_ctUsuario').on('dblclick','tr',function() {
		alert ("entro al doble");
		
	});

});
