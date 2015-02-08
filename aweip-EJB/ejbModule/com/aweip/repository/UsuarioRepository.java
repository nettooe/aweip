package com.aweip.repository;

import java.util.List;

import javax.inject.Inject;

import com.aweip.dao.InteresseDAO;
import com.aweip.dao.UsuarioDAO;
import com.aweip.entity.Interesse;
import com.aweip.entity.InteresseEntity;
import com.aweip.entity.Usuario;
import com.aweip.util.AppConstants;

/**
 * The Class UsuarioRepository.
 */
public class UsuarioRepository {

	/** The dao. */
	@Inject
	private UsuarioDAO dao;

	/** The interesse dao. */
	@Inject
	private InteresseDAO interesseDAO;

	/**
	 * Listar interesses.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	public List<InteresseEntity> listarInteresses(Usuario usuario) {
		return interesseDAO.listarInteresses(usuario);
	}

	/**
	 * Salvar interesse.
	 * 
	 * @param interesse
	 *            the interesse
	 * @return the interesse
	 */
	public Interesse salvarInteresse(Interesse interesse) {
		if (interesse.getId() != null) {
			return interesseDAO.merge(interesse);
		} else {
			return interesseDAO.persist(interesse);
		}
	}

	/**
	 * Remover.
	 * 
	 * @param interesse
	 *            the interesse
	 */
	public void remover(Interesse interesse) {
		interesseDAO.remover(interesse);
	}

	/**
	 * Obter usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 * @throws Exception
	 *             the exception
	 */
	public Usuario obterUsuario(Usuario usuario) throws Exception {
		if (usuario != null && usuario.getId() != null) {
			return dao.obterUsuario(usuario);
		} else {
			throw new Exception("Não foi possível obter os dados do usuario.");
		}
	}

	/**
	 * Autenticar usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	public Usuario autenticarUsuario(Usuario usuario) {
		return dao.autenticarUsuario(usuario);
	}

	/**
	 * Save.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the usuario
	 */
	public Usuario save(Usuario usuario) {
		if (usuario.getId() != null) {
			return dao.merge(usuario);
		} else {
			return dao.persist(usuario);
		}
	}

	/**
	 * Alterar senha.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param novaSenha
	 *            the nova senha
	 * @param repitaSenha
	 *            the repita senha
	 * @throws Exception
	 *             the exception
	 */
	public void alterarSenha(Usuario usuario, String novaSenha,
			String repitaSenha) throws Exception {
		if (null == novaSenha || null == repitaSenha) {
			throw new Exception("Senha não pode ser nula.", new Throwable(
					"Foi informada uma senha vazia."));
		} else if (!novaSenha.equals(repitaSenha)) {
			throw new Exception("Senhas devem ser idênticas.", new Throwable(
					"Foram informadas senhas diferentes."));
		} else if (novaSenha.length() < AppConstants.SENHA_TAMANHO_MINIMO) {
			throw new Exception(
					"Senha deve ter no mínimo "
							+ AppConstants.SENHA_TAMANHO_MINIMO
							+ " caracteres.",
					new Throwable(
							"Senha informada não contém a quantidade mínima de caracteres."));
		} else if (novaSenha.length() > AppConstants.SENHA_TAMANHO_MAXIMO) {
			throw new Exception(
					"Senhs deve ter no máximo "
							+ AppConstants.SENHA_TAMANHO_MAXIMO
							+ " caracteres.",
					new Throwable(
							"Senha informada excede a quantidade máxima de caracteres."));
		} else {
			// passou por todas as validações
			dao.alterarSenha(usuario.getId(), novaSenha);
		}
	}

}
