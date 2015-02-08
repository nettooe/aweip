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

/**
 * The Class IndexMB.
 */
@ManagedBean(name = "indexMB")
@ViewScoped
public class IndexMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IUsuarioStateless ejb;

	/** The usuario. */
	private Usuario usuario;

	/** The sucesso no cadastro. */
	private boolean sucessoNoCadastro;

	/**
	 * Instantiates a new index mb.
	 */
	public IndexMB() {
		if (this.usuario == null) {
			this.usuario = new UsuarioEntity();
		}
	}

	/**
	 * Cadastrar novo usuario.
	 * 
	 * @return the string
	 */
	public String cadastrarNovoUsuario() {
		usuario = ejb.save(usuario);

		if (usuario.getId() == null) {
			return null;
		} else {
			this.sucessoNoCadastro = true;
			return "index";
		}
	}

	/**
	 * Iniciar.
	 * 
	 * @return the string
	 */
	public String iniciar() {
		return autenticarUsuario();
	}

	/**
	 * Autenticar usuario.
	 * 
	 * @return the string
	 */
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

	/**
	 * Gets the usuario.
	 * 
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 * 
	 * @param usuario
	 *            the new usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Checks if is sucesso no cadastro.
	 * 
	 * @return true, if is sucesso no cadastro
	 */
	public boolean isSucessoNoCadastro() {
		return sucessoNoCadastro;
	}

	/**
	 * Sets the sucesso no cadastro.
	 * 
	 * @param sucessoNoCadastro
	 *            the new sucesso no cadastro
	 */
	public void setSucessoNoCadastro(boolean sucessoNoCadastro) {
		this.sucessoNoCadastro = sucessoNoCadastro;
	}

}
