package com.aweip.jsf.controller.util;

/**
 * Contém nomes de atributos temporários de sessão que são eliminados após a primeira leitura.
 * @author ÓliverEmanuel
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
