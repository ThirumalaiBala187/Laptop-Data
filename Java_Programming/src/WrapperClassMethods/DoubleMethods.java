package WrapperClassMethods;

public class DoubleMethods {

    public static void main(String[] args) {

        // Double wrapper class Static methods

    	double num1 = 12.34;
        
    	double num2 = 56.78;
        
    	double nanValue = Double.NaN;
        
    	double infiniteValue = Double.POSITIVE_INFINITY;
    	
    	
    	Double doubleObj1 = 12.34;
        
    	Double doubleObj2 = 56.78;
        
    	Double nanDouble = Math.sqrt(-2);
        
    	Double infiniteDouble = Double.POSITIVE_INFINITY;


        System.out.println("Double class methods: (Static");

        
        // 1. parseDouble(String s) - Converts a String to a double
        
        double parsedDouble = Double.parseDouble("123.45");
        
        System.out.println("\nparseDouble(\"123.45\") : " + parsedDouble);

        
        // 2. valueOf(String s) - Returns a Double object for the specified string
        
        Double valueOfString = Double.valueOf("123.45");
        
        System.out.println("\nvalueOf(\"123.45\") : " + valueOfString);

        
        // 3. valueOf(double d) - Returns a Double object for the specified double value
        
        Double valueOfDouble = Double.valueOf(num1);
        
        System.out.println("\nvalueOf(12.34) : " + valueOfDouble);

        
        // 4. toString(double d) - Converts a double to its String representation
        
        String doubleToString = Double.toString(num1);
        
        System.out.println("\ntoString(12.34) : " + doubleToString);

        
        // 5. compare(double d1, double d2) - Compares two double values
        
        int comparison = Double.compare(num1, num2);
        
        System.out.println("\ncompare(12.34, 56.78) : " + comparison);

        
        // 6. isNaN(double v) - Checks if the value is Not-a-Number (NaN)
        
        boolean isNan = Double.isNaN(nanValue);
        
        System.out.println("\nisNaN(Double.NaN) : " + isNan);


        // 7. isInfinite(double v) - Checks if the value is infinite
        
        boolean isInfinite = Double.isInfinite(infiniteValue);
        
        System.out.println("\nisInfinite(Double.POSITIVE_INFINITY) : " + isInfinite);

        
        // 8. sum(double a, double b) - Returns the sum of two doubles
        
        double sum = Double.sum(num1, num2);
        
        System.out.println("\nsum(12.34, 56.78) : " + sum);

        
        // 9. max(double a, double b) - Returns the maximum of two doubles
        
        double max = Double.max(num1, num2);
        
        System.out.println("\nmax(12.34, 56.78) : " + max);

        
        // 10. min(double a, double b) - Returns the minimum of two doubles
        
        double min = Double.min(num1, num2);
        
        System.out.println("\nmin(12.34, 56.78) : " + min);

        
        // 11. toHexString(double d) - Returns the hexadecimal representation of the double
        
        String hexString = Double.toHexString(num1);
        
        System.out.println("\ntoHexString(12.34) : " + hexString);

        
        // 12. hashCode(double value) - Returns the hash code of the double
        
        int hashCode = Double.hashCode(num1);
        
        System.out.println("\nhashCode(12.34) : " + hashCode);

        
        
        // 13. doubleToLongBits(double value) - Converts the double to its IEEE 754 representation as a long
        
        long doubleToBits = Double.doubleToLongBits(num1);
        
        System.out.println("\ndoubleToLongBits(12.34) : " + doubleToBits);

        
        // 14. longBitsToDouble(long bits) - Converts the IEEE 754 representation as a long back to a double
        
        double bitsToDouble = Double.longBitsToDouble(doubleToBits);
        
        System.out.println("\nlongBitsToDouble(doubleToLongBits(12.34)) : " + bitsToDouble);
        
        
       
        System.out.println("\nDouble class methods: (Non- Static)");
        
        // 15. compareTo(Double anotherDouble) - Compares this Double object with another
        
        int compareToResult = doubleObj1.compareTo(doubleObj2);
        
        System.out.println("\ncompareTo(56.78) : " + compareToResult);

        
        // 16. equals(Object obj) - Checks if the Double object is equal to another object
        
        boolean isEqual = doubleObj1.equals(doubleObj2);
        
        System.out.println("\nequals(56.78) : " + isEqual);

        
        
        // 17. hashCode() - Returns the hash code for the Double object
        
        int hashCode1 = doubleObj1.hashCode();
        
        System.out.println("\nhashCode(12.34) : " + hashCode1);

        
        // 18. isNaN() - Checks if the Double object is NaN
        
        boolean isNan1 = nanDouble.isNaN();
        
        System.out.println("\nisNaN(Double.NaN) : " + isNan1);

        
        // 19. isInfinite() - Checks if the Double object is infinite
        
        boolean isInfinite1 = infiniteDouble.isInfinite();
        
        System.out.println("\nisInfinite(Double.POSITIVE_INFINITY) : " + isInfinite1);

        
        // 20. toString() - Converts the Double object to its string representation
        
        String doubleToString1 = doubleObj1.toString();
        
        System.out.println("\ntoString() : " + doubleToString1);

        
        // 21. doubleValue() - Converts the Double object to a primitive double
        
        double primitiveDouble = doubleObj1.doubleValue();
        
        System.out.println("\ndoubleValue() : " + primitiveDouble);

        
        // 22. byteValue() - Converts the Double object to a byte
        
        byte byteValue = doubleObj1.byteValue();
        
        System.out.println("\nbyteValue() : " + byteValue);

        
        // 23. shortValue() - Converts the Double object to a short
        
        short shortValue = doubleObj1.shortValue();
        
        System.out.println("\nshortValue() : " + shortValue);

        
        // 24. intValue() - Converts the Double object to an int
        
        int intValue = doubleObj1.intValue();
        
        System.out.println("\nintValue() : " + intValue);
        
        
        System.out.println("Double wrapper class Cnstants:");

       
        // 25. Double.MAX_VALUE - Largest positive finite value of type double
        
        System.out.println("\nDouble.MAX_VALUE : " + Double.MAX_VALUE);  // Maximum value that a double can hold

        
        // 26. Double.MIN_VALUE - Smallest positive non-zero value of type double
        
        System.out.println("\nDouble.MIN_VALUE : " + Double.MIN_VALUE);  // Smallest positive number

        
        // 27. Double.SIZE - The number of bits used to represent a double value (64 bits)
        
        System.out.println("\nDouble.SIZE : " + Double.SIZE);

        
        // 28. Double.BYTES - The number of bytes used to represent a double value (8 bytes)
        
        System.out.println("\nDouble.BYTES : " + Double.BYTES);

        
        // 29. Double.TYPE - The Class type for the Double class
        
        System.out.println("\nDouble.TYPE : " + Double.TYPE);

        
        // 30. Double.POSITIVE_INFINITY - Represents positive infinity
        
        System.out.println("\nDouble.POSITIVE_INFINITY : " + Double.POSITIVE_INFINITY);

        
        // 31. Double.NEGATIVE_INFINITY - Represents negative infinity
        
        System.out.println("\nDouble.NEGATIVE_INFINITY : " + Double.NEGATIVE_INFINITY);

        
        // 32. Double.NaN - Represents "Not-a-Number"
        
        System.out.println("\nDouble.NaN : " + Double.NaN);
    
        
    }

}
