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

@MappedSuperclass
@Where(clause = "dataExclusao IS NULL")
public abstract class AweipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AweipEntity(String id) {
		this.id = id;
	}

	public AweipEntity() {
	}

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataUltAtualizacao;

	private Long versao;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataExclusao;

	@PrePersist
	private void gerarUUID() {
		this.setId(UUID.randomUUID().toString());
		atualizarDataVersao();
	}

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Calendar getDataUltAtualizacao() {
		return dataUltAtualizacao;
	}

	public void setDataUltAtualizacao(Calendar dataUltAtualizacao) {
		this.dataUltAtualizacao = dataUltAtualizacao;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	public Calendar getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Calendar dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

}
