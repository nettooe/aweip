package com.aweip.jsf.controller.componente;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.aweip.entity.Comentario;
import com.aweip.entity.ComentarioEntity;
import com.aweip.entity.ComentarioIdeia;
import com.aweip.entity.ComentarioIdeiaEntity;
import com.aweip.entity.Ideia;
import com.aweip.entity.IdeiaEntity;
import com.aweip.entity.PermissaoUsuarioIdeia;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class ComentsIdeiaResumoMB.
 */
@ManagedBean(name = "comentsIdeiaResumoMB")
@ViewScoped
public class ComentsIdeiaResumoMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The comentario. */
	private Comentario comentario;

	private List<ComentarioIdeia> comentsIdeiaResumo;

	private String idIdeia;

	/**
	 * Instantiates a new coments ideia resumo mb.
	 */
	public ComentsIdeiaResumoMB() {
		if (this.comentario == null) {
			this.comentario = new ComentarioEntity();
		}
	}

	public String excluir(ComentarioIdeia comentarioIdeiaEntity) {
		System.out.println("Excluindo: " + comentarioIdeiaEntity.getId());
		comentarioIdeiaEntity.setDataExclusao(Calendar.getInstance());
		this.ejb.save(comentarioIdeiaEntity);

		//findComentsIdeiaResumo(this.getIdIdeia());

		return "";
	}

	/**
	 * Salvar.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 */
	public void salvar(String idIdeia) {
		if (this.comentario != null && idIdeia != null) {
			// obtém o usuário da sessão
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			Ideia ideia = new IdeiaEntity();
			ideia.setId(idIdeia);

			this.comentario.setUsuario(usuario);

			ComentarioIdeia comentarioIdeia = new ComentarioIdeiaEntity();
			comentarioIdeia.setComentario(comentario);
			comentarioIdeia.setIdeia(ideia);

			ejb.save(comentarioIdeia);

			this.comentario = new ComentarioEntity();
		}
	}

	/**
	 * Find coments ideia resumo.
	 * 
	 * @param idIdeia
	 *            the id ideia
	 * @return the list
	 */
	public void findComentsIdeiaResumo(String idIdeia) {
		this.setIdIdeia(idIdeia);
		Ideia ideia = new IdeiaEntity();
		ideia.setId(idIdeia);
		setComentsIdeiaResumo(ejb.findComentsIdeiaResumo(ideia));
		
		// configura a permissão de exclusão para o usuário logado
		List<PermissaoUsuarioIdeia> permitidos = ejb.listarPermissoes(idIdeia);
		if(UtilSession.getAtributo(AtributosSessao.SESSION_Usuario_id) != null){
			for (PermissaoUsuarioIdeia p : permitidos) {
				// se o usuário tiver permissão, então ativa o botão de exclusão
				if(p.getUsuario().getId().equalsIgnoreCase((String) UtilSession.getAtributo(AtributosSessao.SESSION_Usuario_id))){
					for (ComentarioIdeia ci : getComentsIdeiaResumo()) {
						ci.getComentario().setUsuarioPodeExcluir(true);
					}
				}
			}
		}
	}

	/**
	 * Gets the comentario.
	 * 
	 * @return the comentario
	 */
	public Comentario getComentario() {
		return comentario;
	}

	/**
	 * Sets the comentario.
	 * 
	 * @param comentario
	 *            the new comentario
	 */
	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public List<ComentarioIdeia> getComentsIdeiaResumo() {
		return comentsIdeiaResumo;
	}

	public void setComentsIdeiaResumo(List<ComentarioIdeia> comentsIdeiaResumo) {
		this.comentsIdeiaResumo = comentsIdeiaResumo;
	}

	public String getIdIdeia() {
		return idIdeia;
	}

	public void setIdIdeia(String idIdeia) {
		this.idIdeia = idIdeia;
	}

}
