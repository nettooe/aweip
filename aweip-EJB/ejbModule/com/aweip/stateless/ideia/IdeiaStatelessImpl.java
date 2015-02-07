package com.aweip.stateless.ideia;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

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
import com.aweip.repository.IdeiaRepository;
import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class IdeiaStatelessImpl.
 */
@Stateless
@Remote(IIdeiaStateless.class)
public class IdeiaStatelessImpl implements IIdeiaStateless {

	/** The repository. */
	@Inject
	IdeiaRepository ideiaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#apagar(com.aweip.entity.ArquivoIdeia)
	 */
	public void apagar(ArquivoIdeia arquivoIdeia) {
		ideiaRepository.apagar(arquivoIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#atualizarArquivo(com.aweip.entity
	 * .ArquivoIdeiaEntity)
	 */
	public ArquivoIdeiaEntity atualizarArquivo(ArquivoIdeiaEntity arquivoIdeia) {
		return ideiaRepository.atualizarArquivo(arquivoIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#obterIdeia(com.aweip.entity.Ideia)
	 */
	public Ideia obterIdeia(Ideia ideia) {
		return ideiaRepository.obterIdeia(ideia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#obterArquivoIdeia(com.aweip.entity
	 * .ArquivoIdeia)
	 */
	public ArquivoIdeia obterArquivoIdeia(ArquivoIdeia arquivoIdeia) {
		return ideiaRepository.obterArquivoIdeia(arquivoIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aweip.stateless.IIdeiaStateless#save(com.aweip.entity.Ideia,
	 * com.aweip.entity.Usuario)
	 */
	public Ideia save(Ideia ideia, Usuario usuario) {
		return ideiaRepository.save(ideia, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#save(com.aweip.entity.ArquivoIdeiaEntity
	 * )
	 */
	public ArquivoIdeiaEntity save(ArquivoIdeiaEntity arquivoIdeia) {
		return ideiaRepository.salvarArquivoIdeia(arquivoIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#listarIdeias(com.aweip.entity.Usuario
	 * )
	 */
	public List<PermissaoUsuarioIdeia> listarIdeias(Usuario usuario) {
		return ideiaRepository.listarIdeias(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#listarPermissoes(java.lang.String)
	 */
	public List<PermissaoUsuarioIdeia> listarPermissoes(String idIdeia) {
		return ideiaRepository.listarPermissoes(idIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aweip.stateless.IIdeiaStateless#obterArquivo(com.aweip.entity.
	 * ArquivoIdeia)
	 */
	public Arquivo obterArquivo(ArquivoIdeia arquivoIdeia) {
		return ideiaRepository.obterArquivo(arquivoIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#listarPalavraChaveIdeia(com.aweip
	 * .entity.Ideia)
	 */
	public List<PalavraChaveIdeiaEntity> listarPalavraChaveIdeia(Ideia ideia) {
		return ideiaRepository.listarPalavraChaveIdeia(ideia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aweip.stateless.IIdeiaStateless#save(com.aweip.entity.
	 * PalavraChaveIdeiaEntity)
	 */
	public void save(PalavraChaveIdeiaEntity palavraChaveIdeia) {
		ideiaRepository.persist(palavraChaveIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aweip.stateless.IIdeiaStateless#remover(com.aweip.entity.
	 * PalavraChaveIdeiaEntity)
	 */
	public void remover(PalavraChaveIdeiaEntity palavraChaveIdeia) {
		ideiaRepository.remover(palavraChaveIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#listarIdeiasSugeridas(com.aweip.entity
	 * .Usuario)
	 */
	public List<Ideia> listarIdeiasSugeridas(Usuario usuario) {
		return ideiaRepository.listarIdeiasSugeridas(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#findComentsIdeiaResumo(com.aweip.
	 * entity.Ideia)
	 */
	public List<ComentarioIdeia> findComentsIdeiaResumo(Ideia ideia) {
		return ideiaRepository.findComentsIdeiaResumo(ideia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#findComentsArquivoIdeia(com.aweip
	 * .entity.ArquivoIdeia)
	 */
	public List<ComentArquivoIdeia> findComentsArquivoIdeia(
			ArquivoIdeia arquivoIdeia) {
		return ideiaRepository.findComentsArquivoIdeia(arquivoIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#save(com.aweip.entity.ComentarioIdeia
	 * )
	 */
	public ComentarioIdeia save(ComentarioIdeia comentarioIdeia) {
		return ideiaRepository.save(comentarioIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#save(com.aweip.entity.ComentArquivoIdeia
	 * )
	 */
	public ComentArquivoIdeia save(ComentArquivoIdeia comentArquivoIdeia) {
		return ideiaRepository.save(comentArquivoIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#find(com.aweip.entity.ComentArquivoIdeia
	 * )
	 */
	public ComentArquivoIdeiaEntity find(ComentArquivoIdeia comentArquivoIdeia) {
		return this.ideiaRepository.find(comentArquivoIdeia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aweip.stateless.IIdeiaStateless#listarFeeds(com.aweip.entity.
	 * UsuarioEntity)
	 */
	@Override
	public List<Ideia> listarFeeds(UsuarioEntity usuario) {
		return ideiaRepository.listarFeeds(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IIdeiaStateless#obterAvatarIdeia(java.lang.String)
	 */
	@Override
	public byte[] obterAvatarIdeia(String idIdeia) {
		return ideiaRepository.obterAvatarIdeia(idIdeia);
	}

}
