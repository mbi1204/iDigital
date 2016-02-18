
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


function carga_ctUsuario() {

	var errorInfo;

	$.ajax({
		
		type : "GET",
		url : "syConfigUsuCtrl",		
        contentType: "json",
		data: {
			action  : "arreglo" , 
            cCveCia : $('#cCompania').val(),            
        },
		success : function(data)  {			
			
			console.log("Entra Si funciona :)");
			console.log(data);
		

			
			$("#btn-toggle > tbody").empty();
			
			for ( var item in data) {
				$('#btn-toggle > tbody').append(
						'<tr>' + '<td>' + data[item].cCveCia + '</td>'  + 
								 '<td>' + data[item].cUsuario + '</td>' +
								 '<td>' + data[item].ctUsu.cNombre + '</td>' +
								 '<td>'	+ (data[item].lActivo   ? "Activo" : "Inactivo") + '</td>'  + '<td><nobr>'
								 
								+ '<a class="pure-button pure-button-primary"'
								+ 'href="javascript:remove_sysMenu('
								+ data[item].cCveCia + ' )"> <i'
								+ '	class="fa fa-pencil"></i>Editar' + '</a>'
								+ '</nobr>'


								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el usuario selecionado?'"
								+ ');" ' + 'href="javascript:remove_Usuario('
								+ data[item].cCveCia + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'

								+ '</nobr></td>' + '</tr>');

			}
			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
            alert("Status: " + textStatus); alert("Error: " + errorThrown);
        } 

	});
	
}


function submit_ctUsuario() {
	vcUsuario = $('#cUsuario').val();
	viMenu = $('#iIdMenu').val();

	$.ajax({
		type : "POST",
		url : "syConfigUsuCtrl",
		data : {
			action  : "delete" ,
			cUsuario : vcUsuario,
			iIdMenu : viMenu
		},

		success : function(data, textStatus, jqXHR) {
			$("#mytable > tbody").empty();
			for ( var item in data) {
				$('#mytable > tbody').append(
						'<tr>' + '<td>' + data[item].cCveCia + '</td>' + '<td>'
								+ data[item].cUsuario + '</td>' + '<td>'
								+ data[item].lActivo + '</td>' + '<td><nobr>'

								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el Menu selecionado?'"
								+ ');" ' + 'href="javascript:remove_sysMenu('
								+ data[item].iIdMenu + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'

								+ '</nobr></td>' + '</tr>');

			}

		},
		error : function() {
			alert('error');
		}
	});

}

function remove_Usuario(cUsuario){
	
	
	
	$.ajax({
		type : "GET",
		url : "syConfigUsuCtrl",
		data : {
			cCveCia : $('#cCompania').val(),
			cUsuario : cUsuario
		},

		success : function(data, textStatus, jqXHR) {
			$("#mytable > tbody").empty();
			for ( var item in data) {
				$('#mytable > tbody').append(
						'<tr>' + '<td>' + data[item].cCveCia + '</td>' + '<td>'
								+ data[item].cUsuario + '</td>' + '<td>'
								+'<td>' + data[item].ctUsu.cNombre + '</td>' 
								+ data[item].lActivo + '</td>' + '<td><nobr>'

								+ '<a class="pure-button pure-button-primary"'
								+ 'onclick="return confirm('
								+ "'¿Desea Eliminar el usuario selecionado?'"
								+ ');" ' + 'href="javascript:remove_sysMenu('
								+ data[item].cCveCia + ' )"> <i'
								+ '	class="fa fa-times"></i>Eliminar' + '</a>'

								+ '</nobr></td>' + '</tr>');
			}

		},
		error : function() {
			alert('error ');
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

