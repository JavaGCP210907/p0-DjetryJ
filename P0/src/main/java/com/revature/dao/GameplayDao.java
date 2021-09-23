package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Gameplay;
import com.revature.utils.ConnectionUtils;

public class GameplayDao implements GameplayDaoInterface {

	@Override
	public List<Gameplay> getGameplay() {
		
		try(Connection conn = ConnectionUtils.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM gameplay";
					
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Gameplay> gameplayList = new ArrayList<>();
			
			while(rs.next()) {
				
				Gameplay g = new Gameplay(
						rs.getInt("genre_id"),
						rs.getString("game"),
						rs.getString("platform")
						);
				
				gameplayList.add(g);
				
			}
			return gameplayList;
			
		}catch (SQLException e) {
			System.out.println("AWWW GEEEZZ RICK!!! Something went with the Databae!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Gameplay> getGameGenre(String genre) {
		
		return null;
	}

	@Override
	public List<Gameplay> getGameName(int game) {
		
		try(Connection conn = ConnectionUtils.getConnection()){
			
			ResultSet rs = null;
			String sql = "SELECT * FROM gameplay WHERE genre_id= ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, game);
			rs = ps.executeQuery();
			
			List<Gameplay> gamelist = new ArrayList<>();
			
			while(rs.next()) {
				Gameplay g = new Gameplay(
						rs.getInt("genre_id"),
						rs.getString("game"),
						rs.getString("platform")
						);
				gamelist.add(g);
			}
			return gamelist;
		}catch(SQLException e) {
			System.out.println("Something went wrong dog!!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Gameplay> getGamesByPlatform(String platform) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addGame(Gameplay game) {
		
		try(Connection conn = ConnectionUtils.getConnection()){
			String sql = "INSERT INTO gameplay(genre, game, platform)" +
						"Values(?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, game.getgenre_id());
			ps.setString(2, game.getGame());
			ps.setString(3, game.getPlatform());
			
			ps.executeUpdate();
			System.out.println("Game added " + game.getGame() + " Lets ROCK N ROLL!!!!");
			
		}catch(SQLException e) {
			System.out.println("adding game FAILED");
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeGame(String game) {
		
		try(Connection conn = ConnectionUtils.getConnection()){
			String sql = "DELETE FROM gameplay WHERE game = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, game);
			ps.executeUpdate();
			System.out.println("Game has been removed");
		}catch(SQLException e) {
			System.out.println("Removing this game has caused an ERROR");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Gameplay> getGameById(int game) {
try(Connection conn = ConnectionUtils.getConnection()){
			
			ResultSet rs = null;
			String sql = "SELECT * FROM gameplay WHERE genre_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, game);
			rs = ps.executeQuery();
			
			List<Gameplay> gamelist = new ArrayList<>();
			
			while(rs.next()) {
				Gameplay g = new Gameplay(
						rs.getInt("genre_id"),
						rs.getString("game"),
						rs.getString("platform")
						);
				gamelist.add(g);
			}
			return gamelist;
		}catch(SQLException e) {
			System.out.println("Something went wrong dog!!!");
			e.printStackTrace();
		}
		return null;
	}
	
	
	

}
