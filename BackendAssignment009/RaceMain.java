package BackendAssignment009;

import java.util.ArrayList;

public class RaceMain {
	
	public static void main(String[] args) {
		
		Player player1 = new Player("Bala",17);
		
		Player player2 = new Player("Thirumalai",18);
		
		Player player3 = new Player("Hari",20);
		
		Player player4 = new Player("Ramanujam",21);
		
		Player player5 = new Player("Ragavan",19);
		
		Race race = new Race("Men's Sprint", 100);
		
		ArrayList<Player> playersList = new ArrayList<>();
		
		playersList.add(player1);
		
		playersList.add(player2);
		
		playersList.add(player3);
		
		playersList.add(player4);
		
		playersList.add(player5);
		
		PlayerThread p1 = new PlayerThread(player1, race);
		
		PlayerThread p2 = new PlayerThread(player2, race);
		
		PlayerThread p3 = new PlayerThread(player3, race);
		
		PlayerThread p4 = new PlayerThread(player4, race);
		
		PlayerThread p5 = new PlayerThread(player5, race);
		
		System.out.println("----- Welcome to Racing Mania -----\nRace is about to begin ...");
		
		try {
			
			Thread.sleep(5000);
		
		} 
		
		catch (InterruptedException e) {
			
			System.out.println(e.getMessage());

		}
		
		System.out.print("Race in progress ...");
		
		p1.start();
		
		p2.start();
		
		p3.start();
		
		p4.start();
		
		p5.start();
		
	}

}