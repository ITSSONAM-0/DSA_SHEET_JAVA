public class LongestSubarrayLength {

    static int longest(int arr[], int k) {
        int n = arr.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int maxlen = 0;

        while (r < n) {
            sum = sum + arr[r];

            while (sum > k && l <= r) {  // Shrink the window if sum exceeds k
                sum = sum - arr[l];
                l = l + 1;
            }

            if (sum <= k) {
                maxlen = Math.max(maxlen, r - l + 1); // Length = r - l + 1
            }

            r++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 1, 10, 10};
        int k = 14;
        int ans = longest(arr, k);
        System.out.println(ans);  // Output: 3
    }
}
