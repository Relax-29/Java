import java.sql.*;
import java.util.Scanner;

public class MCQExamSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/examdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        int score = 0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM questions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                String optionA = rs.getString("optionA");
                String optionB = rs.getString("optionB");
                String optionC = rs.getString("optionC");
                String optionD = rs.getString("optionD");
                String correctAnswer = rs.getString("correctAnswer");

                System.out.println("\n" + question);
                System.out.println("A. " + optionA);
                System.out.println("B. " + optionB);
                System.out.println("C. " + optionC);
                System.out.println("D. " + optionD);
                System.out.print("Your answer: ");
                String userAnswer = scanner.next().toUpperCase();

                if (userAnswer.equals(correctAnswer)) {
                    score++;
                } else {
                    System.out.println("Wrong! Correct answer is: " + correctAnswer);
                }
            }

            // Save student result
            String insertQuery = "INSERT INTO results (name, score) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, studentName);
            pstmt.setInt(2, score);
            pstmt.executeUpdate();

            System.out.println("\nExam completed! " + studentName + " scored: " + score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
