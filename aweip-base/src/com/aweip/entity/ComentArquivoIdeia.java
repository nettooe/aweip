package com.aweip.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * The Class ComentArquivoIdeia.
 */
@MappedSuperclass
public abstract class ComentArquivoIdeia extends AweipEntity implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The comentario. */
	@NotNull
	@ManyToOne(targetEntity = ComentarioEntity.class, fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "comentario")
	private Comentario comentario;

	/** The arquivo ideia. */
	@NotNull
	@ManyToOne(targetEntity = ArquivoIdeiaEntity.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "arquivoIdeia")
	private ArquivoIdeia arquivoIdeia;

	/**
	 * Gets the comentario.
	 * 
	 * @return the comentario
	 */
	public Comentario getComentario() {
		return comentario;
	}

	/**
	 * Sets the comentario.
	 * 
	 * @param comentario
	 *            the new comentario
	 */
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	/**
	 * Gets the arquivo ideia.
	 * 
	 * @return the arquivo ideia
	 */
	public ArquivoIdeia getArquivoIdeia() {
		return arquivoIdeia;
	}

	/**
	 * Sets the arquivo ideia.
	 * 
	 * @param arquivoIdeia
	 *            the new arquivo ideia
	 */
	public void setArquivoIdeia(ArquivoIdeia arquivoIdeia) {
		this.arquivoIdeia = arquivoIdeia;
	}

}
