package com.aweip.stateless;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.aweip.entity.Interesse;
import com.aweip.entity.InteresseEntity;
import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;
import com.aweip.repository.UsuarioRepository;

/**
 * The Class UsuarioStatelessImpl.
 */
@Stateless
@Remote(IUsuarioStateless.class)
public class UsuarioStatelessImpl implements IUsuarioStateless {

	/** The repository. */
	@Inject
	UsuarioRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aweip.stateless.IUsuarioStateless#gerarUsuario()
	 */
	@Override
	public Usuario gerarUsuario() {
		Usuario usuario = new UsuarioEntity();
		usuario.setNome("Óliver Emanuel");
		usuario.setEmail("netto.oe@gmail.com");
		usuario.setSenha("123456");
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.aweip.stateless.IUsuarioStateless#save(com.aweip.entity.Usuario)
	 */
	@Override
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IUsuarioStateless#autenticarUsuario(com.aweip.entity
	 * .Usuario)
	 */
	@Override
	public Usuario autenticarUsuario(Usuario usuario) {
		return repository.autenticarUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IUsuarioStateless#obterUsuario(com.aweip.entity.Usuario
	 * )
	 */
	@Override
	public Usuario obterUsuario(Usuario usuario) throws Exception {
		return repository.obterUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IUsuarioStateless#salvarInteresse(com.aweip.entity
	 * .Interesse)
	 */
	@Override
	public Interesse salvarInteresse(Interesse interesse) {
		return repository.salvarInteresse(interesse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IUsuarioStateless#remover(com.aweip.entity.Interesse)
	 */
	@Override
	public void remover(Interesse interesse) {
		repository.remover(interesse);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IUsuarioStateless#listarInteresses(com.aweip.entity
	 * .Usuario)
	 */
	@Override
	public List<InteresseEntity> listarInteresses(Usuario usuario) {
		return repository.listarInteresses(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.aweip.stateless.IUsuarioStateless#alterarSenha(com.aweip.entity.Usuario
	 * , java.lang.String, java.lang.String)
	 */
	@Override
	public void alterarSenha(Usuario usuario, String novaSenha,
			String repitaSenha) throws Exception {
		repository.alterarSenha(usuario, novaSenha, repitaSenha);
	}

}
