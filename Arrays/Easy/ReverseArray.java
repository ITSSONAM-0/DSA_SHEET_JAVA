

import java.util.Scanner;


public class ReverseArray {
    static void fun(int arr[]){
        int left=0;
        int right = arr.length-1;

        while(left<=right){
            int temp=arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        int arr[] = new int[n] ;
        System.out.println("Enter the array elements: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Reversed Array is: ");
        fun(arr);
        for(int i =0;i<n;i++){
            System.out.println(arr[i]);
        }



        sc.close();
    }
}
