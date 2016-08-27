package br.com.brunoluz.breeweer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brunoluz.breeweer.model.Cerveja;
import br.com.brunoluz.breeweer.repository.CervejaRepository;
import br.com.brunoluz.breeweer.service.eventos.CervejaSalvaEvento;

@Service
@Transactional
public class CadastroCervejaService {

	@Autowired
	private CervejaRepository repository;
	
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher; 
	
	/**
	 * salvar
	 * @param cerveja
	 */
	public void salvar(Cerveja cerveja) {
		
		repository.save(cerveja);
		applicationEventPublisher.publishEvent(new CervejaSalvaEvento(cerveja));
	}
	
	
}
