package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The Class ComentarioIdeiaEntity.
 */
@Entity
@Table(name = "comentarioideia")
@Access(AccessType.FIELD)
@NamedQueries(@NamedQuery(name = ComentarioIdeiaEntity.findByIdeia, query = "Select obj"
		+ " from ComentarioIdeiaEntity obj"
		+ " JOIN obj.ideia"
		+ " JOIN FETCH obj.comentario comentario"
		+ " JOIN FETCH comentario.usuario usuario"
		+ " where"
		+ "  obj.ideia = :ideia"
		+ "  AND obj.dataExclusao IS NULL"
		+ " ORDER BY obj.comentario.dataUltAtualizacao"))
public class ComentarioIdeiaEntity extends ComentarioIdeia {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant findByIdeia. */
	public static final String findByIdeia = "ComentarioIdeia.findByIdeia";
}
