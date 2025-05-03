package Comparator;

import java.util.Arrays;

public class Student {
	
	String name;
	int age;

	public Student(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public static void main(String[] args) {
		Student s1= new Student("Hari",12);
		Student s2=new Student("Bala",16);
		Student s3=new Student("Java",14);
		
		Student[] studentArray= {s1,s2,s3};
		
		for(Student std : studentArray) {
			System.out.println("Name : " + std.name + "\nAge : " + std.age);
		}
		System.out.println("\n\n");
		Arrays.sort(studentArray, new ageComparatorHTL());
		
		for(Student std : studentArray) {
			System.out.println("Name : " + std.name + "\nAge : " + std.age);
		}
	}

}
