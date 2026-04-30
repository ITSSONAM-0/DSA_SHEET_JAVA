package DSA_SHEET_JAVA.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrat {

    // better solution
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }

        }
        return count;
    }

    // optimal solution

    @SuppressWarnings("unchecked")
    public static int findAllSubarraysWithGivenSum(int arr[], int k) {
        int n = arr.length; // size of the given array.
        Map mpp = new HashMap();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += (int) mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, (int) mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 4 };
        int k = 6;
        int cnt = findAllSubarraysWithGivenSum(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }
}
