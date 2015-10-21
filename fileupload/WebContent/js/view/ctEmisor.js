function add_ctEmisor() {
	$('#ctEmisor_Dialog').dialog("option", "title", 'Agregar Emisor');
	$('#ctEmisor_Dialog').dialog('open');
}


$(document).ready(function() {

    $('#ctEmisor_Dialog').dialog({

           autoOpen : false,
           position : 'center',
           modal : true,
           resizable : false,
           width : 440,
           buttons : {
                  "Save" : function() {
                        $('#ctEmisor_Dialog').submit();
                  },
                  "Cancel" : function() {
                        $(this).dialog('close');
                  }
           },
           close : function() {

                  resetDialog($('#ctEmisor_Dialog'));
                  $(this).dialog('close');
           }
    });

   
});