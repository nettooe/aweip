package com.aweip.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.aweip.entity.discreto.TipoPermissao;

/**
 * The Class PermissaoUsuarioIdeia.
 */
@MappedSuperclass
public abstract class PermissaoUsuarioIdeia extends AweipEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6924779635982032896L;

	/** The usuario. */
	@NotNull
	@ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	/** The ideia. */
	@NotNull
	@ManyToOne(targetEntity = IdeiaEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ideia")
	private Ideia ideia;

	/** The tipo permissao. */
	@NotNull
	private TipoPermissao tipoPermissao;

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
	 * Gets the tipo permissao.
	 * 
	 * @return the tipo permissao
	 */
	public TipoPermissao getTipoPermissao() {
		return tipoPermissao;
	}

	/**
	 * Sets the tipo permissao.
	 * 
	 * @param tipoPermissao
	 *            the new tipo permissao
	 */
	public void setTipoPermissao(TipoPermissao tipoPermissao) {
		this.tipoPermissao = tipoPermissao;
	}

}
