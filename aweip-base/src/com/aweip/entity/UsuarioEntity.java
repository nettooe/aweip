package com.aweip.entity;

import java.text.SimpleDateFormat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class UsuarioEntity.
 */
@Entity
@Table(name = "usuario")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = UsuarioEntity.NamedQuery_autenticarUsuario, query = "select usu from UsuarioEntity usu where usu.email = :emailUsuario and usu.senha = :senhaUsuario"),
		@NamedQuery(name = UsuarioEntity.NamedQuery_alterarSenha, query = "UPDATE UsuarioEntity usu SET usu.senha = :novaSenha where usu.id = :idUsuario"),
		@NamedQuery(name = UsuarioEntity.NamedQuery_obterAvatarUsuario, query = "SELECT obj.avatar from UsuarioEntity obj where obj.id = :idUsuario") })
public class UsuarioEntity extends Usuario {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant NamedQuery_autenticarUsuario. */
	public static final String NamedQuery_autenticarUsuario = "UsuarioEntity.autenticarUsuario";

	/** The Constant NamedQuery_alterarSenha. */
	public static final String NamedQuery_alterarSenha = "UsuarioEntity.alterarSenha";

	/** The Constant NamedQuery_obterAvatarUsuario. */
	public static final String NamedQuery_obterAvatarUsuario = "UsuarioEntity.obterAvatarUsuario";

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/YYYY hh:mm:ss");

		return String
				.format("UsuarioEntity [getId()=%s, getNome()=%s, getEmail()=%s, getSenha()=%s, getVersao()=%s, getDataUltAtualizacao()=%s]",
						getId(), getNome(), getEmail(), getSenha(),
						getVersao(), simpleDateFormat
								.format(getDataUltAtualizacao().getTime()));
	}

}