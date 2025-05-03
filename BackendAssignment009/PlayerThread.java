package BackendAssignment009;

import java.time.LocalTime;

import java.time.Duration;

public class PlayerThread extends Thread{

	Player p;
	
	Race race;
	
	static String time;
	
	public PlayerThread(Player p, Race race) {
		
		this.p = p;
		
		this.race = race;
		
	}
	
	public void run() {
		
		int distanceTraveled = 0;
		
		LocalTime startTime = LocalTime.now();
		
		while (!race.isCompleted) {
			
			try {
				
				System.out.print(".");

				Thread.sleep((int)(Math.random() * 500));
				
			} 
			
			catch (Exception e) {
			
				System.out.println("Obstacle in between the race : " + e.getMessage());
				
			}
			
			distanceTraveled += (int) (Math.random() * 10) + 1;
			
			if (distanceTraveled >= Race.meters && !race.isCompleted) {
				
				race.setRaceWinner(p);
				
				Duration timeTaken = Duration.between(startTime, LocalTime.now());	
				
				time = String.format("%02d:%02d:%02d",timeTaken.toMinutes(),timeTaken.toSeconds(),timeTaken.toMillis());
				
				System.out.println(p.toString());
				
			}
			
		}
		
	}

}