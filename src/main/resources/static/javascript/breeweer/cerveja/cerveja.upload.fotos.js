var Breeweer = Breeweer || {};

Breeweer.UploadFoto = (function () {
	
	'use-strict';
	
	function UploadFoto() {
		
		this.inputFoto = $('input[name=foto]');
		this.inputContentType = $('input[name=contentType]');

		this.fotoCervejaHTMLTemplate = $('#fotoHandlebarsTemplate').html();	
		this.template = Handlebars.compile(this.fotoCervejaHTMLTemplate);
	
		this.uikitUploadDrop = $('#uikitUploadDrop');
		this.fotoCervejaRegiao = $('.js-foto-cerveja-regiao');
		
	};
	
	UploadFoto.prototype.iniciar = function () {
		
		var settings = {
				type: 'json',
				filelimit: 1,
				allow: '*.(jpg|jpeg|png)',
				action: this.uikitUploadDrop.data('url-fotos'),
				complete: onUploadCompleto.bind(this)
			};
		
		UIkit.uploadSelect($('#uikitUploadSelect'), settings);
		UIkit.uploadDrop(this.uikitUploadDrop, settings);
		
		
		/**
		 * Usando o call
		 * Uso do nomeFuncao.call(this, object);
		 * faz uma chamada a função, forçando o contexto this
		 */
		if (this.inputFoto.val()) {
			onUploadCompleto.call(this, { 
				nome:this.inputFoto.val() , 
				contentType: this.inputContentType.val()
			});
		}
	};
	
	
	function onUploadCompleto(resposta) {
		
		this.inputFoto.val(resposta.nome);
		this.inputContentType.val(resposta.contentType);
		
		this.uikitUploadDrop.addClass('hidden');
		
		var htmlFotoCerveja = this.template({nomeFoto: resposta.nome});
		this.fotoCervejaRegiao.append(htmlFotoCerveja);
		
		$('.js-botao-remove-foto').on('click', onRemoveFoto.bind(this));
		
	};
	
	
	function onRemoveFoto() {
		
		$('.foto-handlebars-template').remove();
		this.uikitUploadDrop.removeClass('hidden');
		this.inputFoto.val('');
		this.inputContentType.val('');
		
	};
	
	return UploadFoto;
	
}());

(function () {
	
	'use-strict';
	
	var uploadFotos = new Breeweer.UploadFoto();
	uploadFotos.iniciar();
	
}());