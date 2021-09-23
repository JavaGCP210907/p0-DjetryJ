package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Gameplay;
import com.revature.models.Playtime;
import com.revature.utils.ConnectionUtils;

public class PlaytimeDao implements PlaytimeDaoInterface{

	@Override
	public List<Playtime> getPlaytime() {
		
try(Connection conn = ConnectionUtils.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM playtime";
					
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Playtime> playtimelist = new ArrayList<>();
			
			while(rs.next()) {
				
				Playtime p = new Playtime(
						rs.getInt("genre_id_fk"),
						rs.getFloat("time_hr")
						);
				
				playtimelist.add(p);
				
			}
			return playtimelist;
			
		}catch (SQLException e) {
			System.out.println("AWWW GEEEZZ RICK!!! Something went with the Databae!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updatePlaytime(int genre_id_fk, float time_hr) {
		try(Connection conn = ConnectionUtils.getConnection()){
			String sql = "UPDATE playtime FROM gameplay genre_fk= ? WHERE time_hr = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, genre_id_fk);
			ps.setFloat(2, time_hr);
			ps.executeUpdate();
			System.out.println("Playtime has been updated");
		}catch(SQLException e) {
			System.out.println("GET RICKITY RICKITY WRECKED SON!! FAILED TO UPDATE PLAYTIME");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Playtime> getPlaytime(int genre_id_fk, float time_hr) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
