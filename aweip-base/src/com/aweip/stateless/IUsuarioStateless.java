package com.aweip.stateless;

import java.util.List;

import com.aweip.entity.Interesse;
import com.aweip.entity.InteresseEntity;
import com.aweip.entity.Usuario;

/**
 * The Interface IUsuarioStateless.
 */
public interface IUsuarioStateless {
	// TODO eliminar
	/**
	 * Gerar usuario.
	 *
	 * @return the usuario
	 */
	Usuario gerarUsuario();
	
	/**
	 * Listar interesses.
	 *
	 * @param usuario the usuario
	 * @return the list
	 */
	List<InteresseEntity> listarInteresses(Usuario usuario);
	
	/**
	 * Salvar interesse.
	 *
	 * @param interesse the interesse
	 * @return the interesse
	 */
	Interesse salvarInteresse(Interesse interesse);
	
	/**
	 * Remover.
	 *
	 * @param interesse the interesse
	 */
	void remover(Interesse interesse);
	
	/**
	 * Obter usuario.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 * @throws Exception the exception
	 */
	Usuario obterUsuario(Usuario usuario) throws Exception;

	/**
	 * Autenticar usuario.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 */
	Usuario autenticarUsuario(Usuario usuario);

	/**
	 * Save.
	 *
	 * @param usuario the usuario
	 * @return the usuario
	 */
	Usuario save(Usuario usuario);

	/**
	 * Alterar senha.
	 *
	 * @param usuario the usuario
	 * @param novaSenha the nova senha
	 * @param repitaSenha the repita senha
	 * @throws Exception the exception
	 */
	void alterarSenha(Usuario usuario, String novaSenha, String repitaSenha) throws Exception ;

}
