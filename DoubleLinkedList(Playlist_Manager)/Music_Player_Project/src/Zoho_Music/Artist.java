package Zoho_Music;

import java.util.ArrayList;

import Exceptions.IndexOutOfRangeException;

public class Artist extends User{
	
	ArrayList<String> uploadedTracks;
	
	private long followersCount;

	public Artist(String name, String userName, String password, String role) {
		
		super(name, userName, password, role);
		
		this.uploadedTracks = new ArrayList<>();
		
		this.followersCount = 0;
		
	}
	
	public Artist(String name, String userName, String password, String role, ArrayList<String> uploadedTracks,long follwersCount) {
		
		super(name, userName, password, role);
		
		this.uploadedTracks = uploadedTracks;
		
		this.followersCount = follwersCount;
		
	}
	

	public ArrayList<String> getUploadedTracks() {
	
		return uploadedTracks;
	
	}

	public void setUploadedTracks(ArrayList<String> uploadedTracks) {

		this.uploadedTracks = uploadedTracks;
	
	}

	public long getFollowersCount() {

		return followersCount;
	
	}

	public void setFollowersCount(long followersCount) {
	
		this.followersCount = followersCount;
	
	}
	
	
	public void removeSong(String songToRemove) throws IndexOutOfRangeException {
		
		for(int i=0;i<DataManager.availableSongs.size();i++) {
			
			if(DataManager.availableSongs.getAtIndex(i).songName.toLowerCase().equals(songToRemove.toLowerCase()) || DataManager.availableSongs.getAtIndex(i).songName.toLowerCase().contains(songToRemove.toLowerCase())) {
				
				if(this.uploadedTracks.contains(DataManager.availableSongs.getAtIndex(i).songName)) {
				
					System.out.println("----- Song to remove ------ ");
					
					System.out.println(DataManager.availableSongs.getAtIndex(i).toString());
					
					DataManager.availableSongs.remove(i);
					
					System.out.println("\nSong removed successfully.");
					
					return;
				
				}
				
				else {
					
					System.out.println("You haven't uploaded this song. So, you can't remove it.");
					
					return;
					
				}
				
			}
			
		}
		
		System.out.println("Sorry, Could find the given song.");
		
	}

	
	@Override
	public void dashBoard() {

		System.out.println("\n----- Artist Dashboard -----\nWhat would you like to do ?\n(1) => 'Upload' a song.\n(2) => 'Remove' a song.\n(3) => 'Search' a song.\n(4) => 'Play' a random song.\n(5) => 'Play' songs from your uploads.\n(6) => 'View' your uploads.\n(7) => 'Update your Bio'.\n(8) => 'Log out.'");
		
	}

}
