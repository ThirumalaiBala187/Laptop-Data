package BinarySearch;

public class Main {
	
	public static void main(String[] args) {
		
		DivideAndConquer div = new DivideAndConquer();
		
		int[] arr = {4,8,10,23,28,60,80,90};
		
		int x=4;
		
		int result=div.find(arr,x);
		
		if(result == -1) {
			
			System.out.println("Value not found.");
			
		}
		
		else {
			
			System.out.println("Your target found at " + (result+1) + " position.");
			
		}
		
	}

}
