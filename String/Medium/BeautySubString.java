import java.util.HashMap;

public class BeautySubString {
     public int findcount(String ans){
        HashMap<Character,Integer> hp = new HashMap<>();

        for(char ch:ans.toCharArray()){
            hp.put(ch,hp.getOrDefault(ch,0)+1);
        }

        int max = 0;
        int min = Integer.MAX_VALUE;

        for(Map.Entry<Character,Integer> e : hp.entrySet()){
            if(e.getValue()>max){
                max = e.getValue();
            }
            if(e.getValue() < min){
                min = e.getValue();
            }
        }

        int pass = max - min;
        return pass;

    }


    public int beautySum(String s) {
        int n = s.length();
        int finalans = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String add = s.substring(i,j+1);
                finalans += findcount(add);
            }
        }
        return finalans;
    }
}
