package com.aweip.dao;

import java.util.List;

import javax.persistence.Query;

import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;

public class UsuarioDAO extends AweipDAO {

	public Usuario obterUsuario(Usuario usuario) {
		return entityManager.find(usuario.getClass(), usuario.getId());
	}

	public Usuario autenticarUsuario(Usuario usuario) {
		Query query = entityManager
				.createNamedQuery(UsuarioEntity.NamedQuery_autenticarUsuario);
		query.setParameter("emailUsuario", usuario.getEmail());
		query.setParameter("senhaUsuario", usuario.getSenha());

		query.setMaxResults(1);

		List<?> usuarios = query.getResultList();

		if (usuarios != null && usuarios.size() > 0) {
			return (UsuarioEntity) usuarios.get(0);
		} else {
			return usuario;
		}
	}

	public void alterarSenha(String idUsuario, String novaSenha)
			throws Exception {
		try {
			Query query = entityManager
					.createNamedQuery(UsuarioEntity.NamedQuery_alterarSenha);
			query.setParameter("idUsuario", idUsuario);
			query.setParameter("novaSenha", novaSenha);

			int result = query.executeUpdate();

			if (result < 1) {
				throw new Exception(
						"Erro desconhecido ao alterar a senha.",
						new Throwable(
								"Ocorreu um erro ao alterar a senha na base de dados."));
			}
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public Usuario merge(Usuario usuario) {
		return entityManager.merge(usuario);
	}

	public Usuario persist(Usuario usuario) {
		entityManager.persist(usuario);
		entityManager.flush();
		return usuario;
	}

	public void apagar(Usuario usuario) {
		entityManager.remove(usuario);
	}

}
