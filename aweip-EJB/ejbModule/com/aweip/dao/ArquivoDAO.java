package com.aweip.dao;

import com.aweip.entity.Arquivo;
import com.aweip.entity.ArquivoEntity;
import com.aweip.entity.ArquivoIdeia;

/**
 * The Class ArquivoDAO.
 */
public class ArquivoDAO extends AweipDAO {

	/**
	 * Obter arquivo.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo
	 */
	public Arquivo obterArquivo(ArquivoIdeia arquivoIdeia) {
		return (Arquivo) entityManager
				.createNamedQuery(ArquivoEntity.findByArquivoIdeia)
				.setParameter("arquivoIdeia", arquivoIdeia).getSingleResult();
	}

}
