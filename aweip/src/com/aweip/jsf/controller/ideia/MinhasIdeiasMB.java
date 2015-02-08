package com.aweip.jsf.controller.ideia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.AtributosSessaoTemp;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class MinhasIdeiasMB.
 */
@ManagedBean(name = "minhasIdeiasMB")
@ViewScoped
public class MinhasIdeiasMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The ideias permitidas. */
	private List<PermissaoUsuarioIdeia> ideiasPermitidas;

	/**
	 * Instantiates a new minhas ideias mb.
	 */
	public MinhasIdeiasMB() {
		ideiasPermitidas = new ArrayList<PermissaoUsuarioIdeia>();
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	private void init() {
		// obtém o usuário da sessão
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setId(UtilSession.getAtributo(
				AtributosSessao.SESSION_Usuario_id).toString());

		this.ideiasPermitidas = ejb.listarIdeias(usuario);
	}

	/**
	 * Abrir ideia.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the string
	 */
	public String abrirIdeia(String idIdeia) {
		if (idIdeia != null && !idIdeia.isEmpty()) {
			UtilSession.setAtributoTemp(
					AtributosSessaoTemp.SESSION_TMP_Ideia_id_a, idIdeia);
			UtilSession.setAtributoTemp(
					AtributosSessaoTemp.SESSION_TMP_Ideia_id_b, idIdeia);
			return "/ideia/tabResumo.xhtml?faces-redirect=true";
		} else {
			return "";
		}
	}

	/**
	 * Ir para.
	 * 
	 * @param endereco
	 *            the endereco
	 * @return the string
	 */
	public String irPara(String endereco) {
		return endereco + "?faces-redirect=true";
	}

	/**
	 * Gets the ideias permitidas.
	 * 
	 * @return the ideias permitidas
	 */
	public List<PermissaoUsuarioIdeia> getIdeiasPermitidas() {
		return ideiasPermitidas;
	}

	/**
	 * Sets the ideias permitidas.
	 * 
	 * @param ideiasPermitidas
	 *            the new ideias permitidas
	 */
	public void setIdeiasPermitidas(List<PermissaoUsuarioIdeia> ideiasPermitidas) {
		this.ideiasPermitidas = ideiasPermitidas;
	}

}
