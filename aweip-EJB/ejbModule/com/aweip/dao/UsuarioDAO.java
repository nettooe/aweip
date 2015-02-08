package com.aweip.dao;

import java.util.List;

import javax.persistence.Query;

import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;

/**
 * The Class UsuarioDAO.
 */
public class UsuarioDAO extends AweipDAO {

	/**
	 * Obter usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	public Usuario obterUsuario(Usuario usuario) {
		return entityManager.find(usuario.getClass(), usuario.getId());
	}

	/**
	 * Autenticar usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
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

	/**
	 * Alterar senha.
	 * 
	 * @param idUsuario
	 *            the id usuario
	 * @param novaSenha
	 *            the nova senha
	 * @throws Exception
	 *             the exception
	 */
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

	/**
	 * Merge.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	public Usuario merge(Usuario usuario) {
		return entityManager.merge(usuario);
	}

	/**
	 * Persist.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	public Usuario persist(Usuario usuario) {
		entityManager.persist(usuario);
		entityManager.flush();
		return usuario;
	}

	/**
	 * Apagar.
	 * 
	 * @param usuario
	 *            the usuario
	 */
	public void apagar(Usuario usuario) {
		entityManager.remove(usuario);
	}

	/**
	 * Obter avatar usuario.
	 * 
	 * @param idUsuario
	 *            the id usuario
	 * @return the byte[]
	 */
	public byte[] obterAvatarUsuario(String idUsuario) {
		return (byte[]) entityManager
				.createNamedQuery(UsuarioEntity.NamedQuery_obterAvatarUsuario)
				.setParameter("idUsuario", idUsuario).getSingleResult();
	}

}
