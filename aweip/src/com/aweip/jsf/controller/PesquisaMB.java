/**
 * 
 */
package com.aweip.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.aweip.entity.Ideia;
import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.UsuarioEntity;
import com.aweip.entity.discreto.TipoPermissao;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.AtributosSessaoTemp;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class PesquisaMB.
 */
@ManagedBean(name = "pesquisaMB")
@ViewScoped
public class PesquisaMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The resultados ideias. */
	private List<Ideia> resultadosIdeias;

	/** The termo pesquisado. */
	private String termoPesquisado;

	/**
	 * Instantiates a new sugere ideias mb.
	 */
	public PesquisaMB() {
	}

	/**
	 * Pesquisar ideias.
	 * 
	 * @return the string
	 */
	public String pesquisarIdeias() {
		// UsuarioEntity usuario = new UsuarioEntity();
		//
		// // obtém o usuário da sessão
		// if (AtributosSessao.SESSION_Usuario_id != null) {
		// usuario.setId(UtilSession.getAtributo(
		// AtributosSessao.SESSION_Usuario_id).toString());
		// }

		// this.resultadosIdeias = ejb.pesquisarIdeias(usuario,
		// termoPesquisado);

		// return "pesquisa?q=" + termoPesquisado;

		return "/pesquisa.xhtml?faces-redirect=true&amp;q=" + termoPesquisado;
	}

	/**
	 * Ativar pesquisa.
	 */
	@PostConstruct
	public void ativarPesquisa() {
		if (null != FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("q")) {
			UsuarioEntity usuario = new UsuarioEntity();

			this.setTermoPesquisado(FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap().get("q"));

			// obtém o usuário da sessão
			if (AtributosSessao.SESSION_Usuario_id != null) {
				usuario.setId(UtilSession.getAtributo(
						AtributosSessao.SESSION_Usuario_id).toString());
			}

			this.resultadosIdeias = ejb.pesquisarIdeias(usuario,
					termoPesquisado);
		}
	}

	/**
	 * Abrir ideia.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the string
	 */
	public String abrirIdeia(String idIdeia) {

		System.out.println("abrirIdeia XXXXXXXXXXXXXXXXXX");

		// String idIdeia = "aa";
		if (idIdeia != null && !idIdeia.isEmpty()) {
			UtilSession.setAtributoTemp(
					AtributosSessaoTemp.SESSION_TMP_Ideia_id_a, idIdeia);
			UtilSession.setAtributoTemp(
					AtributosSessaoTemp.SESSION_TMP_Ideia_id_b, idIdeia);

			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			List<PermissaoUsuarioIdeia> ideiasPermitidas = ejb
					.listarIdeias(usuario);

			// se for o criador da idéia, então será direcionado para a tela de
			// edição
			for (PermissaoUsuarioIdeia permissaoUsuarioIdeia : ideiasPermitidas) {
				if (idIdeia.equals(permissaoUsuarioIdeia.getIdeia().getId())
						&& TipoPermissao.CRIADOR.equals(permissaoUsuarioIdeia
								.getTipoPermissao())) {
					return "/ideia/tabResumo.xhtml?faces-redirect=true&amp;id="
							+ idIdeia;
				}
			}

			// se não for o criador, então direciona para a tela de visualização
			return "/ideia.xhtml?faces-redirect=true&amp;id=" + idIdeia;
		} else {
			return "";
		}
	}

	/**
	 * Gets the resultados ideias.
	 * 
	 * @return the resultados ideias
	 */
	public List<Ideia> getResultadosIdeias() {
		return resultadosIdeias;
	}

	/**
	 * Sets the resultados ideias.
	 * 
	 * @param resultadosIdeias
	 *            the new resultados ideias
	 */
	public void setResultadosIdeias(List<Ideia> resultadosIdeias) {
		this.resultadosIdeias = resultadosIdeias;
	}

	/**
	 * Gets the termo pesquisado.
	 * 
	 * @return the termo pesquisado
	 */
	public String getTermoPesquisado() {
		return termoPesquisado;
	}

	/**
	 * Sets the termo pesquisado.
	 * 
	 * @param termoPesquisado
	 *            the new termo pesquisado
	 */
	public void setTermoPesquisado(String termoPesquisado) {
		this.termoPesquisado = termoPesquisado;
	}

}