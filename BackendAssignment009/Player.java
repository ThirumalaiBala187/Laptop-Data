package BackendAssignment009;

public class Player{
	
	String playerName;
	
	int playerAge;

	public Player(String playerName, int playerAge) {
		
		this.playerName = playerName;
		
		this.playerAge = playerAge;			
		
	}
	
	public void setPlayerName(String playerName) {
		
		this.playerName = playerName;
		
	}
	
	public String getPlayerName() {
		
		return playerName;
		
	}
	
	public void setPlayerAge(int playerAge) {
		
		this.playerAge = playerAge;
		
	}
	
	public int getPlayerAge() {
		
		return playerAge;
		
	}
	
	@Override
	public String toString() {
		
		return "----- Winner Details -----\nPlayer Name : " + playerName + "\nAge Category : " + playerAge + "\nRace Name :  " + Race.raceName + "\nRace distance : " + Race.meters + " meters.\nTime Taken : " + PlayerThread.time;
		
	}

}
