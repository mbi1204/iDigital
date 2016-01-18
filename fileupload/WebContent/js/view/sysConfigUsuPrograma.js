function add_ctPrograma() {
	
	$.get("syConfigUsuCtrl?action=list_Programa", function(result) {
		$("#addUsuPrograma_Dialog").html(result);
		$('#addUsuPrograma_Dialog').dialog("option", "title", 'Agregar Programa');
		$('#addUsuPrograma_Dialog').dialog('open');
	});
	
} 


function update_sysUsuPrograma(cUsuario,iMenu) {
	
	

	$.get("syConfigUsuCtrl?action=updatePrograma&cUsuario=" + cUsuario + "&iMenu="+iMenu, function(result) {
		$("#addUsuPrograma_Dialog").html(result);		
		$('#addUsuPrograma_Dialog').dialog("option", "title", 'Editar Programa');
		$("#addUsuPrograma_Dialog").dialog('open');
	});

}

function resetDialog(form) {

}

$(document).ready(function() {
	
	

	$('#addUsuPrograma_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Agregar" : function() {
				$('#AddUsuPrograma_Form').submit();
			},
			"Cancelar" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#AddUsuPrograma_Form'));
			$(this).dialog('close');
		}
	});

});