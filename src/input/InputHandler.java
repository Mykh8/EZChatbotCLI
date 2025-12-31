package input;

import config.Config;

import java.util.Scanner;

public class InputHandler {
    private final InputUtils inputUtils;
    public InputHandler(Scanner scanner) {
        this.inputUtils = new InputUtils(scanner);
    }

    // Menu input methods
    public void showMenu() {
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


}