package com.speedrunsbrasil.blindraces.dominio;

public class Runner extends EntidadeDominio {
	
	private String nickTwitch;
	private String nameTagDiscord;
	/**
	 * @return the nickTwitch
	 */
	public String getNickTwitch() {
		return nickTwitch;
	}
	/**
	 * @param nickTwitch the nickTwitch to set
	 */
	public void setNickTwitch(String nickTwitch) {
		this.nickTwitch = nickTwitch;
	}
	/**
	 * @return the nameTagDiscord
	 */
	public String getNameTagDiscord() {
		return nameTagDiscord;
	}
	/**
	 * @param nameTagDiscord the nameTagDiscord to set
	 */
	public void setNameTagDiscord(String nameTagDiscord) {
		this.nameTagDiscord = nameTagDiscord;
	}

}
