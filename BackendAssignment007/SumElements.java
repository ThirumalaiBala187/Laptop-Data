package BackendAssignment007;

import java.util.List;

public class SumElements {

	public static <T> double SumNumbers(List<? extends Number> list) {
		
		double sumOfTheNumbers = 0;
		
		for(int i=0;i<list.size();i++) {
			
			sumOfTheNumbers = sumOfTheNumbers + list.get(i).doubleValue();
			
		}
		
		return sumOfTheNumbers;
		
	}

}
