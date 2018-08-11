package com.speedrunsbrasil.blindraces.dominio;

public class Submit extends EntidadeDominio{
	private Jogo jogo;
	private Runner runner;
	private String objetivo;
	private String linkDownload;
	private String linkPastebin;
	private int estimate;
	private StatusSubmit statusSubmit;
	
	public Submit() {
		this.jogo = new Jogo();
	}

	public Jogo getJogo() {
		return jogo;
	}
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getLinkDownload() {
		return linkDownload;
	}
	public void setLinkDownload(String linkDownload) {
		this.linkDownload = linkDownload;
	}
	public String getLinkPastebin() {
		return linkPastebin;
	}
	public void setLinkPastebin(String linkPastebin) {
		this.linkPastebin = linkPastebin;
	}
	public int getEstimate() {
		return estimate;
	}
	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	/**
	 * @return the statusSubmit
	 */
	public StatusSubmit getStatusSubmit() {
		return statusSubmit;
	}

	/**
	 * @param statusSubmit the statusSubmit to set
	 */
	public void setStatusSubmit(StatusSubmit statusSubmit) {
		this.statusSubmit = statusSubmit;
	}

	/**
	 * @return the runner
	 */
	public Runner getRunner() {
		return runner;
	}

	/**
	 * @param runner the runner to set
	 */
	public void setRunner(Runner runner) {
		this.runner = runner;
	}	
}
