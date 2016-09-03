package br.com.brunoluz.breeweer.service.eventos;

import org.thymeleaf.util.StringUtils;

import br.com.brunoluz.breeweer.model.Cerveja;

public class CervejaSalvaEvento {

	private Cerveja cerveja;

	
	/**
	 * CervejaSalvaEvento
	 * @param cerveja
	 */
	public CervejaSalvaEvento(Cerveja cerveja) {
		this.cerveja = cerveja;
	}


	/**
	 * @return the cerveja
	 */
	public Cerveja getCerveja() {
		return cerveja;
	}
	
	
	/**
	 * temFoto
	 * @return
	 */
	public boolean temFoto() {
		return !StringUtils.isEmpty(cerveja.getFoto());
	}
	
}
