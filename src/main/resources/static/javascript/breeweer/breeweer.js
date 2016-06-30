$(function () {
	
	/**
	 * @View : /cerveja/cadastro-cerveja
	 * Mascarás de inputs para valores numéricos
	 */
	$('.js-maskmoney-decimal').maskMoney({
		decimal: ',',
		thousands: '.'
	});
	
	
	$('.js-maskmoney-integer').maskMoney({
		precision: 0,
		thousands: '.'
	});
	
	
});