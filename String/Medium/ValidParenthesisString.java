package String.Medium;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int count = 0;

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '*'){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                return false;
            }
        }

        count = 0;
        for(int i = s.length() - 1 ; i >= 0; i--){
            char c = s.charAt(i);
            if(c == ')' || c == '*'){
                count++;
            }else{
                count--;
            }

            if(count < 0){
                return false;
            }
        }

        return true;

    }
    
}