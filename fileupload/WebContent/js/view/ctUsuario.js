
function add_ctUsuario() {
	$('#ctUsuario_Dialog').dialog("option", "title", 'Agregar Usuario');
	$('#ctUsuario_Dialog').dialog('open');
}


$(document).ready(function() {

    $('#ctUsuario_Dialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#ctUsuario_Form').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#ctUsuario_Form'));
                  $(this).dialog('close');
           }
    });

   
});