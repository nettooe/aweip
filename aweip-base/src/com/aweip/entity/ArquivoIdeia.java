/*
 * 
 */
package com.aweip.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

// TODO: Auto-generated Javadoc
/**
 * The Class ArquivoIdeia.
 */
@MappedSuperclass
public abstract class ArquivoIdeia extends AweipEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The usuario. */
	@NotNull
	@ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	/** The ideia. */
	@NotNull
	@ManyToOne(targetEntity = IdeiaEntity.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ideia")
	private Ideia ideia;

	/** The arquivo. */
	@NotNull
	@OneToOne(targetEntity = ArquivoEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "arquivo")
	private Arquivo arquivo;

	/** The nome. */
	@NotNull
	private String nome;

	/** The tamanho. */
	@NotNull
	private Long tamanho;

	/** The descricao. */
	@Lob
	private String descricao;

	/**
	 * Gets the ideia.
	 * 
	 * @return the ideia
	 */
	public Ideia getIdeia() {
		return ideia;
	}

	/**
	 * Sets the ideia.
	 * 
	 * @param ideia
	 *            the new ideia
	 */
	public void setIdeia(Ideia ideia) {
		this.ideia = ideia;
	}

	/**
	 * Gets the arquivo.
	 * 
	 * @return the arquivo
	 */
	public Arquivo getArquivo() {
		return arquivo;
	}

	/**
	 * Sets the arquivo.
	 * 
	 * @param arquivo
	 *            the new arquivo
	 */
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * Gets the descricao.
	 * 
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Sets the descricao.
	 * 
	 * @param descricao
	 *            the new descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Gets the nome.
	 * 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 * 
	 * @param nome
	 *            the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the tamanho.
	 * 
	 * @return the tamanho
	 */
	public Long getTamanho() {
		return tamanho;
	}

	/**
	 * Sets the tamanho.
	 * 
	 * @param tamanho
	 *            the new tamanho
	 */
	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}

	/**
	 * Gets the usuario.
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 * 
	 * @param usuario
	 *            the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
