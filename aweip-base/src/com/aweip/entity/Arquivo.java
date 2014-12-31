package com.aweip.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Arquivo extends AweipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private byte[] content;

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
