package br.com.brunoluz.breeweer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brunoluz.breeweer.model.Estilo;
import br.com.brunoluz.breeweer.repository.EstiloRepository;

@Service
@Transactional
public class CadastroEstiloService {

	@Autowired
	private EstiloRepository repository;
	
	
	/**
	 * salvar
	 * @param cerveja
	 */
	public void salvar(Estilo estilo) {
		repository.save(estilo);
	}
	
}
