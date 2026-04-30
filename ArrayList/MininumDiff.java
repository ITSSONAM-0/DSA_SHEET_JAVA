import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MininumDiff {
     public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        Arrays.sort(arr);
        List<List<Integer>> ls = new ArrayList<>();

        int min_diff = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            min_diff = Math.min(arr[i] - arr[i-1],min_diff);
        }

        for(int i=1;i<arr.length;i++){
            ArrayList<Integer> ans = new ArrayList<>();
            if(arr[i] - arr[i-1] == min_diff){
                ans.add(arr[i-1]);
                ans.add(arr[i]);
                ls.add(ans);
            }
        }

        return ls;

    }
}
