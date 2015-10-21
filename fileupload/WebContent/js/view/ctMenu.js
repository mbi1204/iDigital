/**
 * 
 */
function add_ctMenu() {
	$('#ctMenu_Dialog').dialog("option", "title", 'Agregar Menu');
	$('#ctMenu_Dialog').dialog('open');
}


$(document).ready(function() {

    $('#ctMenu_Dialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#ctMenu_Form').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#ctMenu_Form'));
                  $(this).dialog('close');
           }
    });

   
});