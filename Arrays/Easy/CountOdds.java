public class CountOdds {
    public int countOdds(int low, int high) {
        
        // int count = 0;

        // for(int i = low;i<=high;i++){
        //     if(i%2 != 0){
        //         count++;
        //     }
        // }
        // return count;
        int c=high-low;
        if(high%2==1||low%2==1){
            return c/2+1;
        }
        else{
            return c/2;
        }
    }
}
