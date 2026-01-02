package bot;

import input_output.InputHandler;

import java.util.Scanner;

import api.AiClient;

public class Chatbot {
    private final InputHandler inputHandler;
    private final AiClient aiClient = new AiClient();

    public Chatbot(Scanner scanner) {
        this.inputHandler = new InputHandler(scanner);
    }

    public void run() {
        while (true) {
            inputHandler.showMenu();
            int userMenuOption = inputHandler.getUserMenuOption();

            if (!inputHandler.isValidMenuOption(userMenuOption)) {
                System.out.println(": ERROR: Invalid option\n");
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
        // get chat name
        String chatName = inputHandler.getChatName();

        // start
        System.out.println();
        inputHandler.printChatBarrier(75);

        // info message to user
        inputHandler.printChatInfoMessage();

        inputHandler.printChatBarrier(75);
        inputHandler.printChatName(chatName);


        // start chat loop
        while (true) {
            // Need message value variable to store it to the database
            String userMsg = inputHandler.getUserMessage();

            if (userMsg.equals("/q")) {
                break; // end chat loop
            }

            System.out.println();
            String response = aiClient.getResponse(userMsg);
            System.out.println("> [BOT]: " + response);
        }

        inputHandler.printChatBarrier(75);

        // end
        stopChat();
    }

    public void stopChat() {
        System.out.println();
        String saveYesOrNot = inputHandler.getSaveYesOrNot();

        if (saveYesOrNot.equals("y")) {
            System.out.println(": INFO: Chat was successfully saved.");
        } else {
            System.out.println(": INFO: Chat data was deleted.");
        }

        inputHandler.printChatBarrier(75);
    }
}