package com.aweip.jsf.controller.util;

/**
 * Cont�m nomes de atributos tempor�rios de sess�o que s�o eliminados ap�s a
 * primeira leitura.
 * 
 * @author �liverEmanuel
 * 
 */
public enum AtributosSessaoTemp {

	/** The SESSIO n_ tm p_ ideia_id_a. */
	SESSION_TMP_Ideia_id_a("ideiaNova_a"),

	/** The SESSIO n_ tm p_ ideia_id_b. */
	SESSION_TMP_Ideia_id_b("ideiaNova_b"),

	/** The SESSIO n_ tm p_ termo_pesquisa. */
	SESSION_TMP_Termo_pesquisa("termoPesquisa");

	/** The nome do atributo. */
	private String nomeDoAtributo;

	/**
	 * Instantiates a new atributos sessao temp.
	 * 
	 * @param nomeDoAtributo
	 *            the nome do atributo
	 */
	private AtributosSessaoTemp(String nomeDoAtributo) {
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
