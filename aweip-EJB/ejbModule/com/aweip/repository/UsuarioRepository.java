package com.aweip.repository;

import java.util.List;

import javax.inject.Inject;

import com.aweip.dao.InteresseDAO;
import com.aweip.dao.UsuarioDAO;
import com.aweip.entity.Interesse;
import com.aweip.entity.InteresseEntity;
import com.aweip.entity.Usuario;

public class UsuarioRepository {

	@Inject
	private UsuarioDAO dao;

	@Inject
	private InteresseDAO interesseDAO;
	
	public List<InteresseEntity> listarInteresses(Usuario usuario) {
		return interesseDAO.listarInteresses(usuario);
	}

	public Interesse salvarInteresse(Interesse interesse) {
		if (interesse.getId() != null) {
			return interesseDAO.merge(interesse);
		} else {
			return interesseDAO.persist(interesse);
		}
	}
	
	public void remover(Interesse interesse){
		interesseDAO.remover(interesse);
	}

	public Usuario obterUsuario(Usuario usuario) throws Exception {
		if (usuario != null && usuario.getId() != null) {
			return dao.obterUsuario(usuario);
		} else {
			throw new Exception("Não foi possível obter os dados do usuario.");
		}
	}

	public Usuario autenticarUsuario(Usuario usuario) {
		return dao.autenticarUsuario(usuario);
	}

	public Usuario save(Usuario usuario) {
		if (usuario.getId() != null) {
			return dao.merge(usuario);
		} else {
			return dao.persist(usuario);
		}
	}

}
