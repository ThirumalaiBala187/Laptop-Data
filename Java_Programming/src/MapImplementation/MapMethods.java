package MapImplementation;

import java.util.HashMap;

public class MapMethods {
	

	public static void main(String[] args) {
		
		HashMap<Integer, String> studentMap = new HashMap<>();
		
		studentMap.put(368,"Thirumalai");
		
		studentMap.put(377,"Hari");
		
		studentMap.put(187,"Bala");
		
//		Iterator<Integer> iterator = studentMap.keySet().iterator();
//		while(iterator.hasNext()) {
//			int key = iterator.next();
//			System.out.println("Employee Data : " + studentMap.get(key));
//		}
		
//		Iterator<Entry<Integer, String>> stdData = studentMap.entrySet().iterator();
//		while (stdData.hasNext()) {
//			System.out.println("Key : " + stdData.next().getValue());
//			
//		}
		
		System.out.println(studentMap);
		
	}

}