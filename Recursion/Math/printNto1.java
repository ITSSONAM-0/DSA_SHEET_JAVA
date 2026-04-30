package DSA_SHEET_JAVA.Recursion.Math;

public class printNto1 {
    static void fun(int n, int i) {
        if (n == i) {
            return;
        }
        System.out.println(n);
        fun(n - 1, i);
    }

    public static void main(String[] args) {
        int n = 5;
        int i = 0;
        fun(n, i);
    }
}
