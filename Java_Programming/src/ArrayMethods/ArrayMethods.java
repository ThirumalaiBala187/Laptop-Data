package ArrayMethods;

import java.util.Arrays;

public class ArrayMethods {

	public ArrayMethods() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		System.out.println("----- Array Methods -----");
		Person p1 = new Person("Thirumalai",17);
		Person p2 = new Person("Bala",16);
		Person p3 = new Person("Hariram",18);
		
		Person[] personList = {p1, p2, p3};
		
		int[] intArray = {2,3,1,4,5};
		
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(personList));
		
//		Arrays.sort(intArray);
//		
//		System.out.println("Binary Search : " + Arrays.binarySearch(intArray, 2));
//	
//		Arrays.sort(personList);
//		
//		System.out.println("Binary Search : " + Arrays.binarySearch(personList, 2));
		
		
	}

}
