package com.aweip.stateless;

import java.util.List;

import com.aweip.entity.Interesse;
import com.aweip.entity.InteresseEntity;
import com.aweip.entity.Usuario;

public interface IUsuarioStateless {
	// TODO eliminar
	Usuario gerarUsuario();
	
	List<InteresseEntity> listarInteresses(Usuario usuario);
	
	Interesse salvarInteresse(Interesse interesse);
	
	void remover(Interesse interesse);
	
	Usuario obterUsuario(Usuario usuario) throws Exception;

	Usuario autenticarUsuario(Usuario usuario);

	Usuario save(Usuario usuario);

}
