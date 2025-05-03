package ObjectComparison;

import java.util.Arrays;

public class Student implements Comparable<Student>{
		
		String name;
		
		int age;
		
		Marks average;
		
		Student(String name, int age, Marks average){
			
			this.name = name;
			
			this.age = age;
			
			this.average = average;
			
			
			
		}
		
		public String toString() {
			
			return "Name : " + this.name + "\nAge : " + this.age + "\nMarks : " + this.average.getAverage() + "\n"; 
			
		}
	
		public static void main(String[] args) {
			
			Marks mark1 = new Marks(40);
			
			Marks mark2 = new Marks(80);
			
			Marks mark3 = new Marks(30);
			
			Marks mark4 = new Marks(10);
			
			Student std1 = new Student("Hari", 19, mark1);
			
			Student std2 = new Student("Thirumalai", 17, mark2);
			
			Student std3 = new Student("Ramanujam", 21, mark3);
			
			Student std4 = new Student("Bala", 18, mark4);
			
			Student[] studentArray = {std1,std2, std3, std4};
			
			Arrays.sort(studentArray);
			
			for(Student std : studentArray) {
				
				System.out.println(std.toString());
				
			}
			
		}

		@Override
		public int compareTo(Student std) {
			
			return Integer.compare(this.average.getAverage(), std.average.getAverage());
			
//			return this.name.compareTo(std.name);
			
		}
	
	
}
