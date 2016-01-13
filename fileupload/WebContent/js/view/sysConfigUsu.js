
function add_ctUsuario() {
	
	var cCveCia = $('#cCompania').val();
	
	$.get("syConfigUsuCtrl?action=list_Usu&cCveCia=" + cCveCia, function(result) {
		$("#addUsuComp_Dialog").html(result);
		$('#addUsuComp_Dialog').dialog("option", "title", 'Agregar Usuario');
		$('#addUsuComp_Dialog').dialog('open');
	});
	
} 


function update_sysUsuCompania(cCveCia,cUsuario) {
	
	

	$.get("syConfigUsuCtrl?action=update&cCveCia=" + cCveCia+"&cUsuario="+cUsuario, function(result) {
		$("#addUsuComp_Dialog").html(result);		
		$('#addUsuComp_Dialog').dialog("option", "title", 'Editar Usuario');
		$("#addUsuComp_Dialog").dialog('open');
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
	
	$('.seccionToggle').hide();
	
	$('tbody tr').hover( function(){
		$(this).find('td').addClass('hover');
		},
		function(){
		$(this).find('td').removeClass('hover');
		}
		);

	$('tbody tr').dblclick(function(){
	$('.seccionToggle').slideToggle();
	$(this).find('td:eq(1)').each(function () {
		 
		 //obtenemos el valor de la celda
		 cUsuario = $(this).html();
		 
		 
		 $.get("syConfigUsuCtrl?action=inicial&cUsuario=" + cUsuario, function(result) {});
		})
	});

});

