package BackendAssignment007;

import java.util.Arrays;

import java.util.List;

import java.io.CharArrayReader;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		String[] strArr = {"a","b","c","d","e"};
		
		Integer[] intArr = {1,2,3,4,5};
		
		Double[] dblArr = {1.0,2.0,3.0,4.0,5.0};
		
		Character[] charArr = {'a','b','c','d','e'};
		
		System.out.println("----- Swapping two Elements -----");
		
		System.out.println("\nInitial String Array");
		
		System.out.println(Arrays.toString(strArr));
		
		System.out.println("\nInitial Integer Array");
		
		System.out.println(Arrays.toString(intArr));
		
		System.out.println("\nInitial Double Array");
		
		System.out.println(Arrays.toString(dblArr));
		
		System.out.println("\nInitial Char Array");
		
		System.out.println(Arrays.toString(charArr));
		
		System.out.println("\nEnter the index 1 to swap :");
		
		int idx1 = userInput.nextInt();
		
		if (idx1 > 4)  idx1 = 4;
		
		System.out.println("Enter the index 2 to swap :");
		
		int idx2 = userInput.nextInt();
		
		if (idx2 > 4)  idx2 = 4;
		
		System.out.println("\nString array after swapping");
		
		SwapArray.swapElements(strArr,idx1,idx2);
		
		System.out.println(Arrays.toString(strArr));
		
		System.out.println("\nInteger array after swapping");
		
		SwapArray.swapElements(intArr,idx1,idx2);
		
		System.out.println(Arrays.toString(intArr));
		
		System.out.println("\nDouble array after swapping");
		
		SwapArray.swapElements(dblArr,idx1,idx2);
		
		System.out.println(Arrays.toString(dblArr));
		
		System.out.println("\nChar array after swapping");
		
		SwapArray.swapElements(charArr,idx1,idx2);
		
		System.out.println(Arrays.toString(charArr));
		
		
		
		System.out.println("\n\n----- Sum of the Elements -----");
		
		List<Integer> integerArr = new ArrayList<>();
		
		integerArr.add(7);
		
		integerArr.add(18);
		
		integerArr.add(45);
		
		integerArr.add(49);
		
		integerArr.add(33);
		
		System.out.println("\nInteger Array to sum : " + integerArr);
		
		System.out.println("Sum of the elements in the integer array  : " + SumElements.SumNumbers(integerArr));
		
		List<Double> doubleArr = new ArrayList<>();
		
		doubleArr.add(10.0);
		
		doubleArr.add(63.0);
		
		doubleArr.add(12.0);
		
		doubleArr.add(93.0);
		
		doubleArr.add(73.0);
		
		System.out.println("\nDouble Array to sum : " + doubleArr);
		
		System.out.println("Sum of the elements in the double array  : " + SumElements.SumNumbers(doubleArr));
		
		userInput.close();
		
		
		
		System.out.println("\n\n----- Filter Elements -----");
		
		List<Object> stringArray = new ArrayList<>();
		
		stringArray.add(("Hello"));
		
		stringArray.add(("World"));
		
		stringArray.add(new StringBuffer("Hi"));
		
		stringArray.add(new StringBuilder("Happy"));
		
		char[] characterArray = {'H','o','l','i'};
		
		stringArray.add(new CharArrayReader(characterArray));
		
		stringArray.add(18);
		
		System.out.println("\nGiven array of mixed elements : " + stringArray);
		
		System.out.println("Given prefix to filter : \"H\"");
		
		System.out.println("Filtered Array : " + StringFilter.filterElements(stringArray, "H"));
		
		System.out.println("\n" + "-".repeat(100));		

	}

}
