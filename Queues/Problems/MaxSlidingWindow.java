package DSA_SHEET_JAVA.Queues.Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() <= i - k) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offer(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[dq.peek()];
            }
        }
        return res;
    }
}
