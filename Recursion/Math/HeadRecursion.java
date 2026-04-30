package DSA_SHEET_JAVA.Recursion.Math;

class HeadRecursion {
    static void headRecursion(int count) {
        if (count == 5)
            return; // Base case
        headRecursion(count + 1); // Recursive call first
        System.out.println(count); // Operation after recursive call

    }

    public static void main(String[] args) {
        headRecursion(1); // Start from 5
    }
}
