import java.io.*;

public class FileHandlingExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // Create and Write to File
        writeFile(fileName, "Hello, this is a file handling example in Java.\n");

        // Append Data to File
        appendToFile(fileName, "Appending a new line to the file.\n");

        // Read and Display File Content
        readFile(fileName);

        // Delete File
        deleteFile(fileName);
    }

    // Method to Write to File
    public static void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Method to Append Data to File
    public static void appendToFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(content);
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while appending data.");
            e.printStackTrace();
        }
    }

    // Method to Read File
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    // Method to Delete File
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
