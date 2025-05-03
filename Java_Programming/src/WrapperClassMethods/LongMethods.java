package WrapperClassMethods;

public class LongMethods {

    public static void main(String[] args) {

        // Long methods
       
    	long num1 = 123456789L;
        
    	long num2 = 987654321L;

        System.out.println("Long class methods: (Static)");

       
        // 1. parseLong(String s) - Converts a String to a long
        
        long parsedLong = Long.parseLong("12345");
        
        System.out.println("\nparseLong(\"12345\") : " + parsedLong);

        
        // 2. valueOf(String s) - Converts a String to a Long object
        
        Long valueOfString = Long.valueOf("12345");
        
        System.out.println("\nvalueOf(\"12345\") : " + valueOfString);

        
        // 3. valueOf(long l) - Converts a long to a Long object
        
        Long valueOfLong = Long.valueOf(num1);
        
        System.out.println("\nvalueOf(123456789L) : " + valueOfLong);

        
        // 4. toString(long l) - Converts a long to its string representation
        
        String longToString = Long.toString(num1);
        
        System.out.println("\ntoString(123456789L) : " + longToString);


        // 5. toBinaryString(long l) - Converts a long to its binary representation
        
        String binaryString = Long.toBinaryString(num1);
        
        System.out.println("\ntoBinaryString(123456789L) : " + binaryString);

        
        // 6. toHexString(long l) - Converts a long to its hexadecimal representation
        
        String hexString = Long.toHexString(num1);
        
        System.out.println("\ntoHexString(123456789L) : " + hexString);

        
        // 7. toOctalString(long l) - Converts a long to its octal representation
        
        String octalString = Long.toOctalString(num1);
        
        System.out.println("\ntoOctalString(123456789L) : " + octalString);

        
        // 8. toString(long l, int radix) - Converts a long to a string in the specified radix
        
        String radixString = Long.toString(num1, 16);
        
        System.out.println("\ntoString(123456789L, 16) : " + radixString);

        
        // 9. compare(long x, long y) - Compares two long values
        
        int comparison = Long.compare(num1, num2);
        
        System.out.println("\ncompare(123456789L, 987654321L) : " + comparison);

        
        // 10. sum(long a, long b) - Returns the sum of two long values
        
        long sum = Long.sum(num1, num2);
        
        System.out.println("\nsum(123456789L, 987654321L) : " + sum);

        
        // 11. max(long a, long b) - Returns the larger of two long values
        
        long max = Long.max(num1, num2);
        
        System.out.println("\nmax(123456789L, 987654321L) : " + max);

        
        // 12. min(long a, long b) - Returns the smaller of two long values
        
        long min = Long.min(num1, num2);
        
        System.out.println("\nmin(123456789L, 987654321L) : " + min);

        
        // 13. signum(long x) - Returns the signum function of the specified long value
        
        int signum = Long.signum(num1);
        
        System.out.println("\nsignum(123456789L) : " + signum);

        
        // 14. bitCount(long l) - Returns the number of one-bits in the two's complement binary representation
        
        int bitCount = Long.bitCount(num1);
        
        System.out.println("\nbitCount(123456789L) : " + bitCount);

        
        // 15. highestOneBit(long l) - Returns the highest one bit in the two's complement binary representation
        
        long highestOneBit = Long.highestOneBit(num1);
        
        System.out.println("\nhighestOneBit(123456789L) : " + highestOneBit);

        
        // 16. lowestOneBit(long l) - Returns the lowest one bit in the two's complement binary representation
        
        long lowestOneBit = Long.lowestOneBit(num1);
        
        System.out.println("\nlowestOneBit(123456789L) : " + lowestOneBit);

        
        // 17. reverse(long l) - Reverses the order of the bits in the two's complement binary representation
        
        long reversed = Long.reverse(num1);
        
        System.out.println("\nreverse(123456789L) : " + reversed);

        
        // 18. decode(String nm) - Decodes a String into a Long object
        
        Long decodedValue = Long.decode("123456789");
        
        System.out.println("\ndecode(\"123456789\") : " + decodedValue);
        
        
        System.out.println("\nLong class methods: (Non- Static");

        // 19. longValue() - Returns the value of the Long object as a long
        
        long primitiveLong = valueOfLong.longValue();
        
        System.out.println("\nlongValue() : " + primitiveLong);

        
        // 20. toString() - Converts the Long object to a String
        
        String objectToString = valueOfLong.toString();
        
        System.out.println("\ntoString() : " + objectToString);

        
        // 21. compareTo(Long longObj) - Compares this Long object to another Long
        
        int compareToResult = valueOfLong.compareTo(num2);
        
        System.out.println("\ncompareTo(987654321L) : " + compareToResult);

        
        // 22. equals(Object obj) - Checks if this Long object is equal to another object
        
        boolean isEqual = valueOfLong.equals(num2);
        
        System.out.println("\nequals(987654321L) : " + isEqual);

        
        // 23. hashCode() - Returns the hash code for this Long object
        
        int hashCode = valueOfLong.hashCode();
        
        System.out.println("\nhashCode() : " + hashCode);

        
        // 24. byteValue() - Converts the Long object to a byte
        
        byte byteValue = valueOfLong.byteValue();
        
        System.out.println("\nbyteValue() : " + byteValue);

        
        // 25. shortValue() - Converts the Long object to a short
        
        short shortValue = valueOfLong.shortValue();
        
        System.out.println("\nshortValue() : " + shortValue);

        // 26. intValue() - Converts the Long object to an int
        
        int intValue = valueOfLong.intValue();
        
        System.out.println("\nintValue() : " + intValue);

        
        // 27. floatValue() - Converts the Long object to a float
        
        float floatValue = valueOfLong.floatValue();
        
        System.out.println("\nfloatValue() : " + floatValue);

        
        // 28. doubleValue() - Converts the Long object to a double
        
        double doubleValue = valueOfLong.doubleValue();
        
        System.out.println("\ndoubleValue() : " + doubleValue);
        
        
        System.out.println("Long class methods: (Constants");

        
        // 29. Long.MAX_VALUE - The maximum value a long can have
        
        System.out.println("\nLong.MAX_VALUE : " + Long.MAX_VALUE);

        
        // 30. Long.MIN_VALUE - The minimum value a long can have
        
        System.out.println("\nLong.MIN_VALUE : " + Long.MIN_VALUE);

        
        // 31. Long.SIZE - The number of bits used to represent a long
        
        System.out.println("\nLong.SIZE : " + Long.SIZE);

        
        // 32. Long.BYTES - The number of bytes used to represent a long
        
        System.out.println("\nLong.BYTES : " + Long.BYTES);

        
        // 33. Long.TYPE - The class type of the primitive long
        
        System.out.println("\nLong.TYPE : " + Long.TYPE);
    
    }

}
