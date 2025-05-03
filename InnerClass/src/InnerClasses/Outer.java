package InnerClasses;

public class Outer {

	private String name = "Hello World";
	
	interface InnerInterface{
		
		void printInnerClass();
		
		String getClassName();
		
	}
		
	public InnerInterface createClass() {
		
		class Inner implements InnerInterface{
			
			String innerName = "Inner class";
			
			public void printInnerClass() {
				
				System.out.println("This is a inner class");
				
			}

			@Override
			public String getClassName() {

				return innerName;

			}
			
			public void hello() {
				
				System.out.println("HEllo");
				
			}
			
		}
		
		Inner inner = new Inner();
		
//		System.out.println(inner.innerName);
//		
//		inner.printInnerClass();
		
		return inner;
		
	}

	 public static void main(String[] args) {
	       
		 Outer out = new Outer();
	     
		 System.out.println(out.name);
   
	     InnerInterface obj = out.createClass();
	     
	     System.out.println(obj.getClassName());
	     
	     obj.getClassName();
	     
//	     System.out.println(obj.getClass());
//	        
//	     if(obj instanceof InnerInterface) {
//	        	
//	        InnerInterface innerClass = (InnerInterface) obj;
//	        
//	        	
//	        System.out.println(innerClass.getClassName());
//	        	
//	       	innerClass.printInnerClass();
//	       	
////	       	innerClass.hello();
//	        	
//	    }
	   
	 }

}
