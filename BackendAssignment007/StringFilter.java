package BackendAssignment007;

import java.util.ArrayList;

import java.util.List;

public class StringFilter {

	public static<T> List<String> filterElements(List<? super String> inpArr, String prefix ) {
		
		List<String> filteredElement = new ArrayList<>();
		
		for(Object item : inpArr) {

			if(item instanceof String) {
				
				if(((String) item).startsWith(prefix)) {
					
					filteredElement.add((String)item);
					
				}
				
			}
			
			else if(item instanceof CharSequence) {
				
				String str = item.toString();
				
				if(str.startsWith(prefix)) {
					
					filteredElement.add(str);
					
				}
				
			}
			
		}
		
		return filteredElement;
	}

}
