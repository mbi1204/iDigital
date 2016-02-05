
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
	 $.get("Configuracion", function(responseJson) {          
	        var $table = $("<table>").appendTo($(".class"));
	        $.each(responseJson, function(index, list_UsuCompania) {   
	            $("<tr>").appendTo($table)                    
	                .append($("<td>").text(list_UsuCompania.cCveCia))       
	                .append($("<td>").text(list_UsuCompania.cUsuario))     
	                .append($("<td>").text(list_UsuCompania.lActivo));  
	        });
	    });
}

function valor_Menu(){
	window.location = "syConfigUsuCtrl?action=inicial&cCveCia=" + $('#cCompania').val();
}

function carga_ctMenu() {

	var errorInfo;

	$.ajax({
		
		type : "GET",
		url : "syConfigUsuCtrl?action=inicial&",
		data: {
            cCveCia : $('#cCompania').val()
        },
		success : function(responseText) {
			console.log("Entra Si funciona :)");
			console.log(responseText);
			
			$("#btn-toggle > tbody").empty();
			
			for ( var item in responseText) {
				$('#btn-toggle > tbody').append(
						'<tr>' + '<td>' + responseText[item].cCveCia + '</td>' + '<td>'
								+ responseText[item].cUsuario + '</td>' + '<td>'
								+ responseText[item].lActivo + '</td>' + '<td><nobr>'

								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el usuario selecionado?'"
								+ ');" ' + 'href="javascript:remove_sysMenu('
								+ responseText[item].cCveCia + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'

								+ '</nobr></td>' + '</tr>');

			}
			
		},
		error : function() {
			console.log("erro al ejecutar el BuscaMenu");
		}

	});
	
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

