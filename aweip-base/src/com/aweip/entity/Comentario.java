package com.aweip.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class Comentario.
 */
@MappedSuperclass
public abstract class Comentario extends AweipEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Autor do comentário. */
	@NotNull
	@ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	private Usuario usuario;

	/** The descricao. */
	@NotNull
	@NotBlank
	@NotEmpty
	@Lob
	private String descricao;

	/** The usuario pode excluir. */
	@Transient
	private boolean usuarioPodeExcluir;

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
	 * Checks if is usuario pode excluir.
	 * 
	 * @return true, if is usuario pode excluir
	 */
	public boolean isUsuarioPodeExcluir() {
		return usuarioPodeExcluir;
	}

	/**
	 * Sets the usuario pode excluir.
	 * 
	 * @param usuarioPodeExcluir
	 *            the new usuario pode excluir
	 */
	public void setUsuarioPodeExcluir(boolean usuarioPodeExcluir) {
		this.usuarioPodeExcluir = usuarioPodeExcluir;
	}

}
