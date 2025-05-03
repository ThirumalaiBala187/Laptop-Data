package ArrayMethods;

public class Person implements Comparable<Person>{
	
	String name;
	
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "----- Person Details -----\nPerson Name : " + this.name + "\nPerson Age : " + this.age;
	}

	@Override
	public int compareTo(Person p1) {
		
		return Integer.compare(this.age, p1.age);
	}
	
	

}
