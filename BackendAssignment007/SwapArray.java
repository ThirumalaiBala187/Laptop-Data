package BackendAssignment007;

public class SwapArray {

	public static <T> void swapElements(T userArray[], int idx1, int idx2 ) {
		
		T temp = userArray[idx1];
		
		userArray[idx1] = userArray[idx2];
		
		userArray[idx2] = temp;
		
	}

}