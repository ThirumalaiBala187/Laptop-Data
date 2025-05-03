package Music_Player;

import java.io.File;

// java.desktop

import javax.sound.sampled.*;

import java.util.Scanner;

public class MP3Player {
	
	static private long pausePosition;
	
	static private Clip clip;
	
	static private boolean isPlaying;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		pausePosition = 0;
		
    	if(isPlaying) {
    		
    		System.out.println("Song already playing..");
    		
    		return;
    		
    	}
	    
	    try {		

	        String mp3Path = "/home/thiru-zstk368/Downloads/WhistlePodu.wav";
	        
	        File audioFile = new File(mp3Path);
	        
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
	        
	        clip = AudioSystem.getClip();
	        
	        clip.open(audioStream);
	        
	        clip.setFramePosition((int) pausePosition);
	        
	        clip.start();
	        
	        isPlaying = true;
	        
	        System.out.println("Audio playing.\nSong Name : Whistle Podu");
	        
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
		        		
		        	}
		        	
		        	else {
		        		
		        		resumeSong();
		        		
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
	    
	}
	
	
	static public void resumeSong() {
		
		if(clip != null && !isPlaying) {
			
			clip.setFramePosition((int) pausePosition);
			
			clip.start();
			
			isPlaying = true;
			
			System.out.println("Resuming song.\n");
			
		}
		
	}
	
	
	static public void pauseSong() {
		
		if(clip != null && clip.isRunning()) {
			
			pausePosition = clip.getFramePosition();
			
			clip.stop();
			
			isPlaying = false;
			
			System.out.println("Song paused.\n");
			
		}
		
	}
	
	
	static public void stopSong() {
	
		if(clip != null && clip.isRunning()) {
			
			clip.stop();
			
			clip.close();
			
			pausePosition = 0;
			
			isPlaying = false;
			
			System.out.println("Song playback stopped.");
			
		}
		
	}
	
}
