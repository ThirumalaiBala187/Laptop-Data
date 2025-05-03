package Zoho_Music;

import Exceptions.IndexOutOfRangeException;

import java.io.File;

import javax.sound.sampled.*;

import java.util.Scanner;

public abstract class User {
	
	Scanner scanner = new Scanner(System.in);
	
	String name;
	
	String userName;
	
	String password;
	
	String role;
	
	private long pausePosition;
	
	private Clip clip;
	
	private boolean isPlaying;
	
//	DataManager dataManager = new DataManager();

	public User(String name, String userName, String password, String role) {

		this.name = name;
		
		this.userName = userName;
		
		this.password = password;
		
		this.role = role;	
		
		pausePosition = 0;
		
		isPlaying = false;

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
		
		pausePosition = 0;
		
    	if(isPlaying) {
    		
    		System.out.println("Song already playing..");
    		
    		return;
    		
    	}
		
//		double songDuration = song.duration;
//	       
//		int sleepTime = 500;
//
//	    double elapsed = 0.1;
	    
	    try {
	        
	        File audioFile = new File(song.songPath);
	        
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	        
	        clip = AudioSystem.getClip();
	        
	        clip.open(audioStream);
	        
	        clip.setFramePosition((int) pausePosition);
	        
	        clip.start();
	        
	        isPlaying = true;
	        
	        System.out.println("Audio playing.");
	        
	        loop1: while(true) {
	        
		        System.out.println("Press 'P' to 'Pause'/'Play'.\nPress 'S' to 'Stop' this song.");
		        
		        String choice = scanner.nextLine();
		        
		        if(choice.equals("S") || choice.equals("s")) {
		        	
		        	stopSong();
		        	
		        	break loop1;
		        	
		        }
	
		        else if (choice.equals("P") || choice.equals("p")) {
					
		        	if(isPlaying) {
		        		
		        		pauseSong();
		        		
		        		continue;
		        		
		        	}
		        	
		        	else {
		        		
		        		resumeSong();
		        		
		        		continue;
		        		
		        	}
		        	
				}
		        
		        else {
		        	
		        	System.out.println("Invalid option.");
		        	
		        }
	        
	        }
	        
	        if(!clip.isRunning() && clip.getFrameLength() == clip.getFramePosition()) {

	        	System.out.println("Song playback completed!\n");
	        
	        }
			
		} 
		
		catch (Exception e) {
		
			System.out.println("Error : " + e.getMessage());
		
		}
	    
//	    System.out.println("\n----- Currently Playing Song -----");
//	    
//	    System.out.println(song.toString());
//	    
//	    
//
//	    while (elapsed <= songDuration) {
//
//	    	System.out.print("-");
//	    	
//	        try {
//	                
//	        	Thread.sleep(sleepTime);
//	            
//	        }
//	        
//	        catch (InterruptedException e) {
//	        
//	        	e.printStackTrace();
//	            
//	        }
//	        
//	        elapsed = elapsed + 0.1;
//	        
//	    }
		
	}
	
	
	public void resumeSong() {
		
		if(clip != null && !isPlaying) {
			
			clip.setFramePosition((int) pausePosition);
			
			clip.start();
			
			isPlaying = true;
			
			System.out.println("Resuming song.\n");
			
		}
		
	}
	
	
	public void pauseSong() {
		
		if(clip != null && clip.isRunning()) {
			
			pausePosition = clip.getFramePosition();
			
			clip.stop();
			
			isPlaying = false;
			
			System.out.println("Song paused.\n");
			
		}
		
	}
	
	
	public void stopSong() {
	
		if(clip != null && clip.isRunning()) {
			
			clip.stop();
			
			clip.close();
			
			pausePosition = 0;
			
			isPlaying = false;
			
			System.out.println("Song playback stopped.");
			
		}
		
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
