package DSA_SHEET_JAVA.Recursion.Math;

import java.util.Scanner;

public class factorial {

    static int fun(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fun(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Enter any Number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fun(n));
        sc.close();
    }

}