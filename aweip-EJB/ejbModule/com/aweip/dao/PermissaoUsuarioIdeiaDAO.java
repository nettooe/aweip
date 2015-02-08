package com.aweip.dao;

import com.aweip.entity.PermissaoUsuarioIdeia;

/**
 * The Class PermissaoUsuarioIdeiaDAO.
 */
public class PermissaoUsuarioIdeiaDAO extends AweipDAO {

	/**
	 * Merge.
	 * 
	 * @param permissao
	 *            the permissao
	 * @return the permissao usuario ideia
	 */
	public PermissaoUsuarioIdeia merge(PermissaoUsuarioIdeia permissao) {
		PermissaoUsuarioIdeia permissaoUsuarioIdeia = entityManager
				.merge(permissao);
		entityManager.flush();
		return permissaoUsuarioIdeia;
	}

	/**
	 * Persist.
	 * 
	 * @param permissao
	 *            the permissao
	 * @return the permissao usuario ideia
	 */
	public PermissaoUsuarioIdeia persist(PermissaoUsuarioIdeia permissao) {
		entityManager.persist(permissao);
		entityManager.flush();
		return permissao;
	}

	/**
	 * Apagar.
	 * 
	 * @param permissao
	 *            the permissao
	 */
	public void apagar(PermissaoUsuarioIdeia permissao) {
		entityManager.remove(permissao);
	}

}
