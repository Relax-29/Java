import java.util.Scanner;

public class BetaGammaCalculator {

    // Iterative Gamma function to avoid stack overflow
    public static double gamma(double n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Gamma function is not defined for non-positive values.");
        }
        if (n == 1.0) return 1.0;
        if (n == 0.5) return Math.sqrt(Math.PI);

        double result = 1.0;
        while (n > 1) {
            n--;
            result *= n;
        }
        return result;
    }

    // Beta function using Gamma function
    public static double beta(double x, double y) {
        return gamma(x) * gamma(y) / gamma(x + y);
    }

    // Factorial function for integer values
    public static long factorial(int num) {
        if (num < 0) throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Compute Gamma Function");
            System.out.println("2. Compute Beta Function");
            System.out.println("3. Compute Factorial");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            if (choice == 4) {
                System.out.println("Exiting... Thank you!");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a value for Gamma function: ");
                    double gammaInput = scanner.nextDouble();
                    try {
                        System.out.printf("Gamma(%.2f) = %.5f%n", gammaInput, gamma(gammaInput));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter value x for Beta function: ");
                    double x = scanner.nextDouble();
                    System.out.print("Enter value y for Beta function: ");
                    double y = scanner.nextDouble();
                    try {
                        System.out.printf("Beta(%.2f, %.2f) = %.5f%n", x, y, beta(x, y));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter an integer for factorial calculation: ");
                    int n = scanner.nextInt();
                    try {
                        System.out.println(n + "! = " + factorial(n));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
