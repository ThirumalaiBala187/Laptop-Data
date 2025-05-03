package WrapperClassMethods;

public class IntegerMethods {

    public static void main(String[] args) {

        // Integer object (Autoboxing)
        
    	Integer intObj = 42;

        System.out.println("\nInteger Wrapper Class Methods (Static)");

       
        // 1. parseInt(String s)
        
        System.out.println("\nparseInt(\"123\"): " + Integer.parseInt("110",2));

        
        // 2. valueOf(String s)
        
        System.out.println("\nvalueOf(\"123\"): " + Integer.valueOf("123"));

        
        // 3. valueOf(int i)
        	
        System.out.println("\nvalueOf(42): " + Integer.valueOf(42));

        
        // 4. toString(int i)
        
        System.out.println("\ntoString(42): " + Integer.toString(42));

        
        // 5. toBinaryString(int i)
        
        System.out.println("\ntoBinaryString(42): " + Integer.toBinaryString(42));

        
        // 6. toHexString(int i)
        
        System.out.println("\ntoHexString(42): " + Integer.toHexString(42));


        // 7. toOctalString(int i)
        
        System.out.println("\ntoOctalString(42): " + Integer.toOctalString(42));

        
        // 8. toString(int i, int radix)
        
        System.out.println("\ntoString(42, 16): " + Integer.toString(42, 16));

        
        // 9. compare(int x, int y)
        
        System.out.println("\ncompare(42, 30): " + Integer.compare(22, 30));

        
        // 10. sum(int a, int b)
        
        System.out.println("\nsum(10, 20): " + Integer.sum(10, 20));

        
        // 11. max(int a, int b)
        
        System.out.println("\nmax(10, 20): " + Integer.max(10, 20));

        
        // 12. min(int a, int b)
        
        System.out.println("\nmin(10, 20): " + Integer.min(10, 20));

        
        // 13. signum(int x)
        
        System.out.println("\nsignum(-42): " + Integer.signum(0));

        
        // 14. bitCount(int i)
        
        System.out.println("\nbitCount(42): " + Integer.bitCount(42));

        
        // 15. highestOneBit(int i)
        
        System.out.println("\nhighestOneBit(42): " + Integer.highestOneBit(42));

        
        // 16. lowestOneBit(int i)
        
        System.out.println("\nlowestOneBit(42): " + Integer.lowestOneBit(42));

        
        // 17. reverse(int i)
        
        System.out.println("\nreverse(42): " + Integer.reverse(3));

        
        // 18. decode(String nm)
        
        System.out.println("\ndecode(\"0x2A\"): " + Integer.decode("0x2a"));

        
        System.out.println("\nInteger Wrapper Class Methods (Non-Static)");

        
        // 19. intValue()
        
        System.out.println("\nintValue(): " + intObj.intValue());

        
        // 20. toString()
        
        System.out.println("\ntoString(): " + intObj.toString());

        
        // 21. compareTo(Integer anotherInteger)

        System.out.println("\ncompareTo(30): " + intObj.compareTo(30));

        
        // 22. equals(Object obj)
        
        System.out.println("\nequals(42): " + intObj.equals(42));

        
        // 23. hashCode()
        
        Integer intObj1 = 5500;
        
        System.out.println("\nhashCode(): " + intObj1.hashCode());

        
        // 24. byteValue()
        
        System.out.println("\nbyteValue(): " + intObj1.byteValue());

        
        // 25. shortValue()
        
        System.out.println("\nshortValue(): " + intObj.shortValue());

        
        // 26. longValue()
        
        System.out.println("\nlongValue(): " + intObj.longValue());

        
        // 27. floatValue()
        
        System.out.println("\nfloatValue(): " + intObj.floatValue());

        
        // 28. doubleValue()
        
        System.out.println("\ndoubleValue(): " + intObj.doubleValue());

        
        System.out.println("\nInteger Wrapper Class Constants");

        
        // 29. Integer.MAX_VALUE
        
        System.out.println("\nInteger.MAX_VALUE: " + Integer.MAX_VALUE);

        
        // 30. Integer.MIN_VALUE
        
        System.out.println("\nInteger.MIN_VALUE: " + Integer.MIN_VALUE);

        
        // 31. Integer.SIZE
        
        System.out.println("\nInteger.SIZE: " + Integer.SIZE);

        
        // 32. Integer.BYTES
        
        System.out.println("\nInteger.BYTES: " + Integer.BYTES);

        
        // 33. Integer.TYPE
        
        System.out.println("\nInteger.TYPE: " + Integer.TYPE);
    
    }

}
