package DSA_SHEET_JAVA.Recursion.Math;

import java.util.Scanner;

public class FibonacciRecusion {

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int last = fib(n - 1);
        int secondlast = fib(n - 2);
        return last + secondlast;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n number: ");
        int n = sc.nextInt();
        System.out.println(fib(n));
        sc.close();
    }
}
