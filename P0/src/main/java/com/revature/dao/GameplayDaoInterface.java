package com.revature.dao;

import java.util.List;

import com.revature.models.Gameplay;

public interface GameplayDaoInterface {

	public List<Gameplay> getGameplay();
	
	public List<Gameplay> getGameGenre(String genre);
	
	public List<Gameplay> getGameName(int game);
	
	public List<Gameplay> getGamesByPlatform(String platform);
	
	public List<Gameplay> getGameById(int genre_id);
	
	public void addGame(Gameplay game); //This will add new games to the list/database
	
	public void removeGame(String game);//this will remove games based on the game name
}
