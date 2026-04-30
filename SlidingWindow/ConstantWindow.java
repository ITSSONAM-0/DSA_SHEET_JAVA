public class ConstantWindow {

    static int window(int arr[],int k){
        int n = arr.length;
        int l = 0;
        int r = k-1;
        int sum = 0;
       
        for(int i=l;i<k;i++){
            sum += arr[i];
        }
        int maxsum = sum;
        while (r<n-1) {
            sum = sum - arr[l];
            l++;
            r++;
            sum = sum + arr[r];
            maxsum = Math.max(maxsum, sum);

        }

        return maxsum;
    }



    public static void main(String[] args) {
        int arr [] = {-1,2,3,3,4,5,-1};
        int k = 4;
        int ans = window(arr, k);
        System.out.println(ans);
    }
}
