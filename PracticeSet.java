import java.util.Scanner;

public class PracticeSet {

    public static void main(String[] args) {
        System.out.println("Enter three numbers");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number 1: ");
        int A = sc.nextInt();
        System.out.print("Enter Number 2: ");
        int B = sc.nextInt();
        System.out.print("Enter Number 3: ");
        int C = sc.nextInt();
        int T = A + B + C;

        System.out.println(A + " + " + B + " + " + C + " = " + T);



    }

}
