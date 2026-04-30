package DSA_SHEET_JAVA.Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    static String twosum(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        int left = 0;
        int rigth = n - 1;
        while (left < rigth) {
            int sum = arr[left] + arr[rigth];
            if (sum == target) {
                return "YES";
            } else if (sum < target)
                left++;
            else {
                rigth--;
            }
        }
        return "NO";
    }

    public static int[] twoSum(int n, int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            mpp.put(arr[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 6, 5, 8, 11 };
        int target = 14;
        String ans = twosum(arr, target);
        System.out.println(ans);
    }
}
