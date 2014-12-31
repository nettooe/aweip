package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "interesse")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name=InteresseEntity.listByUsuario,
				query="Select obj"
						+ " from InteresseEntity obj"
						+ " JOIN FETCH obj.palavraChave"
						+ " where obj.usuario = :usuario"
						+ " ORDER BY obj.palavraChave.termo ASC"),
		@NamedQuery(name=InteresseEntity.listByTermo,
				query="Select obj"
						+ " from InteresseEntity obj"
						+ " JOIN FETCH obj.usuario"
						+ " where obj.palavraChave.termo = :termo")
})
public class InteresseEntity extends Interesse {
	private static final long serialVersionUID = 1L;
	
	public static final String listByUsuario = "Interesse.listByUsuario";
	public static final String listByTermo = "Interesse.listByTermo";

}
