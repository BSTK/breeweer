package br.com.brunoluz.breeweer.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Cerveja implements Serializable {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8026447830293560299L;
	
	@NotBlank
	@Size(min = 5, max = 5)
	@Pattern(regexp = "^[A-Z0-9]*$")
	private String sku;

	@NotBlank
	@Size(min = 5, max = 50)
	private String nome;
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String descricao;

	
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


	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}


	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}