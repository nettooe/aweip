package com.aweip.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "arquivo")
@Access(AccessType.FIELD)
@NamedQueries(
		@NamedQuery(name=ArquivoEntity.findByArquivoIdeia,
				query="Select obj.arquivo"
						+ " from ArquivoIdeiaEntity obj"
						+ " JOIN obj.arquivo"
						+ " where obj = :arquivoIdeia")
		)
public class ArquivoEntity extends Arquivo {
	private static final long serialVersionUID = 1L;
	
	public static final String findByArquivoIdeia = "Arquivo.findByArquivoIdeia";

}
