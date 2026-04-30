package DSA_SHEET_JAVA.Recursion.Math;

public class print1toN {
    static void fun(int n, int i) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        fun(n, i + 1);
    }

    public static void main(String[] args) {
        int n = 5;
        int i = 1;
        fun(n, i);
    }
}
