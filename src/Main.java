import java.util.Scanner;

import bot.Chatbot;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Chatbot chatbot = new Chatbot(scanner);

        chatbot.run();
    }
}