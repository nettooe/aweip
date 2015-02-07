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

@Entity
@Table(name = "ideia")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name=IdeiaEntity.sugerirIdeiasByUsuario,
			query="Select obj from IdeiaEntity obj"),
	@NamedQuery(name=IdeiaEntity.listarFeedsByUsuario,
			query="Select obj from IdeiaEntity obj JOIN FETCH obj.palavrasChaveIdeia obj2 ORDER BY obj.dataUltAtualizacao"),
	@NamedQuery(name=IdeiaEntity.obterAvatarIdeia,
			query="Select obj.avatar from IdeiaEntity obj WHERE obj.id = :idIdeia")
})
public class IdeiaEntity extends Ideia {
	private static final long serialVersionUID = 1L;
	
	public static final String sugerirIdeiasByUsuario = "IdeiaEntity.sugerirIdeiasByUsuario";
	public static final String listarFeedsByUsuario = "IdeiaEntity.listarFeedsByUsuario";
	public static final String obterAvatarIdeia = "IdeiaEntity.obterAvatarIdeia";
	
	@PrePersist
	@PreUpdate
	private void atribuirResumo() {
		if (this.getResumo() == null || this.getResumo().isEmpty()) {
			this.setResumo("-- resumo inexistente --");
		}
	}

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