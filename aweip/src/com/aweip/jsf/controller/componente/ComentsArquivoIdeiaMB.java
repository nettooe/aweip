package com.aweip.jsf.controller.componente;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import com.aweip.entity.ArquivoIdeia;
import com.aweip.entity.ArquivoIdeiaEntity;
import com.aweip.entity.ComentArquivoIdeia;
import com.aweip.entity.ComentArquivoIdeiaEntity;
import com.aweip.entity.Comentario;
import com.aweip.entity.ComentarioEntity;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

/**
 * The Class ComentsArquivoIdeiaMB.
 */
@ManagedBean(name = "comentsArquivoIdeiaMB")
@RequestScoped
public class ComentsArquivoIdeiaMB implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ejb. */
	@EJB
	private IIdeiaStateless ejb;

	/** The comentario. */
	private Comentario comentario;

	/** The coments arquivo ideia. */
	List<ComentArquivoIdeia> comentsArquivoIdeia;

	/**
	 * Instantiates a new coments arquivo ideia mb.
	 */
	public ComentsArquivoIdeiaMB() {
		if (this.comentario == null) {
			this.comentario = new ComentarioEntity();
		}
	}

	/**
	 * Find coments arquivo ideia.
	 * 
	 * @param idArquivoIdeia
	 *            the id arquivo ideia
	 */
	public List<ComentArquivoIdeia> findComentsArquivoIdeia(
			String idArquivoIdeia) {
		ArquivoIdeia arquivoIdeia = new ArquivoIdeiaEntity();
		arquivoIdeia.setId(idArquivoIdeia);
		return ejb.findComentsArquivoIdeia(arquivoIdeia);
	}

	public void salvar(String idArquivoIdeia) {
		if (this.comentario != null && idArquivoIdeia != null) {
			// obtém o usuário da sessão
			UsuarioEntity usuario = new UsuarioEntity();
			usuario.setId(UtilSession.getAtributo(
					AtributosSessao.SESSION_Usuario_id).toString());

			ArquivoIdeia arquivoIdeia = new ArquivoIdeiaEntity();
			arquivoIdeia.setId(idArquivoIdeia);

			this.comentario.setUsuario(usuario);

			ComentArquivoIdeia comentArquivoIdeia = new ComentArquivoIdeiaEntity();
			comentArquivoIdeia.setComentario(comentario);
			comentArquivoIdeia.setArquivoIdeia(arquivoIdeia);

			ejb.save(comentArquivoIdeia);

			this.comentario = new ComentarioEntity();
		}
	}

	public void excluir(ActionEvent actionEvent) {

		String idComentArquivoIdeia = (String) actionEvent.getComponent()
				.getAttributes().get("idComentArquivoIdeia");

		ComentArquivoIdeia comentArquivoIdeia = new ComentArquivoIdeiaEntity();
		comentArquivoIdeia.setId(idComentArquivoIdeia);

		comentArquivoIdeia = this.ejb.find(comentArquivoIdeia);

		comentArquivoIdeia.setDataExclusao(Calendar.getInstance());

		comentArquivoIdeia = this.ejb.save(comentArquivoIdeia);
	}

	/**
	 * Gets the coments arquivo ideia.
	 * 
	 * @return the coments arquivo ideia
	 */
	public List<ComentArquivoIdeia> getComentsArquivoIdeia() {
		return comentsArquivoIdeia;
	}

	/**
	 * Sets the coments arquivo ideia.
	 * 
	 * @param comentsArquivoIdeia
	 *            the new coments arquivo ideia
	 */
	public void setComentsArquivoIdeia(
			List<ComentArquivoIdeia> comentsArquivoIdeia) {
		this.comentsArquivoIdeia = comentsArquivoIdeia;
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

}
