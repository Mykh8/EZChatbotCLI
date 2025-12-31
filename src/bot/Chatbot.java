package bot;

import input.InputHandler;

import java.util.Scanner;

public class Chatbot {
    private final InputHandler inputHandler;
    public Chatbot(Scanner scanner) {
        this.inputHandler = new InputHandler(scanner);
    }

    public void run() {
        while (true) {
            inputHandler.showMenu();
            int userMenuOption = inputHandler.getUserMenuOption();

            if (!inputHandler.isValidMenuOption(userMenuOption)) {
                System.out.println("ERROR: Invalid option\n");
                continue;
            }

            if (userMenuOption == 0) {
                System.out.println("Bye!");
                break;
            }

            execute(userMenuOption);
        }
    }

    public void execute(int userOption) {
        switch (userOption) {
            case 1 -> startChat();
            case 2 -> System.out.println(2);
        }
    }

    public void startChat() {
        
    }
}