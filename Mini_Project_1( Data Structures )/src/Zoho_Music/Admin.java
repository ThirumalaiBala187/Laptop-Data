package Zoho_Music;

import Exceptions.IndexOutOfRangeException;

public class Admin extends User{
	 
	private int usersManaged;
	
	private int resolvedIssues;	

	public Admin(String name, String userName, String password, String role, int usersManaged, int resolvedIssues) {
		
		super(name, userName, password, role);
		
		this.usersManaged = usersManaged;
		
		this.resolvedIssues = resolvedIssues;
		
	}
	
	public int getUsersManaged() {
	
		return usersManaged;
	
	}

	public void setUsersManaged(int usersManaged) {

		this.usersManaged = usersManaged;
	
	}

	public int getResolvedIssues() {
	
		return resolvedIssues;
	
	}
	
	public void setResolvedIssues(int resolvedIssues) {
	
		this.resolvedIssues = resolvedIssues;
	
	}
	
	public void removeSong(String songToRemove) throws IndexOutOfRangeException {
		
		for(int i=0;i<DataManager.availableSongs.size();i++) {
			
			if(DataManager.availableSongs.getAtIndex(i).songName.toLowerCase().equals(songToRemove.toLowerCase()) || DataManager.availableSongs.getAtIndex(i).songName.toLowerCase().contains(songToRemove.toLowerCase())) {
				
				System.out.println("----- Song to remove ------ ");
				
				System.out.println(DataManager.availableSongs.getAtIndex(i).toString());
				
				DataManager.availableSongs.remove(i);
				
				System.out.println("\nSong removed successfully.");
				
				return;
				
			}
			
		}
		
		System.out.println("Sorry, Could find the given song.");
		
	}

	
	@Override
	public void dashBoard() {
		
		System.out.println("\n----- Admin Dashboard -----\nWhat would you like to do ?\n(1)  => 'Check' song count.\n(2)  => 'Check' Artist count.\n(3)  => 'Check' Curator count.\n(4)  => 'Check' Listeners count.\n(5)  => 'Remove' any song.\n(6)  => 'Add' a new 'Artist'.\n(7)  => 'Add' a new 'Curator'.\n(8)  => 'Add' a new 'Admin'.\n(9)  => 'Update' your Bio.\n(10) => 'Log out'.");
		
	}

}
