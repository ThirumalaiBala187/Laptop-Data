package BackendAssignment009;

public class Race {
	
	static String raceName;
	
	static int meters;
	
	boolean isCompleted = false;
	
	Player winner;

	public Race(String name, int mts) {
		
		raceName = name;
		
		meters = mts;

	}

	public String getRaceName() {
	
		return raceName;
	
	}

	public void setRaceName(String name) {
	
		raceName =name;
	
	}

	public int getKms() {
	
		return meters;
	
	}

	public void setKms(int mts) {
	
		meters = mts;
	
	}
	
	public void setDeclaredWinner(boolean result) {
		
		isCompleted = result;
		
	}
	
	public boolean IsWinnerDeclared() {
		
		return isCompleted;
		
	}
	
	public void setRaceWinner(Player winner) {
		
		this.winner = winner;
		
		System.out.println("\n\n" + winner.playerName + " has won the race.");
		
		isCompleted = true;
		
	}
	
	public Player getWinner() {
		
		return winner;
		
	}

}
