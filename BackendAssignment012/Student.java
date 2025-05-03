package BackendAssignment012;

public class Student {
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	String name;
	private short height;	
	private byte weight;	
	private String bloodGroup;

	public Student(String name, short height, byte weight, String bloodGroup) {	
		this.name = name;
		this.height = height;		
		this.weight = weight;		
		this.bloodGroup = bloodGroup;		
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getHeight() {
		return height;
	}

	public void setHeight(short height) {
		this.height = height;
	}

	public byte getWeight() {
		return weight;
	}

	public void setWeight(byte weight) {
		this.weight = weight;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	@Override
	public String toString() {

		return "\n--- Student Details ---\nStudent Name : " + name + "\nHeight : " + height + "\nWeight : " + weight + "\nBlood Group : " + bloodGroup + "\n-----------------------";

	}

}
