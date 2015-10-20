/**
 * 
 */

function add_ctPrograma() {
	$('#ctPrograma_Dialog').dialog("option", "title", 'Agregar Compañia');
	$('#ctPrograma_Dialog').dialog('open');
}


$(document).ready(function() {

    $('#ctPrograma_Dialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#ctPrograma_Form').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#ctPrograma_Form'));
                  $(this).dialog('close');
           }
    });

   
});