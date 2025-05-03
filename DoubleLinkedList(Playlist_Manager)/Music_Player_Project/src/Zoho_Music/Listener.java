package Zoho_Music;

import java.util.ArrayList;

import java.util.HashMap;

import DoubleLinkedList.DoubleLinkedList;

public class Listener extends User{
	
	ArrayList<String> favouriteArtists;
	
	HashMap<String, DoubleLinkedList<Track>> playlistsCreated;
	
	DoubleLinkedList<Track> likedSongs;
	
	DoubleLinkedList<Track> recentlyPlayed;

	public Listener(String name, String userName, String password, String role, ArrayList<String> favouriteArtists) {
		
		super(name, userName, password, role);
		
		this.favouriteArtists = favouriteArtists;	
		
		this.playlistsCreated = new HashMap<>();
		
		this.likedSongs = new DoubleLinkedList<Track>();
		
		this.recentlyPlayed = new DoubleLinkedList<>();
		
	}

	
	public ArrayList<String>  getFavouriteArtists() {
		
		return favouriteArtists;
	
	}

	public void setFavouriteArtists(ArrayList<String> favouriteArtists) {
	
		this.favouriteArtists = favouriteArtists;
	
	}

	public HashMap<String, DoubleLinkedList<Track>> getPlaylistsCreated() {
	
		return playlistsCreated;
	
	}

	public void setPlaylistsCreated(HashMap<String, DoubleLinkedList<Track>> playlistsCreated) {

		this.playlistsCreated = playlistsCreated;
	
	}
	
	public DoubleLinkedList<Track> getLikedSongs() {
	
		return likedSongs;
	
	}

	public void setLikedSongs(DoubleLinkedList<Track> likedSongs) {
	
		this.likedSongs = likedSongs;
	
	}

	public DoubleLinkedList<Track> getRecentlyPlayed() {

		return recentlyPlayed;
	
	}

	public void setRecentlyPlayed(DoubleLinkedList<Track> recentlyPlayed) {

		this.recentlyPlayed = recentlyPlayed;
	
	}
	
	
	public void deletePlaylist(String playlistName) {
		
		for(String key : playlistsCreated.keySet()) {
			
			if(key.toLowerCase().equals(playlistName.toLowerCase()) || key.toLowerCase().contains(playlistName.toLowerCase())) {
				
				System.out.println("----- Playlist details -----\nPlaylist created by : " + name + "\nNo.of songs : " + playlistsCreated.get(key).size() + "");
				
				playlistsCreated.remove(key);
				
				System.out.println("Playlist " + key + " deleted successfully.");
				
				return;
				
			}
			
		}
		
		System.out.println("Could find the playlist. Please Enter the correct playlist name.");
		
	}


	@Override
	public void dashBoard() {		

//		System.out.println("\n----- Listener Dashboard -----\nWhat would you like to do ?\n(1) => 'Create' a new playlist.\n(2) => 'Delete' a playlist.\n(3) => 'Search' a song.\n(4) => 'Play' a random song.\n(5) => 'Play' songs from your playlist.\n(6) => 'Play' songs from your favourites.\n(7) => 'Update your Profile'.\n(8) => 'Log out'.");
		
		System.out.println("\n----- Listener Dashboard -----\nWhat would you like to do ?\n(1) => 'Song' options.\n(2) => 'Playlist' options.\n(3) => 'Settings'.\n(4) => 'Log out.'");
		
	}

}
