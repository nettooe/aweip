package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "arquivoideia")
@Access(AccessType.FIELD)
public class ArquivoIdeiaEntity extends ArquivoIdeia {
	private static final long serialVersionUID = 1L;
	
	public ArquivoIdeiaEntity() {
		super();
	}
	public ArquivoIdeiaEntity(String id) {
		super();
		setId(id);
	}

	@Override
	public String toString() {
		return getNome();
	}
}