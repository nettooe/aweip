package com.aweip.dao;

import java.util.List;

import com.aweip.entity.Ideia;
import com.aweip.entity.IdeiaEntity;
import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.PermissaoUsuarioIdeiaEntity;
import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;

/**
 * The Class IdeiaDAO.
 */
public class IdeiaDAO extends AweipDAO {

	/**
	 * Obter ideia.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the ideia entity
	 */
	public IdeiaEntity obterIdeia(Ideia ideia) {
		return (IdeiaEntity) entityManager
				.find(ideia.getClass(), ideia.getId());
	}

	/**
	 * Merge.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the ideia
	 */
	public Ideia merge(Ideia ideia) {
		return entityManager.merge(ideia);
	}

	/**
	 * Persist.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the ideia
	 */
	public Ideia persist(Ideia ideia) {
		entityManager.persist(ideia);
		// entityManager.flush();
		return ideia;
	}

	/**
	 * Apagar.
	 * 
	 * @param ideia
	 *            the ideia
	 */
	public void apagar(Ideia ideia) {
		entityManager.remove(ideia);
	}

	/**
	 * Listar ideias.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<PermissaoUsuarioIdeia> listarIdeias(Usuario usuario) {
		return entityManager
				.createNamedQuery(PermissaoUsuarioIdeiaEntity.findByUsuario)
				.setParameter("usuario", usuario).getResultList();
	}

	/**
	 * Listar permissoes.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<PermissaoUsuarioIdeia> listarPermissoes(String idIdeia) {
		return entityManager
				.createNamedQuery(PermissaoUsuarioIdeiaEntity.findByIdeia)
				.setParameter("idIdeia", idIdeia).getResultList();
	}

	/**
	 * Listar ideias sugeridas.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Ideia> listarIdeiasSugeridas(Usuario usuario) {
		// return
		// entityManager.createNamedQuery(PermissaoUsuarioIdeiaEntity.findByUsuario)
		// .setParameter("usuario", usuario).getResultList();
		return entityManager.createNamedQuery(
				IdeiaEntity.sugerirIdeiasByUsuario).getResultList();
	}

	/**
	 * Listar feeds.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Ideia> listarFeeds(UsuarioEntity usuario) {
		return entityManager.createNamedQuery(IdeiaEntity.listarFeedsByUsuario)
				.setMaxResults(200).getResultList();
	}

	/**
	 * Obter avatar ideia.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the byte[]
	 */
	public byte[] obterAvatarIdeia(String idIdeia) {
		return (byte[]) entityManager
				.createNamedQuery(IdeiaEntity.obterAvatarIdeia)
				.setParameter("idIdeia", idIdeia).getSingleResult();
	}

	/**
	 * Pesquisar ideias.
	 * 
	 * @param termoPesquisado
	 *            the termo pesquisado
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<Ideia> pesquisarIdeias(String termoPesquisado) {
		return entityManager.createNamedQuery(IdeiaEntity.pesquisarIdeia)
				.setParameter("termoPesquisadoTitulo", termoPesquisado)
				.setParameter("termoPesquisadoResumo", termoPesquisado)
				.setMaxResults(100).getResultList();
	}

}
