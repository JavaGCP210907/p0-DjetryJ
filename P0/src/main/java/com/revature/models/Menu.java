package com.revature.models;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.GameplayDao;
import com.revature.dao.PlaytimeDao;

public class Menu {

	GameplayDao gDao = new GameplayDao();
	PlaytimeDao pDao = new PlaytimeDao();
	Logger log = LogManager.getLogger(Menu.class); 
	
	public void displayMenu() {
		boolean displayMenu = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("```````````````````````````````");
		System.out.println("Shall we play Game?");
		
		while(displayMenu) {
			System.out.println("TYPE IN ONE OF THESE");
			System.out.println("---------------------");
			
			//menu options
			System.out.println("What games do I have? -> return all games");
			System.out.println("What should I play? -> get random game");
			System.out.println("How long should I play -> return playtime");
			System.out.println("addGame -> add a game");
			System.out.println("removeGame -> removes a game");
			System.out.println("UpdatePlaytime -> will update playtime");
			System.out.println("Done -> exit app");
			
			String input = sc.nextLine();
			
			switch(input){
			case "What games do I have?":{
				List<Gameplay> gameplay = gDao.getGameplay();
				
				for(Gameplay gp: gameplay) {
					System.out.println(gp);
				}
				log.info("User RETRIEVED GAMEPLAY LIST");
				break;
			}
			case "What should I play?":{
				System.out.println("Im glad you asked!!!!");
				Random rand = new Random();
				int rn = rand.nextInt(6);
				System.out.println(rn);
				List<Gameplay> gameId = gDao.getGameById(rn);
				for(Gameplay gi: gameId) {
					System.out.println(gi);
				}
				/*for(int i = 0; i < 5;) {
					double index = (int)(Math.random() * gDao.getGameplay().size());
					List<Gameplay> getGameName = gDao.getGameName(index);
					System.out.println("You should play: " + getGameName);
					sc.nextLine();
					break;
					
				}*/
				break;
			}
			case "How long should I play?":{
				List<Playtime> playtime = pDao.getPlaytime();
				
				for(Playtime pt: playtime) {
					System.out.println(pt);
				}
				
				break;
			}
			case "addGame":{
				System.out.println("Enter game genre");
				System.out.println("Fighting, Open World, Story Driven, Action RPG, MOBA");
				String gameGenre = sc.nextLine();
				System.out.println("Enter game name");
				String gameName = sc.nextLine();
				System.out.println("Enter platform game is on");
				System.out.println("PC, PS4");
				String gamePlatform = sc.nextLine();
				
				Gameplay gm = new Gameplay(gameGenre, gameName, gamePlatform);
				
				gDao.addGame(gm);
				sc.nextLine();
				
				log.info("USER ADDED GAME" + gm);
				
				break;
				
			}
			case "removeGame":{
				System.out.println("Enter game name to remove it");
				String game = sc.nextLine();
				
				gDao.removeGame(game);
				sc.nextLine();
				
				log.warn("USER DELETED A GAME" + game);
				
				break;
			}
			case "UpdatePlaytime":{
				System.out.println("Enter a genre to update");
				int genre_idInput = sc.nextInt();
				
				System.out.println("Enter a time to update");
				float timeInput = sc.nextFloat();
				sc.nextLine();
				
				pDao.updatePlaytime(genre_idInput, timeInput);
				sc.nextLine();
				
				break;
			}
			case "Done":{
				displayMenu = false;
				System.out.println("Have FUN GAMING BRUH!!!!");
				log.info("USER ENDED THE GAMEPLAY APP");
				break;
				
			}
			default:{
				System.out.println("WUBBA LUBBA DUB-DUB, YOUR TYPO IS PAIN!!!!!");
			}
			
			}
		}
	}
	
}
