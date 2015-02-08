package com.aweip.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;

/**
 * The Class AweipEntity.
 */
@MappedSuperclass
@Where(clause = "dataExclusao IS NULL")
public abstract class AweipEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new aweip entity.
	 * 
	 * @param id
	 *            the id
	 */
	public AweipEntity(String id) {
		this.id = id;
	}

	/**
	 * Instantiates a new aweip entity.
	 */
	public AweipEntity() {
	}

	/** The id. */
	@Id
	private String id;

	/** The data ult atualizacao. */
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataUltAtualizacao;

	/** The versao. */
	private Long versao;

	/** The data exclusao. */
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataExclusao;

	/**
	 * Gerar uuid.
	 */
	@PrePersist
	private void gerarUUID() {
		this.setId(UUID.randomUUID().toString());
		atualizarDataVersao();
	}

	/**
	 * Atualizar data versao.
	 */
	@PreUpdate
	private void atualizarDataVersao() {
		// atualiza para data atual
		this.setDataUltAtualizacao(Calendar.getInstance());
		// incrementa versão
		if (this.getVersao() == null) {
			this.setVersao(new Long(0L));
		} else {
			this.setVersao(this.getVersao() + 1);
		}
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the data ult atualizacao.
	 * 
	 * @return the data ult atualizacao
	 */
	public Calendar getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	/**
	 * Sets the data ult atualizacao.
	 * 
	 * @param dataUltAtualizacao
	 *            the new data ult atualizacao
	 */
	public void setDataUltAtualizacao(Calendar dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	/**
	 * Gets the versao.
	 * 
	 * @return the versao
	 */
	public Long getVersao() {
		return versao;
	}

	/**
	 * Sets the versao.
	 * 
	 * @param versao
	 *            the new versao
	 */
	public void setVersao(Long versao) {
		this.versao = versao;
	}

	/**
	 * Gets the data exclusao.
	 * 
	 * @return the data exclusao
	 */
	public Calendar getDataExclusao() {
		return dataExclusao;
	}

	/**
	 * Sets the data exclusao.
	 * 
	 * @param dataExclusao
	 *            the new data exclusao
	 */
	public void setDataExclusao(Calendar dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

}
