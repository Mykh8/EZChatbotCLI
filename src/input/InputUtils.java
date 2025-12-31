package input;

import java.util.Scanner;

public class InputUtils {
    private final Scanner scanner;
    public InputUtils(Scanner scanner) {
        this.scanner = scanner;
    }

    public int askForInt(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println("ERROR: An valid integer is required.\n");
            scanner.nextLine();
        }
    }
}