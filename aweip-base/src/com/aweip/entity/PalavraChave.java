package com.aweip.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class PalavraChave extends AweipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	@NotBlank
	private String termo;

	public String getTermo() {
		return termo;
	}

	public void setTermo(String termo) {
		this.termo = termo;
	}

}
