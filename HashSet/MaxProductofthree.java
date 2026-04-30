package DSA_SHEET_JAVA.HashSet;

import java.util.Arrays;
import java.util.HashSet;

public class MaxProductofthree {

    static int maxProduct(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        int nums[] = new int[hs.size()];
        int i = 0;
        for (int val : hs) {
            nums[i] = val;
            i++;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int one = nums[n - 1];
        int two = nums[n - 2];
        int three = nums[n - 3];

        return one * two * three;

    }

    public static void main(String[] args) {
        int arr[] = { 852, -566, 182, -638, -693, -323 };

        int ans = maxProduct(arr);
        System.out.println(ans);

    }
}