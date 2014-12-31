package com.aweip.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.aweip.entity.discreto.TipoPermissao;

@MappedSuperclass
public abstract class PermissaoUsuarioIdeia extends AweipEntity {
	private static final long serialVersionUID = -6924779635982032896L;

	@NotNull
	@ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	@NotNull
	@ManyToOne(targetEntity = IdeiaEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ideia")
	private Ideia ideia;

	@NotNull
	private TipoPermissao tipoPermissao;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ideia getIdeia() {
		return ideia;
	}

	public void setIdeia(Ideia ideia) {
		this.ideia = ideia;
	}

	public TipoPermissao getTipoPermissao() {
		return tipoPermissao;
	}

	public void setTipoPermissao(TipoPermissao tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

}
