public class BreakAPalindrome {
    static String breakone(String palindrome){

        int n = palindrome.length();
        char s[] = palindrome.toCharArray();

        for(int i=0;i<n/2;i++){
            if(s[i] != 'a'){
                s[i] = 'a';
                return new String(s);
            }
        }

        if(palindrome.length() == 1){
            return "";
        }

        s[n-1] = 'b';
        return new String(s);
    }
}
