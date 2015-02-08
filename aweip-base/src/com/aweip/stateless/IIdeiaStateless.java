package com.aweip.stateless;

import java.util.List;

import com.aweip.entity.Arquivo;
import com.aweip.entity.ArquivoIdeia;
import com.aweip.entity.ArquivoIdeiaEntity;
import com.aweip.entity.ComentArquivoIdeia;
import com.aweip.entity.ComentArquivoIdeiaEntity;
import com.aweip.entity.ComentarioIdeia;
import com.aweip.entity.Ideia;
import com.aweip.entity.PalavraChaveIdeiaEntity;
import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;

/**
 * The Interface IIdeiaStateless.
 */
public interface IIdeiaStateless {

	/**
	 * Apagar.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 */
	void apagar(ArquivoIdeia arquivoIdeia);

	/**
	 * Atualizar arquivo.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo ideia entity
	 */
	ArquivoIdeiaEntity atualizarArquivo(ArquivoIdeiaEntity arquivoIdeia);

	/**
	 * Listar palavra chave ideia.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the list
	 */
	List<PalavraChaveIdeiaEntity> listarPalavraChaveIdeia(Ideia ideia);

	/**
	 * Save.
	 * 
	 * @param palavraChaveIdeia
	 *            the palavra chave ideia
	 */
	void save(PalavraChaveIdeiaEntity palavraChaveIdeia);

	/**
	 * Remover.
	 * 
	 * @param palavraChaveIdeia
	 *            the palavra chave ideia
	 */
	void remover(PalavraChaveIdeiaEntity palavraChaveIdeia);

	/**
	 * Obter arquivo ideia.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo ideia
	 */
	ArquivoIdeia obterArquivoIdeia(ArquivoIdeia arquivoIdeia);

	/**
	 * Save.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo ideia entity
	 */
	ArquivoIdeiaEntity save(ArquivoIdeiaEntity arquivoIdeia);

	/**
	 * Obter arquivo.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo
	 */
	Arquivo obterArquivo(ArquivoIdeia arquivoIdeia);

	/**
	 * Listar ideias.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	List<PermissaoUsuarioIdeia> listarIdeias(Usuario usuario);

	/**
	 * Listar permissoes.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the list
	 */
	List<PermissaoUsuarioIdeia> listarPermissoes(String idIdeia);

	/**
	 * Listar ideias sugeridas.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	List<Ideia> listarIdeiasSugeridas(Usuario usuario);

	/**
	 * Obter ideia.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the ideia
	 */
	Ideia obterIdeia(Ideia ideia);

	/**
	 * Save.
	 * 
	 * @param ideia
	 *            the ideia
	 * @param usuario
	 *            the usuario
	 * @return the ideia
	 */
	Ideia save(Ideia ideia, Usuario usuario);

	/**
	 * Find coments ideia resumo.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the list
	 */
	List<ComentarioIdeia> findComentsIdeiaResumo(Ideia ideia);

	/**
	 * Find coments arquivo ideia.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the list
	 */
	List<ComentArquivoIdeia> findComentsArquivoIdeia(ArquivoIdeia arquivoIdeia);

	/**
	 * Save.
	 * 
	 * @param comentarioIdeia
	 *            the comentario ideia
	 * @return the comentario ideia
	 */
	ComentarioIdeia save(ComentarioIdeia comentarioIdeia);

	/**
	 * Save.
	 * 
	 * @param comentArquivoIdeia
	 *            the coment arquivo ideia
	 * @return the coment arquivo ideia
	 */
	ComentArquivoIdeia save(ComentArquivoIdeia comentArquivoIdeia);

	/**
	 * Find.
	 * 
	 * @param comentArquivoIdeia
	 *            the coment arquivo ideia
	 * @return the coment arquivo ideia entity
	 */
	ComentArquivoIdeiaEntity find(ComentArquivoIdeia comentArquivoIdeia);

	/**
	 * Listar feeds.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	List<Ideia> listarFeeds(UsuarioEntity usuario);

	/**
	 * Obter avatar ideia.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the byte[]
	 */
	byte[] obterAvatarIdeia(String idIdeia);

	/**
	 * Pesquisar ideias.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param termoPesquisado
	 *            the termo pesquisado
	 * @return the list
	 */
	List<Ideia> pesquisarIdeias(UsuarioEntity usuario, String termoPesquisado);

	/**
	 * Obter avatar usuario.
	 * 
	 * @param idUsuario
	 *            the id usuario
	 * @return the byte[]
	 */
	byte[] obterAvatarUsuario(String idUsuario);

}
