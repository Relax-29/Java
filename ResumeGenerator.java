import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class ResumeGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Theme selection
        System.out.println("Choose a theme: \n1. Classic\n2. Modern\n3. Creative");
        int themeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Collect user details
        System.out.print("Enter your full name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        System.out.print("Enter your education details: ");
        String education = scanner.nextLine();

        System.out.print("Enter your skills (comma-separated): ");
        String skills = scanner.nextLine();

        System.out.print("Enter your experience details: ");
        String experience = scanner.nextLine();

        System.out.print("Enter your projects: ");
        String projects = scanner.nextLine();

        scanner.close();

        // Create PDF Document
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("resume.pdf"));
            document.open();

            // Apply theme-based styling
            Font titleFont;
            Font sectionFont;
            Font contentFont;

            if (themeChoice == 2) { // Modern Theme
                titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLUE);
                sectionFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.DARK_GRAY);
                contentFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
            } else if (themeChoice == 3) { // Creative Theme
                titleFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 22, BaseColor.MAGENTA);
                sectionFont = FontFactory.getFont(FontFactory.COURIER_BOLD, 16, BaseColor.ORANGE);
                contentFont = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);
            } else { // Classic Theme (Default)
                titleFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, BaseColor.BLACK);
                sectionFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, BaseColor.BLACK);
                contentFont = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.BLACK);
            }

            // Add content to PDF with selected theme
            document.add(new Paragraph("Resume", titleFont));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph("Name: " + name, contentFont));
            document.add(new Paragraph("Email: " + email, contentFont));
            document.add(new Paragraph("Phone: " + phone, contentFont));
            document.add(new Paragraph("Address: " + address, contentFont));
            document.add(new Paragraph("\nEducation:", sectionFont));
            document.add(new Paragraph(education, contentFont));
            document.add(new Paragraph("\nSkills:", sectionFont));
            document.add(new Paragraph(skills, contentFont));
            document.add(new Paragraph("\nExperience:", sectionFont));
            document.add(new Paragraph(experience, contentFont));
            document.add(new Paragraph("\nProjects:", sectionFont));
            document.add(new Paragraph(projects, contentFont));

            document.close();
            System.out.println("Resume saved as resume.pdf with selected theme.");
        } catch (DocumentException | IOException e) {
            System.out.println("An error occurred while writing the PDF file.");
            e.printStackTrace();
        }
    }
}
