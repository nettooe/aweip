package com.aweip.dao;

import com.aweip.entity.Arquivo;
import com.aweip.entity.ArquivoEntity;
import com.aweip.entity.ArquivoIdeia;

public class ArquivoDAO extends AweipDAO {

	public Arquivo obterArquivo(ArquivoIdeia arquivoIdeia) {
		return (Arquivo) entityManager
				.createNamedQuery(ArquivoEntity.findByArquivoIdeia)
				.setParameter("arquivoIdeia", arquivoIdeia).getSingleResult();
	}

}
