package DSA_SHEET_JAVA.Recursion.BackTracking;

public class Print1ton {
    static void fun(int n) {
        if (n == 0) {
            return;
        }
        fun(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 5;
        fun(n);
    }
}
