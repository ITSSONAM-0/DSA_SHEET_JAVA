package DSA_SHEET_JAVA.Arrays.Hard;

public class CountInversion {
    static int inversionCount(int arr[]) {
        int temp[] = new int[arr.length]; // Temporary array for merge sort
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    // Merge Sort function
    private static int mergeSort(int arr[], int temp[], int left, int right) {
        int mid, count = 0;
        if (left < right) {
            mid = (left + right) / 2;
            count += mergeSort(arr, temp, left, mid); // Left subarray
            count += mergeSort(arr, temp, mid + 1, right); // Right subarray
            count += merge(arr, temp, left, mid, right); // Merge and count inversions
        }
        return count;
    }

    // Merge function that counts inversions
    private static int merge(int arr[], int temp[], int left, int mid, int right) {
        int i = left; // Left subarray pointer
        int j = mid + 1; // Right subarray pointer
        int k = left; // Temp array pointer
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // Count inversions
            }
        }

        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return count;
    }
}
