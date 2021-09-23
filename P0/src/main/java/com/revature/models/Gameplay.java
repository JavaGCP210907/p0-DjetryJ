package com.revature.models;

import java.util.List;

public class Gameplay {

	//fields for Gameplay class
	private int genre_id;
	private String game;
	private String platform;
	private String genre_id_st;
	
	//No args constructor 
	public Gameplay() {
		
	}

	public Gameplay(int genre_id, String game, String platform) {
		super();
		this.genre_id = genre_id;
		this.game = game;
		this.platform = platform;
	}
	
	public Gameplay(String genre_id_st, String game, String platform) {
		super();
		this.genre_id_st = genre_id_st;
		this.game = game;
		this.platform = platform;
	}
	
	//getters and setters for gameplay
	public int getgenre_id() {
		return genre_id;
	}

	public void setgenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}


	@Override
	public String toString() {
		return "Gameplay [genre_id=" + genre_id + ", game=" + game + ", platform=" + platform + "]";
	}


	
	
}
