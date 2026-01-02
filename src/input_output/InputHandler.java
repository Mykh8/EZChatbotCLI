package input_output;

import config.Config;

import java.util.Scanner;

public class InputHandler {
    private final input_output.InputUtils inputUtils;
    public InputHandler(Scanner scanner) {
        this.inputUtils = new InputUtils(scanner);
    }

    // Menu input methods
    public void showMenu() {
        System.out.println();
        System.out.println("""
                ┌─────────────────────────┐
                │      EZChatbot CLI      │
                ├─────────────────────────┤
                │  1. Start new chat      │
                │  2. View chat history   │
                │  0. Exit                │
                └─────────────────────────┘
               \s""");
    }

    public int getUserMenuOption() {
        return inputUtils.askForInt("> Choose an option: ");
    }

    public boolean isValidMenuOption(int userOption) {
        return Config.VALID_MENU_OPTIONS.contains(userOption);
    }

    // Chat output methods
    public String getChatName() {
        return inputUtils.askForString("> How will you name the chat? ", true);
    }

    public void printChatName(String chatName) {
        System.out.println(": Chat name: " + chatName);
        printChatBarrier(20 + chatName.length());
        System.out.println();
    }

    public void printChatBarrier(int amountOfTimes) {
        for (int i = 0; i < amountOfTimes; i++) {
            System.out.print("─");
        }
        System.out.println();
    }

    public void printChatInfoMessage() {
        System.out.println(": To quit the chat - Enter /q command");
        System.out.println(": For more help - Enter /help command");
    }

    // Chat input methods
    public String getUserMessage() {
        return inputUtils.askForString("> [YOU]: ", false);
    }

    public String getSaveYesOrNot() {
        while (true) {
            String userAnswer = inputUtils.askForString("> Would you like to save this chat (Y/N)? ", true);
            userAnswer = userAnswer.toLowerCase().strip();

            if (!userAnswer.equals("y") && !userAnswer.equals("n")) {
                System.out.println(": ERROR: Invalid option, please type either Y or N.");
                System.out.println();
                continue;
            }

            return userAnswer;
        }
    }

}