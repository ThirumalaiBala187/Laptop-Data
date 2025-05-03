package Zoho_Music;

import java.util.ArrayList;

import DoubleLinkedList.DoubleLinkedList;

public class Curator extends User{
	
	private ArrayList<String> favouriteArtists;
	
	private ArrayList<DoubleLinkedList<Track>> playlistsUploaded;

	public Curator(String name, String userName, String password, String role, ArrayList<String> favouriteArtists) {
		
		super(name, userName, password, role);
		
		this.favouriteArtists = favouriteArtists;
		
		playlistsUploaded = new ArrayList<>();	
		
	}

	public ArrayList<DoubleLinkedList<Track>> getPlaylistsUploaded() {
	
		return playlistsUploaded;
	
	}

	public void setPlaylistsUploaded(ArrayList<DoubleLinkedList<Track>> playlistsUploaded) {
	
		this.playlistsUploaded = playlistsUploaded;
	
	}

	public ArrayList<String> getFavouriteArtists() {

		return favouriteArtists;
	
	}

	public void setFavouriteArtists(ArrayList<String> favouriteArtists) {

		this.favouriteArtists = favouriteArtists;
	
	}

	
	@Override
	public void dashBoard() {
		
		System.out.println("\n----- Curator Dashboard -----\nWhat would you like to do ?\n(1) => 'Upload' a playlist.\n(2) => 'Remove' your playlists.\n(3) => 'Play' songs from your playlists.\n(4) => 'Play' a random songs.\n(5) => 'View' your uploaded playlists.\n(6) => 'Update your Bio'.\n(7) => 'Exit'");
		
	}

}
