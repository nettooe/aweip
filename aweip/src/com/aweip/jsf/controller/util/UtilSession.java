package com.aweip.jsf.controller.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * The Class UtilSession.
 */
public class UtilSession {

	/**
	 * Sets the atributo.
	 * 
	 * @param atributosSessao
	 *            the atributos sessao
	 * @param valor
	 *            the valor
	 */
	public static void setAtributo(AtributosSessao atributosSessao, Object valor) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.setAttribute(atributosSessao.getNomeDoAtributo(), valor);
	}

	/**
	 * Gets the atributo.
	 * 
	 * @param atributosSessao
	 *            the atributos sessao
	 * @return the atributo
	 */
	public static Object getAtributo(AtributosSessao atributosSessao) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		return session.getAttribute(atributosSessao.getNomeDoAtributo());
	}

	/**
	 * Sets the atributo temp.
	 * 
	 * @param atributosSessaoTemp
	 *            the atributos sessao temp
	 * @param valor
	 *            the valor
	 */
	public static void setAtributoTemp(AtributosSessaoTemp atributosSessaoTemp,
			Object valor) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.setAttribute(atributosSessaoTemp.getNomeDoAtributo(), valor);
	}

	/**
	 * Gets the atributo temp.
	 * 
	 * @param atributosSessaoTemp
	 *            the atributos sessao temp
	 * @return the atributo temp
	 */
	public static Object getAtributoTemp(AtributosSessaoTemp atributosSessaoTemp) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		// obtém o que está armazenado
		Object obj = session.getAttribute(atributosSessaoTemp
				.getNomeDoAtributo());
		// elimina da sessão
		session.removeAttribute(atributosSessaoTemp.getNomeDoAtributo());

		return obj;
	}

}
