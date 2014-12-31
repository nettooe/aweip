package com.aweip.dao;

import java.util.List;

import com.aweip.entity.Ideia;
import com.aweip.entity.IdeiaEntity;
import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.PermissaoUsuarioIdeiaEntity;
import com.aweip.entity.Usuario;

public class IdeiaDAO extends AweipDAO {

	public IdeiaEntity obterIdeia(Ideia ideia) {
		return (IdeiaEntity) entityManager
				.find(ideia.getClass(), ideia.getId());
	}

	public Ideia merge(Ideia ideia) {
		return entityManager.merge(ideia);
	}

	public Ideia persist(Ideia ideia) {
		entityManager.persist(ideia);
		// entityManager.flush();
		return ideia;
	}

	public void apagar(Ideia ideia) {
		entityManager.remove(ideia);
	}

	@SuppressWarnings("unchecked")
	public List<PermissaoUsuarioIdeia> listarIdeias(Usuario usuario) {
		return entityManager
				.createNamedQuery(PermissaoUsuarioIdeiaEntity.findByUsuario)
				.setParameter("usuario", usuario).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PermissaoUsuarioIdeia> listarPermissoes(String idIdeia) {
		return entityManager
				.createNamedQuery(PermissaoUsuarioIdeiaEntity.findByIdeia)
				.setParameter("idIdeia", idIdeia).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Ideia> listarIdeiasSugeridas(Usuario usuario) {
		// return
		// entityManager.createNamedQuery(PermissaoUsuarioIdeiaEntity.findByUsuario)
		// .setParameter("usuario", usuario).getResultList();
		return entityManager.createNamedQuery(
				IdeiaEntity.sugerirIdeiasByUsuario).getResultList();
	}

}
