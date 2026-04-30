package DSA_SHEET_JAVA.Stacks.Implementations.Easy;

import java.util.*;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                arr[stack.pop()] = nums[i % n];
            }

            if (i < n) {
                stack.push(i);
            }
        }
        return arr;
    }
}
