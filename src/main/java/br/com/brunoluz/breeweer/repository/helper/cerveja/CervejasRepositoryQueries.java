package br.com.brunoluz.breeweer.repository.helper.cerveja;

import java.util.List;

import br.com.brunoluz.breeweer.model.Cerveja;
import br.com.brunoluz.breeweer.repository.filtro.CervejasFiltro;

public interface CervejasRepositoryQueries {

	public List<Cerveja> filtrar(CervejasFiltro filtro);
	
}
