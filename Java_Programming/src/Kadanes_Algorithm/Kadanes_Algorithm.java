package Kadanes_Algorithm;

public class Kadanes_Algorithm {
	
	static int maxSum(int[] arr) {
		
		int localMax = arr[0];
		
		int globalMax = arr[0];
		
		for(int i=0;i<arr.length;i++) {
			
			localMax = Math.max(localMax+arr[i], arr[i]);
			
			globalMax = Math.max(localMax, globalMax);
			
		}	
				
		return globalMax;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		
//		int[] arr = {1,-2,3,5,6,-7};
		
		System.out.println(Kadanes_Algorithm.maxSum(arr));
		
	}

}
