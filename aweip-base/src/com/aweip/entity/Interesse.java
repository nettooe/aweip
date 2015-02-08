package com.aweip.entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * The Class Interesse.
 */
@MappedSuperclass
public abstract class Interesse extends AweipEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6924779635982032896L;

	/** The usuario. */
	@NotNull
	@ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	/** The palavra chave. */
	@NotNull
	@ManyToOne(targetEntity = PalavraChaveEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "palavraChave")
	private PalavraChave palavraChave;

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

	/**
	 * Gets the palavra chave.
	 * 
	 * @return the palavra chave
	 */
	public PalavraChave getPalavraChave() {
		return palavraChave;
	}

	/**
	 * Sets the palavra chave.
	 * 
	 * @param palavraChave
	 *            the new palavra chave
	 */
	public void setPalavraChave(PalavraChave palavraChave) {
		this.palavraChave = palavraChave;
	}

}
