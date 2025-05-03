package Recursion_Binarysearch;

public class DivideAndConquer {

	int findRecursion(int[] arr, int low, int high, int x) {
		
		if(low > high) {
			
			return -1;
			
		}
		
		int mid = (low+high)/2;
		
		if(arr[mid] == x) {
			
			return mid;
			
		}
		
		else if (arr[mid] < x) {
			
			low = mid+1;
			
//			findRecursion(arr, low, high, x);
			
		}
		
		else {
			
			high = mid-1;
			
//			findRecursion(arr, low, high, x);
			
		}
		
		return findRecursion(arr, low, high, x);
		
	}

}
