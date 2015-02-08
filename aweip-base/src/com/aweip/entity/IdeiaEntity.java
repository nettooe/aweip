package com.aweip.entity;

import java.text.SimpleDateFormat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 * The Class IdeiaEntity.
 */
@Entity
@Table(name = "ideia")
@Access(AccessType.FIELD)
@NamedQueries({
		@NamedQuery(name = IdeiaEntity.sugerirIdeiasByUsuario, query = "Select obj from IdeiaEntity obj"),
		@NamedQuery(name = IdeiaEntity.listarFeedsByUsuario, query = "Select obj from IdeiaEntity obj LEFT JOIN FETCH obj.palavrasChaveIdeia obj2 ORDER BY obj.dataUltAtualizacao"),
		@NamedQuery(name = IdeiaEntity.obterAvatarIdeia, query = "Select obj.avatar from IdeiaEntity obj WHERE obj.id = :idIdeia"),
		@NamedQuery(name = IdeiaEntity.pesquisarIdeia, query = "Select obj from IdeiaEntity obj LEFT JOIN FETCH obj.palavrasChaveIdeia obj2 "
				+ " WHERE upper(obj.titulo) LIKE CONCAT('%', upper(:termoPesquisadoTitulo), '%') "
				+ " OR upper(obj.resumo) LIKE CONCAT('%', upper(:termoPesquisadoResumo), '%')  ") })
public class IdeiaEntity extends Ideia {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant sugerirIdeiasByUsuario. */
	public static final String sugerirIdeiasByUsuario = "IdeiaEntity.sugerirIdeiasByUsuario";

	/** The Constant listarFeedsByUsuario. */
	public static final String listarFeedsByUsuario = "IdeiaEntity.listarFeedsByUsuario";

	/** The Constant obterAvatarIdeia. */
	public static final String obterAvatarIdeia = "IdeiaEntity.obterAvatarIdeia";

	/** The Constant pesquisarIdeia. */
	public static final String pesquisarIdeia = "IdeiaEntity.pesquisarIdeia";

	/**
	 * Atribuir resumo.
	 */
	@PrePersist
	@PreUpdate
	private void atribuirResumo() {
		if (this.getResumo() == null || this.getResumo().isEmpty()) {
			this.setResumo("-- resumo inexistente --");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/YYYY hh:mm:ss");

		return String
				.format("IdeiaEntity [getId()=%s, getVersao()=%s, getDataUltAtualizacao()=%s]",
						getId(), getVersao(), simpleDateFormat
								.format(getDataUltAtualizacao().getTime()));
	}
}