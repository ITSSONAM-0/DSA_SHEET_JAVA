package String.Easy;

public class LastWordLength {
    public int lengthOfLastWord(String s) {
        String str1 = s.trim();
        int n = str1.length();
        int i=n-1;
        int count = 0;
        while(i>=0 && str1.charAt(i)!=' '){
            count++;
            i--;
        }
        return count;
    }
}
