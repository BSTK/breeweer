package br.com.brunoluz.breeweer.model;

import java.io.Serializable;

public class Cerveja implements Serializable {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8026447830293560299L;

	
	private String nome;
	
	private String sku;

	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	
	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}
	

}
