package com.aweip.entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Interesse extends AweipEntity {
	private static final long serialVersionUID = -6924779635982032896L;

	@NotNull
	@ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	@NotNull
	@ManyToOne(targetEntity = PalavraChaveEntity.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "palavraChave")
	private PalavraChave palavraChave;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PalavraChave getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(PalavraChave palavraChave) {
		this.palavraChave = palavraChave;
	}

	

}
