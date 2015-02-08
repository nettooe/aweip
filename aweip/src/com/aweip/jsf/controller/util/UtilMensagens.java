package com.aweip.jsf.controller.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * The Class UtilMensagens.
 */
public class UtilMensagens {

	/**
	 * Adds the info message.
	 * 
	 * @param componentId
	 *            the component id
	 * @param sumary
	 *            the sumary
	 * @param detail
	 *            the detail
	 */
	public static void addInfoMessage(String componentId, String sumary,
			String detail) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				sumary, detail);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMsg);
	}

	/**
	 * Adds the error message.
	 * 
	 * @param componentId
	 *            the component id
	 * @param sumary
	 *            the sumary
	 * @param detail
	 *            the detail
	 */
	public static void addErrorMessage(String componentId, String sumary,
			String detail) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				sumary, detail);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMsg);
	}

	/**
	 * Adds the warn message.
	 * 
	 * @param componentId
	 *            the component id
	 * @param sumary
	 *            the sumary
	 * @param detail
	 *            the detail
	 */
	public static void addWarnMessage(String componentId, String sumary,
			String detail) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN,
				sumary, detail);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMsg);
	}

	/**
	 * Adds the fatal message.
	 * 
	 * @param componentId
	 *            the component id
	 * @param sumary
	 *            the sumary
	 * @param detail
	 *            the detail
	 */
	public static void addFatalMessage(String componentId, String sumary,
			String detail) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
				sumary, detail);
		FacesContext.getCurrentInstance().addMessage(componentId, facesMsg);
	}

}
