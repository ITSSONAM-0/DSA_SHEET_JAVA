package DSA_SHEET_JAVA.Recursion.Math;

class TailRecursion {
    static void tailRecursion(int count) {
        if (count == 5)
            return; // Base case
        System.out.println(count); // Operation before recursive call
        tailRecursion(count + 1); // Recursive call is last
    }

    public static void main(String[] args) {
        tailRecursion(1); // Start from 5
    }
}
