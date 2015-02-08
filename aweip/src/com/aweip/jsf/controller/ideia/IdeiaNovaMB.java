package com.aweip.jsf.controller.ideia;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aweip.entity.Ideia;
import com.aweip.entity.IdeiaEntity;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.AtributosSessaoTemp;
import com.aweip.jsf.controller.util.UtilMensagens;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;
import com.aweip.stateless.IUsuarioStateless;

/**
 * The Class IdeiaNovaMB.
 */
@ManagedBean(name = "ideiaNovaMB")
@ViewScoped
public class IdeiaNovaMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The ejb usuario. */
	@EJB
	private IUsuarioStateless ejbUsuario;

	/** The ideia. */
	private Ideia ideia;

	/**
	 * Instantiates a new ideia nova mb.
	 */
	public IdeiaNovaMB() {
		if (this.ideia == null) {
			this.ideia = new IdeiaEntity();
		}
	}

	/**
	 * Iniciar ideia.
	 * 
	 * @return the string
	 */
	public String iniciarIdeia() {
		try {
			// obtém o usuário da sessão
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			usuario = (UsuarioEntity) ejbUsuario.obterUsuario(usuario);

			System.out.println("Usuario:" + usuario.getId());

			this.ideia = ejb.save(this.ideia, usuario);

			UtilSession.setAtributoTemp(
					AtributosSessaoTemp.SESSION_TMP_Ideia_id_a,
					this.ideia.getId());
			UtilSession.setAtributoTemp(
					AtributosSessaoTemp.SESSION_TMP_Ideia_id_b,
					this.ideia.getId());

			// return "ideia?faces-redirect=true";
			return "/ideia/tabArquivos.xhtml";// ?faces-redirect=true";
		} catch (Exception e) {
			UtilMensagens.addErrorMessage("", "Erro",
					"Ocorreu um erro inesperado. Tente salvar novamente.");
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * Gets the ideia.
	 * 
	 * @return the ideia
	 */
	public Ideia getIdeia() {
		return ideia;
	}

	/**
	 * Sets the ideia.
	 * 
	 * @param ideia
	 *            the new ideia
	 */
	public void setIdeia(Ideia ideia) {
		this.ideia = ideia;
	}

}
