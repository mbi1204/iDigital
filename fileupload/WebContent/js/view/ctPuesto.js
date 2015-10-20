/**
 * 
 */


function add_ctPuesto() {
	$('#ctPuesto_Dialog').dialog("option", "title", 'Agregar Puesto');
	$('#ctPuesto_Dialog').dialog('open');
}


$(document).ready(function() {

    $('#ctPuesto_Dialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#ctPuesto_Form').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#ctPuesto_Form'));
                  $(this).dialog('close');
           }
    });

   
});