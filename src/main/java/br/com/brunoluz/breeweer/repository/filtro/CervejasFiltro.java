package br.com.brunoluz.breeweer.repository.filtro;

import java.math.BigDecimal;

import br.com.brunoluz.breeweer.model.Estilo;
import br.com.brunoluz.breeweer.model.Origem;
import br.com.brunoluz.breeweer.model.Sabor;

public class CervejasFiltro {

	private String sku;
	private String nome;
	private Estilo estilo;
	private Origem origem;
	private Sabor sabor;
	private BigDecimal valorDe;
	private BigDecimal valorAte;

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku
	 *            the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
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
	 * @return the estilo
	 */
	public Estilo getEstilo() {
		return estilo;
	}

	/**
	 * @param estilo
	 *            the estilo to set
	 */
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	/**
	 * @return the origem
	 */
	public Origem getOrigem() {
		return origem;
	}

	/**
	 * @param origem
	 *            the origem to set
	 */
	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	/**
	 * @return the valorDe
	 */
	public BigDecimal getValorDe() {
		return valorDe;
	}

	/**
	 * @param valorDe
	 *            the valorDe to set
	 */
	public void setValorDe(BigDecimal valorDe) {
		this.valorDe = valorDe;
	}

	/**
	 * @return the valorAte
	 */
	public BigDecimal getValorAte() {
		return valorAte;
	}

	/**
	 * @param valorAte
	 *            the valorAte to set
	 */
	public void setValorAte(BigDecimal valorAte) {
		this.valorAte = valorAte;
	}

	/**
	 * @return the sabor
	 */
	public Sabor getSabor() {
		return sabor;
	}

	/**
	 * @param sabor the sabor to set
	 */
	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

}
