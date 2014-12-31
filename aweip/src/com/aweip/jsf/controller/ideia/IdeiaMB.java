package com.aweip.jsf.controller.ideia;

import java.io.Serializable;

import javax.annotation.PostConstruct;
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

// TODO: Auto-generated Javadoc
/**
 * The Class IdeiaMB.
 */
@ManagedBean(name = "ideiaMB")
@ViewScoped
public class IdeiaMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The ideia. */
	private Ideia ideia;

	/**
	 * Instantiates a new ideia mb.
	 */
	public IdeiaMB() {
		// verifica se existe um id de IdeiaNova na sess�o... se existir, inicia
		this.ideia = new IdeiaEntity();
		this.ideia.setId((String) UtilSession
				.getAtributoTemp(AtributosSessaoTemp.SESSION_TMP_Ideia_id_a));
	}
	
	public void carregarIdeia(String idIdeia){
		// se uma ideia for passada por par�metro, ent�o ela ser� carregada
		if(idIdeia != null){
			this.ideia = new IdeiaEntity();
			this.ideia.setId(idIdeia);
			init();
		}
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	private void init() {
		if (this.ideia != null && this.ideia.getId() != null) {
			this.ideia = ejb.obterIdeia(ideia);

			if (this.ideia != null) {
				this.ideia.setPermissoes(ejb.listarPermissoes(this.ideia
						.getId()));
			}
		}
	}

	/**
	 * Ir para.
	 * 
	 * @param enderecoTab
	 *            the endereco tab
	 * @return the string
	 */
	public String irPara(String enderecoTab) {

		UtilSession.setAtributoTemp(AtributosSessaoTemp.SESSION_TMP_Ideia_id_a,
				this.ideia.getId());
		UtilSession.setAtributoTemp(AtributosSessaoTemp.SESSION_TMP_Ideia_id_b,
				this.ideia.getId());

		return enderecoTab + "?faces-redirect=true&amp;id="
				+ this.ideia.getId();
	}

	/**
	 * Salvar titulo ideia.
	 * 
	 * @return the string
	 */
	public String salvarTituloIdeia() {
		try {
			// obt�m o usu�rio da sess�o
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			this.ideia = ejb.save(this.ideia, usuario);

			UtilMensagens.addInfoMessage("formTituloIdeia", "Sucesso",
					"T�tulo salvo!");
			return "";
		} catch (Exception e) {
			UtilMensagens.addErrorMessage("", "Erro",
					"Ocorreu um erro inesperado. Tente salvar novamente.");
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * Salvar resumo ideia.
	 * 
	 * @return the string
	 */
	public String salvarResumoIdeia() {
		try {
			// obt�m o usu�rio da sess�o
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			this.ideia = ejb.save(this.ideia, usuario);

			UtilMensagens.addInfoMessage("btSalvarIdeiaResumo", "Sucesso",
					"Resumo salvo!");
			return "";
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