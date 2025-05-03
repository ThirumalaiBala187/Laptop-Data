package WrapperClassMethods;

public class CharacterMethods {

    public static void main(String[] args) {

        char ch1 = 'A';
       
        char ch2 = 'b';
        
        char ch3 = '1';
        
        char ch4 = ' ';
        
        int radix = 16;
        
        int codePoint = 65;

        System.out.println("Character Wrapper Class Methods (Static):");

        // 1. isLetter(char ch)
        
        System.out.println("\nisLetter('A'): " + Character.isLetter(ch1));

        
        // 2. isDigit(char ch)
        
        System.out.println("\nisDigit('1'): " + Character.isDigit(ch3));

        
        // 3. isWhitespace(char ch)
        
        System.out.println("\nisWhitespace(' '): " + Character.isWhitespace(ch4));

        
        // 4. isUpperCase(char ch)
        
        System.out.println("\nisUpperCase('A'): " + Character.isUpperCase(ch1));

        
        // 5. isLowerCase(char ch)
        
        System.out.println("\nisLowerCase('b'): " + Character.isLowerCase(ch2));

        
        // 6. toUpperCase(char ch)
        
        System.out.println("\ntoUpperCase('b'): " + Character.toUpperCase(ch2));

        
        // 7. toLowerCase(char ch)
        
        System.out.println("\ntoLowerCase('A'): " + Character.toLowerCase(ch1));

        
        // 8. toString(char c)
        
        System.out.println("\ntoString('A'): " + Character.toString(ch1));

        
        // 9. valueOf(char c)
        
        System.out.println("\nvalueOf('A'): " + Character.valueOf(ch1));

        
        // 10. forDigit(int digit, int radix)
        
        System.out.println("\nforDigit(9, 16): " + Character.forDigit(10, radix));

        
        // 11. isLetterOrDigit(char ch)
        
        System.out.println("\nisLetterOrDigit('A'): " + Character.isLetterOrDigit(ch1));

        
        // 12. getNumericValue(char ch)
        
        System.out.println("\ngetNumericValue('b'): " + Character.getNumericValue(ch2));

        
        // 13. digit(char ch, int radix)
        
        System.out.println("\ndigit('b', 16): " + Character.digit(ch2, radix));

        
        // 14. compare(char x, char y)
        
        System.out.println("\ncompare('A', 'b'): " + Character.compare(ch1, ch2));

        
        // 15. toChars(int codePoint)
        
        System.out.println("\ntoChars(65): " + Character.toChars(133)[0]);

        
        // 16. charCount(int codePoint)
        
        System.out.println("\ncharCount(65): " + Character.charCount(codePoint));

        
        System.out.println("\nCharacter Wrapper Class Methods (Non-Static):");


        Character charObj1 = 'A';
        
        Character charObj2 = 'A';

        
        // 17. charValue()
        
        System.out.println("\ncharValue() of 'A': " + charObj1.charValue());

        
        // 18. equals(Object obj)
        
        System.out.println("\nequals('A', 'A'): " + charObj1.equals(charObj2));

        
        // 19. toString()
        
        System.out.println("\ntoString() of 'A': " + charObj1.toString());

        
        // 20. hashCode()
        
        System.out.println("\nhashCode() of 'A': " + charObj1.hashCode());

        
        System.out.println("\nCharacter Wrapper Class Constants:");

        
        // 1. Character.MAX_VALUE
        
        System.out.println("\nCharacter.MAX_VALUE: " + Character.MAX_VALUE);

        
        // 2. Character.MIN_VALUE
        
        System.out.println("\nCharacter.MIN_VALUE: " + Character.MIN_VALUE +"Hello");

        
        // 3. Character.SIZE
        
        System.out.println("\nCharacter.SIZE: " + Character.SIZE);

        
        // 4. Character.BYTES
        
        System.out.println("\nCharacter.BYTES: " + Character.BYTES);

        
        // 5. Character.TYPE
        
        System.out.println("\nCharacter.TYPE: " + Character.TYPE);
    
    }

}
