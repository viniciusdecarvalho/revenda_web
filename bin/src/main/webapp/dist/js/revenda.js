/**
 * 
 */

(function(){	
	
	$('button[type=submit]').on('click', function() {		
		$('button[type=submit]').text("Aguarde...").disabled = true;
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
	
})();
