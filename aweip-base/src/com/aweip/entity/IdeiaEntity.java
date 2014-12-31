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
			query="Select obj from IdeiaEntity obj")
})
public class IdeiaEntity extends Ideia {
	private static final long serialVersionUID = 1L;
	
	public static final String sugerirIdeiasByUsuario = "IdeiaEntity.sugerirIdeiasByUsuario";
	
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