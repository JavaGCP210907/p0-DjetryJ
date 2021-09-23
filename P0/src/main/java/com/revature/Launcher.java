package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.models.Menu;
import com.revature.utils.ConnectionUtils;

public class Launcher {

	public static void main(String[] args) {
		
		try(Connection com = ConnectionUtils.getConnection()){
			System.out.println("IT WORKED DUDE!!!!!!!");
		}catch(SQLException e) {
			System.out.println("OOOOO SO CLOSE BRO!!!!!");
			e.printStackTrace();
		}
		
		Menu menu = new Menu();
		menu.displayMenu();

	}

}
