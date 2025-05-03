package BackendAssignment012;

import java.util.List;

public class Stream {

	public Stream() {
		// TODO Auto-generated constructor stub
	}
	
	//Iterating a list using Stream for each
	
	public void listIteration(List<?> list) {
		
		list.stream().forEach((value) -> System.out.println(value));
		
	}
	
	
	// Verifying the password
	
	public List<String> passwordVerificaition(List<String> passwordList) {
		
		String regex = "^(?=.*[A-Z])(?=.*\\d).{6,}$";
				
		return passwordList.stream().filter((password) -> password.matches(regex)).toList();
		
	}
	
	
	// Filtering students with O+ve Blood group
	
	public List<Student> filterStudents(List<Student> list) {
		
		return list.stream().filter((student) -> student.getBloodGroup().equals("O+ve")).toList();
		
	}
	
		
	// Calculating the Area of the triangle
	
	public int calculateArea(int base, int height) {
		
		Triangle triangle = (b,h) -> (b*h)/2;
		
		System.out.println("Height of the Triangle :  " + height);
		
		System.out.println("Base of the Triangle :  " + base);
		
		return triangle.getArea(base, height);
		
	}

}



