package com.aweip.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * The Class ComentarioIdeia.
 */
@MappedSuperclass
public abstract class ComentarioIdeia extends AweipEntity implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The comentario. */
	@NotNull
	@ManyToOne(targetEntity = ComentarioEntity.class, fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "comentario")
	private Comentario comentario;

	/** The ideia. */
	@NotNull
	@ManyToOne(targetEntity = IdeiaEntity.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ideia")
	private Ideia ideia;

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

}
