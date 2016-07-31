var Breeweer = Breeweer || {};

Breeweer.EstiloCadastroRapido = (function () {
	
	'use-strict';
	
	/**
	 * Função contrutora javascript
	 */
	function EstiloCadastroRapido() {
		
		this.modal = $('#cadastroRapidoEstilo');
		this.botaoSalvar = this.modal.find('.js-btn-salvar-cadastr-rapido-estilo');
		this.formulario  = this.modal.find('form');
		this.url = this.formulario.attr('action');
		this.campoNomeEstilo = $('.js-nome-estilo-cadastro-rapido');
		this.containerMenssagem = $('.js-menssagem-estilo-cadastro-rapido');
		
	};
	
	
	/**
	 * Inicia o bind dos objetos
	 */
	EstiloCadastroRapido.prototype.init = function() {
		
		this.formulario.on('submit', function (event) {
			event.preventDefault();
		});
		
		this.modal.on('shown.bs.modal', modalOnShow.bind(this));
		this.modal.on('hide.bs.modal', modalOnHide.bind(this));
		this.botaoSalvar.on('click', botaoSalvarOnClick.bind(this));
		
	};
	
	
	/**
	 * modalOnShow
	 */
	function modalOnShow() {
		this.campoNomeEstilo.focus();
	};
	
	
	/**
	 * modalOnHide
	 */
	function modalOnHide() {
		
		this.campoNomeEstilo.val('');
		this.containerMenssagem.addClass('hidden');
		this.formulario.find('div.form-group').removeClass('has-error');
		
	};
	
	
	/**
	 * botaoSalvarOnClick
	 */
	function botaoSalvarOnClick() {
		
		const METHOD = 'POST';
		const CONTENT_TYPE_JASON = 'application/json';
		var nomeEstilo = this.campoNomeEstilo.val().trim();
		
		$.ajax({
			
			url: this.url,
			method: METHOD,
			contentType: CONTENT_TYPE_JASON,
			data: JSON.stringify({
				nome: nomeEstilo
			}),
			error: onErrorSalvaEstilo.bind(this),
			success: onSucessoSalvaEstilo.bind(this)
			
		});
		
	};
	
	
	/**
	 *onSucessoSalvaEstilo
	 */
	function onSucessoSalvaEstilo(estilo) {
		
		this.campoNomeEstilo.val('');
		
		this.containerMenssagem.removeClass('hidden');
		this.containerMenssagem.removeClass('alert-danger');
		this.containerMenssagem.addClass('alert-success');
		
		this.formulario.find('div.form-group').removeClass('has-error');
		
		this.containerMenssagem.html('<i class="glyphicon glyphicon-ok"></i><strong> Estilo salvo com sucesso !</strong>');
		
		var selectEstilo = $('.js-select-estilo');
			selectEstilo.append('<option value=' + estilo.id + '>' + estilo.nome + '</option>');
			selectEstilo.val(estilo.id);
		
		var modalObject = this.modal;
		
		setTimeout(function() {
			modalObject.modal('hide');
		}, 300);
		
	};
	
	
	
	/**
	 * onErrorSalvaEstilo
	 */
	function onErrorSalvaEstilo(resposta) {
		
		var menssagemErro = resposta.responseText;
		
		this.containerMenssagem.removeClass('hidden');
		this.containerMenssagem.removeClass('alert-success');
		this.containerMenssagem.html('<i class="fa fa-exclamation-circle"></i><strong> ' + menssagemErro + '</strong>');
		
		this.containerMenssagem.addClass('alert-danger');
		this.formulario.find('div.form-group').addClass('has-error');
		
	};
	

	return EstiloCadastroRapido;
	
}());

$(function () {
	
	'use-strict';
	
	var estiloCadastroRapido = new Breeweer.EstiloCadastroRapido();
		estiloCadastroRapido.init();
	
});