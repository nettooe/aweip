package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class PalavraChaveEntity.
 */
@Entity
@Table(name = "palavraChave")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = PalavraChaveEntity.findByTermo, query = "Select obj"
		+ " from PalavraChaveEntity obj" + " where obj.termo = :termo"))
public class PalavraChaveEntity extends PalavraChave {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant findByTermo. */
	public static final String findByTermo = "PalavraChave.findByTermo";

}
