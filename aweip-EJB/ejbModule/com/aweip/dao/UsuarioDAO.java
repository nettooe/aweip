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
