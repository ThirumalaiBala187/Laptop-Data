package Zoho_Music;

import java.util.ArrayList;

import java.util.Arrays;

import DoubleLinkedList.DoubleLinkedList;

import Exceptions.IndexOutOfRangeException;

public class DataManager {
	
	static DoubleLinkedList<Track> availableSongs;
	
	ArrayList<User> availableUsers = new ArrayList<>();
	
	ArrayList<String> availableArtists = new ArrayList<>();
	
	public DataManager() {

		availableSongs = new DoubleLinkedList<>();
				
		intializeTracks();
		
		initializeUsers();
		
	}
	
	public void name() {
		
	}
	
	
	public DoubleLinkedList<Track> getAvailableSongs() {
		
		return availableSongs;
		
	}	
		
	public ArrayList<User> getAvailableUsers() {
		
		return availableUsers;
		
	}
	
	
	public void printArtists() throws IndexOutOfRangeException {
		
		for(int i=0;i<availableSongs.size();i++) {
			
			if(!(availableArtists.contains(availableSongs.getAtIndex(i).artistName))) {
				
				availableArtists.add(availableSongs.getAtIndex(i).artistName);
				
			}
			
		}
		
		int idx = 1;
		
		for(String artist : availableArtists) {
			
			System.out.println(idx + ". " + artist);
			
			idx++;
			
		}
		
	}
	
	
	private void initializeUsers() {
		
		availableUsers.add(new Admin("Thirumalai","thirumalai@2627","tvl@187","Admin",18,7));
		
		availableUsers.add(new Admin("Bala","bala@187","bala@2627","Admin",8,3));
		
		availableUsers.add(new Artist("Anirudh Ravichaner","ani@music.com","ani@2025","Artist",new ArrayList<String>(Arrays.asList("Badass","Hukum","Ratata","Kanave Kanave","Manasilaayo","Lokiverse","Veera Raghavan","Nee Yaaro Pulla","Fear Song","Chikitu Vibe")),12543));
		
		availableUsers.add(new Artist("Thalapathy Vijay","thalapathy@music.com","vjprince@2026","Artist",new ArrayList<String>(Arrays.asList("Ranjithame","Whistle Podu","Kutti Story","Naa Ready","Verithanam","Papa Papa","Selfie Pulla")),20543));
		
		availableUsers.add(new Artist("Yuvan Shankar Raja","u1@music.com","kingmakeru1@2026","Artist",new ArrayList<String>(Arrays.asList("Matta","Spark","Kutti Story","Nenja kasakki","Enkeyoo Partha","The Real OG","Idhu Varai")),17543));
		
//		availableUsers.add(new Curator("Hariram","hram@2025","hariram@07","Curator",new ArrayList<String>(Arrays.asList("Anirudh Ravichander","Thalapathy Vijay","Harris Jeyaraj"))));
		
//		availableUsers.add(new Curator("Leo Dhas","leodhas@718","badassleom@123","Curator",new ArrayList<String>(Arrays.asList("Yuvan Shankar Raja","A.R.Rahman","Devi Sri Prasad"))));
		
		availableUsers.add(new Listener("Leo Dhas","leodhas@718","parthiban@123","Listener",new ArrayList<String>(Arrays.asList("Thalapathy Vijay","Yuvan Shankar Raja","Anirudh Ravichander"))));
		
		availableUsers.add(new Listener("Jeevan","jeevan@2024","jeevan@5924","Listener",new ArrayList<String>(Arrays.asList("Thalapathy Vijay","D.Imman","Thaman S"))));
		
	}
	
	
	private void intializeTracks() {
		
		availableSongs.add(new Track("Ordinary Person", "Anirudh Ravichander","Leo",2.3,"/home/thiru-zstk368/Downloads/OrdinaryPerson.wav"));
		
		availableSongs.add(new Track("Whistle Podu", "Thalapathy Vijay","The Greatest Of All Time",5.1,"/home/thiru-zstk368/Downloads/WhistlePodu.wav"));
		
		availableSongs.add(new Track("Matta", "Yuvan Shankar Raja","The Greatest Of All Time",3.7,"/home/thiru-zstk368/Downloads/Matta.wav"));
		
		availableSongs.add(new Track("Ratata", "Anirudh Ravichander","Leo",2.1,"/home/thiru-zstk368/Downloads/Ratata.wav"));
		
		availableSongs.add(new Track("Arabic Kuthu", "Anirudh Ravichander","Beast",4.2,"/home/thiru-zstk368/Downloads/ArabicKuthu.wav"));
		
		availableSongs.add(new Track("Beast Mode", "Anirudh Ravichander","Beast",3.2));
		
		availableSongs.add(new Track("Katchi Sera", "Sai Abhyankkar","Think Indie",3.5));
		
		availableSongs.add(new Track("Beer Song", "Gana Guna","Diesel",4.3));

		availableSongs.add(new Track("Vaane Vaane", "Hariharan","Amaran",4.9));
		
		availableSongs.add(new Track("Anbenum (From Leo)", "Anirudh Ravichander","Leo",3.8));
		
		availableSongs.add(new Track("Sawadeeka", "Anirudh Ravichander","Vidaamuyarchi",4.9));
		
		availableSongs.add(new Track("Peelings", "Devi Sri Prasad","Pushpa 2 The Rule",4.3));
		
		availableSongs.add(new Track("Kanave Kanave", "Anirudh Ravichander","David",4.3));
		
		availableSongs.add(new Track("Makkamishi", "Harris Jeyaraj","Brother",4.1));
		
		availableSongs.add(new Track("Manasilaayo", "Anirudh Ravichander","Vettayan",4.5));

		availableSongs.add(new Track("Golden Sparrow", "G.V.Prakash","Nilavuku En Mel Ennadi Kobam",3.5));

		availableSongs.add(new Track("Lokiverse", "Anirudh Ravichander","Leo",2.5));
		
		availableSongs.add(new Track("Badass", "Anirudh Ravichander","Leo",3.4));
		
		availableSongs.add(new Track("Top Tucker", "Mohit Chauhan","Sarkar",3.3));
		
		availableSongs.add(new Track("Veera Raghavan", "Anirudh Ravichander","Leo",4));

		availableSongs.add(new Track("Seemaraja Swag", "D.Imman","Seemaraja",4));
		
		availableSongs.add(new Track("Hey Minnale", "G.V.Prakash","Amaran",3.4));
		
		availableSongs.add(new Track("Maduraikku Pogathadee", "Benny Dayal","Azhagiya Tamilmagan",5.2));
		
		availableSongs.add(new Track("Madura Palapalakkuthu", "Nivas K. Prasanna","Devarattam",7.3));
		
		availableSongs.add(new Track("Madura Kulunga", "Velmurugan","Subramaniapuram",6.4));

		availableSongs.add(new Track("Kattu Kattu", "Manikka Vinayagam","Tirupatchi",5.1));
		
		availableSongs.add(new Track("Senjitaley", "Anirudh Ravichander","Remo",4.2));
		
		availableSongs.add(new Track("Pidichiruka Illa Pudikalaya", "Hiphop Tamizha","Kalkalappu 2",4.7));
		
		availableSongs.add(new Track("Ava Enna", "Harris Jeyaraj","Varanam Ayiram",4.3));

		availableSongs.add(new Track("Mangalyam", "Thaman S","Eeswaran",4.1));
		
		availableSongs.add(new Track("I'm Scared", "Anirudh Ravichander","Leo",2.1));
		
		availableSongs.add(new Track("Illuminati", "Sushin Shyam","Aavesham",3.3));
		
		availableSongs.add(new Track("Kurchi Madathapetti", "Thaman S","Guntur Kaaram",3.1));

		availableSongs.add(new Track("Believer", "Imagine Dragins","Evolve",3.2));
		
		availableSongs.add(new Track("Takkaru Takkaru", "Hiphop Tamizha","Album",3.7));
		
		availableSongs.add(new Track("Ponni Nadhi", "A.R.Rahman","Ponniyin Selvan",4.5));

		availableSongs.add(new Track("Vandha Edam", "Anirudh Ravichander","Jawan",4.1));

		availableSongs.add(new Track("Vaa Thalaivaa", "Thaman S","Varisu",3.4));
		
		availableSongs.add(new Track("Thee Thalapathy", "Thaman S","Varisu",3.7));
		
		availableSongs.add(new Track("Jimikku Ponnu", "Thaman S","Varisu",4.1));
		
		availableSongs.add(new Track("Ranjithame", "Thalapathy Vijay","Varisu",4.3));
		
		availableSongs.add(new Track("Pakkam Vanthu", "Anirudh Ravichander","Kaththi",3.3));
		
		availableSongs.add(new Track("Aathi", "Anirudh Ravichander","Kaththi",4.5));

		availableSongs.add(new Track("Nee Yaaro", "Anirudh Ravichander","Kaththi",5.2));
		
		availableSongs.add(new Track("Selfie Pulla", "Thalapathy Vijay","Kaththi",4.1));
		
		availableSongs.add(new Track("Chuttamalle", "Shilpa Rao","Devara Part-1",3.4));

		availableSongs.add(new Track("Bloody Sweet", "Anirudh Ravichander","Leo",2.7));

		availableSongs.add(new Track("Naa Ready", "Thalapathy Vijay","Leo",4.8));
		
		availableSongs.add(new Track("Maamadura", "Santhosh Narayanan","Jigarthanda DoubleX",2.1));
				
		availableSongs.add(new Track("Paadhavathi", "Santhosh Narayanan","Vaazhai",5.5));

		availableSongs.add(new Track("Arjunar Villu", "Sukhwinder Singh","Ghilli",4.2));
		
		availableSongs.add(new Track("Kokkorakko", "Udit Narayanan","Ghilli",4.3));
	
		availableSongs.add(new Track("Kutti Story", "Thalapathy Vijay","Master",5.0));
		
		availableSongs.add(new Track("Vaathi Coming", "Anirudh Ravichander","Master",4.7));
		
		availableSongs.add(new Track("Fear Song", "Anirudh Ravichander","Devara Part-1",3.1));
			
		availableSongs.add(new Track("Pushpa Pushpa", "Devi Sri Prasad","Pushpa 2 The Rule",4.1));
		
		availableSongs.add(new Track("Ma Ma Mahesha", "Thaman S","Sarkaru Vaari Paata",4.0));
	
		availableSongs.add(new Track("Kalaavathi", "Sid Sriram","Sarkaru Vaari Paata",4.2));
		
		availableSongs.add(new Track("Seval Kodi", "Yuvan Shankar Raja","Billa",4.5));
		
		availableSongs.add(new Track("Manike", "Yohani","Thank God",3.1));	

		availableSongs.add(new Track("Hukum", "Anirudh Ravichander","Jailer",4.9));
		
		availableSongs.add(new Track("Kaavaalaa", "Anirudh Ravichander","Jailer",4.1));
	
		availableSongs.add(new Track("Rathamaarey", "Anirudh Ravichander","Jailer",3.4));
		
		availableSongs.add(new Track("Aalaporaan Thamizhan", "A.R.Rahman","Mersal",4.9));
		
		availableSongs.add(new Track("Maacho", "A.R.Rahman","Mersal",3.8));
			
		availableSongs.add(new Track("Neethanae", "A.R.Rahman","Mersal",3.9));		
		
		availableSongs.add(new Track("Verithanam", "Thalapathy Vijay","Bigil",4.2));
	
		availableSongs.add(new Track("Unakaga", "A.R.Rahman","Bigil",4.1));
		
		availableSongs.add(new Track("Kaalame", "A.R.Rahman","Bigil",3.8));
		
		availableSongs.add(new Track("Porkanda Singam", "Anirudh Ravichander","Vikram",3.1));	
		
		availableSongs.add(new Track("Paiya Dei", "Asal Kolaar","Think Indie",4.9));
		
		availableSongs.add(new Track("K for Kabaradakkam", "Asal Kolaar","Guruvayoor Ambalanadayil",3.1));

		availableSongs.add(new Track("Chikitu Vibe", "Anirudh Ravichander","Coolie",2.4));
		
		availableSongs.add(new Track("Machi Open the Bottle", "Yuvan Shankar Raja","Mankatha",4.9));

		availableSongs.add(new Track("Sathiyama", "Mugen Rao","Love Album",3.9));
			
		availableSongs.add(new Track("Azhage", "Thenuja","Love Album",4.3));
		
		availableSongs.add(new Track("Quit Pannuda", "Anirudh Ravichander","Master",4.5));
	
		availableSongs.add(new Track("VIP Title Song", "Anirudh Ravichander","Velai Illa Pattathari",4.2));
		
		availableSongs.add(new Track("Udhungada Sangu", "Anirudh Ravichander","BVelai Illa Pattathariigil",3.9));
		
		availableSongs.add(new Track("Maari Thara Local", "Anirudh Ravichander","Maari",3.1));	
		
		availableSongs.add(new Track("Nillayo", "Haricharan","Bhairavaa",4.1));
		
		availableSongs.add(new Track("Papa Papa", "Thalapathy Vijay","Bhairavaa",3.1));

		availableSongs.add(new Track("Spark", "Yuvan Shankar Raja","The Greatest Of All Time",3.7));	
		
		availableSongs.add(new Track("Enkeyoo Partha", "Yuvan Shankar Raja","Yaaradi Nee Mohini",3.9));

		availableSongs.add(new Track("Oh Baby", "Yuvan Shankar Raja","Yaaradi Nee Mohini",4.1));
			
		availableSongs.add(new Track("Nenjai Kasakki", "Yuvan Shankar Raja","Yaaradi Nee Mohini",5.3));
		
		availableSongs.add(new Track("Venmegam", "Yuvan Shankar Raja","Yaaradi Nee Mohini",4.5));			
	
		availableSongs.add(new Track("Adada Mazhaida", "Yuvan Shankar Raja","Paiya",4.2));
		
		availableSongs.add(new Track("Yedho Ondru Ennai", "Yuvan Shankar Raja","Paiya",3.7));
		
		availableSongs.add(new Track("Idhu Varai", "Yuvan Shankar Raja","Yaaradi Nee Mohini",3.5));

		availableSongs.add(new Track("Metro Madness", "Yuvan Shankar Raja","The Greatest Of All Time",2.3));

		availableSongs.add(new Track("The Real OG", "Yuvan Shankar Raja","The Greatest Of All Time",2.8));		
		
		availableSongs.add(new Track("Dilli Swag", "Sam C.S.","Kaithi",1.1));
		
		availableSongs.add(new Track("Night is Dark", "Sam C.S.","Kaithi",1.5));

		availableSongs.add(new Track("Mehabooba", "Ananya Bhat","KGF Chapter 2",4.1));
			
		availableSongs.add(new Track("The Monster", "Ravi Basrur","KGF Chapter 2",3.3));
		
		availableSongs.add(new Track("Kaadhal Kaditham", "Unni Menon","Jodi",4.5));			
	
		availableSongs.add(new Track("Sulthana", "Mohan Krishna","KGF Chapter 2",3.4));
		
		availableSongs.add(new Track("Kaadhal Kan Kattudhe", "Anirudh Ravichander","Kaaki Sattai",4.1));
		
		availableSongs.add(new Track("Ethir Neechal", "Yo Yo Honey Singh","Ethir Neechal",4.3));			
		
	}
	
	

}
