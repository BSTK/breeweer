package br.com.brunoluz.breeweer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import br.com.brunoluz.breeweer.validation.SKU;


@Entity
@Table(name ="TB_CERVEJA")
public class Cerveja implements Serializable {

	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8026447830293560299L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@SKU
	@NotBlank(message = "Informar o código de SKU")
	@Size(min = 6, max = 6, message = "Código SKU deve conter de 6 caracteres")
	@Column(name = "SKU")
	private String sku;

	@NotBlank(message = "Informar o nome")
	@Size(min = 5, max = 50, message = "Nome deve conter de 5 a 50 caracteres")
	@Column(name = "NOME")
	private String nome;
	
	@NotBlank(message = "Informar a descrição")
	@Size(min = 5, max = 50, message = "Descrição deve conter de 5 a 50 caracteres")
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
	
	@Column(name = "TEOR_ALCOOLICO")
	private BigDecimal teorAlcoolico;
	
	@Column(name = "COMISSAO")
	private BigDecimal comissao;
	
	@Column(name = "QUANTIDADE_ESTOQUE")
	private Integer quantidadeEstoque;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "SABOR")
	private Sabor sabor;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ORIGEM")
	private Origem origem;
	
	@ManyToOne
	@JoinColumn(name = "ID_TB_ESTILO")
	private Estilo estilo;

	
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


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}


	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	/**
	 * @return the teorAlcoolico
	 */
	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}


	/**
	 * @param teorAlcoolico the teorAlcoolico to set
	 */
	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}


	/**
	 * @return the comissao
	 */
	public BigDecimal getComissao() {
		return comissao;
	}


	/**
	 * @param comissao the comissao to set
	 */
	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}


	/**
	 * @return the quantidadeEstoque
	 */
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}


	/**
	 * @param quantidadeEstoque the quantidadeEstoque to set
	 */
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
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


	/**
	 * @return the origem
	 */
	public Origem getOrigem() {
		return origem;
	}


	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(Origem origem) {
		this.origem = origem;
	}


	/**
	 * @return the estilo
	 */
	public Estilo getEstilo() {
		return estilo;
	}


	/**
	 * @param estilo the estilo to set
	 */
	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}


	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}


	/** 
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}