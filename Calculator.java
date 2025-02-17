import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial number: ");
        double result = scanner.nextDouble();

        while (true) {
            System.out.print("Enter an operator (+, -, *, /) or 'q' to quit: ");
            char operator = scanner.next().charAt(0);

            if (operator == 'q') {
                break;
            }

            System.out.print("Enter next number: ");
            double num = scanner.nextDouble();

            switch (operator) {
                case '+':
                    result += num;
                    break;
                case '-':
                    result -= num;
                    break;
                case '*':
                    result *= num;
                    break;
                case '/':
                    if (num != 0) {
                        result /= num;
                    } else {
                        System.out.println("Error! Division by zero is not allowed.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Invalid operator!");
                    continue;
            }

            System.out.println("Current result: " + result);
        }

        System.out.println("Final result: " + result);
        scanner.close();
    }
}
