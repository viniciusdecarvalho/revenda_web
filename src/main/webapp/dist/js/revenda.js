/**
 * 
 */

(function(){	
	
	$('button[type=submit]').on('click', function() {
		$(this).text("Aguarde...").addClass('disabled');
		$('a,button').addClass('disabled');
	});
	
	var menuItens = $('#side-menu a');
	
	$('#search_button').on('click', function(evt) {
		var search = $('#search_input').val();
		
		menuItens.removeClass('active').removeClass('collapse').removeClass('in');
		if (search) {
		
			var element = menuItens.filter(function() {
				return this.text.toLowerCase().indexOf(search.toLowerCase()) >= 0; 
			});
			if (element) {
				element = element.addClass('active').parent().parent().addClass('in').parent();				
				
				if (element.is('li')) {
			        element.addClass('active');
			    }
			}
		}
	});
	
	$('.dataTable_wrapper table').DataTable({
    	dom: 't',
	  	scrollY: 250,
        responsive: true,
        language: {
			url: path + "bower_components/datatables-plugins/i18n/Portuguese-Brasil.lang"
		}
    });
	
	//mask	
	$('.input-cpf').mask("000.000.000-00");
	$('.input-cpfcnpj').mask("000.000.000-00");	
	$('input[type=tel]').mask("(00)000000000");
	$('.input-cep').mask("00.000-000");
	$('.input-decimal').mask('000.000.000.000.000,00', {reverse: true});

})();
