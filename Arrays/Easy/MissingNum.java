

public class MissingNum {
    public static int missing(int[] arr){
        int n = arr.length;
        
        int sum = (n*(n+1))/2;
        int s2=0;
        for(int i=0;i<arr.length;i++){
            s2+=arr[i];
        }
        int missnum = sum-s2;


            return missnum;

    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,5};
        int ans = missing(arr);
        System.out.println(ans);


    }
}
