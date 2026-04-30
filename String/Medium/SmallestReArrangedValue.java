import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SmallestReArrangedValue {
    public long isNegative(long num1){
        String ans1 = String.valueOf(Math.abs(num1));
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i=0;i<ans1.length();i++){
            ls.add(ans1.charAt(i) - '0');
        }
        Collections.sort(ls);
        Collections.reverse(ls);
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<ls.size();i++){
            sb.append(ls.get(i));
        }
        Long finans = Long.valueOf(sb.toString());
        return -finans;
        
    }
    public long isPositive(long num2){
        String ans2 = String.valueOf(num2);
        char arr[] = ans2.toCharArray();
        Arrays.sort(arr);
        int j = 0;
        if(arr[j] == '0'){
            for(int i=0;i<arr.length;i++){
                if(arr[i] != '0'){
                    char temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        Long finans2 = Long.valueOf(sb.toString());
        return finans2;

    }


    public long smallestNumber(long num) {
        long ans = 0;
        if(num<0){
            ans = isNegative(num);
        }else{
            ans = isPositive(num);
        }
        return ans;
    }
}
