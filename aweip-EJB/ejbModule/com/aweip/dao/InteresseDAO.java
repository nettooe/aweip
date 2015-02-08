package com.aweip.dao;

import java.util.List;

import com.aweip.entity.Interesse;
import com.aweip.entity.InteresseEntity;
import com.aweip.entity.PalavraChave;
import com.aweip.entity.PalavraChaveEntity;
import com.aweip.entity.Usuario;

/**
 * The Class InteresseDAO.
 */
public class InteresseDAO extends AweipDAO {

	/**
	 * Listar interesses.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<InteresseEntity> listarInteresses(Usuario usuario) {
		return entityManager.createNamedQuery(InteresseEntity.listByUsuario)
				.setParameter("usuario", usuario).getResultList();
	}

	/**
	 * Persist.
	 * 
	 * @param interesse
	 *            the interesse
	 * @return the interesse
	 */
	public Interesse persist(Interesse interesse) {
		PalavraChave palavraChave = getOuPersiste(interesse.getPalavraChave());

		if (palavraChave != null && palavraChave.getId() != null) {
			interesse.setPalavraChave(palavraChave);
		}
		entityManager.persist(interesse);
		return interesse;
	}

	/**
	 * Merge.
	 * 
	 * @param interesse
	 *            the interesse
	 * @return the interesse
	 */
	public Interesse merge(Interesse interesse) {
		PalavraChave palavraChave = getOuPersiste(interesse.getPalavraChave());

		if (palavraChave != null && palavraChave.getId() != null) {
			interesse.setPalavraChave(palavraChave);
		}
		return entityManager.merge(interesse);
	}

	/**
	 * Remover.
	 * 
	 * @param interesse
	 *            the interesse
	 */
	public void remover(Interesse interesse) {
		InteresseEntity entity = entityManager.find(InteresseEntity.class,
				interesse.getId());
		// entityManager.refresh(palavraChaveUsuario);
		entityManager.remove(entity);
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
