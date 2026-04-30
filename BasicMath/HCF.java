package DSA_SHEET_JAVA.BasicMath;

import java.util.Scanner;

public class HCF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first Number : ");
        int a = sc.nextInt();
        System.out.print("Enter the second number : ");
        int b = sc.nextInt();
        int hcf = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                hcf = i;
            }
        }
        System.out.println(hcf);
        sc.close();
    }
}
