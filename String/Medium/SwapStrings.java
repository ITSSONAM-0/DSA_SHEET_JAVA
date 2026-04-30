package String.Medium;

public class SwapStrings {
    public int minimumSwap(String s1, String s2) {
        
        if(s1.length() != s2.length()){
            return -1;
        }

        int xy = 0, yx = 0;

        for(int i=0;i<s1.length();i++){

            if(s1.charAt(i) != s2.charAt(i)){
            if(s1.charAt(i) == 'x'){
                xy++;
            }else{
                yx++;
                }
            }
        }

        if(xy % 2 != yx % 2){
            return -1;
        }else{
            return xy/2 +yx/2 +2*(xy%2);
        }

    }
}
