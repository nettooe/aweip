/**
 * 
 */
package com.aweip.jsf.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * The Class PesquisaMB.
 */
@ManagedBean(name = "principalMB")
@RequestScoped
public class PrincipalMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The termo pesquisado. */
	private String termoPesquisado;

	/**
	 * Instantiates a new sugere ideias mb.
	 */
	public PrincipalMB() {
	}

	/**
	 * Pesquisar ideias.
	 * 
	 * @return the string
	 */
	public String pesquisarIdeias() {
		if (null != termoPesquisado && !termoPesquisado.isEmpty()) {
			return "/pesquisa.xhtml?faces-redirect=true&amp;q="
					+ termoPesquisado;
		} else {
			return "";
		}
	}

	/**
	 * Gets the termo pesquisado.
	 * 
	 * @return the termo pesquisado
	 */
	public String getTermoPesquisado() {
		return termoPesquisado;
	}

	/**
	 * Sets the termo pesquisado.
	 * 
	 * @param termoPesquisado
	 *            the new termo pesquisado
	 */
	public void setTermoPesquisado(String termoPesquisado) {
		this.termoPesquisado = termoPesquisado;
	}

}