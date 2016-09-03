package br.com.brunoluz.breeweer.repository.helper.cerveja;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.brunoluz.breeweer.model.Cerveja;
import br.com.brunoluz.breeweer.repository.filtro.CervejasFiltro;

public interface CervejasRepositoryQueries {

	public Page<Cerveja> filtrar(CervejasFiltro filtro, Pageable pageable);
	
}
