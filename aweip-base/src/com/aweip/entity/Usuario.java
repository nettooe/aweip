package com.aweip.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class Usuario.
 */
@MappedSuperclass
public abstract class Usuario extends AweipEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nome. */
	@NotBlank(message = "Nome não pode estar vazio.")
	@Length(min = 5, max = 120)
	private String nome;

	/** The email. */
	@Email(message = "O email informado não é válido.")
	@NotBlank(message = "Email não pode estar vazio.")
	private String email;

	/** The senha. */
	@NotBlank(message = "Senha não pode estar vazia.")
	private String senha;

	/** The bio. */
	private String bio;

	/** The avatar. */
	private byte[] avatar;

	/** The ideias. */
	@OneToMany(mappedBy = "usuario", targetEntity = PermissaoUsuarioIdeiaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PermissaoUsuarioIdeiaEntity> ideias = new ArrayList<PermissaoUsuarioIdeiaEntity>();

	/**
	 * Gets the ideias.
	 * 
	 * @return the ideias
	 */
	public List<PermissaoUsuarioIdeiaEntity> getIdeias() {
		return ideias;
	}

	/**
	 * Sets the ideias.
	 * 
	 * @param ideias
	 *            the new ideias
	 */
	public void setIdeias(List<PermissaoUsuarioIdeiaEntity> ideias) {
		this.ideias = ideias;
	}

	/**
	 * Gets the nome.
	 * 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 * 
	 * @param nome
	 *            the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the senha.
	 * 
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Sets the senha.
	 * 
	 * @param senha
	 *            the new senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Gets the bio.
	 * 
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Sets the bio.
	 * 
	 * @param bio
	 *            the new bio
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * Gets the avatar.
	 * 
	 * @return the avatar
	 */
	public byte[] getAvatar() {
		return avatar;
	}

	/**
	 * Sets the avatar.
	 * 
	 * @param avatar
	 *            the new avatar
	 */
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

}
