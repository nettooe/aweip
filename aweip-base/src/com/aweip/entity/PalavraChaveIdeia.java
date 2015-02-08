package com.aweip.entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * The Class PalavraChaveIdeia.
 */
@MappedSuperclass
public abstract class PalavraChaveIdeia extends AweipEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6924779635982032896L;

	/** The ideia. */
	@NotNull
	@ManyToOne(targetEntity = IdeiaEntity.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ideia")
	private Ideia ideia;

	/** The palavra chave. */
	@NotNull
	@ManyToOne(targetEntity = PalavraChaveEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "palavraChave")
	private PalavraChave palavraChave;

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
