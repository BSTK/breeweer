package br.com.brunoluz.breeweer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brunoluz.breeweer.model.Cerveja;
import br.com.brunoluz.breeweer.repository.CervejaRepository;

@Service
@Transactional
public class CadastroCervejaService {

	@Autowired
	private CervejaRepository repository;
	
	
	/**
	 * salvar
	 * @param cerveja
	 */
	public void salvar(Cerveja cerveja) {
		repository.save(cerveja);
	}
	
	
}
