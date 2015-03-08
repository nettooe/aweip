package com.aweip.jsf.controller;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

import com.aweip.entity.InteresseEntity;
import com.aweip.entity.PalavraChaveEntity;
import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.UtilMensagens;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IUsuarioStateless;

/**
 * The Class PerfilMB.
 */
@ManagedBean(name = "perfilMB")
@RequestScoped
public class PerfilMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IUsuarioStateless ejb;

	/** The usuario. */
	private Usuario usuario;

	/** The repita senha. */
	private String novaSenha, repitaSenha;

	/** The termo de interesse. */
	private String termoDeInteresse;

	/** The interesses. */
	private List<InteresseEntity> interesses = new ArrayList<InteresseEntity>();

	/** The avatar upload. */
	private UploadedFile avatarUpload;

	/**
	 * Instantiates a new perfil mb.
	 */
	public PerfilMB() {

	}

	/**
	 * Salvar interesse.
	 */
	public void salvarInteresse() {

		PalavraChaveEntity palavraChave = new PalavraChaveEntity();
		palavraChave.setTermo(termoDeInteresse);

		InteresseEntity interesseEntity = new InteresseEntity();
		interesseEntity.setUsuario(this.usuario);
		interesseEntity.setPalavraChave(palavraChave);

		ejb.salvarInteresse(interesseEntity);

		this.interesses = ejb.listarInteresses(this.usuario);
		
		interesseEntity = new InteresseEntity();
	}

	/**
	 * Remover interesse.
	 * 
	 * @param interesseEntity
	 *            the interesse entity
	 */
	public void removerInteresse(InteresseEntity interesseEntity) {
		ejb.remover(interesseEntity);
		this.interesses = ejb.listarInteresses(this.usuario);
	}

	/**
	 * Obter usuario da sessao.
	 */
	@PostConstruct
	private void obterUsuarioDaSessao() {
		if (this.usuario == null) {
			this.usuario = new UsuarioEntity();
			this.usuario.setId((String) UtilSession
					.getAtributo(AtributosSessao.SESSION_Usuario_id));
			try {
				this.usuario = ejb.obterUsuario(this.usuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.interesses = ejb.listarInteresses(this.usuario);
		}
	}

	/**
	 * Salvar dados basicos usuario.
	 */
	public void salvarDadosBasicosUsuario() {
		this.usuario.setAvatar(this.avatarUpload.getContents());
		this.usuario = ejb.save(this.usuario);
		UtilMensagens.addInfoMessage(null, "Sucesso", "Dados básicos salvos!");
	}

	/**
	 * Alterar senha.
	 */
	public void alterarSenha() {
		try {
			ejb.alterarSenha(this.usuario, this.novaSenha, this.repitaSenha);
			this.novaSenha = new String();
			this.repitaSenha = new String();
			UtilMensagens.addInfoMessage(null, "Sucesso",
					"Dados básicos salvos!");
		} catch (Exception e) {
			UtilMensagens.addErrorMessage(null, e.getMessage(), e.getCause()
					.getMessage());
		}
	}

	/**
	 * Gets the avatar.
	 * 
	 * @return the avatar
	 */
	public DefaultStreamedContent getAvatar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			if (this.usuario.getAvatar() == null) {
				return new DefaultStreamedContent();
			} else {
				return new DefaultStreamedContent(new ByteArrayInputStream(
						this.usuario.getAvatar()), "image/png");
			}
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
	 * Gets the termo de interesse.
	 * 
	 * @return the termo de interesse
	 */
	public String getTermoDeInteresse() {
		return termoDeInteresse;
	}

	/**
	 * Sets the termo de interesse.
	 * 
	 * @param termoDeInteresse
	 *            the new termo de interesse
	 */
	public void setTermoDeInteresse(String termoDeInteresse) {
		this.termoDeInteresse = termoDeInteresse;
	}

	/**
	 * Gets the interesses.
	 * 
	 * @return the interesses
	 */
	public List<InteresseEntity> getInteresses() {
		return interesses;
	}

	/**
	 * Sets the interesses.
	 * 
	 * @param interesses
	 *            the new interesses
	 */
	public void setInteresses(List<InteresseEntity> interesses) {
		this.interesses = interesses;
	}

	/**
	 * Gets the nova senha.
	 * 
	 * @return the nova senha
	 */
	public String getNovaSenha() {
		return novaSenha;
	}

	/**
	 * Sets the nova senha.
	 * 
	 * @param novaSenha
	 *            the new nova senha
	 */
	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	/**
	 * Gets the repita senha.
	 * 
	 * @return the repita senha
	 */
	public String getRepitaSenha() {
		return repitaSenha;
	}

	/**
	 * Sets the repita senha.
	 * 
	 * @param repitaSenha
	 *            the new repita senha
	 */
	public void setRepitaSenha(String repitaSenha) {
		this.repitaSenha = repitaSenha;
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
