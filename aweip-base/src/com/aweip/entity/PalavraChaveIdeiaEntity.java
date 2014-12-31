package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "palavrachaveideia")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name=PalavraChaveIdeiaEntity.listByIdeia,
				query="Select obj"
						+ " from PalavraChaveIdeiaEntity obj"
						+ " JOIN FETCH obj.palavraChave"
						+ " where obj.ideia = :ideia"),
		@NamedQuery(name=PalavraChaveIdeiaEntity.listByTermo,
				query="Select obj"
						+ " from PalavraChaveIdeiaEntity obj"
						+ " JOIN FETCH obj.ideia"
						+ " where obj.palavraChave.termo = :termo")
})
public class PalavraChaveIdeiaEntity extends PalavraChaveIdeia {
	private static final long serialVersionUID = 1L;
	
	public static final String listByIdeia = "PalavraChaveIdeia.listByIdeia";
	public static final String listByTermo = "PalavraChaveIdeia.listByTermo";

}
