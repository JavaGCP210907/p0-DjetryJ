package com.revature.dao;

import java.util.List;

import com.revature.models.Playtime;

public interface PlaytimeDaoInterface {

	public List<Playtime> getPlaytime(int genre_id_fk, float time_hr);//this will return Playtime list
	
	public void updatePlaytime(int genre_id_fk, float time_hr); //This will update the playtime by genre and time

	List<Playtime> getPlaytime();
}
