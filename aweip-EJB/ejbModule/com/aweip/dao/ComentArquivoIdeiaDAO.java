package com.aweip.dao;

import java.util.List;

import com.aweip.entity.ArquivoIdeia;
import com.aweip.entity.ComentArquivoIdeia;
import com.aweip.entity.ComentArquivoIdeiaEntity;

/**
 * The Class ComentArquivoIdeiaDAO.
 */
public class ComentArquivoIdeiaDAO extends AweipDAO {

	/**
	 * Find coments arquivo ideia.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<ComentArquivoIdeia> findComentsArquivoIdeia(
			ArquivoIdeia arquivoIdeia) {
		return entityManager
				.createNamedQuery(ComentArquivoIdeiaEntity.findByArquivoIdeia)
				.setParameter("arquivoIdeia", arquivoIdeia).getResultList();
	}

	/**
	 * Merge.
	 * 
	 * @param comentArquivoIdeia
	 *            the coment arquivo ideia
	 * @return the coment arquivo ideia
	 */
	public ComentArquivoIdeia merge(ComentArquivoIdeia comentArquivoIdeia) {
		return entityManager.merge(comentArquivoIdeia);
	}

	/**
	 * Persist.
	 * 
	 * @param comentArquivoIdeia
	 *            the coment arquivo ideia
	 * @return the coment arquivo ideia
	 */
	public ComentArquivoIdeia persist(ComentArquivoIdeia comentArquivoIdeia) {
		entityManager.persist(comentArquivoIdeia);
		return comentArquivoIdeia;
	}

	/**
	 * Find.
	 * 
	 * @param comentArquivoIdeia
	 *            the coment arquivo ideia
	 * @return the coment arquivo ideia entity
	 */
	public ComentArquivoIdeiaEntity find(ComentArquivoIdeia comentArquivoIdeia) {
		return entityManager.find(ComentArquivoIdeiaEntity.class,
				comentArquivoIdeia.getId());
	}
}
