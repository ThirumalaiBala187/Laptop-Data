package Zoho_Music;

public class Track {
	
	String songName;

	String artistName;

	String album;
	
	double duration;

	public Track(String songName, String artistName, String album, double duration) {
		
		this.songName = songName;
		
		this.artistName = artistName;
		
		this.album = album;
		
		this.duration = duration;

	}

	public String getSongName() {
	
		return songName;
	
	}

	public void setSongName(String songName) {
	
		this.songName = songName;
	
	}

	public String getArtistName() {
	
		return artistName;
	
	}

	public void setArtistName(String artistName) {
	
		this.artistName = artistName;
	
	}

	public String getAlbum() {
	
		return album;
	
	}

	public void setAlbum(String album) {
	
		this.album = album;
	
	}

	public double getDuration() {
	
		return duration;
	
	}

	public void setDuration(double duration) {
	
		this.duration = duration;
	
	}
	
	
	@Override
	public String toString() {
		
		return "--- Song Details ---\nSong Name : " + songName + "\nComposed By : " + artistName + "\nAlbum Name : " + album + "\nSong Duration : " + duration + "\n";
		
	}
	

}
