package InnerClasses;

abstract class OuterClass {
	static String name = "jagadhesh";
	public int age = 30;
	abstract void display();
	class InnerClass{
		String gender;
		public InnerClass(String gender) {
			this.gender = gender;
		}
		void display() {
			System.out.println("hello  "+name);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		OuterClass out = new OuterClass() {
			
			@Override
			void display() {
				System.out.println("Hello World");
				
			}
		};
		OuterClass.InnerClass s = out.new InnerClass("m");
		out.display();
		s.display();
		System.out.println(s.gender);
	}
}
