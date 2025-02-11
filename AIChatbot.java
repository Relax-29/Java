import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AIChatbot {
    private static final Map<String, String> responses = new HashMap<>();

    static {
        responses.put("hello", "Hi there! How can I help you?");
        responses.put("how are you", "I'm just a bot, but I'm doing great! How about you?");
        responses.put("bye", "Goodbye! Have a great day!");
        responses.put("your name", "I'm a simple AI chatbot built in Java.");
        responses.put("who created you", "I was created by a Java developer like you!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chatbot: Hello! Type 'exit' to end the chat.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            }

            String response = responses.getOrDefault(input, "I'm not sure how to respond to that.");
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }
}
