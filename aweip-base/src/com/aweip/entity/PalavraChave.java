package com.aweip.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class PalavraChave.
 */
@MappedSuperclass
public abstract class PalavraChave extends AweipEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The termo. */
	@NotNull
	@NotEmpty
	@NotBlank
	private String termo;

	/**
	 * Gets the termo.
	 * 
	 * @return the termo
	 */
	public String getTermo() {
		return termo;
	}

	/**
	 * Sets the termo.
	 * 
	 * @param termo
	 *            the new termo
	 */
	public void setTermo(String termo) {
		this.termo = termo;
	}

}
