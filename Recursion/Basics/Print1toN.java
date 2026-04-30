package DSA_SHEET_JAVA.Recursion.Basics;

public class Print1toN {

    static void printn(int n) {

        if (n == 0) {
            return;
        }

        printn(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int n = 5;
        printn(n);

    }
}
