package com.aweip.jsf.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MenuSuperiorMB implements Serializable {
	private static final long serialVersionUID = 1L;

	public MenuSuperiorMB() {
	}

	public void sair() {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		ec.invalidateSession();
		try {
			ec.redirect(ec.getRequestContextPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
