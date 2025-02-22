import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialDifferentiation {

    // Method to differentiate a term like "3x^2" -> "6x"
    public static String differentiateTerm(String term) {
        Pattern pattern = Pattern.compile("([+-]?\\d*)x\\^?(\\d*)");
        Matcher matcher = pattern.matcher(term);

        if (matcher.matches()) {
            String coefficientStr = matcher.group(1);
            String exponentStr = matcher.group(2);

            int coefficient = coefficientStr.isEmpty() || coefficientStr.equals("+") ? 1
                    : coefficientStr.equals("-") ? -1
                    : Integer.parseInt(coefficientStr);
            int exponent = exponentStr.isEmpty() ? 1 : Integer.parseInt(exponentStr);

            if (exponent == 0) {
                return "0"; // Derivative of a constant is 0
            }

            int newCoefficient = coefficient * exponent;
            int newExponent = exponent - 1;

            if (newExponent == 0) {
                return String.valueOf(newCoefficient);
            } else if (newExponent == 1) {
                return newCoefficient + "x";
            } else {
                return newCoefficient + "x^" + newExponent;
            }
        }

        return "0"; // Default case (constant term)
    }

    // Method to differentiate a polynomial step by step
    public static String differentiatePolynomial(String polynomial) {
        String[] terms = polynomial.split(" ");
        StringBuilder derivative = new StringBuilder();

        System.out.println("\nStep-by-Step Differentiation:");

        for (String term : terms) {
            if (term.equals("+") || term.equals("-")) {
                derivative.append(" ").append(term).append(" ");
                continue;
            }

            String differentiatedTerm = differentiateTerm(term);
            System.out.println("Derivative of " + term + " is: " + differentiatedTerm);

            if (!differentiatedTerm.equals("0")) {
                derivative.append(differentiatedTerm).append(" ");
            }
        }

        return derivative.toString().trim();
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a polynomial (e.g., 3x^2 + 5x - 7): ");
        String polynomial = scanner.nextLine().replaceAll("\\s+", " "); // Normalize spaces

        String result = differentiatePolynomial(polynomial);
        System.out.println("\nFinal Derivative: " + result);

        scanner.close();
    }
}
