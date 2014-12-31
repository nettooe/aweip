package com.aweip.dao;

import com.aweip.entity.PermissaoUsuarioIdeia;

public class PermissaoUsuarioIdeiaDAO extends AweipDAO {

	public PermissaoUsuarioIdeia merge(PermissaoUsuarioIdeia permissao) {
		PermissaoUsuarioIdeia permissaoUsuarioIdeia = entityManager
				.merge(permissao);
		entityManager.flush();
		return permissaoUsuarioIdeia;
	}

	public PermissaoUsuarioIdeia persist(PermissaoUsuarioIdeia permissao) {
		entityManager.persist(permissao);
		entityManager.flush();
		return permissao;
	}

	public void apagar(PermissaoUsuarioIdeia permissao) {
		entityManager.remove(permissao);
	}

}
