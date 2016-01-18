
function add_ctMenu() {
	
	$.get("syConfigUsuCtrl?action=list_Menu", function(result) {
		$("#addUsuMenu_Dialog").html(result);
		$('#addUsuMenu_Dialog').dialog("option", "title", 'Agregar Menu');
		$('#addUsuMenu_Dialog').dialog('open');
	});
	
} 


function update_sysUsuMenu(cUsuario,iMenu) {
	
	

	$.get("syConfigUsuCtrl?action=updateMenu&cUsuario=" + cUsuario + "&iMenu="+iMenu, function(result) {
		$("#addUsuMenu_Dialog").html(result);		
		$('#addUsuMenu_Dialog').dialog("option", "title", 'Editar Menu');
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
	
	
$('.seccionTogglePrograma').hide();

$('#menu tbody tr').hover( function(){
	$(this).find('td').addClass('hover');
	},
	function(){
	$(this).find('td').removeClass('hover');
	}
	);

$('#menu tbody tr').dblclick(function(){
	$('.seccionTogglePrograma').slideToggle();
	$(this).find('td:eq(0)').each(function () {
		 //obtenemos el valor de la celda
		 cUsuario = $(this).html();
		})
		
	$(this).find('td:eq(1)').each(function () {
		 //obtenemos el valor de la celda
		 iMenu = $(this).html();
		})
		$.get("syConfigUsuCtrl?action=inicial&cUsuario=" + cUsuario+"&iMenu="+iMenu, function(result) {});
	});

});
