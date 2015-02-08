package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class ArquivoIdeiaEntity.
 */
@Entity
@Table(name = "arquivoideia")
@Access(AccessType.FIELD)
public class ArquivoIdeiaEntity extends ArquivoIdeia {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new arquivo ideia entity.
	 */
	public ArquivoIdeiaEntity() {
		super();
	}

	/**
	 * Instantiates a new arquivo ideia entity.
	 * 
	 * @param id
	 *            the id
	 */
	public ArquivoIdeiaEntity(String id) {
		super();
		setId(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getNome();
	}
}