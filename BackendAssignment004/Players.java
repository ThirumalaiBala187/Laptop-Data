package BackendAssignment004;

public class Players {
	
	String playerName;

	public Players(String playerName) {

		this.playerName = playerName;
		
	}
	
	public void setName(String playerName) {
		
		this.playerName = playerName;
		
	}
	
	public String getName() {
		
		return this.playerName;
		
	}
	
	@Override
	 public String toString() {
		
		return "----- Player-Details -----" + "\nPlayer_Name : " + this.playerName + "\n";
		
	}

}