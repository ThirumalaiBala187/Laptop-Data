package BackendAssignment004;

import java.util.LinkedList;

import java.util.Queue;

import java.util.Random;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class HotPotato {
	
	static Queue<Players> playersList = new LinkedList<>();
	
//	static Logger logger = Logger.getLogger(HotPotato.class);
	
	static Logger logger = Logger.getLogger(HotPotato.class);
	
	static public Players gameLogic() {
		
		Random randomNum = new Random();
		
		Players player = null;
		
		while(playersList.size()>1) {
			
			int generatedRandomNum = randomNum.nextInt(playersList.size());
			
//			System.out.println("\nRandomly generated number : " + generatedRandomNum);
			
			for(int i=0;i<=generatedRandomNum;i++) {
				
				player=playersList.poll();
				
				if(i<generatedRandomNum) {
					
					playersList.add(player);					
					
				}
				
				else {
					
					System.out.println("\n" + player.playerName + " has been Eliminated from the Game.");
					
					System.out.println("Now, the potato is passed to " + playersList.peek().playerName);
					
				}
				
			}				
			
		}
		
		return playersList.poll();
		
	}
	
	public static void main(String[] args) {
		
		logger.debug("Debug Logger Cofiguration.");
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("--- Welcome to the Hot Potato Game ---");
		
		loop1 : while(true) {
		
			System.out.println("\nWhat do you want to do?\nPress '1' to 'Add' players.\nPress '2' to 'View' players.\nPress '3' to Start Game.\nPress '4' to 'Exit'.");
			
			int choice = userInput.nextInt();
			
			switch (choice) {
			
			case 1:
				
				System.out.println("\nEnter the number of players you want to add.");
				
				int playerCount = userInput.nextInt();
				
				userInput.nextLine();
				
				for(int i=1;i<=playerCount;i++) {
					
					System.out.println("Enter the Player " + i  + " name:");
					
					String playerName = userInput.nextLine();
					
					playersList.add(new Players(playerName));
					
				}
				
				break;

				
			case 2:
				
				if(playersList.isEmpty()) {
					
					System.out.println("\nNo players have been added yet. Please add players to proceed.");
					
				}
				
				else {
					
					for(Players player : playersList) {
						
						System.out.println(player.toString());
						
					}
					
				}
				
				break;
				
			
			case 3:
				
				if(playersList.isEmpty()) {
					
					System.out.println("\nNo players have been added yet. Please add players to Start the Game.");
					
				}
				
				else {
					
					Players winner = gameLogic();
					
					System.out.println("\nWinner of the Game :");
					
					System.out.println(winner.toString());
					
				}
				
				break;
			
			default:
				
				System.out.println("\nThank you for participating in the Game.");
			
				break loop1;

			}
		
		}
		
		userInput.close();
		
	}

}