package DSA_SHEET_JAVA.Arrays.SubArrays;

public class BasicSubArray {

    static void subarray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    static void maximumsubarray(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        subarray(arr);
        maximumsubarray(arr);

    }
}