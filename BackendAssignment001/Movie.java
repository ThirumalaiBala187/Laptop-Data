package BackendAssignment001;

import java.util.Arrays;

import java.util.Scanner;

public class Movie implements Comparable<Movie>{
	
	String title;
	
	int releaseYear;

	public Movie(String title, int releaseYear) {

		this.title = title;
		
		this.releaseYear = releaseYear;
		
	}
	
	public void setTitle(String title) {
		
		this.title = title;
		
	}
	
	public String getTitle() {
		
		return this.title;
		
	}
	
	public void setReleaseYear(int releaseYear) {
		
		this.releaseYear = releaseYear;
		
	}
	
	public int getReleaseYear() {
		
		return this.releaseYear;
		
	}
	
	
	@Override
	public String toString() {
		
		return "----- Movie Details -----\nMovie Name : " + this.title + "\nRelease Year : " + this.releaseYear + "\n";
		
	}
	
	static int choice;

	@Override
	public int compareTo(Movie movie) {
		
		System.out.println("choice : " + choice);
		
		if(choice == 2) {
			
//			System.out.println("2=====  "+choice);
			
			return this.title.compareTo(movie.title);		
			
		}
		
		else if(choice == 3) {
			
//			System.out.println("3=====  "+choice);
			
			int year1 = this.releaseYear;
			
			int year2 = movie.releaseYear;
			
			return Integer.compare(year1,year2);		
			
		}
		
		return 1;
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		Movie movie1 = new Movie("Thalapathy 69", 2025);
		
		Movie movie2 = new Movie("The Greatest Of All Time (GOAT)", 2024);
		
		Movie movie3 = new Movie("Leo", 2023);
		
		Movie movie4 = new Movie("Varisu", 2023);
		
		Movie movie5 = new Movie("Beast", 2022);
		
		Movie movie6 = new Movie("Master", 2021);
		
		Movie movie7 = new Movie("Bigil", 2019);
		
		Movie movie8 = new Movie("Sarkar", 2018);
		
		Movie movie9 = new Movie("Mersal", 2017);
		
		Movie movie10 = new Movie("Bairavaa", 2017);
		
		Movie movie11 = new Movie("Theri", 2016);
		
		Movie movie12 = new Movie("Kaththi", 2014);
		
		Movie movie13 = new Movie("Thuppaki", 2012);
		
		Movie[] moviesList = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12, movie13};
		
		while(true) {
		
		System.out.println("----- Movie Show -----\nPress '1' to view 'Movies;.\nPress '2' to sort by 'Movie Name'.\nPress '3' to sort by 'Movie Release Year'.\nPress '4' to 'Exit'.");
		
		choice = userInput.nextInt();
		
		if(choice == 1) {
			
			System.out.println("All Movies");
		
			for(Movie movie : moviesList) {
				
				System.out.println(movie.toString());
				
			}
			
		}
		
		else if(choice == 2) {
			
			Arrays.sort(moviesList);
			
			System.out.println("\n----- Movies List after sorting by name -----\n");
			
			for(Movie movie : moviesList) {
				
				System.out.println(movie.toString());
				
			}
			
		}
		
		else if(choice == 3) {
			
			Arrays.sort(moviesList);
			
			System.out.println("\n----- Movies List after sorting by release year -----\n");
			
			for(Movie movie : moviesList) {
				
				System.out.println(movie.toString());
				
			}
			
		}
		
		else if(choice == 4) {
			
			System.out.println("Bye see you soon.");
			
			break;
			
		}
	
	}
	
	userInput.close();

		
	}

}




















