import java.util.Scanner;
import org.mariuszgromada.math.mxparser.*;

public class TaylorSeriesMultiVariable {

    // Function to compute factorial
    public static double factorial(int n) {
        double fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Function to compute Taylor series for one variable
    public static double taylorSeries1D(String functionStr, double x0, double x, int order) {
        double sum = 0.0;
        for (int n = 0; n <= order; n++) {
            double derivativeAtX0 = nthDerivative1D(functionStr, n, x0);
            double term = (derivativeAtX0 * Math.pow(x - x0, n)) / factorial(n);
            sum += term;
        }
        return sum;
    }

    // Function to compute nth derivative for one-variable function
    public static double nthDerivative1D(String functionStr, int n, double x0) {
        Function f = new Function("f(x) = " + functionStr);
        Argument x = new Argument("x = " + x0);
        Expression expr = new Expression(f.getFunctionExpressionString(), f, x);

        for (int i = 0; i < n; i++) {
            expr = new Expression("der(f(x), x)", f, x);
        }

        return expr.calculate();
    }

    // Function to compute Taylor series for two-variable functions
    public static double taylorSeries2D(String functionStr, double x0, double y0, double x, double y, int order) {
        double sum = 0.0;
        for (int i = 0; i <= order; i++) {
            for (int j = 0; j <= order - i; j++) {
                double derivativeAtX0Y0 = nthDerivative2D(functionStr, i, j, x0, y0);
                double term = (derivativeAtX0Y0 * Math.pow(x - x0, i) * Math.pow(y - y0, j)) / (factorial(i) * factorial(j));
                sum += term;
            }
        }
        return sum;
    }

    // Function to compute nth derivative for two-variable function
    public static double nthDerivative2D(String functionStr, int i, int j, double x0, double y0) {
        Function f = new Function("f(x,y) = " + functionStr);
        Argument x = new Argument("x = " + x0);
        Argument y = new Argument("y = " + y0);
        Expression expr = new Expression(f.getFunctionExpressionString(), f, x, y);

        for (int k = 0; k < i; k++) {
            expr = new Expression("der(f(x,y), x)", f, x, y);
        }
        for (int k = 0; k < j; k++) {
            expr = new Expression("der(f(x,y), y)", f, x, y);
        }

        return expr.calculate();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose function type: 1 for single-variable f(x), 2 for two-variable f(x, y)");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            // Single variable case
            System.out.println("Enter a function of x (e.g., sin(x), cos(x), exp(x), x^3 + 2*x^2): ");
            String functionStr = scanner.nextLine();

            System.out.print("Enter expansion point (x0): ");
            double x0 = scanner.nextDouble();

            System.out.print("Enter point to evaluate (x): ");
            double x = scanner.nextDouble();

            System.out.print("Enter the order of the Taylor series: ");
            int order = scanner.nextInt();

            double result = taylorSeries1D(functionStr, x0, x, order);
            System.out.println("\nApproximate value using Taylor series: " + result);
        }
        else if (choice == 2) {
            // Two-variable case
            System.out.println("Enter a function of x and y (e.g., x^2 + y^2, sin(x*y), exp(x+y)): ");
            String functionStr = scanner.nextLine();

            System.out.print("Enter expansion point (x0): ");
            double x0 = scanner.nextDouble();

            System.out.print("Enter expansion point (y0): ");
            double y0 = scanner.nextDouble();

            System.out.print("Enter point to evaluate (x): ");
            double x = scanner.nextDouble();

            System.out.print("Enter point to evaluate (y): ");
            double y = scanner.nextDouble();

            System.out.print("Enter the order of the Taylor series: ");
            int order = scanner.nextInt();

            double result = taylorSeries2D(functionStr, x0, y0, x, y, order);
            System.out.println("\nApproximate value using Taylor series: " + result);
        }
        else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
