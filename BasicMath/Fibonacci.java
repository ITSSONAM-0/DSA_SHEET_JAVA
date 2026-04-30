package DSA_SHEET_JAVA.BasicMath;

public class Fibonacci {

    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        int count = 10;

        for (int i = 0; i < count; i++) {
            System.out.println(fibo(i));
        }
    }
}
