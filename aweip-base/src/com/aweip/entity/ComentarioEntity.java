package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
@Access(AccessType.FIELD)
@NamedQueries(
		@NamedQuery(name=ComentarioEntity.findByUsuario,
				query="Select obj"
						+ " from ComentarioEntity obj"
						+ " JOIN obj.usuario"
						+ " where obj.usuario = :usuario")
		)
public class ComentarioEntity extends Comentario {
	private static final long serialVersionUID = 1L;
	
	public static final String findByUsuario = "Comentario.findByUsuario";

}
