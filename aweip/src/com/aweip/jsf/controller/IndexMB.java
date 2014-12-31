package com.aweip.jsf.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.UtilMensagens;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IUsuarioStateless;

@ManagedBean(name = "indexMB")
@ViewScoped
public class IndexMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private IUsuarioStateless ejb;

	private Usuario usuario;
	private boolean sucessoNoCadastro;

	public IndexMB() {
		if (this.usuario == null) {
			this.usuario = new UsuarioEntity();
		}
	}

	public String cadastrarNovoUsuario() {
		usuario = ejb.save(usuario);

		if (usuario.getId() == null) {
			return null;
		} else {
			this.sucessoNoCadastro = true;
			return "index";
		}
	}

	public String iniciar() {
		return autenticarUsuario();
	}

	public String autenticarUsuario() {
		usuario = ejb.autenticarUsuario(usuario);
		if (usuario.getId() != null) {

			UtilSession.setAtributo(AtributosSessao.SESSION_Usuario_id,
					usuario.getId());
			UtilSession.setAtributo(AtributosSessao.SESSION_Usuario_nome,
					usuario.getNome());

			return "inicio";
		} else {
			UtilMensagens.addWarnMessage("txtLogin",
					"Email e/ou senha incorretos.",
					"Email e/ou senha incorretos.");
			return "";
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isSucessoNoCadastro() {
		return sucessoNoCadastro;
	}

	public void setSucessoNoCadastro(boolean sucessoNoCadastro) {
		this.sucessoNoCadastro = sucessoNoCadastro;
	}

}
