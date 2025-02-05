import java.util.Scanner;

public class a_inverse {
    public static void main(String[] args) {

        System.out.println("Check P and Q matrix ");
        System.out.println("Enter the value of A of order 3*3 element by element ");
        Scanner S = new Scanner(System.in);
        // Find A inverse
        System.out.print("a11: ");
        float a11 = S.nextInt();

        System.out.print("a12: ");
        float a12 = S.nextInt();

        System.out.print("a13: ");
        float a13 = S.nextInt();

        System.out.print("a21: ");
        float a21 = S.nextInt();

        System.out.print("a22: ");
        float a22 = S.nextInt();

        System.out.print("a23: ");
        float a23 = S.nextInt();

        System.out.print("a31: ");
        float a31 = S.nextInt();

        System.out.print("a32: ");
        float a32 = S.nextInt();

        System.out.print("a33: ");
        int a33 = S.nextInt();
        // Solve brakets
        float a2233 = a22 * a33;
        float a2332 = a32 * a23;
        float a2133 = a21 * a33;
        float a2331 = a23 * a31;
        float a2132 = a21 * a32;
        float a3122 = a31 * a22;
        float a1233 = a12 * a33;
        float a1332 = a13 * a32;
        float a1133 = a11 * a33;
        float a1331 = a13 * a31;
        float a1132 = a11 * a32;
        float a3112 = a31 * a12;
        float a1223 = a12 * a23;
        float a1322 = a13 * a22;
        float a1123 = a11 * a23;
        float a1321 = a13 * a21;
        float a1122 = a11 * a22;
        float a1221 = a12 * a21;

        float A112233 = a2233 - a2332;
        float A122133 = a2133 - a2331;
        float A132132 = a2132 - a3122;
        float A211233 = a1233 - a1332;
        float A221133 = a1133 - a1331;
        float A231132 = a1132 - a3112;
        float A311223 = a1223 - a1322;
        float A321123 = a1123 - a1321;
        float A331122 = a1122 - a1221;


        // |A|
        float detA11 = (int) (a11 * A112233);
        float detA12 = a12 * A122133;
        float detA13 = a13 * A132132;

        float detA = detA11 - detA12 + detA13;
        if (detA == 0) {
            System.out.println("A inverse does no exist and the value of non-singular P and Q does not possible");
            return;
        }


        // Adjoint A
        float A11 = A112233 / detA;
        float A12 = -A122133 / detA;
        float A13 = A132132 / detA;
        float A21 = -A211233 / detA;
        float A22 = A221133 / detA;
        float A23 = -A231132 / detA;
        float A31 = A311223 / detA;
        float A32 = -A321123 / detA;
        float A33 = A331122 / detA;


        System.out.println("By the element by element values A inverse is: ");
        System.out.println("A11: " + A11);
        System.out.println("A12: " + A21);
        System.out.println("A13: " + A31);
        System.out.println("A21: " + A12);
        System.out.println("A22: " + A22);
        System.out.println("A23: " + A32);
        System.out.println("A31: " + A13);
        System.out.println("A32: " + A23);
        System.out.println("A33: " + A33);

        //NEW
        System.out.print(" --");
        System.out.println("                 --");

        System.out.print("|  ");
        System.out.print(A11);
        System.out.print("     ");
        System.out.print(A21);
        System.out.print("     ");
        System.out.print(A31);
        System.out.println("  |");
        System.out.print("|  ");
        System.out.print(A12);
        System.out.print("     ");
        System.out.print(A22);
        System.out.print("     ");
        System.out.print(A32);
        System.out.println("  |");
        System.out.print("|  ");
        System.out.print(A13);
        System.out.print("     ");
        System.out.print(A23);
        System.out.print("     ");
        System.out.print(A33);
        System.out.println("  |");
        System.out.print(" --");
        System.out.println("                 --");


//      Check P and Q
        System.out.println("Check whether  P and Q matrix of 3*3 order is correct or wrong ");
        //Input P
        System.out.println("Enter the value of P of order 3*3 ");
        Scanner P = new Scanner(System.in);

        System.out.print("a11: ");
        float P11 = P.nextInt();

        System.out.print("a12: ");
        float P12 = P.nextInt();

        System.out.print("a13: ");
        float P13 = P.nextInt();

        System.out.print("a21: ");
        float P21 = P.nextInt();

        System.out.print("a22: ");
        float P22 = P.nextInt();

        System.out.print("a23: ");
        float P23 = P.nextInt();

        System.out.print("a31: ");
        float P31 = P.nextInt();

        System.out.print("a32: ");
        float P32 = P.nextInt();

        System.out.print("a33: ");
        float P33 = P.nextInt();

//        System.out.println(PA12);
        //Input Q

        System.out.println("Enter the value of Q of order 3*3 ");
        Scanner Q = new Scanner(System.in);

        System.out.print("a11: ");
        float Q11 = Q.nextInt();

        System.out.print("a12: ");
        float Q12 = Q.nextInt();

        System.out.print("a13: ");
        float Q13 = Q.nextInt();

        System.out.print("a21: ");
        float Q21 = Q.nextInt();

        System.out.print("a22: ");
        float Q22 = Q.nextInt();

        System.out.print("a23: ");
        float Q23 = Q.nextInt();

        System.out.print("a31: ");
        float Q31 = Q.nextInt();

        System.out.print("a32: ");
        float Q32 = Q.nextInt();

        System.out.print("a33: ");
        float Q33 = Q.nextInt();

//        System.out.println(QA12);

        // Find QP

        float PQ1111 = Q11 * P11;
        float PQ1221 = Q12 * Q21;
        float PQ1331 = P31 * Q13;
        float PQ1112 = Q11 * P12;
        float PQ1222 = Q12 * P22;
        float PQ1332 = Q13 * P32;
        float PQ1113 = Q11 * P13;
        float PQ1223 = Q12 * P23;
        float PQ1333 = Q13 * P33;
        float PQ2111 = Q21 * P11;
        float PQ2221 = Q22 * P21;
        float PQ2331 = Q23 * P31;
        float PQ2112 = Q21 * P12;
        float PQ2222 = Q22 * P22;
        float PQ2332 = P32 * Q23;
        float PQ2113 = Q21 * P13;
        float PQ2223 = P23 * Q22;
        float PQ2333 = Q23 * P33;
        float PQ3111 = Q31 * P11;
        float PQ3221 = Q32 * P21;
        float PQ3331 = Q33 * P31;
        float PQ3112 = Q31 * P12;
        float PQ3222 = Q32 * P22;
        float PQ3332 = P32 * Q33;
        float PQ3113 = Q31 * P13;
        float PQ3223 = P23 * Q32;
        float PQ3333 = Q33 * P33;


        int QP11 = (int) (PQ1111 + PQ1221 + PQ1331);
        int QP12 = (int) (PQ1112 + PQ1222 + PQ1332);
        int QP13 = (int) (PQ1113 + PQ1223 + PQ1333);
        int QP21 = (int) (PQ2111 + PQ2221 + PQ2331);
        int QP22 = (int) (PQ2112 + PQ2222 + PQ2332);
        int QP23 = (int) (PQ2113 + PQ2223 + PQ2333);
        int QP31 = (int) (PQ3111 + PQ3221 + PQ3331);
        int QP32 = (int) (PQ3112 + PQ3222 + PQ3332);
        int QP33 = (int) (PQ3113 + PQ3223 + PQ3333);


        System.out.println("By the element by element values QP is: ");
        System.out.println("A11: " + QP11);
        System.out.println("A12: " + QP12);
        System.out.println("A13: " + QP13);
        System.out.println("A21: " + QP21);
        System.out.println("A22: " + QP22);
        System.out.println("A23: " + QP23);
        System.out.println("A31: " + QP31);
        System.out.println("A32: " + QP32);
        System.out.println("A33: " + QP33);


//
        //Check The value of P and Q

        boolean A = QP11 == A11 && QP12 == A21 && QP13 == A31 && QP21 == A12 && QP22 == A22 && QP23 == A32 && QP31 == A13 && QP32 == A23 && QP33 == A33;


        //NEW
        System.out.print(" --");
        System.out.println("                 --");

        System.out.print("|  ");
        System.out.print(QP11);
        System.out.print("     ");
        System.out.print(QP12);
        System.out.print("     ");
        System.out.print(QP13);
        System.out.println("  |");
        System.out.print("|  ");
        System.out.print(QP21);
        System.out.print("     ");
        System.out.print(QP22);
        System.out.print("     ");
        System.out.print(QP23);
        System.out.println("  |");
        System.out.print("|  ");
        System.out.print(QP31);
        System.out.print("     ");
        System.out.print(QP32);
        System.out.print("     ");
        System.out.print(QP33);
        System.out.println("  |");
        System.out.print(" --");
        System.out.println("                 --");

        if (A == false) {
            System.out.println("The value of P and Q is not correct");
        }

        else if (A==true) {
            System.out.println("The value of P and Q are correct");
        }
    }

}

