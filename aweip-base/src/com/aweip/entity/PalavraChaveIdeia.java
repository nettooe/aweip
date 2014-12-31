package com.aweip.entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class PalavraChaveIdeia extends AweipEntity {
	private static final long serialVersionUID = -6924779635982032896L;

	@NotNull
	@ManyToOne(targetEntity = IdeiaEntity.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ideia")
	private Ideia ideia;

	@NotNull
	@ManyToOne(targetEntity = PalavraChaveEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "palavraChave")
	private PalavraChave palavraChave;

	public Ideia getIdeia() {
		return ideia;
	}

	public void setIdeia(Ideia ideia) {
		this.ideia = ideia;
	}

	public PalavraChave getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(PalavraChave palavraChave) {
		this.palavraChave = palavraChave;
	}

}
