package com.aweip.jsf.controller.util;

public enum AtributosSessao {

	/* atributos de usuário */
	SESSION_Usuario_id("usuario_id"),
	SESSION_Usuario_nome("usuario_nome");
	
	private String nomeDoAtributo;

	private AtributosSessao(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}

	public String getNomeDoAtributo(){
		return nomeDoAtributo;
	}

}
