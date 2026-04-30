package String.Easy;

public class StringSuffle {
    
    static String suffle(String s , int[] indices){

        char [] ch = s.toCharArray();

        for(int i=0;i<s.length();i++){
            ch[indices[i]] = s.charAt(i);
        }
        return new String(ch);
    }



    public static void main(String[] args) {
        
    }


}
