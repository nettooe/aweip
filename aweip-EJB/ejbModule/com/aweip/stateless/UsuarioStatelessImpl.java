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

@Stateless
@Remote(IUsuarioStateless.class)
public class UsuarioStatelessImpl implements IUsuarioStateless {

	@Inject
	UsuarioRepository repository;

	@Override
	public Usuario gerarUsuario() {
		Usuario usuario = new UsuarioEntity();
		usuario.setNome("Óliver Emanuel");
		usuario.setEmail("netto.oe@gmail.com");
		usuario.setSenha("123456");
		return usuario;
	}

	@Override
	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public Usuario autenticarUsuario(Usuario usuario) {
		return repository.autenticarUsuario(usuario);
	}

	@Override
	public Usuario obterUsuario(Usuario usuario) throws Exception {
		return repository.obterUsuario(usuario);
	}

	@Override
	public Interesse salvarInteresse(Interesse interesse) {
		return repository.salvarInteresse(interesse);
	}

	@Override
	public void remover(Interesse interesse) {
		repository.remover(interesse);
	}

	@Override
	public List<InteresseEntity> listarInteresses(Usuario usuario) {
		return repository.listarInteresses(usuario);
	}

	@Override
	public void alterarSenha(Usuario usuario, String novaSenha,
			String repitaSenha) throws Exception {
		repository.alterarSenha(usuario, novaSenha, repitaSenha);
	}

}
