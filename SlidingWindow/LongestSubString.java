import java.util.HashMap;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l=0,r=0,maxlen = 0;
        int n = s.length();
        while(r<n){
            if(map.containsKey(s.charAt(r)))
            l= Math.max(l,map.get(s.charAt(r))+1);

            int len = r-l+1;
            maxlen = Math.max(len,maxlen);
            map.put(s.charAt(r),r);
            r++;
        }
        return maxlen;
    }
}
