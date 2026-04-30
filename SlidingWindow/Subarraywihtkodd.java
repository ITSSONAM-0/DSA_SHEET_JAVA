public class Subarraywihtkodd {
    public int numberOfSubarrays(int[] nums, int k) {
        int r = 0;
        int l = 0;
        int oddcount = 0;
        int result = 0;
        int tempresult = 0;

        while(r<nums.length){
            if(nums[r]%2==1){
                oddcount++;
                tempresult = 0;
            }
            while(oddcount==k){
                tempresult++;
                if(nums[l]%2==1){
                    oddcount--;
                }
                l++;
            }
            result+=tempresult;
            r++;
        }
        return result;
    }
}
