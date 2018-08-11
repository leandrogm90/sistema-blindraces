package com.speedrunsbrasil.blindraces.core.service;

import java.io.Serializable;
import java.util.Base64;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.speedrunsbrasil.blindraces.core.dao.SubmitDAO;
import com.speedrunsbrasil.blindraces.core.util.Resultado;
import com.speedrunsbrasil.blindraces.dominio.Jogo;
import com.speedrunsbrasil.blindraces.dominio.Submit;

public class SubmitService implements Serializable {

	private static final long serialVersionUID = 1L;
	private SubmitDAO dao;
	
	private Resultado resultado;
	
	public Resultado salvarSubmit(Submit submit) {
		
		resultado = new Resultado();
		
		try{
			dao = new SubmitDAO();			
			submit = encriptaCamposSubmit(submit);
			
			dao.salvar(submit);
			resultado.setEntidade(submit);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogo enviado com sucesso!", "Jogo enviado com sucesso!"));
			return resultado;
		} catch (Exception e) {
			resultado.setMsgRetorno(e.getMessage());
			resultado.setEntidade(null);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao enviar jogo! Entre em contato com o desenvolvedor.", "Erro ao enviar jogo! Entre em contato com o desenvolvedor."));
			return resultado;
		}
		
	}
	
	private Submit encriptaCamposSubmit(Submit submit) {
		
		Jogo jogo = submit.getJogo();
		try {
			submit.setLinkDownload(Base64.getEncoder().encodeToString(submit.getLinkDownload().getBytes()));
			submit.setLinkPastebin(Base64.getEncoder().encodeToString(submit.getLinkPastebin().getBytes()));
			submit.setObjetivo(Base64.getEncoder().encodeToString(submit.getObjetivo().getBytes()));		
			jogo.setTitulo(Base64.getEncoder().encodeToString(jogo.getTitulo().getBytes()));

			submit.setJogo(jogo);		
			
			return submit;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}

	/**
	 * @return the dao
	 */
	public SubmitDAO getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(SubmitDAO dao) {
		this.dao = dao;
	}

	/**
	 * @return the resultado
	 */
	public Resultado getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

}
