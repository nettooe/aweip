package com.aweip.jsf.controller.ideia;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.UploadedFile;

import com.aweip.entity.Arquivo;
import com.aweip.entity.ArquivoEntity;
import com.aweip.entity.ArquivoIdeia;
import com.aweip.entity.ArquivoIdeiaEntity;
import com.aweip.entity.ComentArquivoIdeia;
import com.aweip.entity.ComentArquivoIdeiaEntity;
import com.aweip.entity.Comentario;
import com.aweip.entity.ComentarioEntity;
import com.aweip.entity.Ideia;
import com.aweip.entity.IdeiaEntity;
import com.aweip.entity.Usuario;
import com.aweip.entity.UsuarioEntity;
import com.aweip.jsf.controller.util.AtributosSessao;
import com.aweip.jsf.controller.util.AtributosSessaoTemp;
import com.aweip.jsf.controller.util.UtilMensagens;
import com.aweip.jsf.controller.util.UtilSession;
import com.aweip.stateless.IIdeiaStateless;

@ManagedBean(name = "tabArquivosMB")
@ViewScoped
public class TabArquivosMB implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private IIdeiaStateless ejb;

	private Ideia ideia;
	private UploadedFile file;

	private UploadedFile updateFile;

	private String idArquivoIdeia;
	
	private String comentario;

	public TabArquivosMB() {
		// verifica se existe um id de IdeiaNova na sessão... se existir, inicia
		this.ideia = new IdeiaEntity();
		this.ideia.setId((String) UtilSession
				.getAtributoTemp(AtributosSessaoTemp.SESSION_TMP_Ideia_id_b));
	}

	@PostConstruct
	private void init() {
		if (this.ideia != null && this.ideia.getId() != null) {
			this.ideia = ejb.obterIdeia(ideia);
		}
	}
	
	public void salvarComentario(ActionEvent actionEvent){
		System.out.println(">>>>>>>>>>   Comentário realizado "+ Calendar.getInstance().getTimeInMillis());
		String idArquivoIdeia = (String)actionEvent.getComponent().getAttributes().get("idArquivoIdeia");
		System.out.println(">>>>>>>>>>" + idArquivoIdeia);
		System.out.println(">>>>>Comentário>>>>>" + this.getComentario());
		
		Usuario usuario = new UsuarioEntity();
		usuario.setId((String) UtilSession
				.getAtributo(AtributosSessao.SESSION_Usuario_id));
		
		Comentario comentario = new ComentarioEntity();
		comentario.setDescricao(this.getComentario());
		comentario.setUsuario(usuario);
		
		ArquivoIdeia arquivoIdeia = new ArquivoIdeiaEntity();
		arquivoIdeia.setId(idArquivoIdeia);
		arquivoIdeia = this.ejb.obterArquivoIdeia(arquivoIdeia);
		
		ComentArquivoIdeia comentArquivoIdeia = new ComentArquivoIdeiaEntity();
		comentArquivoIdeia.setComentario(comentario);
		comentArquivoIdeia.setArquivoIdeia(arquivoIdeia);
		
		comentArquivoIdeia = this.ejb.save(comentArquivoIdeia);
		
		this.setComentario(new String());
		
		this.ideia = ejb.obterIdeia(this.ideia);
	}

	public void salvarArquivoIdeia(String idArquivoIdeia) {
		ArquivoIdeiaEntity arquivoIdeiaEntity = null;

		for (ArquivoIdeiaEntity ai : this.ideia.getArquivosDaIdeia()) {
			if (ai.getId().equals(idArquivoIdeia)) {
				arquivoIdeiaEntity = ai;
				break;
			}
		}

		ejb.save(arquivoIdeiaEntity);

		UtilMensagens.addInfoMessage("formArquivos", "Sucesso",
				"Descrição salva.");
	}

	public void download(String idArquivoIdeia) {

		ArquivoIdeiaEntity arquivoDownload = new ArquivoIdeiaEntity(
				idArquivoIdeia);

		arquivoDownload = (ArquivoIdeiaEntity) ejb
				.obterArquivoIdeia(arquivoDownload);

		if (arquivoDownload != null) {
			arquivoDownload.setArquivo(ejb.obterArquivo(arquivoDownload));
		}

		if (arquivoDownload != null) {
			try {
				FacesContext fc = FacesContext.getCurrentInstance();
				ExternalContext ec = fc.getExternalContext();

				ec.responseReset();

				ec.setResponseContentLength(Integer.parseInt(String
						.valueOf(arquivoDownload.getTamanho())));

				ec.setResponseHeader("Content-Disposition",
						"attachment; filename=\"" + arquivoDownload.getNome()
								+ "\"");

				OutputStream output = ec.getResponseOutputStream();

				output.write(arquivoDownload.getArquivo().getContent());

				output.close();
				fc.responseComplete();
			} catch (IOException e) {
				UtilMensagens.addFatalMessage("formArquivos", "Ops!",
						"Falha desconhecida. Tente denovo em instantes.");
				e.printStackTrace();
			}
			FacesContext.getCurrentInstance().responseComplete();
		} else {
			UtilMensagens
					.addErrorMessage(
							"formArquivos",
							"Erro",
							"Não foi possível realizar o download. Experimente tentar novamente em instantes.");
		}

	}

	public void atualizarArquivo(String idIdeia) {
		this.ideia = new IdeiaEntity();
		this.ideia.setId(idIdeia);
		this.ideia = ejb.obterIdeia(ideia);

		ArquivoIdeiaEntity aiSalvar = null;

		for (ArquivoIdeiaEntity ai : this.ideia.getArquivosDaIdeia()) {
			if (ai.getId().equals(idArquivoIdeia)) {
				aiSalvar = ai;
				break;
			}
		}

		if (aiSalvar == null) {
			UtilMensagens.addErrorMessage(null, "Erro",
					"Falha ao atualizar arquivo. Tente novamente.");
		} else {
			aiSalvar.setArquivo(ejb.obterArquivo(aiSalvar));
			aiSalvar.getArquivo().setContent(updateFile.getContents());

			Usuario usuario = new UsuarioEntity();
			usuario.setId((String) UtilSession
					.getAtributo(AtributosSessao.SESSION_Usuario_id));

			aiSalvar.setUsuario(usuario);
			aiSalvar.setNome(updateFile.getFileName());
			aiSalvar.setTamanho(updateFile.getSize());

			ejb.atualizarArquivo(aiSalvar);

			this.ideia = ejb.obterIdeia(this.ideia);

			if (updateFile != null) {
				FacesMessage message = new FacesMessage("Sucesso",
						updateFile.getFileName() + " anexado.");
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	}

	public void upload(String idIdeia) {
		this.ideia = new IdeiaEntity();
		this.ideia.setId(idIdeia);
		this.ideia = ejb.obterIdeia(ideia);

		Arquivo arquivo = new ArquivoEntity();
		arquivo.setContent(file.getContents());

		Usuario usuario = new UsuarioEntity();
		usuario.setId((String) UtilSession
				.getAtributo(AtributosSessao.SESSION_Usuario_id));

		ArquivoIdeia arquivoIdeia = new ArquivoIdeiaEntity();
		arquivoIdeia.setArquivo(arquivo);
		arquivoIdeia.setIdeia(this.ideia);
		arquivoIdeia.setUsuario(usuario);
		arquivoIdeia.setNome(file.getFileName());
		arquivoIdeia.setTamanho(file.getSize());

		ejb.save((ArquivoIdeiaEntity) arquivoIdeia);

		this.ideia = ejb.obterIdeia(this.ideia);

		if (file != null) {
			FacesMessage message = new FacesMessage("Sucesso",
					file.getFileName() + " anexado.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void apagar(String idArquivoIdeia) {

		ArquivoIdeiaEntity aiExcluir = null;

		for (ArquivoIdeiaEntity ai : this.ideia.getArquivosDaIdeia()) {
			if (ai.getId().equals(idArquivoIdeia)) {
				aiExcluir = ai;
				break;
			}
		}

		ejb.apagar(aiExcluir);
		
		this.ideia = ejb.obterIdeia(this.ideia);

		FacesMessage message = new FacesMessage("Sucesso", "Arquivo eliminado!");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Ideia getIdeia() {
		return ideia;
	}

	public void setIdeia(Ideia ideia) {
		this.ideia = ideia;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public UploadedFile getUpdateFile() {
		return updateFile;
	}

	public void setUpdateFile(UploadedFile updateFile) {
		this.updateFile = updateFile;
	}

	public String getIdArquivoIdeia() {
		return idArquivoIdeia;
	}

	public void setIdArquivoIdeia(String idArquivoIdeia) {
		this.idArquivoIdeia = idArquivoIdeia;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	
}
