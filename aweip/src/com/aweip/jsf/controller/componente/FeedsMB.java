package com.aweip.jsf.controller.componente;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.aweip.entity.Ideia;
import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.UsuarioEntity;
import com.aweip.entity.discreto.TipoPermissao;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.AtributosSessaoTemp;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class SugereIdeiasMB.
 */
@ManagedBean(name = "feedsMB")
@RequestScoped
public class FeedsMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The ideias sugeridas. */
	private List<Ideia> feedIdeias;

	/**
	 * Instantiates a new sugere ideias mb.
	 */
	public FeedsMB() {
	}

	/**
	 * Listar ideias sugeridas.
	 */
	@PostConstruct
	public void listarIdeiasSugeridas() {
		// obtém o usuário da sessão
		if (null != AtributosSessao.SESSION_Usuario_id) {
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			this.feedIdeias = ejb.listarFeeds(usuario);
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
	 * Gets the feed ideias.
	 * 
	 * @return the feed ideias
	 */
	public List<Ideia> getFeedIdeias() {
		return feedIdeias;
	}

	/**
	 * Sets the feed ideias.
	 * 
	 * @param feedIdeias
	 *            the new feed ideias
	 */
	public void setFeedIdeias(List<Ideia> feedIdeias) {
		this.feedIdeias = feedIdeias;
	}

}