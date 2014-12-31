package com.aweip.jsf.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aweip.entity.InteresseEntity;
import com.aweip.entity.PalavraChaveEntity;
import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.UtilMensagens;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IUsuarioStateless;

@ManagedBean(name = "perfilMB")
@ViewScoped
public class PerfilMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private IUsuarioStateless ejb;

	private Usuario usuario;

	private String termoDeInteresse;

	private List<InteresseEntity> interesses = new ArrayList<InteresseEntity>();

	public PerfilMB() {

	}

	public void salvarInteresse() {

		PalavraChaveEntity palavraChave = new PalavraChaveEntity();
		palavraChave.setTermo(termoDeInteresse);

		InteresseEntity interesseEntity = new InteresseEntity();
		interesseEntity.setUsuario(this.usuario);
		interesseEntity.setPalavraChave(palavraChave);

		ejb.salvarInteresse(interesseEntity);

		this.interesses = ejb.listarInteresses(this.usuario);
	}

	public void removerInteresse(InteresseEntity interesseEntity) {
		ejb.remover(interesseEntity);
		this.interesses = ejb.listarInteresses(this.usuario);
	}

	@PostConstruct
	private void obterUsuarioDaSessao() {
		if (this.usuario == null) {
			this.usuario = new UsuarioEntity();
			this.usuario.setId((String) UtilSession
					.getAtributo(AtributosSessao.SESSION_Usuario_id));
			try {
				this.usuario = ejb.obterUsuario(this.usuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.interesses = ejb.listarInteresses(this.usuario);

		}
	}

	public void salvarDadosBasicosUsuario() {
		this.usuario = ejb.save(this.usuario);

		UtilMensagens.addInfoMessage(null, "Sucesso",
				"Dados básicos salvos!");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTermoDeInteresse() {
		return termoDeInteresse;
	}

	public void setTermoDeInteresse(String termoDeInteresse) {
		this.termoDeInteresse = termoDeInteresse;
	}

	public List<InteresseEntity> getInteresses() {
		return interesses;
	}

	public void setInteresses(List<InteresseEntity> interesses) {
		this.interesses = interesses;
	}

}
