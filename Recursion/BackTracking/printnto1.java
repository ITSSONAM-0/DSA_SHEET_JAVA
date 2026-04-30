package DSA_SHEET_JAVA.Recursion.BackTracking;

public class printnto1 {

    static void fun(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        fun(n - 1);

    }

    public static void main(String[] args) {
        int n = 5;
        fun(n);
    }
}
