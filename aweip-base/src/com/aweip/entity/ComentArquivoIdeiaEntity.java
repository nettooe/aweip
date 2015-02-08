package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class ComentArquivoIdeiaEntity.
 */
@Entity
@Table(name = "comentarquivoideia")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = ComentArquivoIdeiaEntity.findByArquivoIdeia, query = "Select obj"
		+ " from ComentArquivoIdeiaEntity obj"
		+ " JOIN obj.arquivoIdeia"
		+ " JOIN FETCH obj.comentario obj2"
		+ " JOIN FETCH obj2.usuario obj3"
		+ " where obj.arquivoIdeia = :arquivoIdeia"
		+ " AND obj.dataExclusao IS NULL"))
public class ComentArquivoIdeiaEntity extends ComentArquivoIdeia {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant findByArquivoIdeia. */
	public static final String findByArquivoIdeia = "ComentArquivoIdeia.findByArquivoIdeia";
}
