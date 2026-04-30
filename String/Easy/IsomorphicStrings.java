package String.Easy;


import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if((hm.containsKey(ss) && hm.get(ss) != tt || (!hm.containsKey(ss) && hm.values().contains(tt)))){
                return false;
            }
            hm.put(ss,tt);
        }
        return true;
    }
}
