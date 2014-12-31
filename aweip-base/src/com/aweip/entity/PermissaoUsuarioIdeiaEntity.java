package com.aweip.entity;

import java.text.SimpleDateFormat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class PermissaoUsuarioIdeiaEntity.
 */
@Entity
@Table(name = "permissaoUsuarioIdeia")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name=PermissaoUsuarioIdeiaEntity.findByUsuario,
				query="Select obj"
						+ " from PermissaoUsuarioIdeiaEntity obj"
						+ " JOIN FETCH obj.ideia"
						+ " where"
						+ " obj.usuario = :usuario"
						+ " AND obj.dataExclusao IS NULL"
						+ " AND obj.ideia.dataExclusao IS NULL "),
		@NamedQuery(name=PermissaoUsuarioIdeiaEntity.findByIdeia,
		query="Select obj"
				+ " from PermissaoUsuarioIdeiaEntity obj"
				+ " JOIN FETCH obj.usuario"
				+ " where"
				+ " obj.ideia.id = :idIdeia"
				+ " AND obj.dataExclusao IS NULL")}
		)
public class PermissaoUsuarioIdeiaEntity extends PermissaoUsuarioIdeia {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant findByUsuario. */
	public static final String findByUsuario = "PermissaoUsuarioIdeia.findByUsuario";
	
	/** The Constant findByIdeia. */
	public static final String findByIdeia = "PermissaoUsuarioIdeia.findByIdIdeia";

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/YYYY hh:mm:ss");

		return String
				.format("PermissaoUsuarioIdeiaEntity [getId()=%s, getVersao()=%s, getDataUltAtualizacao()=%s]",
						getId(), getVersao(), simpleDateFormat
								.format(getDataUltAtualizacao().getTime()));
	}
}