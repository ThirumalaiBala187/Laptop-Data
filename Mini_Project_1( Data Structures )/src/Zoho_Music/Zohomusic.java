package Zoho_Music;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.Scanner;

import DoubleLinkedList.DoubleLinkedList;

import Exceptions.IndexOutOfRangeException;

public class Zohomusic {
	
	static int optionSelected;
	
	static Scanner userInput = new Scanner(System.in);		
	
	static LoginSystem loginSystem = new LoginSystem();
	
	static DataManager dataManager = new DataManager();
	
	static boolean loopBreaker = false;

	public Zohomusic() {
		
	}

	public static void main(String[] args) throws IndexOutOfRangeException {
		
		System.out.println("---------- Zoho Music ----------\nHello Buddy 👋🏻!\nWhat do you want to do 🤔 ?");
		
		loop1 : while(true) {
		
			System.out.println("Press '1' to 'Login 🔑'.\nPress '2' to 'Sign Up 🔒'.\nPress '3' to 'Exit 🏃'.");
			
			optionSelected = userInput.nextInt();
			
			switch (optionSelected){
			
			case 1: {
				
				userInput.nextLine();
				
				System.out.println("Please Enter your user name :");
				
				String userName = userInput.nextLine();
				
				System.out.println("Please Enter your password :");
				
				String password = userInput.nextLine();
				
				User loginedUser = loginSystem.login(userName, password);
				
				if(loginedUser != null) {
					
					if(loginedUser instanceof Listener) {
						
						listenerOptions(loginedUser);
						
					}
					
					else if(loginedUser instanceof Artist) {
						
						artistOptions((Artist) loginedUser);
						
					}
					
					else if(loginedUser instanceof Admin) {
						
						adminOptions((Admin) loginedUser);
						
					}
					
					else if (loginedUser instanceof Curator) {
						
						curatorOptions((Curator) loginedUser);
						
					}
					
				}
				
				else{
					
					System.out.println("Incorrect Username or Password. Please Enter valid credentials to Login.\n");
					
				}
				
				break;
								
			}
			
			case 2: {
				
				userInput.nextLine();
				
				System.out.println("Please Enter your name :");
				
				String name =  userInput.nextLine();
				
				System.out.println("Please Enter your user name :");
				
				String userName = userInput.nextLine();
				
				System.out.println("Please Enter your password :");
				
				String password = userInput.nextLine();
				
				System.out.println("Please confirm your password :");
				
				String confirmPassword = userInput.nextLine();
				
				loop2 : while(true) {
					
					if(password.equals(confirmPassword)) {
						
						break loop2;
						
					}
					
					System.out.println("Please Enter the correct password to confirm :");
					
					confirmPassword = userInput.nextLine();
					
				}
				
				System.out.println("Select your role :\nPress '1' for 'Listener.\nPress '2' for 'Artist'.");
				
				int choice = userInput.nextInt();
				
				String role = (choice == 1) ? "Listener" : (choice == 2) ? "Artist" : "Curator";
				
				System.out.println(role);
				
				System.out.println("\nPlease select any three artists you love :");
				
				ArrayList<String> favouriteArtists = new ArrayList<>();
				
				dataManager.printArtists();	
				
				for(int i=1;i<=3;i++) {				
					
					System.out.println("\nSelect your favourite Artist no. " + i);
					
					int artistNo = userInput.nextInt();
					
					if(favouriteArtists.contains(dataManager.availableArtists.get(artistNo-1))) {
						
						System.out.println("You have already selected this artist. Please select any other.");
						
						i--;
						
						continue;
						
					}
					
					favouriteArtists.add(dataManager.availableArtists.get(artistNo-1));
					
					System.out.println("Artist " + i + ": " + dataManager.availableArtists.get(artistNo-1));
					
				}
				
				if(role.equals("Listener")) {
				
					Listener newListener = new Listener(name, userName, password, role, favouriteArtists);
					
					dataManager.availableUsers.add(newListener);
					
					listenerOptions(newListener);
					
				}
				
				else if(role.equals("Artist")) {
					
					Artist newArtist = new Artist(name, userName, password, role);
					
					dataManager.availableUsers.add(newArtist);
					
					artistOptions(newArtist);
					
				}
				
				else if(role.equals("Curator")) {
					
					Curator newCurator = new Curator(name, userName, password, role, favouriteArtists);
					
					dataManager.availableUsers.add(newCurator);
					
					curatorOptions(newCurator);
					
				}
				
				break;
				
			}
			
			case 3: {
				
				System.out.println("Thank you for visiting Zoho Music. Bye! 👋🏻.");
				
				break loop1;
				
			}
			
			default:
				
				System.out.println("Please Enter a valid option !");
			
			}
			
		}
		
		userInput.close();
		
	}
	
	
	
	
	
//	
//	public static void listenerOptions(Listener listener) throws IndexOutOfRangeException {
//		
//		loop3 : while (true) {
//		
//			listener.dashBoard();
//			
//			int choice = userInput.nextInt();
//			
//			if(choice == 1) {
//				
//				userInput.nextLine();
//				
//				System.out.println("Enter the playlist name :");
//				
//				String newPlaylist = userInput.nextLine();
//				
//				listener.playlistsCreated.put(newPlaylist, new DoubleLinkedList<Track>());
//				
//				System.out.println("New playlist " + newPlaylist + " has been created Successfully.");
//				
//			}
//			
//			else if(choice == 2) {
//				
//				if(listener.playlistsCreated.size() < 1) {
//					
//					System.out.println("You haven't created any playlists. So, you can't delete anything.");
//					
//				}
//				
//				else {
//					
//					userInput.nextLine();
//				
//					System.out.println("Enter the playlist name you want to delete :");
//					
//					String playlistToRemove = userInput.nextLine();
//					
//					System.out.println("Are you sure you want to remove the playlist.\nPress 'Y' to delete.\nPress 'N' to cancel.");
//					
//					String ch = userInput.next();
//					
//					if(ch.equals("Y") || ch.equals("y")) {
//						
//						listener.deletePlaylist(playlistToRemove);
//						
//					}
//					
//					else {
//						
//						System.out.println("Playlist deletion cancelled ....");
//						
//						continue loop3;
//						
//					}
//				
//				}
//			}
//			
//			else if (choice == 3) {
//				
//				
//				
//				
//			}
//			
//			else if(choice == 4) {
//				
//				
//			
//			}
//			
//			else if (choice  == 5) {
//				
//				
//				
//			}
//			
//			else if (choice  == 6) {
//				
//				if(listener.likedSongs.size() < 1) {
//					
//					System.out.println("You haven't liked any songs.");
//					
//				}
//				
//				else {
//				
//					for(int i=0;i<listener.likedSongs.size();i++) {
//						
//						String songToSearch = listener.likedSongs.getAtIndex(i).songName;
//						
//						Track songTrack = listener.searchSong(songToSearch);
//						
//						listener.playSong(songTrack);
//						
//						if(i == listener.likedSongs.size()-1) {
//							
//							System.out.println("All songs from you favourites has been played...");
//							
//							System.out.println("\nDo you want to play again.\nPress 'Y' to 'Repeat' your uploads.\nPress 'N' to 'Stop' playing.");
//							
//							String play = userInput.next();
//							
//							if(play.equals("Y") || play.equals("y")) {
//								
//								System.out.println("Repeating your favourites again...");
//								
//								i=0;
//								
//								continue;
//								
//							}
//							
//							else {
//								
//								System.out.println("Exitting....\n");
//								
//								break;
//								
//							}
//							
//						}
//						
//						System.out.println("\nDo you want to continue playing the songs.\nPress 'Y' to 'Continue' playing.\nPress 'N' to 'Stop' playing.");
//						
//						String ch = userInput.next();
//						
//						if(ch.equals("Y") || ch.equals("y")) {
//							
//							System.out.println("Playing next song...");
//							
//							continue;
//							
//						}
//						
//						else {
//							
//							System.out.println("Exitting....\n");
//							
//							break;
//							
//						}
//						
//					}
//					
//				}
//				
//			}
//			
//			else if (choice == 7) {
//				
//				updateBio(listener);
//				
//			}
//			
//			else if (choice == 8) {
//				
//				System.out.println("Logging out...\n");
//				
//				break loop3;
//				
//			}
//			
//		}
//		
//	}
//	
//	
//
	
	
	
	
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
		
	
	public static void artistOptions(Artist artist) throws IndexOutOfRangeException {
		
		loop5: while (true) {
			
			artist.dashBoard();
			
			int choice = userInput.nextInt();
			
			if (choice == 1) {
				
				userInput.nextLine();
				
				System.out.println("Enter the song name : ");
								
				String songName = userInput.nextLine();

				String artistName = artist.name;
				
				System.out.println("Enter the album name : ");

				String album = userInput.nextLine();
				
				System.out.println("Enter the duration of the song in this format (mins.secs");
				
				double duration = userInput.nextDouble();
				
				Track newSong = new Track(songName, artistName, album, duration);
				
				DataManager.availableSongs.addFirst(newSong);
				
				artist.uploadedTracks.add(newSong.songName);
				
				System.out.println("New song " + songName + " has been uploaded successsfully.");
				
			}
			
			else if (choice == 2) {
				
				userInput.nextLine();
				
				System.out.println("Enter the song name to remove it :");
				
				String songName = userInput.nextLine();
				
				System.out.println("Are you sure you want to remove this song !\nPress 'Y' to 'remove'.\nPress 'N' to 'cancel'.");
				
				String willing = userInput.nextLine();
				
				if(willing.equals("Y") || willing.equals("y")) {
					
					artist.removeSong(songName);					
					
				}
				
				else {
					
					System.out.println("Song removal cancelled...");
					
				}	
				
			}
			
			else if (choice == 3) {
				
				
				
			}
			
			else if (choice == 4){
				
				loop9:  while(true) {
				
					Track song = artist.generateRandomSong();
					
					artist.playSong(song);	
					
					System.out.println("\nDo you want to continue playing the songs.\nPress 'Y' to 'Continue' playing.\nPress 'N' to 'Stop' playing.");
					
					String ch = userInput.next();
					
					if(ch.equals("Y") || ch.equals("y")) {
						
						System.out.println("Playing next song...");
						
						continue loop9;
						
					}
					
					else {
						
						System.out.println("Exitting....\n");
						
						break loop9 ;
						
					}
				
				}
				
			}
			
			else if(choice == 5) {
				
				for(int i=0;i<artist.uploadedTracks.size();i++) {
					
					String songToSearch = artist.uploadedTracks.get(i);
					
					Track songTrack = artist.searchSong(songToSearch);
					
					artist.playSong(songTrack);
					
					if(i == artist.uploadedTracks.size()-1) {
						
						System.out.println("All songs from you uploads has been played...");
						
						System.out.println("\nDo you want to play again.\nPress 'Y' to 'Repeat' your uploads.\nPress 'N' to 'Stop' playing.");
						
						String play = userInput.next();
						
						if(play.equals("Y") || play.equals("y")) {
							
							System.out.println("Repeating your uploads again...");
							
							i=0;
							
							continue;
							
						}
						
						else {
							
							System.out.println("Exitting....\n");
							
							break;
							
						}
						
					}
					
					System.out.println("\nDo you want to continue playing the songs.\nPress 'Y' to 'Continue' playing.\nPress 'N' to 'Stop' playing.");
					
					String ch = userInput.next();
					
					if(ch.equals("Y") || ch.equals("y")) {
						
						System.out.println("Playing next song...");
						
						continue;
						
					}
					
					else {
						
						System.out.println("Exitting....\n");
						
						break;
						
					}
					
				}
				
			}
			
			else if (choice == 6) {
				
				System.out.println("------ Your uploads ------");
				
				for(int i=0;i<artist.uploadedTracks.size();i++) {
					
					String songToSearch = artist.uploadedTracks.get(i);
					
					Track songTrack = artist.searchSong(songToSearch);
					
					System.out.println("\n" + songTrack.toString() + "\n--------------------------------------------------");
					
				}
				
			}
			
			else if (choice == 7) {
				
				updateBio(artist);
				
			}
			
			else if(choice == 8) {
				
				System.out.println("Logging out .....\n");
				
				break loop5;
				
			}
			
		}
		
	}
	
	
	
	
	
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
	
	
	public static void adminOptions(Admin admin) throws IndexOutOfRangeException {
		
		loop4 : while (true) {
			
			admin.dashBoard();
			
			int choice = userInput.nextInt();
			
			if(choice == 1) {
				
				System.out.println("----- Songs Count -----\nNo of songs uploaded in our application : " + DataManager.availableSongs.size());
				
			}
			
			else if(choice == 2) {
				
				int count = 0;
				
				for(User users : dataManager.availableUsers) {
					
					if(users instanceof Artist) {
						
						count++;
						
					}
					
				}
				
				System.out.println("----- Artists Count -----\nNo of artists registered in our application : " + count);
				
			}
			
			else if(choice == 3) {
				
				int count = 0;
				
				for(User users : dataManager.availableUsers) {
					
					if(users instanceof Curator) {
						
						count++;
						
					}
					
				}
				
				System.out.println("----- Curators Count -----\nNo of Curators registered in our application : " + count);
				
			}
			
			else if(choice == 4) {
				
				int count = 0;
				
				for(User users : dataManager.availableUsers) {
					
					if(users instanceof Listener) {
						
						count++;
						
					}
					
				}
				
				System.out.println("----- Curators Count -----\nNo of Listeners using in our application : " + count);
				
			}
			
			else if (choice == 5) {
				
				userInput.nextLine();
				
				System.out.println("Enter the song name to remove it :");
				
				String songName = userInput.nextLine();
				
				System.out.println("Are you sure you want to remove this song !\nPress 'Y' to 'remove'.\nPress 'N' to 'cancel'.");
				
				String willing = userInput.nextLine();
				
				if(willing.equals("Y") || willing.equals("y")) {
					
					admin.removeSong(songName);					
					
				}
				
				else {
					
					System.out.println("Song removal cancelled...");
					
				}					
				
			}
			
			else if(choice == 6) {
				
				userInput.nextLine();
				
				System.out.println("Please Enter the new artist name :");
				
				String name =  userInput.nextLine();
				
				System.out.println("Please Enter the new artist user name :");
				
				String userName = userInput.nextLine();
				
				System.out.println("Please Enter the password :");
				
				String password = userInput.nextLine();
				
				System.out.println("Please confirm the password :");
				
				String confirmPassword = userInput.nextLine();
				
				loop2 : while(true) {
					
					if(password.equals(confirmPassword)) {
						
						break loop2;
						
					}
					
					System.out.println("Please Enter the correct password to confirm :");
					
					confirmPassword = userInput.nextLine();
					
				}
				
				Artist newArtist = new Artist(name, userName, password, "Artist");
				
				dataManager.availableUsers.add(newArtist);
				
			}
			
			else if(choice == 7) {
				
				userInput.nextLine();
				
				System.out.println("Please Enter the new Curator name :");
				
				String name =  userInput.nextLine();
				
				System.out.println("Please Enter the user name :");
				
				String userName = userInput.nextLine();
				
				System.out.println("Please Enter the password :");
				
				String password = userInput.nextLine();
				
				System.out.println("Please confirm the password :");
				
				String confirmPassword = userInput.nextLine();
				
				loop2 : while(true) {
					
					if(password.equals(confirmPassword)) {
						
						break loop2;
						
					}
					
					System.out.println("Please Enter the correct password to confirm :");
					
					confirmPassword = userInput.nextLine();
					
				}
				
				System.out.println("\nPlease select any three artists you love :");
				
				ArrayList<String> favouriteArtists = new ArrayList<>();
				
				dataManager.printArtists();	
				
				for(int i=1;i<=3;i++) {				
					
					System.out.println("\nSelect your favourite Artist no. " + i);
					
					int artistNo = userInput.nextInt();
					
					if(favouriteArtists.contains(dataManager.availableArtists.get(artistNo-1))) {
						
						System.out.println("You have already chosed this artist. Please select any other.");
						
						i--;
						
						continue;
						
					}
					
					favouriteArtists.add(dataManager.availableArtists.get(artistNo-1));
					
					System.out.println("Artist " + i + ": " + dataManager.availableArtists.get(artistNo-1));
					
				}
				
				Curator newCurator = new Curator(name, userName, password, "Curator",favouriteArtists);
				
				dataManager.availableUsers.add(newCurator);
				
			}
			
			else  if(choice == 8) {
				
				userInput.nextLine();
				
				System.out.println("Please Enter the new Admin name :");
				
				String name =  userInput.nextLine();
				
				System.out.println("Please Enter the user name :");
				
				String userName = userInput.nextLine();
				
				System.out.println("Please Enter the password :");
				
				String password = userInput.nextLine();
				
				System.out.println("Please confirm the password :");
				
				String confirmPassword = userInput.nextLine();
				
				loop2 : while(true) {
					
					if(password.equals(confirmPassword)) {
						
						break loop2;
						
					}
					
					System.out.println("Please Enter the correct password to confirm :");
					
					confirmPassword = userInput.nextLine();
					
				}
				
				Admin newAdmin = new Admin(name, userName, password, "Admin",0,0);
				
				dataManager.availableUsers.add(newAdmin);	
				
			}
			
			else if (choice == 9) {
				
				updateBio(admin);
				
			}
			
			else if (choice == 10) {
				
				System.out.println("Logging out .....\n");
				
				break loop4;
				
			}
		
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //

	
	public static void curatorOptions(Curator curator) {
		
		curator.dashBoard();
		
	}
	
	

	
	
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //

	
	public static void updateBio(User user) {
		
		loop7 : while (true){
		
			System.out.println("What do you want to update?\nPress '1' to update your 'Name'.\nPress '2' to update your 'Username'.\nPress '3' to change your 'Password'.\nPress '4' to 'Exit'");
			
			int choice = userInput.nextInt();
			
			if(user != null) {
			
				if(choice == 1) {
					
					userInput.nextLine();
					
					System.out.println("Enter your new name to update :");
					
					String newName = userInput.nextLine();
					
					user.setName(newName);
					
					System.out.println("Your name has been updated successfully!");
					
				}
				
				else if(choice == 2) {
					
					userInput.nextLine();
					
					System.out.println("Enter your new user name :");
					
					String newUserName = userInput.nextLine();
					
					user.setUserName(newUserName);
					
					System.out.println("Your username has been updated successfully!");
					
				}
				
				else if (choice == 3) {
					
					userInput.nextLine();
					
					for(int i=1;i<=3;i++) {
					
						System.out.println("Enter the old password to confirm :");
						
						String oldPassword = userInput.nextLine();
						
						if(user.password.equals(oldPassword)) {
							
							System.out.println("Enter the new password :");
							
							String newPassword = userInput.nextLine();
							
							System.out.println("Your password has been updated successfully!");
							
							user.setPassword(newPassword);
							
							return;
							
						}
						
						else {
							
							System.out.println("Incorrect old password...Please Try again!\n");
							
						}
					
					}
					
					System.out.println("Maximum attempt to change password reached.\n");
					
					continue loop7;
					
				}
				
				else if(choice == 4) {
					
					System.out.println("Exitting .....");
					
					break loop7;
					
				}
				
				else {
					
					System.out.println("Please Enter a valid choice.");
					
				}
				
				System.out.println("\nDo you want to update any other details.\nPress 'Y' to 'Continue'.\nPress 'N' to 'Exit'");
				
				String chosen = userInput.next();
				
				if(chosen.equals("Y")|| chosen.equals("y")) {
					
					continue loop7;
					
				}
				
				else {
					
					System.out.println("Exitting.....");
					
					break loop7;
					
				}
				
			}
		
		}
		
	}
	

	
	
	
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
	
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //
	
	
public static void listenerOptions(User user) throws IndexOutOfRangeException {
	
	Listener listener = (Listener) user;
	
		loop1: while (true) {
			
			listener.dashBoard();
			
			int input = userInput.nextInt();
			
			if (input == 4) {
				
				System.out.println("Logging Out .....\n");
				
				break loop1;
				
			}
			
			else if (input == 1) {
				
				loop2: while (true) {
					
					System.out.println("Select an option :\nPress '1' to 'Search' a song.\nPress '2' to 'Play' a 'Random' song.\nPress '3' to 'Play' your 'Recent' songs.\nPress '4' to 'Play' song from your 'Favourites'.\nPress '5' to 'Play' song from 'Playlist'.\nPress '6' to 'Play' your favourite 'Artist's' Tracks.\nPress '7' to 'Exit'.");
					
					int input1 = userInput.nextInt();
					
					if(input1 == 7) {
						
						System.out.println("Exitting to Main menu .....");
						
						break loop2;
										
					}
					
					else if (input1 == 1) {
						
						userInput.nextLine();
						
						loop3: while (true) {
						
							System.out.println("Enter the Song name to search :");
							
							String songToSearch = userInput.nextLine();
							
							Track selectedTrack =  listener.searchSong(songToSearch);
							
							if(selectedTrack == null) {
								
								System.out.println("Couldn't find the given song. Please select any other.\n");
								
								continue loop3;
								
							}
							
							else {
								
								System.out.println(selectedTrack.toString());
								
								System.out.println("\nWhat do you want to do?\nPress '1' to 'Play'.\nPress '2' to 'Search' any other song.\nPress '3' to Exit'.\nPress '4' to 'Return' to 'Main Menu'.");
								
								int input2 = userInput.nextInt();
								
								if(input2 == 4) {
									
									System.out.println("Exitting to Main menu .....");
									
									continue loop1;
									
								}
								
								else if(input2 == 1) {
									
									listener.playSong(selectedTrack);
									
									listener.recentlyPlayed.add(selectedTrack);
									
									likeOptions(listener, selectedTrack);
									
									if(loopBreaker) {
										
										loopBreaker = false;
										
										break loop3;
										
									}
								
								}
								
								else if(input2 == 2) {
									
									userInput.nextLine();
									
									System.out.println("Select any other song..\n");
									
									continue loop3;
									
								}
								
								else if (input2 == 3) {
									
									userInput.nextLine();
									
									System.out.println("Exitting ...\n");
									
									break loop3;
									
								}
								
								userInput.nextLine();
								
							}
						
						}
						
					}
					
					else if (input1 == 2) {
						
						loop5 : while(true) {
							
							if(loopBreaker) {
								
								loopBreaker = false;
								
								break loop5;
								
							}
							
							Track song = listener.generateRandomSong();
							
							listener.playSong(song);
							
							listener.recentlyPlayed.add(song);
							
							likeOptions(listener, song);
							
							
						}
						
					}
					
					else if (input1 == 3) {
						
						if(listener.recentlyPlayed.size() < 1) {
							
							System.out.println("You haven't listened to any songs. Recently played is empty.\n");
							
						}
						
						else {
							
							loop7 : while(true) {
							
								Iterator<Track> songIterator = listener.recentlyPlayed.listIterator();
								
								while (songIterator.hasNext()) {
									
									Track songTrack = songIterator.next();
									
									listener.playSong(songTrack);
									
									listener.recentlyPlayed.add(songTrack);
									
									likeOptions(listener, songTrack);
									
								}
								
								System.out.println("All songs has been played from your recents.\n");
								
								userInput.nextLine();
								
								System.out.println("Do you want to repeat playing these songs.\nPress 'Y' to 'Repeat.\nPress 'N' to 'Exit'.");
								
								String option = userInput.nextLine();
								
								if(option.equals("Y") || option.equals("y")) {
									
									System.out.println("Repeating your recents.\n");
									
									continue loop7;
									
								}
								
								else if (option.equals("N") || option.equals("n")) {
									
									System.out.println("Exitting...\n");
									
									break loop7;
									
								}
							
							}
							
						}						
							
					}
					
					else if (input1 == 4) {
						
						if(listener.likedSongs.size() < 1) {
							
							System.out.println("You haven't liked any songs.\n");
							
						}
						
						else {
							
							loop8: while(true) {
							
								Iterator<Track> songIterator = listener.likedSongs.listIterator();
								
								while (songIterator.hasNext()) {
									
									Track songTrack = songIterator.next();
									
									listener.playSong(songTrack);
									
									listener.recentlyPlayed.add(songTrack);
									
									likeOptions(listener, songTrack);
									
								}
								
								System.out.println("All songs has been played from your favourites.\n");
								
								userInput.nextLine();
								
								System.out.println("Do you want to repeat playing these songs.\nPress 'Y' to 'Repeat.\nPress 'N' to 'Exit'.");
								
								String option = userInput.nextLine();
								
								if(option.equals("Y") || option.equals("y")) {
									
									System.out.println("Repeating your favourites.\n");
									
									continue loop8;
									
								}
								
								else if (option.equals("N") || option.equals("n")) {
									
									System.out.println("Exitting...\n");
									
									break loop8;
									
								}
							
							}
							
						}
						
					}
					
					else if (input1 == 5) {						
						
						if(listener.playlistsCreated.size() < 1) {
							
							System.out.println("You haven't created any playlists.\n");
							
						}
						
						else {
							
							userInput.nextLine();
							
							loop9: while(true) {
							
								System.out.println("Enter the playlist name to play songs from it :");
								
								String playlistName = userInput.nextLine();
								
								if(listener.playlistsCreated.containsKey(playlistName)) {
									
									if(listener.playlistsCreated.get(playlistName).size() < 1) {
										
										System.out.println("You playlist " + playlistName + " is empty. Couldn't play songs from it.\n");
										
									}
									
									else {
									
										loop10: while(true) {
										
											Iterator<Track> songIterator = listener.playlistsCreated.get(playlistName).listIterator();
											
											while (songIterator.hasNext()) {
												
												Track songTrack = songIterator.next();
												
												listener.playSong(songTrack);
												
												listener.recentlyPlayed.add(songTrack);
												
												likeOptions(listener, songTrack);
												
											}
											
											System.out.println("All songs has been played from your playlist.");
											
											userInput.nextLine();
											
											System.out.println("\nDo you want to repeat playing these songs.\nPress '1' to 'Repeat.\nPress '2' to 'Play' songs from another playlist.\nPress '3' to 'Exit'.\nPress '4' to 'Return' to 'Main Menu'.");
											
											int option = userInput.nextInt();
											
											if(option == 4) {
												
												System.out.println("Exitting to Main menu .....");
												
												continue loop1;
												
											}
											
											else if(option == 1) {
												
												System.out.println("Repeating the playlist.\n");
												
												continue loop10;
												
											}
											
											else if (option == 2) {
												
												System.out.println("\nSelect any other playlist...");
												
												continue loop9;
												
											}
											
											else if (option == 3) {
												
												System.out.println("Exitting...\n");
												
												break loop9;
												
											}
										
										}
									
									}
									
								}
								
								else {
									
									System.out.println("Playlist not found. Invalid playlist name.");
									
								}
									
							}		
					
						}				
			
					}
					
					else if (input1 == 6) {
						
						userInput.nextLine();
						
						loop11: while(true) {
						
							System.out.println("Which Artist's uploads do you want to play : \n");
							
							for(int i=0;i<listener.favouriteArtists.size();i++) {
								
								System.out.println("(" + (i+1) + ") => " + listener.favouriteArtists.get(i));
								
							}
							
							int input8 = userInput.nextInt();
							
							String artistToPlay = listener.favouriteArtists.get(input8-1);
							
							loop12: while(true) {
							
								Iterator<User> artists = dataManager.availableUsers.listIterator();
								
								while (artists.hasNext()) {
									
									User currentUser = artists.next();
									
									if(currentUser instanceof Artist && currentUser.name.equals(artistToPlay)) {
										
										Artist artist = (Artist) currentUser;
										
										Iterator<String> songIterator = artist.uploadedTracks.listIterator();
										
										while (songIterator.hasNext() && !loopBreaker) {
											
											loopBreaker = false;
											
											String songToPlay = songIterator.next();
											
											Track songTrack = listener.searchSong(songToPlay);
											
											listener.playSong(songTrack);
											
											listener.recentlyPlayed.add(songTrack);
											
											likeOptions(listener, songTrack);
											
										}
										
										System.out.println("All uploads of your favourite artists has been played.\n");
										
										userInput.nextLine();
										
										System.out.println("\nDo you want to repeat playing these songs.\nPress '1' to 'Repeat.\nPress '2' to 'Play' any other artist's uploads.\nPress '3' to 'Exit'.\nPress '4' to 'Return' to 'Main Menu'.");
										
										int option = userInput.nextInt();
										
										if(option == 4) {
											
											System.out.println("Exitting to Main menu .....");
											
											continue loop1;
											
										}
										
										if(option == 1) {
											
											System.out.println("Repeating " + artistToPlay + "'s uploads.\n");
											
											continue loop12;
											
										}
										
										else if (option == 2) {
											
											System.out.println("\nSelect any other artist...");
											
											continue loop12;
											
										}
										
										else if (option == 3) {
											
											System.out.println("Exitting...\n");
											
											break loop11;
											
										}
										
									}
								
								}
								
							}
							
						}
						
					}
				
				}
				
			}
			
			else if (input == 2) {
				
				loop13: while (true) {
					
					System.out.println("\nSelect an option :\nPress '1' to 'Create' a playlist.\nPress '2' to 'Delete' an existing playlist.\nPress '3' to 'Play' songs from your 'Playlist'.\nPress '4' for 'Advanced playlists options'.\nPress '5' to 'Exit'.");
					
					int input2 = userInput.nextInt();
					
					if(input2 == 5) {
						
						System.out.println("Exitting to Main menu .....");
						
						break loop13;
						
					}
					
					else if (input2 == 1) {
						
						userInput.nextLine();
						
						System.out.println("Enter the playlist name to create : ");
						
						String playlistName = userInput.nextLine();
						
						listener.playlistsCreated.put(playlistName, new DoubleLinkedList<Track>());
						
						System.out.println("New playlist " + playlistName + " has been created Successfully.");
						
					}
					
					else if (input2 == 2) {				
						
						if(listener.playlistsCreated.size() < 1) {
							
							System.out.println("You haven't created any playlists. So, you can't delete anything.");
							
						}
						
						else {
							
							userInput.nextLine();
						
							System.out.println("Enter the playlist name you want to delete :");
							
							String playlistToRemove = userInput.nextLine();
							
							if(listener.playlistsCreated.containsKey(playlistToRemove)) {
							
								System.out.println("Are you sure you want to remove the playlist.\nPress 'Y' to delete.\nPress 'N' to cancel.");
								
								String ch = userInput.next();
								
								if(ch.equals("Y") || ch.equals("y")) {
									
									listener.deletePlaylist(playlistToRemove);
									
								}
								
								else {
									
									System.out.println("Playlist deletion cancelled ....\n");
									
									break loop13;
									
								}
							
							}
							
							else {
								
								System.out.println("Invalid playlist name. Playlist not found.\n");
								
							}
						
						}
						
					}
					
					else if (input2 == 3) {						
						
						if(listener.playlistsCreated.size() < 1) {
							
							System.out.println("You haven't created any playlists.\n");
							
						}
						
						else {
							
							userInput.nextLine();
							
							loop14: while(true) {
							
								System.out.println("Enter the playlist name to play songs from it :");
								
								String playlistName = userInput.nextLine();
								
								if(listener.playlistsCreated.containsKey(playlistName)) {
									
									if(listener.playlistsCreated.get(playlistName).size() < 1) {
										
										System.out.println("You playlist " + playlistName + " is empty. Couldn't play songs from it.\n");
										
									}
									
									else {
									
										loop15: while(true) {
										
											Iterator<Track> songIterator = listener.playlistsCreated.get(playlistName).listIterator();
											
											while (songIterator.hasNext()) {
												
												Track songTrack = songIterator.next();
												
												listener.playSong(songTrack);
												
												listener.recentlyPlayed.add(songTrack);
												
												likeOptions(listener, songTrack);
												
											}
											
											System.out.println("All songs has been played from your playlist.");
											
											System.out.println("\nDo you want to repeat playing these songs.\nPress '1' to 'Repeat.\nPress '2' to 'Play' songs from another playlist.\nPress '3' to 'Exit'.\nPress '4' to 'Return' to 'Main Menu'.");
											
											int option = userInput.nextInt();
											
											if(option == 4) {
												
												System.out.println("Exitting to Main menu .....");
												
												continue loop1;
												
											}
											
											else if(option == 1) {
												
												System.out.println("Repeating the playlist.\n");
												
												continue loop15;
												
											}
											
											else if (option == 2) {
												
												System.out.println("\nSelect any other playlist...");
												
												continue loop14;
												
											}
											
											else if (option == 3) {
												
												System.out.println("Exitting...\n");
												
												break loop14;
												
											}
										
										}
									
									}
									
								}
								
								else {
									
									System.out.println("Playlist not found. Invalid playlist name.\n");
									
								}
									
							}		
					
						}
						
					}
					
					else if (input2 == 4) {
						
						loop15: while (true) {
						
							System.out.println("Select any option : \n(1) => 'Create' playlist with your 'Favourites'.\n(2) => 'Create' playlist with your 'Recently played songs'.\n(3) => 'Create' playlist with your 'Favourite Artist's uploads'.\n(4) => 'Copy' Playlist.\n(5) => 'Display' your playlist.\n(6) => 'Exit'.\n(7) => 'Return' to 'Main Menu'.");
							
							int input10 = userInput.nextInt();		
							
							if(input10 == 7) {
								
								System.out.println("Exitting to Main menu .....");
								
								continue loop1;
								
							}
							
							if(input10 == 6) {
								
								System.out.println("Exitting...");
								
								break loop15;
								
							}
							
							else if (input10 == 1) {
								
								loop16: while(true) {
								
									System.out.println("Select any option :\nPress '1' to 'Create' a new playlist to copy your 'Favourites'.\nPress '2' to 'Update' an exisitng playlist to copy your 'Favourites'.\nPress '3' to 'Cancel'.\nPress '4' to 'Return' to 'Main Menu'.");
									
									int input11 = userInput.nextInt();
									
									if(input11 == 4) {
										
										System.out.println("Exitting to Main menu .....");
										
										continue loop1;
										
									}
									
									else if(input11 == 1) {
										
										userInput.nextLine();
										
										System.out.println("Enter the playlist name you want to create : ");
										
										String playlistName = userInput.nextLine();
										
										listener.playlistsCreated.put(playlistName, new DoubleLinkedList<Track>());
										
										listener.playlistsCreated.get(playlistName).addAll(listener.likedSongs);
										
										System.out.println("All liked songs has been added to your playlist " + playlistName + ".\n");
										
										break loop16;
										
									}
									
									else if (input11 == 2) {
										
										String playListName = userInput.nextLine();
										
										if(!listener.playlistsCreated.containsKey(playListName)) {
											
											System.out.println("Invalid Playlist name. Please Enter a valid playlist name.");
											
										}
										
										else {
											
											listener.playlistsCreated.get(playListName).addAll(listener.likedSongs);
											
											System.out.println("All liked songs has been added to your playlist " + playListName + ".\n");
											
										}
										
										break loop16;
										
									}
									
									else if (input11 == 3) {
										
										System.out.println("Cancelling your request...\n");
										
										break loop16;
										
									}
								
								}					
																
							}
							
							else if (input10 == 2) {
								
								loop17: while(true) {
									
									System.out.println("Select any option :\nPress '1' to 'Create' a new playlist to copy your 'Recents'.\nPress '2' to 'Update' an exisitng playlist to copy your 'Recents'.\nPress '3' to 'Cancel'.\nPress '4' to 'Return' to 'Main Menu'.");
									
									int input12 = userInput.nextInt();
									
									if(input12 == 4) {
										
										System.out.println("Exitting to Main menu .....");
										
										continue loop1;
										
									}
									
									else if(input12 == 1) {
										
										userInput.nextLine();
										
										System.out.println("Enter the playlist name you want to create : ");
										
										String playlistName = userInput.nextLine();
										
										listener.playlistsCreated.put(playlistName, new DoubleLinkedList<Track>());
										
										listener.playlistsCreated.get(playlistName).addAll(listener.recentlyPlayed);
										
										System.out.println("All recent songs has been added to your playlist " + playlistName + ".\n");
										
									}
									
									else if (input12 == 2) {
										
										String playListName = userInput.nextLine();
										
										if(!listener.playlistsCreated.containsKey(playListName)) {
											
											System.out.println("Invalid Playlist name. Please Enter a valid playlist name.");
											
										}
										
										else {
											
											listener.playlistsCreated.get(playListName).addAll(listener.recentlyPlayed);
											
											System.out.println("All recent songs has been added to your playlist " + playListName + ".\n");
											
										}
										
									}
									
									else if (input12 == 3) {
										
										System.out.println("Cancelling your request...\n");
										
										break loop17;
										
									}
								
								}
								
							}
							
							else if (input10 == 3) {
								
								userInput.nextLine();
								
								Artist artist1 = null;
								
								System.out.println("Select any artist to copy their uploads to your playlist :");
								
								for(int i=0;i<listener.favouriteArtists.size();i++){
									
									System.out.println("(" + (i+1) + ") => " + listener.favouriteArtists.get(i) + ".");
									
								}
								
								int input13 = userInput.nextInt();
								
								String selectedArtist = listener.favouriteArtists.get(input13 - 1);
									
								Iterator<User> artists = dataManager.availableUsers.listIterator();
									
								while (artists.hasNext()) {
									
									User currentUser = artists.next();
									
									if(currentUser instanceof Artist && currentUser.name.equals(selectedArtist)) {
										
										artist1 = (Artist) currentUser;
											
									
									}
									
								}
								
								loop18: while(true) {
									
									System.out.println("Select any option :\nPress '1' to 'Create' a new playlist to copy your 'Favourite artist's uploads'.\nPress '2' to 'Update' an exisitng playlist to copy your 'Favourite Artist's uploads'.\nPress '3' to 'Cancel'.\nPress '4' to 'Return' to 'Main Menu'.");
									
									int input12 = userInput.nextInt();
									
									if(input12 == 4) {
										
										System.out.println("Exitting to Main menu .....");
										
										continue loop1;
										
									}
									
									if(input12 == 1) {
										
										userInput.nextLine();
										
										System.out.println("Enter the playlist name you want to create : ");
										
										String playlistName = userInput.nextLine();
										
										listener.playlistsCreated.put(playlistName, new DoubleLinkedList<Track>());
										
										Iterator<Track> trackIterator = DataManager.availableSongs.listIterator();
										
										while (trackIterator.hasNext()) {
											
											Track song = trackIterator.next();
											
											if(song.artistName.equals(artist1.name)) {
												
												listener.playlistsCreated.get(playlistName).add(song);
												
											}
											
										}
										
										System.out.println("All uploads of your favourite artists has been added to your playlist " + playlistName + ".\n");
										
									}
									
									else if (input12 == 2) {
										
										userInput.nextLine();
										
										String playlistName = userInput.nextLine();
										
										if(!listener.playlistsCreated.containsKey(playlistName)) {
											
											System.out.println("Invalid Playlist name. Please Enter a valid playlist name.");
											
										}
										
										else {										

											Iterator<Track> trackIterator = DataManager.availableSongs.listIterator();
											
											while (trackIterator.hasNext()) {
												
												Track song = trackIterator.next();
												
												if(song.artistName.equals(artist1.name)) {
													
													listener.playlistsCreated.get(playlistName).add(song);
													
												}
												
											}
											
											System.out.println("All uploads of your favourite artists has been added to your playlist " + playlistName + ".\n");
																						
										}
										
									}
									
									else if (input12 == 3) {
										
										System.out.println("Cancelling your request...\n");
										
										break loop18;
										
									}
								
								}								
																
							}
							
							else if (input10 == 4) {
								
								if(listener.playlistsCreated.isEmpty()) {
									
									System.out.println("You haven't created any playlist before. So, first create a playlist to copy.\n");
									
								}
								
								else {
									
									userInput.nextLine();
									
									System.out.println("Enter the source playlist to copy :");
									
									String srcPlaylist = userInput.nextLine();
									
									if(!listener.playlistsCreated.containsKey(srcPlaylist)) {
										
										System.out.println("Playlist not found. Please Enter a valid playlist name.");
										
									}
									
									else {
										
										DoubleLinkedList<Track> srcPlayList2 = listener.playlistsCreated.get(srcPlaylist);
										
										System.out.println("Select any option :\nPress '1' to 'Create' a new playlist to copy.\nPress '2' to 'Update' any existing playlist.\nPress '3' to 'Exit'.");
										
										int input13 = userInput.nextInt();
										
										if(input13 == 1) {
											
											userInput.nextLine();
											
											System.out.println("Enter the new playlist name : ");
											
											String plName = userInput.nextLine();
											
											listener.playlistsCreated.put(plName, new DoubleLinkedList<Track>());
											
											listener.playlistsCreated.get(plName).addAll(srcPlayList2);
											
											System.out.println("All songs from " + srcPlaylist + " has been copied to " + plName + ".\n");
											
										}
										
										else if (input13 == 2) {
											
											userInput.nextLine();
											
											System.out.println("Enter the playlist name to update : ");
											
											String plName = userInput.nextLine();
											
											if(!listener.playlistsCreated.containsKey(plName)) {
												
												System.out.println("Invalid playlist name. Playlist not found.\n");
												
											}
											
											else {
												
												listener.playlistsCreated.get(plName).addAll(srcPlayList2);
												
												System.out.println("All songs from " + srcPlaylist + " has been copied to " + plName + ".\n");
											
											}
											
										}
										
										else if (input13 == 3) {
											
											System.out.println("Exitting ....\n");
											
											continue loop15;
											
										}
										
									}
									
								}
								
							}
							
							else if (input10 == 5) {
								
								loop16: while(true) {
								
									System.out.println("Which one do you want to display :\nPress '1' to display 'Favourites'.\nPress '2' to display 'Recents'.\nPress '3' to display your 'Playlist'.\nPress '4' to 'Exit'.\nPress '5' to 'Return' to 'Main Menu'.");
									
									int input18 = userInput.nextInt();
									
									if(input18 == 5) {
										
										System.out.println("Exitting to Main menu .....");
										
										continue loop1;
										
									}
									
									if(input18 == 4) {
										
										System.out.println("Exitting ...\n");
										
										break loop16;
										
									}
									
									else if (input18 == 1) {
										
										Iterator<Track> favourites = listener.getLikedSongs().listIterator();
										
										while(favourites.hasNext()) {
											
											Track song = favourites.next();
											
											System.out.println(song.toString());
											
										}
										
									}
									
									else if (input18 == 2) {
										
										Iterator<Track> recents = listener.getRecentlyPlayed().listIterator();
										
										while(recents.hasNext()) {
											
											Track song = recents.next();
											
											System.out.println(song.toString());
											
										}
										
									}
									
									else if (input18 == 3) {
										
										if(listener.playlistsCreated.size() < 1) {
											
											System.out.println("You haven't created any playlist. So, you can't display it.\n");
											
										}
										
										else {
										
											userInput.nextLine();
											
											System.out.println("Enter the playlist name you want to display : ");
											
											String plName = userInput.nextLine();
											
											if(!listener.playlistsCreated.containsKey(plName)) {
												
												System.out.println("Playlist not found. Invalid playlist name.\n");
																								
											}
											
											else {
												
												Iterator<Track> songIterator =  listener.playlistsCreated.get(plName).listIterator();
												
												while (songIterator.hasNext()) {
													
													Track song = songIterator.next();
													
													song.toString();
													
												}												
												
											}
										
										}
										
									}
								
								}
								
							}
						
						}
						
					}
					
				}		
								
			}
			
			else if (input == 3) {
				
				System.out.println("\n----- Settings -----");
				
				updateBio(listener);
				
			}
			
			else if (input == 4) {
				
				System.out.println("Logging out.....\n");
				
				continue loop1;
				
			}
				
					
		}
	
	}





//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- //


	public static void likeOptions(Listener listener, Track song) {
		
		loop6: while(true) {
			
			System.out.println("\nPress '1' to 'Like' this song..\nPress '2' to 'Add' to your playlist.\nPress '3' to 'Continue' playing.\nPress '4' to 'Exit'");
			
			int input6 = userInput.nextInt();
			
			if(input6 == 1) {
				
				if(listener.likedSongs.contains(song)) {
					
					System.out.println("Song has already been added to you favourites.");
					
				}
				
				else {
					
					listener.likedSongs.add(song);
					
					System.out.println("Added to your liked songs....");										
					
				}
				
			}
			
			else if(input6 == 2) {
				
				if(listener.playlistsCreated.isEmpty()) {
					
					System.out.println("You haven't created any playlists. \nPress '1' to 'Create' playlist.\nPress '2' to 'Exit'");
					
					int input7 = userInput.nextInt();
					
					if(input7 == 1) {
						
						userInput.nextLine();
						
						System.out.println("Enter the playlist name :");
						
						String playlistName = userInput.nextLine();
						
						listener.playlistsCreated.put(playlistName, new DoubleLinkedList<Track>());
						
						listener.playlistsCreated.get(playlistName).add(song);
						
						System.out.println("Playlist created successfully!");
						
						System.out.println("Song successfully added to your playlist " + playlistName + "!");
						
					}
					
					else if(input7 == 2) {
						
						System.out.println("Exitting .....");
						
						continue loop6;
						
					}
					
					else {
						
						System.out.println("Please select a valid option.");
						
					}
					
				}
				
				else {
					
					System.out.println("Press '1' to add to your 'Existing' playlist.\nPress '2' to 'Create' a new playlist.\nPress '3' to 'Exit'.");
					
					int input8 = userInput.nextInt();
					
					if(input8 == 1) {
						
						ArrayList<String> keys = new ArrayList<>(listener.playlistsCreated.keySet());
						
						System.out.println("Select the playlist to add songs :");
											
						for(int i=0;i<listener.playlistsCreated.size();i++) {
							
							System.out.println("(" + (i+1) + ") => " + keys.get(i));
							
						}
						
						int playlistNo = userInput.nextInt();
						
						String playlistName = keys.get(playlistNo-1);
						
						if(listener.playlistsCreated.containsKey(playlistName)) {
							
							DoubleLinkedList<Track> userPlayList = listener.playlistsCreated.get(playlistName);
							
							if(userPlayList.contains(song)) {
								
								System.out.println("Song has already added to you playlist.");
								
							}
							
							else {
							
								userPlayList.add(song);
								
								System.out.println("Song successfully added to your playlist " + playlistName + "!");
							
							}
							
						}
						
						else {
							
							System.out.println("Playlist not found.");
							
						}
						
					}
					
					else if (input8 == 2) {
						
						userInput.nextLine();
						
						System.out.println("Enter the playlist name :");
						
						String playlistName = userInput.nextLine();
						
						listener.playlistsCreated.put(playlistName, new DoubleLinkedList<Track>());
						
						DoubleLinkedList<Track> userPlayList = listener.playlistsCreated.get(playlistName);
						
						userPlayList.add(song);
						
						System.out.println("Playlist created successfully!");
						
						System.out.println("Song successfully added to you playlist " + playlistName + "!");
						
					}
					
					else if (input8 == 3) {
						
						System.out.println("Exitting .....\n");
						
						continue loop6;
						
					}
					
					else {
						
						System.out.println("Please select a valid option.");
						
					}
					
				}
				
			}
			
			else if (input6 == 3) {
				
				System.out.println("Playing next song ....");
				
				break loop6;
				
			}
			
			else  if(input6 == 4){
				
				System.out.println("Exitting .....\n");
				
				loopBreaker = true;
				
				break loop6;
				
			}
		
		}
		
	}

}
