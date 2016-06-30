package br.com.brunoluz.breeweer.model;

public enum Origem {
	
	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");
	
	private String descricao;
	
	private Origem(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * @return descricao
	 */
	public String getDescricao() {
		return descricao;
	}

}
