public class DumsumEsum {

    public int differenceOfSum(int[] nums) {
        int esum = 0;
        int dsum = 0;

        for(int i : nums){
            esum += i;

            while(i != 0){
                int rem = i % 10;
                dsum += rem;
                i = i / 10;
            }
        }
        return esum-dsum;
    }
}