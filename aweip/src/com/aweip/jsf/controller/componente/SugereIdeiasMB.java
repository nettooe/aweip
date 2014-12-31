package com.aweip.jsf.controller.componente;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aweip.entity.Ideia;
import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.UsuarioEntity;
import com.aweip.entity.discreto.TipoPermissao;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.AtributosSessaoTemp;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

// TODO: Auto-generated Javadoc
/**
 * The Class SugereIdeiasMB.
 */
@ManagedBean(name = "sugereIdeiasMB")
@ViewScoped
public class SugereIdeiasMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The ideias sugeridas. */
	private List<Ideia> ideiasSugeridas;

	/**
	 * Instantiates a new sugere ideias mb.
	 */
	public SugereIdeiasMB() {
	}

	/**
	 * Listar ideias sugeridas.
	 */
	@PostConstruct
	public void listarIdeiasSugeridas() {
		// obtém o usuário da sessão
		if (AtributosSessao.SESSION_Usuario_id != null) {
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			this.ideiasSugeridas = ejb.listarIdeiasSugeridas(usuario);
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
	 * Gets the ideias sugeridas.
	 * 
	 * @return the ideias sugeridas
	 */
	public List<Ideia> getIdeiasSugeridas() {
		return ideiasSugeridas;
	}

	/**
	 * Sets the ideias sugeridas.
	 * 
	 * @param ideiasSugeridas
	 *            the new ideias sugeridas
	 */
	public void setIdeiasSugeridas(List<Ideia> ideiasSugeridas) {
		this.ideiasSugeridas = ideiasSugeridas;
	}

}
