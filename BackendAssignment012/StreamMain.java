package BackendAssignment012;

import java.util.ArrayList;

import java.util.List;

public class StreamMain {

	public StreamMain() {
		// TODO Auto-generated constructor stub
	}
	
	public static<E> void main(String[] args) {
		
		Stream streamObj = new Stream();
		
		
		// Iterating a list using Stream for each
		
		List<String> list = new ArrayList<>();		
		
		list.add("Thirumalai");		
		
		list.add("Bala");		
		
		list.add("Hari");		
		
		list.add("Ramanujam");		
		
		list.add("Kesavan");
		
		list.add("Ragavan");
		
		list.add("Mathavan");
		
		list.add("Vijay");
		
		System.out.println("----- (1) - List Iteration -----\n");
		
		streamObj.listIteration(list);
		
		
		// Verifying the Password
		
		List<String> passwordList = new ArrayList<>(); 
		
		passwordList.add("Bala@123");
		
		passwordList.add("hariram147");
		
		passwordList.add("Thiruzsttk-368");
		
		passwordList.add("Vijay$2026");
		
		passwordList.add("king#187");
		
		System.out.println("\n----- (2) - Password Verification -----\n");
		
		System.out.println("Passwords List : " + passwordList);		
		
		System.out.println("Valid passwords List : " +  streamObj.passwordVerificaition(passwordList));
		
		
		
		// Filtering the students with O+ve blood group.
		
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student("Hari", (short)123, (byte)78, "O+ve"));
		
		studentList.add(new Student("Bala", (short)176, (byte)56, "A1+ve"));
		
		studentList.add(new Student("Ram", (short)154, (byte)62, "B+ve"));
		
		studentList.add(new Student("Vijay", (short)145, (byte)75, "O+ve"));
		
		studentList.add(new Student("Kesavan", (short)149, (byte)54, "A+ve"));
		
		studentList.add(new Student("Thirumalai", (short)137, (byte)56, "O+ve"));
		
		List<Student> filteredStudents = streamObj.filterStudents(studentList);
		
		System.out.println("\n----- (3) - Filter O+ve Blood Group -----");
				
		filteredStudents.forEach(System.out::println);
		
		
		
		// Calculating the area of the Triangle		
		
		System.out.println("\n----- (4) - Calculating the area of the Triangle -----\n");
		
		System.out.println("Area of the Triangle : " + streamObj.calculateArea(4,5));
		
	}

}
