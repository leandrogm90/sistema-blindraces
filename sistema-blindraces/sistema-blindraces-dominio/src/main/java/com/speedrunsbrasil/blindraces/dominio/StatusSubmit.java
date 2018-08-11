package com.speedrunsbrasil.blindraces.dominio;

public enum StatusSubmit {
	
	APROVADO (1, "Aprovado"),
	PENDENTE (2, "Pendente"),
	REJEITADO (3, "Rejeitado");
	
	private int codigo;
	private String descricao;
	
	private StatusSubmit(int codigo, String descricao) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}
		
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}
