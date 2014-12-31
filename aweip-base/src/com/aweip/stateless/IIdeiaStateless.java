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

public interface IIdeiaStateless {

	void apagar(ArquivoIdeia arquivoIdeia);

	ArquivoIdeiaEntity atualizarArquivo(ArquivoIdeiaEntity arquivoIdeia);

	List<PalavraChaveIdeiaEntity> listarPalavraChaveIdeia(Ideia ideia);

	void save(PalavraChaveIdeiaEntity palavraChaveIdeia);

	void remover(PalavraChaveIdeiaEntity palavraChaveIdeia);

	ArquivoIdeia obterArquivoIdeia(ArquivoIdeia arquivoIdeia);

	ArquivoIdeiaEntity save(ArquivoIdeiaEntity arquivoIdeia);

	Arquivo obterArquivo(ArquivoIdeia arquivoIdeia);

	List<PermissaoUsuarioIdeia> listarIdeias(Usuario usuario);

	List<PermissaoUsuarioIdeia> listarPermissoes(String idIdeia);

	List<Ideia> listarIdeiasSugeridas(Usuario usuario);

	Ideia obterIdeia(Ideia ideia);

	Ideia save(Ideia ideia, Usuario usuario);

	List<ComentarioIdeia> findComentsIdeiaResumo(Ideia ideia);

	List<ComentArquivoIdeia> findComentsArquivoIdeia(ArquivoIdeia arquivoIdeia);

	ComentarioIdeia save(ComentarioIdeia comentarioIdeia);

	ComentArquivoIdeia save(ComentArquivoIdeia comentArquivoIdeia);

	ComentArquivoIdeiaEntity find(ComentArquivoIdeia comentArquivoIdeia);

}
