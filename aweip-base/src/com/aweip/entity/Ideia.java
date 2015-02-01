package com.aweip.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class Ideia.
 */
@MappedSuperclass
public abstract class Ideia extends AweipEntity implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The titulo. */
	@NotBlank
	@NotEmpty
	@Length(max = 120)
	private String titulo;

	/** The resumo. */
	@NotBlank
	@NotEmpty
	@Lob
	private String resumo;

	/** The arquivos da ideia. */
	@OneToMany(mappedBy = "ideia", targetEntity = ArquivoIdeiaEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy(value = "nome ASC")
	@Where(clause = "dataExclusao IS NULL")
	private List<ArquivoIdeiaEntity> arquivosDaIdeia = new ArrayList<ArquivoIdeiaEntity>();

	/** The permissoes. */
	@OneToMany(mappedBy = "ideia", targetEntity = PermissaoUsuarioIdeiaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PermissaoUsuarioIdeia> permissoes = new ArrayList<PermissaoUsuarioIdeia>();

	/** The palavras chave ideia. */
	@OneToMany(mappedBy = "ideia", targetEntity = PalavraChaveIdeiaEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PalavraChaveIdeiaEntity> palavrasChaveIdeia = new ArrayList<PalavraChaveIdeiaEntity>();

	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 *
	 * @param titulo the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the resumo.
	 *
	 * @return the resumo
	 */
	public String getResumo() {
		return resumo;
	}

	/**
	 * Sets the resumo.
	 *
	 * @param resumo the new resumo
	 */
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	/**
	 * Gets the arquivos da ideia.
	 *
	 * @return the arquivos da ideia
	 */
	public List<ArquivoIdeiaEntity> getArquivosDaIdeia() {
		return arquivosDaIdeia;
	}

	/**
	 * Sets the arquivos da ideia.
	 *
	 * @param arquivosDaIdeia the new arquivos da ideia
	 */
	public void setArquivosDaIdeia(List<ArquivoIdeiaEntity> arquivosDaIdeia) {
		this.arquivosDaIdeia = arquivosDaIdeia;
	}

	/**
	 * Gets the permissoes.
	 *
	 * @return the permissoes
	 */
	public List<PermissaoUsuarioIdeia> getPermissoes() {
		return permissoes;
	}

	/**
	 * Sets the permissoes.
	 *
	 * @param permissoes the new permissoes
	 */
	public void setPermissoes(List<PermissaoUsuarioIdeia> permissoes) {
		this.permissoes = permissoes;
	}

	/**
	 * Gets the palavras chave ideia.
	 *
	 * @return the palavras chave ideia
	 */
	public List<PalavraChaveIdeiaEntity> getPalavrasChaveIdeia() {
		return palavrasChaveIdeia;
	}

	/**
	 * Sets the palavras chave ideia.
	 *
	 * @param palavrasChaveIdeia the new palavras chave ideia
	 */
	public void setPalavrasChaveIdeia(
			List<PalavraChaveIdeiaEntity> palavrasChaveIdeia) {
		this.palavrasChaveIdeia = palavrasChaveIdeia;
	}

}
