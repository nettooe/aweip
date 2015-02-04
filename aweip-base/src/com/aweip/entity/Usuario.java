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

@MappedSuperclass
public abstract class Usuario extends AweipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Nome não pode estar vazio.")
	@Length(min = 5, max = 120)
	private String nome;

	@Email(message = "O email informado não é válido.")
	@NotBlank(message = "Email não pode estar vazio.")
	private String email;

	@NotBlank(message = "Senha não pode estar vazia.")
	private String senha;

	private String bio;

	private byte[] avatar;

	@OneToMany(mappedBy = "usuario", targetEntity = PermissaoUsuarioIdeiaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PermissaoUsuarioIdeiaEntity> ideias = new ArrayList<PermissaoUsuarioIdeiaEntity>();

	public List<PermissaoUsuarioIdeiaEntity> getIdeias() {
		return ideias;
	}

	public void setIdeias(List<PermissaoUsuarioIdeiaEntity> ideias) {
		this.ideias = ideias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

}
