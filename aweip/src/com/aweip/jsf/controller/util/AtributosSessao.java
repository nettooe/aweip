package com.aweip.jsf.controller.util;

/**
 * The Enum AtributosSessao.
 */
public enum AtributosSessao {

	/* atributos de usuário */
	/** The SESSIO n_ usuario_id. */
	SESSION_Usuario_id("usuario_id"),

	/** The SESSIO n_ usuario_nome. */
	SESSION_Usuario_nome("usuario_nome");

	/** The nome do atributo. */
	private String nomeDoAtributo;

	/**
	 * Instantiates a new atributos sessao.
	 * 
	 * @param nomeDoAtributo
	 *            the nome do atributo
	 */
	private AtributosSessao(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}

	/**
	 * Gets the nome do atributo.
	 * 
	 * @return the nome do atributo
	 */
	public String getNomeDoAtributo() {
		return nomeDoAtributo;
	}

}
