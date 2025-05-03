package Zoho_Music;

import Exceptions.IndexOutOfRangeException;

public abstract class User {
	
	String name;
	
	String userName;
	
	String password;
	
	String role;
	
//	DataManager dataManager = new DataManager();

	public User(String name, String userName, String password, String role) {

		this.name = name;
		
		this.userName = userName;
		
		this.password = password;
		
		this.role = role;		

	}
	

	public String getName() {
	
		return name;
	
	}

	public void setName(String name) {
	
		this.name = name;
	
	}

	public String getUserName() {
	
		return userName;
	
	}

	public void setUserName(String userName) {
	
		this.userName = userName;
	
	}

	public String getPassword() {
	
		return password;
	
	}

	public void setPassword(String password) {
	
		this.password = password;
	
	}

	public String getRole() {
	
		return role;
	
	}

	public void setRole(String role) {
	
		this.role = role;
	
	}
	
	
	public abstract void dashBoard();
	
	
	public Track generateRandomSong() throws IndexOutOfRangeException {
		
		int randomSong = (int) (Math.random() * (65 - 1 + 1)) + 1;
		
		Track selectedSong = DataManager.availableSongs.getAtIndex(randomSong);	
		
//		playSong(selectedSong);
		
		return selectedSong;
		
	}
	
	public void playSong(Track song) {
		
		double songDuration = song.duration;
	       
		int sleepTime = 500;

	    double elapsed = 0.1;
	    
	    System.out.println("\n----- Currently Playing Song -----");
	    
	    System.out.println(song.toString());

	    while (elapsed <= songDuration) {

	    	System.out.print("-");
	    	
	        try {
	                
	        	Thread.sleep(sleepTime);
	            
	        }
	        
	        catch (InterruptedException e) {
	        
	        	e.printStackTrace();
	            
	        }
	        
	        elapsed = elapsed + 0.1;
	        
	    }

        System.out.println("\nSong playback completed!");
		
	}
	
	public Track searchSong(String songName) throws IndexOutOfRangeException {
		
		for(int i=0;i<DataManager.availableSongs.size();i++) {
			
			if(DataManager.availableSongs.getAtIndex(i).songName.toLowerCase().contains(songName.toLowerCase())) {
				
				return DataManager.availableSongs.getAtIndex(i);
				
			}
			
		}
		return null;
		
	}
	
}
