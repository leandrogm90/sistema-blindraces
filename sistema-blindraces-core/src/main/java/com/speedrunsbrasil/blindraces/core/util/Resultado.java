package com.speedrunsbrasil.blindraces.core.util;

import com.speedrunsbrasil.blindraces.dominio.EntidadeDominio;

public class Resultado {
	private EntidadeDominio entidade;
	private String msgRetorno;
	
	
	public Resultado() {
		entidade = new EntidadeDominio();
		msgRetorno = "";
	}
	/**
	 * @return the entidade
	 */
	public EntidadeDominio getEntidade() {
		return entidade;
	}
	/**
	 * @param entidade the entidade to set
	 */
	public void setEntidade(EntidadeDominio entidade) {
		this.entidade = entidade;
	}
	/**
	 * @return the msgRetorno
	 */
	public String getMsgRetorno() {
		return msgRetorno;
	}
	/**
	 * @param msgRetorno the msgRetorno to set
	 */
	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}

}
