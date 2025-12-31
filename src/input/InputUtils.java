package input;

import java.util.Scanner;

public class InputUtils {
    private final Scanner scanner;
    public InputUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public String askForString(String prompt, boolean isRequired) {
        while (true) {
            System.out.print(prompt);
            String userInput = scanner.nextLine();

            if (!isRequired || !userInput.isBlank()) {
                return userInput;
            }

            System.out.println("ERROR: This field is required.");
            System.out.println();
        }
    }

    public int askForInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            System.out.println("ERROR: An valid integer is required.\n");
            scanner.nextLine();
        }
    }
}