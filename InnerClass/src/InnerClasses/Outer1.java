package InnerClasses;

abstract class OuterClass1{
    static String name = "jagadhesh";
    public int age = 30;

    void display() { 
        System.out.println("Hello from OuterClass");
    }

    class InnerClass {
        String gender;

        public InnerClass(String gender) {
            this.gender = gender;
        }

        void display() {
            System.out.println("hello " + name);
        }
    }
}

class OuterSubclass extends OuterClass1 {
	
}

public class Outer1 {
    public static void main(String[] args) {
        OuterClass1 out = new OuterSubclass();
        OuterClass1.InnerClass s = out.new InnerClass("m");
        out.display();
        s.display();
        System.out.println(s.gender);
    }
}
