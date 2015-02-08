package com.aweip.jsf.controller.ideia;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aweip.entity.Ideia;
import com.aweip.entity.IdeiaEntity;
import com.aweip.entity.PalavraChave;
import com.aweip.entity.PalavraChaveEntity;
import com.aweip.entity.PalavraChaveIdeiaEntity;
import com.aweip.jsf.controller.util.AtributosSessaoTemp;
import com.aweip.jsf.controller.util.UtilMensagens;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class TabPalavrasChaveMB.
 */
@ManagedBean(name = "tabPalavrasChaveMB")
@ViewScoped
public class TabPalavrasChaveMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The ideia. */
	private Ideia ideia;

	/** The nova palavra chave. */
	private String novaPalavraChave;

	/**
	 * Instantiates a new tab palavras chave mb.
	 */
	public TabPalavrasChaveMB() {
		// verifica se existe um id de IdeiaNova na sessão... se existir, inicia
		this.ideia = new IdeiaEntity();
		this.ideia.setId((String) UtilSession
				.getAtributoTemp(AtributosSessaoTemp.SESSION_TMP_Ideia_id_b));

		novaPalavraChave = new String();
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	private void init() {
		if (this.ideia != null && this.ideia.getId() != null) {
			this.ideia = ejb.obterIdeia(ideia);
			listarPalavrasChave();
		}
	}

	/**
	 * Listar palavras chave.
	 */
	private void listarPalavrasChave() {
		List<PalavraChaveIdeiaEntity> lista = ejb
				.listarPalavraChaveIdeia(this.ideia);
		if (lista != null) {
			this.ideia.setPalavrasChaveIdeia(lista);
		}
	}

	/**
	 * Remover.
	 * 
	 * @param idPalavraChaveIdeia
	 *            the id palavra chave ideia
	 */
	public void remover(String idPalavraChaveIdeia) {

		PalavraChaveIdeiaEntity palavraChaveIdeia = new PalavraChaveIdeiaEntity();

		for (PalavraChaveIdeiaEntity pci : this.ideia.getPalavrasChaveIdeia()) {
			if (pci.getId().equals(idPalavraChaveIdeia)) {
				palavraChaveIdeia = pci;
				break;
			}
		}

		if (palavraChaveIdeia.getId() != null) {
			ejb.remover(palavraChaveIdeia);
			listarPalavrasChave();
			UtilMensagens.addInfoMessage("formTabPalavrasChave", "Sucesso",
					"Palavra-chave removida.");
		} else {
			UtilMensagens.addErrorMessage("formTabPalavrasChave", "Erro",
					"Palavra-chave não removida. Tente novamente.");
		}
	}

	/**
	 * Salvar.
	 */
	public void salvar() {
		PalavraChave palavraChave = new PalavraChaveEntity();
		palavraChave.setTermo(new String(novaPalavraChave));

		PalavraChaveIdeiaEntity palavraChaveIdeia = new PalavraChaveIdeiaEntity();
		palavraChaveIdeia.setIdeia(this.ideia);
		palavraChaveIdeia.setPalavraChave(palavraChave);

		ejb.save(palavraChaveIdeia);

		novaPalavraChave = new String();

		listarPalavrasChave();

		UtilMensagens.addInfoMessage("formTabPalavrasChave", "Sucesso",
				"Palavra-chave salva.");
	}

	/**
	 * Gets the ideia.
	 * 
	 * @return the ideia
	 */
	public Ideia getIdeia() {
		return ideia;
	}

	/**
	 * Sets the ideia.
	 * 
	 * @param ideia
	 *            the new ideia
	 */
	public void setIdeia(Ideia ideia) {
		this.ideia = ideia;
	}

	/**
	 * Gets the nova palavra chave.
	 * 
	 * @return the nova palavra chave
	 */
	public String getNovaPalavraChave() {
		return novaPalavraChave;
	}

	/**
	 * Sets the nova palavra chave.
	 * 
	 * @param novaPalavraChave
	 *            the new nova palavra chave
	 */
	public void setNovaPalavraChave(String novaPalavraChave) {
		this.novaPalavraChave = novaPalavraChave;
	}

}
