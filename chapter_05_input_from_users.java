import java.util.Scanner;

public class chapter_05_input_from_users {



    public static void main(String[] args) {   //Type "main" for print public static void main(String[] args) {....}

        System.out.println("Hii, here you can see your percentage"); // Type "sout" for print: System.out.println();

        System.out.println("Enter your Marks");
        Scanner sc = new Scanner(System.in);
        System.out.print("Maths:  ");
        float M = sc.nextInt();
        System.out.print("Science:  ");
        float S = sc.nextInt();
        System.out.print("Social Studies: ");
        float SST = sc.nextInt();
        System.out.print("Hindi; ");
        float H = sc.nextInt();
        System.out.print("English: ");
        int E = sc.nextInt();
        float P = M + S + SST + H + E;
        System.out.println("Your total Marks is: " + P);
        float per = P/5;
        System.out.println("Your percentage is: " + per);








    }
}
