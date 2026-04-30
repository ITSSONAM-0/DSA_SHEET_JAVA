package DSA_SHEET_JAVA.Arrays.Medium;

public class BuyAndSellStock {

    static int maxProfit(int[] arr) {
        int n = arr.length;
        int mini = arr[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            int cost = arr[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(arr[i], mini);
        }
        return profit;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };

        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);

    }
}
