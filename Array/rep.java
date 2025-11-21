import java.util.*;

public class rep {
    public static int[] findMissingAndRepeating(int[][] grid) {
        int n = grid.length;
        int N = n * n;

        boolean[] seen = new boolean[N + 1];
        int repeating = -1;
        long actualSum = 0;

        // Traverse the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                actualSum += val;

                if (seen[val]) {
                    repeating = val;
                } else {
                    seen[val] = true;
                }
            }
        }

        long expectedSum = (long) N * (N + 1) / 2;
        int missing = (int) (expectedSum - (actualSum - repeating));

        return new int[] { repeating, missing };
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 3 },
                { 2, 2 }
        };

        int[] ans = findMissingAndRepeating(grid);
        System.out.println("Repeating: " + ans[0]);
        System.out.println("Missing: " + ans[1]);
    }
}
// You are given a 0-indexed 2D integer matrix grid of size n * n with values in
// the range [1, n2]. Each integer appears exactly once except a which appears
// twice and b which is missing. The task is to find the repeating and missing
// numbers a and b. Return a 0-indexed integer array ans of size 2 where ans[0]
// equals to a and ans[1] equals to b.