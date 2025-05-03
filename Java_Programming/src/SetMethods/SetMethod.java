package SetMethods;

import java.util.HashSet;
import java.util.Set;

public class SetMethod {

	public SetMethod() {
		
	}
	
	public static void main(String[] args) {
		
//		Set<String> set = new HashSet<>();
//		
//		set.add("Bala");
//		set.add("Hari");
//		set.add("Thirumalai");
//		set.add("Ram");
//		set.add("Anujam");
//		set.add("Ram");
		
//		Iterator<String> iterator = set.iterator();
//		
//		while(iterator.hasNext()) {
//			String elementString = iterator.next();
//			System.out.println(elementString);
//			System.out.println(elementString.hashCode());
//		}
		
//		Object[] setArray = set.toArray();
//		
//		for(Object obj:setArray) {			
//			System.out.println(obj);
//			System.out.println(obj instanceof String);
//			Be extremely good at one thing and make it your profession (earn money)… decent at everything else to be sharp in that one thing….
//		}
		
//		String[] setArray1 = set.toArray(new String[0]);
//		
//		for(String obj:setArray1) {			
//			System.out.println(obj);
//			System.out.println(obj instanceof String);
//		}
		
		

		Set<Integer> setA = new HashSet<>();
		setA.add(1);
		setA.add(2);
		setA.add(3);
		Set<Integer> setB = new HashSet<>();
		setB.add(1);
		setB.add(2);
		if (setA.containsAll(setB)) {
		    System.out.println("setB is a subset of setA");
		}
		else {
		    System.out.println("setB is not a subset of setA");
		}
		
		Set<Integer> setC = new HashSet<>(setA);
		
//		setC.addAll(setB);
//		System.out.println("Union : " + setC);
		
		setC.retainAll(setB);
		System.out.println("Intersection : " + setC);
		
		
		
	}

}
