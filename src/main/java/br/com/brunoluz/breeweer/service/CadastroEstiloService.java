package br.com.brunoluz.breeweer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brunoluz.breeweer.exception.NomeEstiloJaCadastrado;
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
		
		Optional<Estilo> estiloOptional = repository.findByNomeIgnoreCase(estilo.getNome());
		
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastrado("Estilo já cadastrado !");
		}
		
		repository.save(estilo);
	}
	
}