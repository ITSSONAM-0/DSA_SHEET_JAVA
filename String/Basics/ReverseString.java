package String.Basics;

public class ReverseString {

    public static void main(String[] args) {
        String str = "HELLO";
        String result ="";
        StringBuilder rb = new StringBuilder(result);
        int last = str.length()-1;
        
        for(int i=last;i>=0;i--){
            rb.append(str.charAt(i));
        }
        System.out.println(rb);
    }
    
}