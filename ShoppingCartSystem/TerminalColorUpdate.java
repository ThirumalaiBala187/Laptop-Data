package ShoppingCartSystem;

import java.util.Scanner;

public class TerminalColorUpdate {
    // ANSI color codes
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String BLUE = "\033[34m";
    public static final String CLEAR_SCREEN = "\033[H\033[2J";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Initial message
        System.out.println(RED + "This is the initial output in red." + RESET);

        // Ask for color preference
        System.out.print("Enter a new color (red, green, blue): ");
        String colorInput = scanner.nextLine().trim().toLowerCase();

        // Clear the screen
        System.out.print(CLEAR_SCREEN);
        System.out.flush();

        // Reprint with the chosen color
        String selectedColor = switch (colorInput) {
            case "green" -> GREEN;
            case "blue" -> BLUE;
            case "red" -> RED;
            default -> RESET; // Default to no color if input is invalid
        };

        System.out.println(selectedColor + "This is the updated output in " + colorInput + "." + RESET);
    }
}
