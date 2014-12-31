package com.aweip.jsf.controller.util;

/**
 * Cont�m nomes de atributos tempor�rios de sess�o que s�o eliminados ap�s a primeira leitura.
 * @author �liverEmanuel
 *
 */
public enum AtributosSessaoTemp {

	SESSION_TMP_Ideia_id_a("ideiaNova_a"),
	SESSION_TMP_Ideia_id_b("ideiaNova_b");;
	
	private String nomeDoAtributo;

	private AtributosSessaoTemp(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}

	public String getNomeDoAtributo(){
		return nomeDoAtributo;
	}

}
