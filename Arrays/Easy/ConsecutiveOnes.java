

public class ConsecutiveOnes {

    public static int ones(int[] arr){
        int maximun = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==1){
                count++;
                maximun = Math.max(maximun, count);
            }
            else{
                count = 0;
            }
        }

        
        return maximun;

    }
    public static void main(String[] args) {
        int arr[] = {1,1,0,1,1,1,0,1,1};
        int ans = ones(arr);
        System.out.println(ans);
    }
}
