
function add_ctUsuario() {
	
	var cCveCia = $('#cCompania').val();
	
	$.get("syConfigUsuCtrl?action=list_Usu&cCveCia=" + cCveCia, function(result) {
		$("#addUsuComp_Dialog").html(result);
		$('#addUsuComp_Dialog').dialog("option", "title", 'Agregar Usuario');
		$('#addUsuComp_Dialog').dialog('open');
	});
	
} 

function resetDialog(form) {

}

$(document).ready(function() {
	
	

	$('#addUsuComp_Dialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Agregar" : function() {
				$('#AddUsuComp_Form').submit();
			},
			"Cancelar" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#AddUsuComp_Form'));
			$(this).dialog('close');
		}
	});
	
	
	$('#table_ctUsuario').on('dblclick','tr',function() {
		alert ("entro al doble");
		
	});

});

