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

import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class IdeiaMB.
 */
@ManagedBean(name = "imagemMB")
@RequestScoped
public class ImagemMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

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

}
