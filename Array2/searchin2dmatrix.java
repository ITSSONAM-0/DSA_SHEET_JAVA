public class searchin2dmatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };

        int target = 3;

        boolean result = searchMatrix(matrix, target);

        System.out.println("Target found? " + result);
    }
}

// You are given an m x n integer matrix matrix with the following two
// properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the
// previous row.
// Given an integer target, return true if target is in matrix or false
// otherwise.

// You must write a solution in O(log(m * n)) time complexity.