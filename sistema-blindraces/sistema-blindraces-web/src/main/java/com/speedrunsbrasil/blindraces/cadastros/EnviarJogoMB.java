package com.speedrunsbrasil.blindraces.cadastros;

import java.io.Serializable;
import com.speedrunsbrasil.blindraces.core.service.SubmitService;
import com.speedrunsbrasil.blindraces.dominio.Jogo;
import com.speedrunsbrasil.blindraces.dominio.Runner;
import com.speedrunsbrasil.blindraces.dominio.Submit;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EnviarJogoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Submit submitJogo;
	
	@PostConstruct
	public void init() {
		
		submitJogo = new Submit();
		submitJogo.setRunner(new Runner());
		submitJogo.setJogo(new Jogo());	
	}
	
	public void cadastrar() throws Exception {
	
		SubmitService ISubmit = new SubmitService();
		
		
		ISubmit.salvarSubmit(submitJogo);
		
		submitJogo = new Submit();
		
	}

	public Submit getSubmitJogo() {
		return submitJogo;
	}

	public void setSubmitJogo(Submit submitJogo) {
		this.submitJogo = submitJogo;
	}
}
