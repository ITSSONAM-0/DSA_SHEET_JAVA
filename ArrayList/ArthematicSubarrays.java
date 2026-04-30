import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArthematicSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        ArrayList<Boolean> ls = new ArrayList<>();
        int n1 = l.length;
    

       
        for(int i=0;i<n1;i++){
            int s = l[i];
            int e = r[i];


            ArrayList<Integer> ls2 = new ArrayList<>();
            for(int k=s;k<=e;k++){
                ls2.add(nums[k]);
            }
            Collections.sort(ls2);
            int ans = ls2.get(1)-ls2.get(0);
            Boolean flag = true;
            for(int v=0;v < ls2.size()-1;v++){
                if(ls2.get(v+1) - ls2.get(v) != ans){
                    flag = false;
                }
            }
            if(flag == true){
                ls.add(true);
            }else{
                ls.add(false);
            }

        }
        return ls;
    }
    
}