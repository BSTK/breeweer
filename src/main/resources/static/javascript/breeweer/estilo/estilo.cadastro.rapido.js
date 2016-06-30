$(function () {
	
	var modal = $('#cadastroRapidoEstilo');
	var botaoSalvar = modal.find('.js-btn-salvar-cadastr-rapido-estilo');
	var formulario  = modal.find('form');
	var url = formulario.attr('action');
	var campoNomeEstilo = $('.js-nome-estilo-cadastro-rapido');
	var containerMenssagem = $('.js-menssagem-estilo-cadastro-rapido');
	
	formulario.on('submit', formPreventDefault);
	
	modal.on('shown.bs.modal', modalOnShow);
	modal.on('hide.bs.modal', modalOnHide);
	
	botaoSalvar.on('click', botaoSalvarOnClick);
	
	
	/**
	 * modalOnShow
	 */
	function modalOnShow() {
		campoNomeEstilo.focus();
	}
	
	
	
	
	/**
	 * modalOnHide
	 */
	function modalOnHide() {
		
		campoNomeEstilo.val('');
		containerMenssagem.addClass('hidden');
		formulario.find('div.form-group').removeClass('has-error');
		
	}
	
	
	
	/**
	 * formPreventDefault
	 * @param event
	 */
	function formPreventDefault(event) {
		event.preventDefault();
	}
	
	
	
	/**
	 * botaoSalvarOnClick
	 */
	function botaoSalvarOnClick() {
		
		const METHOD = 'POST';
		const CONTENT_TYPE_JASON = 'application/json';
		var nomeEstilo = campoNomeEstilo.val().trim();
		
		$.ajax({
			
			url: url,
			method: METHOD,
			contentType: CONTENT_TYPE_JASON,
			data: JSON.stringify({
				nome: nomeEstilo
			}),
			error: onErrorSalvaEstilo,
			success: onSucessoSalvaEstilo
			
		});
		
	}
	
	
	
	/**
	 * onSucessoSalvaEstilo
	 */
	function onSucessoSalvaEstilo(estilo) {
		
		campoNomeEstilo.val('');
		
		containerMenssagem.removeClass('hidden');
		containerMenssagem.removeClass('alert-danger');
		containerMenssagem.addClass('alert-success');
		
		formulario.find('div.form-group').removeClass('has-error');
		
		containerMenssagem.html('<i class="glyphicon glyphicon-ok"></i><strong>Estilo salvo com sucesso !</strong>');
		
		var selectEstilo = $('.js-select-estilo');
		
		selectEstilo.append('<option value=' + estilo.id + '>' + estilo.nome + '</option>');
		selectEstilo.val(estilo.id);
		
		setTimeout(function() {
			modal.modal('hide');
		}, 10000);
		
	}
	
	
	
	/**
	 * onErrorSalvaEstilo
	 * @param resposta
	 */
	function onErrorSalvaEstilo(resposta) {
		
		var menssagemErro = resposta.responseText;
		
		containerMenssagem.removeClass('hidden');
		containerMenssagem.removeClass('alert-success');
		containerMenssagem.html('<i class="fa fa-exclamation-circle"></i><strong> ' + menssagemErro + '</strong>');
		
		containerMenssagem.addClass('alert-danger');
		formulario.find('div.form-group').addClass('has-error');
		
	}
	
});