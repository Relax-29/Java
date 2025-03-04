import java.util.Scanner;

public class ParagraphEnhancer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder paragraph = new StringBuilder();

        System.out.println("Enter your paragraph (type 'EXIT' to finish):");

        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("EXIT")) {
                break;
            }
            paragraph.append(line.trim()).append(" ");
        }

        System.out.println("\nChoose an option: ");
        System.out.println("1. Enhance Clarity");
        System.out.println("2. Change Tone to Formal");
        System.out.println("3. Change Tone to Casual");
        System.out.println("4. Change Tone to Creative");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        String formattedParagraph = paragraph.toString().trim().replaceAll("\\s+", " ");
        String enhancedParagraph = enhanceParagraph(formattedParagraph, choice);

        System.out.println("\nEnhanced Paragraph:\n" + enhancedParagraph);
        scanner.close();
    }

    public static String enhanceParagraph(String text, int choice) {
        switch (choice) {
            case 1:
                return text.replaceAll("very ", "extremely ")
                        .replaceAll("really ", "significantly ");
            case 2:
                return text.replaceAll("I'm", "I am")
                        .replaceAll("gonna", "going to")
                        .replaceAll("wanna", "want to")
                        .replaceAll("can't", "cannot")
                        .replaceAll("it's", "it is");
            case 3:
                return text.replaceAll("cannot", "can't")
                        .replaceAll("do not", "don't")
                        .replaceAll("is not", "isn't")
                        .replaceAll("have to", "gotta");
            case 4:
                return text.replaceAll("good", "fantastic")
                        .replaceAll("bad", "terrible")
                        .replaceAll("happy", "overjoyed")
                        .replaceAll("sad", "heartbroken");
            default:
                return text;
        }
    }
}
