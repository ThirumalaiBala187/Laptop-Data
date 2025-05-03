package Kadanes_Algorithm;

public class BruteForce {
	
	static int maxSum(int[] arr) {
		
		int result = arr[0];		
		
		for(int i=0;i<arr.length;i++) {
		
			int curSum = 0;		
			
			for(int j=i;j<arr.length;j++) {
			
				curSum += arr[j];				
				
				result = Math.max(curSum, result);
			
			}			
		
		}		
		
		return result;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,-2,3,5,6,-7};
		
//		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		
		System.out.println(BruteForce.maxSum(arr));
		
	}

}
