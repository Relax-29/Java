import java.util.Scanner;

public class DefiniteMultipleIntegration {

    // Method to perform definite integration of x^n
    public static double integrateTerm(double coefficient, int exponent, double lower, double upper) {
        int newExponent = exponent + 1;
        double newCoefficient = coefficient / newExponent;

        // Compute definite integral F(b) - F(a)
        double upperValue = newCoefficient * Math.pow(upper, newExponent);
        double lowerValue = newCoefficient * Math.pow(lower, newExponent);

        return upperValue - lowerValue;
    }

    // Method for definite single-variable integration
    public static double definiteIntegral(String function, String variable, double lower, double upper) {
        String[] terms = function.split(" ");
        double result = 0.0;

        System.out.println("\nStep-by-Step Definite Integration with respect to " + variable + " from " + lower + " to " + upper + ":");

        for (String term : terms) {
            if (term.equals("+") || term.equals("-")) continue;

            // Handling simple polynomial ax^n
            if (term.matches("([+-]?\\d*)x\\^?(\\d*)")) {
                String[] parts = term.split("x\\^?");
                double coefficient = parts[0].isEmpty() ? 1 : Double.parseDouble(parts[0]);
                int exponent = parts.length > 1 ? Integer.parseInt(parts[1]) : 1;

                double integralValue = integrateTerm(coefficient, exponent, lower, upper);
                System.out.println("∫ " + term + " d" + variable + " from " + lower + " to " + upper + " = " + integralValue);
                result += integralValue;
            }

            // Handling trigonometric functions
            else if (term.equals("sin(x)")) {
                double integralValue = -Math.cos(upper) + Math.cos(lower);
                System.out.println("∫ sin(x) dx from " + lower + " to " + upper + " = " + integralValue);
                result += integralValue;
            } else if (term.equals("cos(x)")) {
                double integralValue = Math.sin(upper) - Math.sin(lower);
                System.out.println("∫ cos(x) dx from " + lower + " to " + upper + " = " + integralValue);
                result += integralValue;
            }
        }
        return result;
    }

    // Main function for double and triple definite integration
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a function to integrate: ");
        String function = scanner.nextLine().replaceAll("\\s+", " "); // Normalize spaces

        System.out.print("Enter the first variable for integration (e.g., x): ");
        String var1 = scanner.next();
        System.out.print("Enter lower limit of " + var1 + ": ");
        double lower1 = scanner.nextDouble();
        System.out.print("Enter upper limit of " + var1 + ": ");
        double upper1 = scanner.nextDouble();

        double firstIntegral = definiteIntegral(function, var1, lower1, upper1);
        System.out.println("\nFirst Integral Value: " + firstIntegral);

        System.out.print("\nDo you want to integrate again? (y/n): ");
        char choice = scanner.next().charAt(0);
        if (choice == 'y' || choice == 'Y') {
            System.out.print("Enter the second variable for integration (e.g., y): ");
            String var2 = scanner.next();
            System.out.print("Enter lower limit of " + var2 + ": ");
            double lower2 = scanner.nextDouble();
            System.out.print("Enter upper limit of " + var2 + ": ");
            double upper2 = scanner.nextDouble();

            double secondIntegral = definiteIntegral(String.valueOf(firstIntegral), var2, lower2, upper2);
            System.out.println("\nSecond Integral Value: " + secondIntegral);

            System.out.print("\nDo you want a third integration? (y/n): ");
            choice = scanner.next().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                System.out.print("Enter the third variable for integration (e.g., z): ");
                String var3 = scanner.next();
                System.out.print("Enter lower limit of " + var3 + ": ");
                double lower3 = scanner.nextDouble();
                System.out.print("Enter upper limit of " + var3 + ": ");
                double upper3 = scanner.nextDouble();

                double thirdIntegral = definiteIntegral(String.valueOf(secondIntegral), var3, lower3, upper3);
                System.out.println("\nFinal (Triple) Integral Value: " + thirdIntegral);
            }
        }

        scanner.close();
    }
}
