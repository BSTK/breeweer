package br.com.brunoluz.breeweer.web.dto;

import java.io.Serializable;

public class FotoDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	private String contentType;

	public FotoDTO() {
	}

	public FotoDTO(String nome, String contentType) {
		super();
		this.nome = nome;
		this.contentType = contentType;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
