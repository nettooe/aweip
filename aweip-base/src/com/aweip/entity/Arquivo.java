package com.aweip.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * The Class Arquivo.
 */
@MappedSuperclass
public abstract class Arquivo extends AweipEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content. */
	@NotNull
	private byte[] content;

	/**
	 * Gets the content.
	 * 
	 * @return the content
	 */
	public byte[] getContent() {
		return content;
	}

	/**
	 * Sets the content.
	 * 
	 * @param content
	 *            the new content
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

}
