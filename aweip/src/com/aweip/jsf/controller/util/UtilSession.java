package com.aweip.jsf.controller.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class UtilSession {

	public static void setAtributo(AtributosSessao atributosSessao, Object valor) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.setAttribute(atributosSessao.getNomeDoAtributo(), valor);
	}

	public static Object getAtributo(AtributosSessao atributosSessao) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		return session.getAttribute(atributosSessao.getNomeDoAtributo());
	}

	public static void setAtributoTemp(AtributosSessaoTemp atributosSessaoTemp,
			Object valor) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.setAttribute(atributosSessaoTemp.getNomeDoAtributo(), valor);
	}

	public static Object getAtributoTemp(AtributosSessaoTemp atributosSessaoTemp) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		// obt�m o que est� armazenado
		Object obj = session.getAttribute(atributosSessaoTemp
				.getNomeDoAtributo());
		// elimina da sess�o
		session.removeAttribute(atributosSessaoTemp.getNomeDoAtributo());

		return obj;
	}

}
