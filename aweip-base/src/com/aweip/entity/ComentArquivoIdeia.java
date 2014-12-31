package com.aweip.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class ComentArquivoIdeia extends AweipEntity implements
		Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne(targetEntity = ComentarioEntity.class, fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "comentario")
	private Comentario comentario;

	@NotNull
	@ManyToOne(targetEntity = ArquivoIdeiaEntity.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "arquivoIdeia")
	private ArquivoIdeia arquivoIdeia;

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public ArquivoIdeia getArquivoIdeia() {
		return arquivoIdeia;
	}

	public void setArquivoIdeia(ArquivoIdeia arquivoIdeia) {
		this.arquivoIdeia = arquivoIdeia;
	}

}
