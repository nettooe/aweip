package com.aweip.entity;

import java.text.SimpleDateFormat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = UsuarioEntity.NamedQuery_autenticarUsuario,
			query = "select usu from UsuarioEntity usu where usu.email = :emailUsuario and usu.senha = :senhaUsuario"),
	@NamedQuery(name = UsuarioEntity.NamedQuery_alterarSenha,
			query = "UPDATE UsuarioEntity usu SET usu.senha = :novaSenha where usu.id = :idUsuario")
})
public class UsuarioEntity extends Usuario {
	private static final long serialVersionUID = 1L;

	public static final String NamedQuery_autenticarUsuario = "UsuarioEntity.autenticarUsuario";
	public static final String NamedQuery_alterarSenha = "UsuarioEntity.alterarSenha";

	

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