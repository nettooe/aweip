package com.aweip.dao;

import java.util.List;

import com.aweip.entity.Ideia;
import com.aweip.entity.PalavraChave;
import com.aweip.entity.PalavraChaveEntity;
import com.aweip.entity.PalavraChaveIdeiaEntity;

/**
 * The Class PalavraChaveDAO.
 */
public class PalavraChaveDAO extends AweipDAO {

	/**
	 * Listar palavra chave ideia.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<PalavraChaveIdeiaEntity> listarPalavraChaveIdeia(Ideia ideia) {
		return entityManager
				.createNamedQuery(PalavraChaveIdeiaEntity.listByIdeia)
				.setParameter("ideia", ideia).getResultList();
	}

	/**
	 * Persist.
	 * 
	 * @param palavraChaveIdeia
	 *            the palavra chave ideia
	 */
	public void persist(PalavraChaveIdeiaEntity palavraChaveIdeia) {
		PalavraChave palavraChave = getOuPersiste(palavraChaveIdeia
				.getPalavraChave());

		if (palavraChave != null && palavraChave.getId() != null) {
			palavraChaveIdeia.setPalavraChave(palavraChave);
		}
		entityManager.persist(palavraChaveIdeia);
	}

	/**
	 * Remover.
	 * 
	 * @param palavraChaveIdeia
	 *            the palavra chave ideia
	 */
	public void remover(PalavraChaveIdeiaEntity palavraChaveIdeia) {
		palavraChaveIdeia = entityManager.find(PalavraChaveIdeiaEntity.class,
				palavraChaveIdeia.getId());
		entityManager.remove(palavraChaveIdeia);
	}

	/**
	 * Gets the ou persiste.
	 * 
	 * @param palavraChave
	 *            the palavra chave
	 * @return the ou persiste
	 */
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
