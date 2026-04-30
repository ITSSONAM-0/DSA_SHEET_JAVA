public class CounttheDigitsThatDivideaNumber {
    public int countDigits(int num) {
        int count = 0;
        String str = String.valueOf(num);

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int t = ch - '0';
            if(num % t == 0){
                count++;
            }
        }
        return count;
    }
}
