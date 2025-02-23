import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedDifferentiation {

    // Method to differentiate a single term
    public static String differentiateTerm(String term) {
        // Polynomial differentiation: ax^n -> a*n*x^(n-1)
        Pattern polyPattern = Pattern.compile("([+-]?\\d*)x\\^?(\\d*)");
        Matcher polyMatcher = polyPattern.matcher(term);

        if (polyMatcher.matches()) {
            String coefficientStr = polyMatcher.group(1);
            String exponentStr = polyMatcher.group(2);

            int coefficient = coefficientStr.isEmpty() || coefficientStr.equals("+") ? 1
                    : coefficientStr.equals("-") ? -1
                    : Integer.parseInt(coefficientStr);
            int exponent = exponentStr.isEmpty() ? 1 : Integer.parseInt(exponentStr);

            if (exponent == 0) return "0"; // Derivative of a constant is 0

            int newCoefficient = coefficient * exponent;
            int newExponent = exponent - 1;

            if (newExponent == 0) return String.valueOf(newCoefficient);
            else if (newExponent == 1) return newCoefficient + "x";
            else return newCoefficient + "x^" + newExponent;
        }

        // Trigonometric differentiation
        if (term.equals("sin(x)")) return "cos(x)";
        if (term.equals("cos(x)")) return "-sin(x)";
        if (term.equals("tan(x)")) return "sec^2(x)";
        if (term.equals("csc(x)")) return "-csc(x)cot(x)";
        if (term.equals("sec(x)")) return "sec(x)tan(x)";
        if (term.equals("cot(x)")) return "-csc^2(x)";

        // Logarithmic differentiation
        if (term.equals("ln(x)")) return "1/x";
        if (term.equals("log(x)")) return "1/(x ln(10))"; // log(x) base 10

        return "0"; // Default case (constant term)
    }

    // Method to differentiate an entire function step by step
    public static String differentiateFunction(String function) {
        String[] terms = function.split(" ");
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

        System.out.print("Enter a function (e.g., 3x^2 + sin(x) - ln(x)): ");
        String function = scanner.nextLine().replaceAll("\\s+", " "); // Normalize spaces

        String result = differentiateFunction(function);
        System.out.println("\nFinal Derivative: " + result);

        scanner.close();
    }
}
