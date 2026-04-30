package DSA_SHEET_JAVA.Recursion.Math;

//print string n times

public class StringNTimes {

    static void name(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println("vaiju");
        name(i + 1, n);

    }

    public static void main(String[] args) {
        int n = 5;
        int i = 1;
        name(i, n);
    }
}