

public class LargestElement {
    public static void main(String[] args) {
        int arr[] = {3,2,5,1,6,0};
        int largest = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest)
            {
                largest = arr[i];
            }
        }
        System.out.println(largest);
    }
}
