
function add_ctUsuario() {
	
	var cCveCia = $('#cCompania').val();
	
	$.get('syConfigUsuCtrl?action=list_Usu&cCveCia=' + cCveCia, function(result) {
		$('#addUsuComp_Dialog').html(result);
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

function compania(){
	var cCveCia = $('#cCompania').val();
	var url = 'syConfigUsuCtrl?action=inicial&cCveCia=' + cCveCia;
	
	$(document).ready(function() {
		$.ajaxSetup({ cache: false }); 
		$("#tablaCompania").load(url);
		console.log("Estoy actualizando la tabla");
	});
}

function valor_Menu(){
	window.location = "syConfigUsuCtrl?action=inicial&cCveCia=" + $('#cCompania').val();
}

function carga_ctMenu(cCveCia) {

	var errorInfo;

	$.ajax({
		
		type : "GET",
		url : "syConfigUsuCtrl?action=inicial",
		data: 'cCveCia='+$('#cCompania').val(),
		
		success : function(data) {
			console.log("Entra Si funciona :)");
			console.log(data);
			
		},
		error : function() {
			console.log("erro al ejecutar el BuscaMenu");
		}

	});
	window.location = "syConfigUsuCtrl?action=inicial&cCveCia=" + $('#cCompania').val();
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
	
	$('#btn-toggle tbody tr').dblclick(function(){
		$('.seccionToggle').slideToggle();
		$(this).find('td:eq(1)').each(function () {
			 //obtenemos el valor de la celda
			 cUsuario = $(this).html();
			 $.get("syConfigUsuCtrl?action=inicial&cUsuario=" + cUsuario, function(result) {});
			})
		});

});

