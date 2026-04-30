package DSA_SHEET_JAVA.Arrays.SubArrays;

import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        long result = 0;

        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        // Previous Less Element (PLE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Less Element (NLE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - prevSmaller[i];
            long right = nextSmaller[i] - i;
            result = (result + (arr[i] * left * right) % MOD) % MOD;
        }

        return (int) result;
    }
}
