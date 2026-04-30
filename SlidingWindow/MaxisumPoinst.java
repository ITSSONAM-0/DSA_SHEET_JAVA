public class MaxisumPoinst {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0;
        int rsum = 0;

        // Take the first k elements as initial left sum
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }

        int maxsum = lsum;

        // Slide the window: remove from left, add from right
        for (int i = 1; i <= k; i++) {
            lsum -= cardPoints[k - i];
            rsum += cardPoints[n - i];
            maxsum = Math.max(maxsum, lsum + rsum);
        }

        return maxsum;
    }
    
}