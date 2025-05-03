package WrapperClassMethods;

public class BooleanMethods {

    public static void main(String[] args) {

        // Boolean object (Autoboxing)
        
    	Boolean bool = true;

        
    	System.out.println("\nBoolean Wrapper Class Methods (Static)");

        
    	// 1. parseBoolean(String s)
        
    	System.out.println("\nparseBoolean(\"true\"): " + Boolean.parseBoolean("1"));

        
    	// 2. valueOf(String s)
        
    	System.out.println("\nvalueOf(\"true\"): " + Boolean.valueOf("true"));

        
    	// 3. valueOf(boolean b)
        
    	System.out.println("\nvalueOf(false): " + Boolean.valueOf(false));

        
    	// 4. logicalAnd(boolean a, boolean b)
        
    	System.out.println("\nlogicalAnd(true, false): " + Boolean.logicalAnd(true, false));

        
    	// 5. logicalOr(boolean a, boolean b)
        
    	System.out.println("\nlogicalOr(true, false): " + Boolean.logicalOr(true, false));

        
    	// 6. logicalXor(boolean a, boolean b)
        
    	System.out.println("\nlogicalXor(true, false): " + Boolean.logicalXor(false, false));

        
    	// 7. toString(boolean b)
        
    	System.out.println("\ntoString(true): " + Boolean.toString(true));

        
    	// 8. compare(boolean x, boolean y)
        
    	System.out.println("\ncompare(true, false): " + Boolean.compare(true, false));

        
    	System.out.println("\nBoolean Wrapper Class Methods (Non-Static)");

    	
        // 9. booleanValue()
        
    	System.out.println("\nbooleanValue(): " + bool.booleanValue());

        
    	// 10. equals(Object obj)
        
    	System.out.println("\nequals(true): " + bool.equals(true));

        
    	// 11. toString()
        
    	System.out.println("\ntoString(): " + bool.toString());

        
    	// 12. hashCode()
        
    	System.out.println("\nhashCode(): " + bool.hashCode());

        
    	System.out.println("\nBoolean Wrapper Class Constants");

    	
        // 13. Boolean.TRUE
        
    	System.out.println("\nBoolean.TRUE: " + Boolean.TRUE);

    	
        // 14. Boolean.FALSE
        
    	System.out.println("\nBoolean.FALSE: " + Boolean.FALSE);

        
    	// 15. Boolean.TYPE
        
    	System.out.println("\nBoolean.TYPE: " + Boolean.TYPE);
    
    }

}
