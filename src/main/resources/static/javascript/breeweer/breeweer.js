var Breeweer = Breeweer || {};

Breeweer.MaskMoney = (function () {
	
	'use-strict';
	
	/**
	 * Função contrutora javascript
	 */
	function MaskMoney() {
		this.decimal = $('.js-maskmoney-decimal');
		this.integer = $('.js-maskmoney-integer');
	};
	
	
	/**
	 * Habilita as configurações do objeto
	 * @View : /cerveja/cadastro-cerveja
	 * Mascarás de inputs para valores numéricos
	 */
	MaskMoney.prototype.enable = function () {
		this.decimal.maskMoney({
			decimal: ',',
			thousands: '.'
		});
		
		this.integer.maskMoney({
			precision: 0,
			thousands: '.'
		});
	};
	
	
	/**
	 * Retorna o objeto craido
	 */
	return MaskMoney;
	
}());

$(function () {

	'use-strict';
	
	var mascara = new Breeweer.MaskMoney();
		mascara.enable();
	
});