package com.aweip.repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.aweip.dao.ArquivoDAO;
import com.aweip.dao.ArquivoIdeiaDAO;
import com.aweip.dao.ComentArquivoIdeiaDAO;
import com.aweip.dao.ComentIdeiaResumoDAO;
import com.aweip.dao.IdeiaDAO;
import com.aweip.dao.PalavraChaveDAO;
import com.aweip.dao.PermissaoUsuarioIdeiaDAO;
import com.aweip.dao.UsuarioDAO;
import com.aweip.entity.Arquivo;
import com.aweip.entity.ArquivoIdeia;
import com.aweip.entity.ArquivoIdeiaEntity;
import com.aweip.entity.ComentArquivoIdeia;
import com.aweip.entity.ComentArquivoIdeiaEntity;
import com.aweip.entity.ComentarioIdeia;
import com.aweip.entity.Ideia;
import com.aweip.entity.PalavraChaveIdeiaEntity;
import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.PermissaoUsuarioIdeiaEntity;
import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;
import com.aweip.entity.discreto.TipoPermissao;

/**
 * The Class IdeiaRepository.
 */
public class IdeiaRepository {

	/** The dao. */
	@Inject
	private IdeiaDAO dao;

	/** The permissao dao. */
	@Inject
	private PermissaoUsuarioIdeiaDAO permissaoDao;

	/** The arquivo ideia dao. */
	@Inject
	private ArquivoIdeiaDAO arquivoIdeiaDAO;

	/** The arquivo dao. */
	@Inject
	private ArquivoDAO arquivoDAO;

	/** The palavra chave dao. */
	@Inject
	private PalavraChaveDAO palavraChaveDAO;

	/** The comentario dao. */
	// @Inject
	// private ComentarioDAO comentarioDAO;

	/** The coment ideia resumo dao. */
	@Inject
	private ComentIdeiaResumoDAO comentIdeiaResumoDAO;

	/** The coment arquivo ideia dao. */
	@Inject
	private ComentArquivoIdeiaDAO comentArquivoIdeiaDAO;

	/** The usuario dao. */
	@Inject
	private UsuarioDAO usuarioDAO;

	/**
	 * Find.
	 * 
	 * @param comentArquivoIdeia
	 *            the coment arquivo ideia
	 * @return the coment arquivo ideia entity
	 */
	public ComentArquivoIdeiaEntity find(ComentArquivoIdeia comentArquivoIdeia) {
		return this.comentArquivoIdeiaDAO.find(comentArquivoIdeia);
	}

	/**
	 * Listar palavra chave ideia.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the list
	 */
	public List<PalavraChaveIdeiaEntity> listarPalavraChaveIdeia(Ideia ideia) {
		return palavraChaveDAO.listarPalavraChaveIdeia(ideia);
	}

	/**
	 * Persist.
	 * 
	 * @param palavraChaveIdeia
	 *            the palavra chave ideia
	 */
	public void persist(PalavraChaveIdeiaEntity palavraChaveIdeia) {
		palavraChaveDAO.persist(palavraChaveIdeia);
	}

	/**
	 * Remover.
	 * 
	 * @param palavraChaveIdeia
	 *            the palavra chave ideia
	 */
	public void remover(PalavraChaveIdeiaEntity palavraChaveIdeia) {
		palavraChaveDAO.remover(palavraChaveIdeia);
	}

	/**
	 * Obter arquivo.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo
	 */
	public Arquivo obterArquivo(ArquivoIdeia arquivoIdeia) {
		return arquivoDAO.obterArquivo(arquivoIdeia);
	}

	/**
	 * Obter arquivo ideia.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo ideia
	 */
	public ArquivoIdeia obterArquivoIdeia(ArquivoIdeia arquivoIdeia) {
		return arquivoIdeiaDAO.obterArquivoIdeia(arquivoIdeia);
	}

	/**
	 * Salvar arquivo ideia.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo ideia entity
	 */
	public ArquivoIdeiaEntity salvarArquivoIdeia(ArquivoIdeiaEntity arquivoIdeia) {
		if (arquivoIdeia.getId() != null) {
			return arquivoIdeiaDAO.merge(arquivoIdeia);
		} else {
			arquivoIdeiaDAO.persist(arquivoIdeia);
			return arquivoIdeia;
		}
	}

	/**
	 * Atualizar arquivo.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the arquivo ideia entity
	 */
	public ArquivoIdeiaEntity atualizarArquivo(ArquivoIdeiaEntity arquivoIdeia) {
		arquivoIdeiaDAO.atualizarArquivo(arquivoIdeia);
		return arquivoIdeia;
	}

	/**
	 * Obter ideia.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the ideia
	 */
	public Ideia obterIdeia(Ideia ideia) {
		if (ideia != null && ideia.getId() != null) {
			return dao.obterIdeia(ideia);
		} else {
			// throw new
			// Exception("Não foi possível obter os dados do usuario.");
		}
		return null;
	}

	/**
	 * Save.
	 * 
	 * @param ideia
	 *            the ideia
	 * @param usu
	 *            the usu
	 * @return the ideia
	 */
	public Ideia save(Ideia ideia, Usuario usu) {
		if (ideia.getId() != null) {
			// TODO Verificar se o usuário tem permissão
			return dao.merge(ideia);
		} else {
			ideia = dao.persist(ideia);

			PermissaoUsuarioIdeiaEntity permissao = new PermissaoUsuarioIdeiaEntity();
			permissao.setUsuario(usu);
			permissao.setIdeia(ideia);
			permissao.setTipoPermissao(TipoPermissao.CRIADOR);

			permissaoDao.merge(permissao);

			return permissao.getIdeia();
		}
	}

	/**
	 * Save.
	 * 
	 * @param permissao
	 *            the permissao
	 * @return the permissao usuario ideia
	 */
	public PermissaoUsuarioIdeia save(PermissaoUsuarioIdeia permissao) {
		if (permissao.getId() != null) {
			return permissaoDao.merge(permissao);
		} else {
			return permissaoDao.persist(permissao);
		}
	}

	/**
	 * Listar ideias.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	public List<PermissaoUsuarioIdeia> listarIdeias(Usuario usuario) {
		return dao.listarIdeias(usuario);
	}

	/**
	 * Listar permissoes.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the list
	 */
	public List<PermissaoUsuarioIdeia> listarPermissoes(String idIdeia) {
		return dao.listarPermissoes(idIdeia);
	}

	/**
	 * Listar ideias sugeridas.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	public List<Ideia> listarIdeiasSugeridas(Usuario usuario) {
		return dao.listarIdeiasSugeridas(usuario);
	}

	/**
	 * Apagar.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 */
	public void apagar(ArquivoIdeia arquivoIdeia) {
		arquivoIdeiaDAO.apagar(arquivoIdeia);
	}

	/**
	 * Find coments ideia resumo.
	 * 
	 * @param ideia
	 *            the ideia
	 * @return the list
	 */
	public List<ComentarioIdeia> findComentsIdeiaResumo(Ideia ideia) {
		if (ideia.getId() != null) {
			return this.comentIdeiaResumoDAO.findComentsIdeiaResumo(ideia);
		} else {
			return new ArrayList<ComentarioIdeia>();
		}
	}

	/**
	 * Find coments arquivo ideia.
	 * 
	 * @param arquivoIdeia
	 *            the arquivo ideia
	 * @return the list
	 */
	public List<ComentArquivoIdeia> findComentsArquivoIdeia(
			ArquivoIdeia arquivoIdeia) {
		if (arquivoIdeia.getId() != null) {
			return this.comentArquivoIdeiaDAO
					.findComentsArquivoIdeia(arquivoIdeia);
		} else {
			return new ArrayList<ComentArquivoIdeia>();
		}
	}

	/**
	 * Save.
	 * 
	 * @param comentarioIdeia
	 *            the comentario ideia
	 * @return the comentario ideia
	 */
	public ComentarioIdeia save(ComentarioIdeia comentarioIdeia) {
		if (comentarioIdeia.getId() != null) {
			return this.comentIdeiaResumoDAO.merge(comentarioIdeia);
		} else {
			comentarioIdeia.getComentario().setUsuario(
					this.usuarioDAO.obterUsuario(comentarioIdeia
							.getComentario().getUsuario()));
			return this.comentIdeiaResumoDAO.persist(comentarioIdeia);
		}
	}

	/**
	 * Save.
	 * 
	 * @param comentArquivoIdeia
	 *            the coment arquivo ideia
	 * @return the coment arquivo ideia
	 */
	public ComentArquivoIdeia save(ComentArquivoIdeia comentArquivoIdeia) {
		if (comentArquivoIdeia.getId() != null) {
			return this.comentArquivoIdeiaDAO.merge(comentArquivoIdeia);
		} else {
			comentArquivoIdeia.getComentario().setUsuario(
					this.usuarioDAO.obterUsuario(comentArquivoIdeia
							.getComentario().getUsuario()));
			return this.comentArquivoIdeiaDAO.persist(comentArquivoIdeia);
		}
	}

	/**
	 * Listar feeds.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the list
	 */
	public List<Ideia> listarFeeds(UsuarioEntity usuario) {
		return dao.listarFeeds(usuario);
	}

	/**
	 * Obter avatar ideia.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the byte[]
	 */
	public byte[] obterAvatarIdeia(String idIdeia) {
		return dao.obterAvatarIdeia(idIdeia);
	}

	/**
	 * Pesquisar ideias.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param termoPesquisado
	 *            the termo pesquisado
	 * @return the list
	 */
	public List<Ideia> pesquisarIdeias(UsuarioEntity usuario,
			String termoPesquisado) {
		return dao.pesquisarIdeias(usuario, termoPesquisado);
	}

	/**
	 * Obter avatar usuario.
	 * 
	 * @param idUsuario
	 *            the id usuario
	 * @return the byte[]
	 */
	public byte[] obterAvatarUsuario(String idUsuario) {
		return this.usuarioDAO.obterAvatarUsuario(idUsuario);
	}
}
