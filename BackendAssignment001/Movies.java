package BackendAssignment001;

import java.util.Arrays;

public class Movies implements Comparable<Movies>{
	
	String title;
	
	int releaseYear;

	public Movies(String title, int releaseYear) {

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

	@Override
	public int compareTo(Movies movie) {
		
		return this.title.compareTo(movie.title);
		
	}
	
	
	public static void main(String[] args) {
		
		Movies movie1 = new Movies("Thalapathy 69", 2025);
		
		Movies movie2 = new Movies("The Greatest Of All Time (GOAT)", 2024);
		
		Movies movie3 = new Movies("Leo", 2023);
		
		Movies movie4 = new Movies("Varisu", 2023);
		
		Movies movie5 = new Movies("Beast", 2022);
		
		Movies movie6 = new Movies("Master", 2021);
		
		Movies movie7 = new Movies("Bigil", 2019);
		
		Movies movie8 = new Movies("Sarkar", 2018);
		
		Movies movie9 = new Movies("Mersal", 2017);
		
		Movies movie10 = new Movies("Bairavaa", 2017);
		
		Movies movie11 = new Movies("Theri", 2016);
		
		Movies movie12 = new Movies("Kaththi", 2014);
		
		Movies movie13 = new Movies("Thuppaki", 2012);
		
		Movies[] moviesList = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12, movie13};
		
		System.out.println("----- Movies List before Sorting -----\n");
		
		for(Movies movie : moviesList) {
			
			System.out.println(movie.toString());
			
		}
		
		System.out.println("-------------------------------");
		
		Arrays.sort(moviesList);
		
		System.out.println("\n----- Movies List after Sorting -----\n");
		
		for(Movies movie : moviesList) {
			
			System.out.println(movie.toString());
			
		}			
		
	}

}
