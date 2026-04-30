

public class SecondLargest {
    public static int getSecondLargest(int[] arr) {
            int largest = arr[0];
            int secondlargest = -1;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]>largest)
                {
                    secondlargest = largest;
                    largest = arr[i];
                }
                else if(arr[i]<largest && arr[i]>secondlargest){
                    secondlargest = arr[i];
                }
            }
            return secondlargest;
        }
        public static void main(String[] args) {
            int arr [] = {2,3,7,7,5,4};
            System.out.println(getSecondLargest(arr));
    }
}
