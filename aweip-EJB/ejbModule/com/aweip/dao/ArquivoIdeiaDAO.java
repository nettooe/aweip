package com.aweip.dao;

import java.util.Calendar;

import com.aweip.entity.ArquivoIdeia;
import com.aweip.entity.ArquivoIdeiaEntity;

/**
 * The Class ArquivoIdeiaDAO.
 */
public class ArquivoIdeiaDAO extends AweipDAO {

	/**
	 * Obter arquivo ideia.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo ideia
	 */
	public ArquivoIdeia obterArquivoIdeia(ArquivoIdeia arquivoIdeia) {
		return entityManager
				.find(arquivoIdeia.getClass(), arquivoIdeia.getId());
	}

	/**
	 * Merge.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo ideia entity
	 */
	public ArquivoIdeiaEntity merge(ArquivoIdeiaEntity arquivoIdeia) {
		entityManager.merge(arquivoIdeia.getArquivo());
		return (ArquivoIdeiaEntity) entityManager.merge(arquivoIdeia);
	}

	/**
	 * Persist.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 */
	public void persist(ArquivoIdeia arquivoIdeia) {
		entityManager.persist(arquivoIdeia.getArquivo());
		entityManager.persist(arquivoIdeia);
		entityManager.flush();
	}

	/**
	 * Atualizar arquivo.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 */
	public void atualizarArquivo(ArquivoIdeia arquivoIdeia) {
		entityManager.merge(arquivoIdeia.getArquivo());
		entityManager.merge(arquivoIdeia);
		entityManager.flush();
	}

	/**
	 * Apagar.
	 * 
	 * @param ai
	 *            the ai
	 */
	public void apagar(ArquivoIdeia ai) {
		ArquivoIdeiaEntity arquivoIdeia = (ArquivoIdeiaEntity) entityManager
				.find(ai.getClass(), ai.getId());

		arquivoIdeia.getArquivo().setDataExclusao(Calendar.getInstance());
		entityManager.merge(arquivoIdeia.getArquivo());

		arquivoIdeia.setDataExclusao(Calendar.getInstance());
		entityManager.merge(arquivoIdeia);
	}

}
