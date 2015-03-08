package com.aweip.jsf.controller.ideia;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import com.aweip.entity.Ideia;
import com.aweip.entity.IdeiaEntity;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.AtributosSessaoTemp;
import com.aweip.jsf.controller.util.UtilMensagens;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

import static java.nio.charset.StandardCharsets.*;

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

	/** The avatar upload. */
	private UploadedFile avatarUpload;

	/**
	 * Instantiates a new ideia mb.
	 */
	public IdeiaMB() {
		// verifica se existe um id de IdeiaNova na sessão... se existir, inicia
		this.ideia = new IdeiaEntity();
		this.ideia.setId((String) UtilSession
				.getAtributoTemp(AtributosSessaoTemp.SESSION_TMP_Ideia_id_a));
	}

	/**
	 * Carregar ideia.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 */
	public void carregarIdeia(String idIdeia) {
		// se uma ideia for passada por parâmetro, então ela será carregada
		if (idIdeia != null) {
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
			// obtém o usuário da sessão
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			String titulo = new String(this.ideia.getTitulo());
			this.ideia = ejb.obterIdeia(ideia);
			this.ideia.setTitulo(titulo);
			
			this.ideia = ejb.save(this.ideia, usuario);

			UtilMensagens.addInfoMessage("formTituloIdeia", "Sucesso",
					"Título salvo!");
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
			// obtém o usuário da sessão
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			//######################
			
			String resumo = new String(this.ideia.getResumo().getBytes(), UTF_8); 
			
			//#########################
			
			
			//String resumo = new String(this.ideia.getResumo());
			
			this.ideia = ejb.obterIdeia(this.ideia);
			this.ideia.setResumo(resumo);
			
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
	 * Salvar avatar ideia.
	 * 
	 * @return the string
	 */
	public String salvarAvatarIdeia() {
		try {
			// obtém o usuário da sessão
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			this.ideia.setAvatar(this.avatarUpload.getContents());

			this.ideia = ejb.save(this.ideia, usuario);

			UtilMensagens.addInfoMessage("btSalvarIdeiaResumo", "Sucesso",
					"Avatar salvo!");
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

	/**
	 * Gets the avatar upload.
	 * 
	 * @return the avatar upload
	 */
	public UploadedFile getAvatarUpload() {
		return avatarUpload;
	}

	/**
	 * Sets the avatar upload.
	 * 
	 * @param avatarUpload
	 *            the new avatar upload
	 */
	public void setAvatarUpload(UploadedFile avatarUpload) {
		this.avatarUpload = avatarUpload;
	}

}
