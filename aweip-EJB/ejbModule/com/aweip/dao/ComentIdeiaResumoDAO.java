package com.aweip.dao;

import java.util.List;

import com.aweip.entity.ComentarioIdeia;
import com.aweip.entity.ComentarioIdeiaEntity;
import com.aweip.entity.Ideia;

/**
 * The Class ComentarioIdeiaDAO.
 */
public class ComentIdeiaResumoDAO extends AweipDAO {

	/**
	 * Listar comentario ideia.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<ComentarioIdeia> findComentsIdeiaResumo(Ideia ideia) {
		return entityManager
				.createNamedQuery(ComentarioIdeiaEntity.findByIdeia)
				.setParameter("ideia", ideia).getResultList();
	}

	/**
	 * Merge.
	 * 
	 * @param comentarioIdeia
	 *            the comentario ideia
	 * @return the comentario ideia
	 */
	public ComentarioIdeia merge(ComentarioIdeia comentarioIdeia) {
		return entityManager.merge(comentarioIdeia);
	}

	/**
	 * Persist.
	 * 
	 * @param comentarioIdeia
	 *            the comentario ideia
	 * @return the comentario ideia
	 */
	public ComentarioIdeia persist(ComentarioIdeia comentarioIdeia) {
		entityManager.persist(comentarioIdeia);
		return comentarioIdeia;
	}

}
