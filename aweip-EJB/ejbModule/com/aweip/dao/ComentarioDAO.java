package com.aweip.dao;

import com.aweip.entity.Comentario;

/**
 * The Class ComentarioIdeiaDAO.
 */
public class ComentarioDAO extends AweipDAO {

	/**
	 * Merge.
	 * 
	 * @param comentario
	 *            the comentario
	 * @return the comentario
	 */
	public Comentario merge(Comentario comentario) {
		return entityManager.merge(comentario);
	}

	/**
	 * Persist.
	 * 
	 * @param comentario
	 *            the comentario
	 * @return the comentario
	 */
	public Comentario persist(Comentario comentario) {
		entityManager.persist(comentario);
		return comentario;
	}

}
