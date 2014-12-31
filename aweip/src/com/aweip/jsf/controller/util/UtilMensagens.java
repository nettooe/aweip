package com.aweip.jsf.controller.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UtilMensagens {

	public static void addInfoMessage(String componentId, String sumary,
			String detail) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				sumary, detail);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMsg);
	}

	public static void addErrorMessage(String componentId, String sumary,
			String detail) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				sumary, detail);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMsg);
	}

	public static void addWarnMessage(String componentId, String sumary,
			String detail) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN,
				sumary, detail);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMsg);
	}

	public static void addFatalMessage(String componentId, String sumary,
			String detail) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
				sumary, detail);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMsg);
	}

}
