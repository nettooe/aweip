package com.aweip.dao;

import java.util.List;

import com.aweip.entity.Ideia;
import com.aweip.entity.PalavraChave;
import com.aweip.entity.PalavraChaveEntity;
import com.aweip.entity.PalavraChaveIdeiaEntity;

public class PalavraChaveDAO extends AweipDAO {

	@SuppressWarnings("unchecked")
	public List<PalavraChaveIdeiaEntity> listarPalavraChaveIdeia(Ideia ideia) {
		return entityManager
				.createNamedQuery(PalavraChaveIdeiaEntity.listByIdeia)
				.setParameter("ideia", ideia).getResultList();
	}

	public void persist(PalavraChaveIdeiaEntity palavraChaveIdeia) {
		PalavraChave palavraChave = getOuPersiste(palavraChaveIdeia
				.getPalavraChave());

		if (palavraChave != null && palavraChave.getId() != null) {
			palavraChaveIdeia.setPalavraChave(palavraChave);
		}
		entityManager.persist(palavraChaveIdeia);
	}

	public void remover(PalavraChaveIdeiaEntity palavraChaveIdeia) {
		palavraChaveIdeia = entityManager.find(PalavraChaveIdeiaEntity.class,
				palavraChaveIdeia.getId());
		entityManager.remove(palavraChaveIdeia);
	}

	@SuppressWarnings("unchecked")
	private PalavraChave getOuPersiste(PalavraChave palavraChave) {
		System.out.println("PesquisandoTermo:" + palavraChave.getTermo());
		List<PalavraChaveEntity> lista = entityManager
				.createNamedQuery(PalavraChaveEntity.findByTermo)
				.setParameter("termo", palavraChave.getTermo()).getResultList();

		if (lista != null && lista.size() > 0) {
			palavraChave = lista.get(0);
			palavraChave = entityManager.find(PalavraChaveEntity.class,
					palavraChave.getId());
			System.out.println("Encontrado:" + palavraChave.getTermo());
		} else {
			entityManager.persist(palavraChave);
			System.out.println("NãoEncontrado e persistido:"
					+ palavraChave.getTermo());
		}

		return palavraChave;
	}
}
