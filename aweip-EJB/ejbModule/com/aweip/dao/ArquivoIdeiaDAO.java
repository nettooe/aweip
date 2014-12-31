package com.aweip.dao;

import java.util.Calendar;

import com.aweip.entity.ArquivoIdeia;
import com.aweip.entity.ArquivoIdeiaEntity;

public class ArquivoIdeiaDAO extends AweipDAO {

	public ArquivoIdeia obterArquivoIdeia(ArquivoIdeia arquivoIdeia) {
		return entityManager
				.find(arquivoIdeia.getClass(), arquivoIdeia.getId());
	}

	public ArquivoIdeiaEntity merge(ArquivoIdeiaEntity arquivoIdeia) {
		entityManager.merge(arquivoIdeia.getArquivo());
		return (ArquivoIdeiaEntity) entityManager.merge(arquivoIdeia);
	}

	public void persist(ArquivoIdeia arquivoIdeia) {
		entityManager.persist(arquivoIdeia.getArquivo());
		entityManager.persist(arquivoIdeia);
		entityManager.flush();
	}

	public void atualizarArquivo(ArquivoIdeia arquivoIdeia) {
		entityManager.merge(arquivoIdeia.getArquivo());
		entityManager.merge(arquivoIdeia);
		entityManager.flush();
	}

	public void apagar(ArquivoIdeia ai) {
		ArquivoIdeiaEntity arquivoIdeia = (ArquivoIdeiaEntity) entityManager
				.find(ai.getClass(), ai.getId());

		arquivoIdeia.getArquivo().setDataExclusao(Calendar.getInstance());
		entityManager.merge(arquivoIdeia.getArquivo());

		arquivoIdeia.setDataExclusao(Calendar.getInstance());
		entityManager.merge(arquivoIdeia);
	}

}
