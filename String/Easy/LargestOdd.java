package String.Easy;

public class LargestOdd {
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int i = n-1; i>=0;i--){
            char c = num.charAt(i);

            if(c%2 == 1){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
