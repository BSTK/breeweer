package br.com.brunoluz.breeweer.model;

public enum Sabor {

	ADOCICADA("Adocicada"),
	AMARGA("Amarga"),
	FORTE("Forte"),
	FRUTADA("Frutada"),
	SUAVE("Suave");
	
	private String descricao;
	
	private Sabor(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	
}
