package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	
	public static Connection getConnection() throws SQLException {
		
		try { 
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//Setting up credentials 
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=gameplay";
		String username = "postgres";
		String password = "Nukacola4$";
		
		return DriverManager.getConnection(url, username, password);
	}

}
