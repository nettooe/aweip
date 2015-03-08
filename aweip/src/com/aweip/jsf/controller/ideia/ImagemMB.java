package com.aweip.jsf.controller.ideia;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

import com.aweip.entity.IdeiaEntity;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.UtilMensagens;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class ImagemMB.
 */
@ManagedBean(name = "imagemMB")
@RequestScoped
public class ImagemMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The avatar upload. */
	private UploadedFile avatarUpload;

	/**
	 * Salvar avatar ideia.
	 * 
	 * @return the string
	 */
	public String salvarAvatarIdeia() {
		try {
			Map<String, String> params = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap();
			String idIdeia = params.get("idIdeia");

			// obtém o usuário da sessão
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			IdeiaEntity ideia = new IdeiaEntity();
			ideia.setId(idIdeia);
			ideia = (IdeiaEntity) ejb.obterIdeia(ideia);

			ideia.setAvatar(this.avatarUpload.getContents());

			ideia = (IdeiaEntity) ejb.save(ideia, usuario);

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
	 * Gets the avatar ideia.
	 * 
	 * @return the avatar ideia
	 */
	public DefaultStreamedContent getAvatarIdeia() {

		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idIdeia = params.get("idIdeia");

		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			byte[] imagemArray = ejb.obterAvatarIdeia(idIdeia);

			if (null == imagemArray) {
				return new DefaultStreamedContent();
			} else {
				return new DefaultStreamedContent(new ByteArrayInputStream(
						imagemArray), "image/png");
			}
		}
	}

	/**
	 * Gets the avatar usuario.
	 * 
	 * @return the avatar usuario
	 */
	public DefaultStreamedContent getAvatarUsuario() {

		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String idUsuario = params.get("idUsuario");

		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			byte[] imagemArray = ejb.obterAvatarUsuario(idUsuario);

			if (null == imagemArray) {
				return new DefaultStreamedContent();
			} else {
				return new DefaultStreamedContent(new ByteArrayInputStream(
						imagemArray), "image/png");
			}
		}
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
