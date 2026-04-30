package DSA_SHEET_JAVA.SortingTechniques;

public class SelectionSort {

    static void Selectionsorting(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        System.out.println("After selection sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 13, 45, 24, 52, 20, 9 };
        int n = arr.length;
        System.out.println("Before Selection Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
        Selectionsorting(arr, n);

    }
}
