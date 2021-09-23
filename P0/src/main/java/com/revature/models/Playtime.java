package com.revature.models;

public class Playtime {
	
	private int genre_id_fk;
	private float time_hr;

	//NO args constructor
	public Playtime() {
		
	}

	public Playtime(int genre_id_fk, float time_hr) {
		super();
		this.genre_id_fk = genre_id_fk;
		this.time_hr = time_hr;
	}

	public int getGenre_id_fk() {
		return genre_id_fk;
	}

	public void setGenre(int genre_id_fk) {
		this.genre_id_fk = genre_id_fk;
	}

	public float getTime_hr() {
		return time_hr;
	}

	public void setTime_hr(float time_hr) {
		this.time_hr = time_hr;
	}

	@Override
	public String toString() {
		return "Playtime [genre_id_fk=" + genre_id_fk + ", time_hr=" + time_hr + "]";
	}
	
	
}
